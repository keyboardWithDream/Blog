package glod.study.blog.service;

import glod.study.blog.domain.UserInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

/**
 * @Author Harlan
 * @Date 2020/10/16
 */
@SpringBootTest
public class UserServiceTest {

    @Autowired
    private UserInfoService userInfoService;

    @Test
    public void insertUserInfoTest() throws Exception {
        UserInfo userInfo = new UserInfo();
        userInfo.setId("testInsert");
        userInfo.setPassword("123456");
        userInfo.setIp("127.0.0.1");
        userInfo.setEmail("test@tset.com");
        userInfo.setBirthday(new Date());
        userInfo.setAge(1);
        userInfo.setNikeName("insert");
        userInfo.setRegistrationTime(new Date());
        userInfo.setUsername("testInsert");
        userInfoService.insertUserInfo(userInfo);
    }

    @Test
    public void testUpdateEmailByUsername(){
        userInfoService.updateUserInfoEmailByUsername("hello", "1353662613@qq.com");
    }
}
