package glod.study.blog.service.impl;

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
    RabbitTemplate rabbitTemplate;

    /**
     * 用户注册
     * @param userInfo 用户信息
     * @throws Exception 异常
     */
    @Override
    public void insertUserInfo(UserInfo userInfo) throws Exception {
        String uuid = UUID.randomUUID().toString().replace("-", "");
        Date registrationTime = new Date();
        String defaultPhoto = "default";
        Date birthday = userInfo.getBirthday();
        //计算用户年龄
        int age;
        if (birthday.getMonth() - registrationTime.getMonth() > 0 && birthday.getDay() - registrationTime.getDay() > 0){
            age = registrationTime.getYear() - birthday.getYear() - 1;
        }else {
            age = registrationTime.getYear() - birthday.getYear();
        }
        userInfo.setAge(age);
        //设置用户id(UUID)
        userInfo.setId(uuid);
        //设置注册时间
        userInfo.setRegistrationTime(registrationTime);
        //设置默认头像
        userInfo.setProfilePhoto(defaultPhoto);
        //添加用户信息
        userInfoDao.insertUserInfo(userInfo);
        //为用户添加游客角色
        userInfoDao.insertUserInfoAndRole(userInfo.getId(), "1");
        //发送注册邮件
        rabbitTemplate.convertAndSend("amq.direct", userInfo.getEmail());

    }

    @Override
    public UserInfo selectUserInfoByUsername(String username) {
        return userInfoDao.selectUserInfoByUsername(username);
    }

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


    public List<SimpleGrantedAuthority> getAuthority(List<Role> roleList){
        System.out.println(roleList);
        List<SimpleGrantedAuthority> list = new ArrayList<>();
        for (Role role : roleList) {
            list.add(new SimpleGrantedAuthority("ROLE_" + role.getRole()));
        }
        return list;
    }
}
