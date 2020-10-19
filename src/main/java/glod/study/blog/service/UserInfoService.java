package glod.study.blog.service;

import glod.study.blog.domain.UserInfo;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * @Author Harlan
 * @Date 2020/10/16
 */
public interface UserInfoService extends UserDetailsService {

    /**
     * 保存用户信息
     * @param userInfo 用户信息
     * @return 用户信息
     * @throws Exception 异常
     */
    UserInfo insertUserInfo(UserInfo userInfo) throws Exception;


    /**
     * 根据用户名查询用户
     * @param username 用户名
     * @return 用户信息
     */
    UserInfo selectUserInfoByUsername(String username);

    /**
     * 通过id激活用户
     * @param id 用户id
     */
    void activeUserInfo(String id);

    /**
     * 通过用户名修改邮箱
     * @param username 用户名
     * @param email 新邮箱
     */
    void updateUserInfoEmailByUsername(String username, String email);
}
