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
     * @throws Exception 异常
     */
    void insertUserInfo(UserInfo userInfo) throws Exception;


    /**
     * 根据用户名查询用户
     * @param username 用户名
     * @return 用户信息
     */
    UserInfo selectUserInfoByUsername(String username);


}
