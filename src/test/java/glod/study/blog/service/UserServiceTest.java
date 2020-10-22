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
        userInfo.setUsername("testInsert");
        userInfo.setPassword("123456");
        userInfo.setIp("127.0.0.1");
        userInfo.setPhone("12311111111");
        userInfo.setEmail("isharlan.hu@gmail.com");
        userInfo.setBirthday(new Date());
        userInfoService.insertUserInfo(userInfo);
    }

    @Test
    public void testUpdateEmailByUsername(){
        userInfoService.updateUserInfoEmailByUsername("testInsert", "isharlan.hu@gmail.com");
    }
}
