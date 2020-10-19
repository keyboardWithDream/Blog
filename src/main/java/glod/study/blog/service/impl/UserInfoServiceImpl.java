package glod.study.blog.service.impl;

import glod.study.blog.dao.ArticleDao;
import glod.study.blog.dao.RoleDao;
import glod.study.blog.dao.UserInfoDao;
import glod.study.blog.domain.Role;
import glod.study.blog.domain.UserInfo;
import glod.study.blog.service.UserInfoService;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @Author Harlan
 * @Date 2020/10/16
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    private UserInfoDao userInfoDao;
    @Autowired
    private RoleDao roleDao;
    @Autowired
    RabbitTemplate rabbitTemplate;
    @Autowired
    BCryptPasswordEncoder passwordEncoder;

    /**
     * 用户注册
     * @param userInfo 用户信息
     * @throws Exception 异常
     */
    @Override
    public UserInfo insertUserInfo(UserInfo userInfo) throws Exception {
        //设置用户id(UUID)
        String uuid = UUID.randomUUID().toString().replace("-", "");
        userInfo.setId(uuid);
        //用户密码加密
        String password = userInfo.getPassword();
        userInfo.setPassword(passwordEncoder.encode(password));
        //设置注册时间
        Date registrationTime = new Date();
        userInfo.setRegistrationTime(registrationTime);
        //计算用户年龄
        Date birthday = userInfo.getBirthday();
        int age;
        if (birthday.getMonth() - registrationTime.getMonth() > 0 && birthday.getDay() - registrationTime.getDay() > 0){
            age = registrationTime.getYear() - birthday.getYear() - 1;
        }else {
            age = registrationTime.getYear() - birthday.getYear();
        }
        userInfo.setAge(age);
        //设置默认头像
        String defaultPhoto = "default";
        userInfo.setProfilePhoto(defaultPhoto);
        //添加用户信息
        userInfoDao.insertUserInfo(userInfo);
        //为用户添加游客角色
        userInfoDao.insertUserInfoAndRole(userInfo.getId(), "1");
        //发送注册邮件
        rabbitTemplate.convertAndSend("amq.direct","user.email", userInfo);
        return userInfo;
    }

    /**
     * 通过用户名查询用户
     * @param username 用户名
     * @return 用户信息
     */
    @Override
    public UserInfo selectUserInfoByUsername(String username) {
        return userInfoDao.selectUserInfoByUsername(username);
    }

    /**
     * 用户激活
     * @param id 用户id
     */
    @Override
    public void activeUserInfo(String id) {
        roleDao.updateRoleByUserId(id, "2");
    }

    /**
     * 通过用户名修改邮箱
     * @param username 用户名
     * @param email 新邮箱
     */
    @Override
    public void updateUserInfoEmailByUsername(String username, String email) {
        UserInfo userInfo = userInfoDao.selectUserInfoByUsername(username);
        //用户修改的邮箱与目前邮箱相同则不做处理
        if (!userInfo.getEmail().equals(email)){
            userInfoDao.updateUserInfoEmailByUsername(username, email);
            //重新进入未激活状态
            roleDao.updateRoleByUserId(userInfo.getId(), "1");
            rabbitTemplate.convertAndSend("amq.direct", "user.email", userInfo);
        }
    }


    /**
     * 权限控制
     * @param s 用户名
     * @return 权限
     * @throws UsernameNotFoundException 异常
     */
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        UserInfo userInfo = null;
        try {
            userInfo = selectUserInfoByUsername(s);
        }catch (Exception e){
            e.printStackTrace();
        }
        assert userInfo != null;
        return new User(userInfo.getUsername(), userInfo.getPassword(), getAuthority(userInfo.getRoleList()));
    }


    /**
     * 获取用户权限
     * @param roleList 权限列表
     * @return 权限列表
     */
    public List<SimpleGrantedAuthority> getAuthority(List<Role> roleList){
        List<SimpleGrantedAuthority> list = new ArrayList<>();
        for (Role role : roleList) {
            list.add(new SimpleGrantedAuthority("ROLE_" + role.getRole()));
        }
        return list;
    }
}
