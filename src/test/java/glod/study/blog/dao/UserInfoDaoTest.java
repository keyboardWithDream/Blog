package glod.study.blog.dao;

import glod.study.blog.domain.UserInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.List;

/**
 * @Author Harlan
 * @Date 2020/10/16
 */
@SpringBootTest
public class UserInfoDaoTest {


    @Autowired
    private UserInfoDao userInfoDao;

    @Test
    public void testSelectAllUserInfo() throws Exception {
        List<UserInfo> userInfos = userInfoDao.selectAllUserInfo();
        for (UserInfo userInfo : userInfos) {
            System.out.println(userInfo);
        }
    }

    @Test
    public void testInsertUserInfo() throws Exception{
        UserInfo userInfo = new UserInfo();
        userInfo.setUsername("testInsert");
        userInfo.setToken("testInsert");
        userInfo.setPassword("123456");
        userInfo.setIp("127.0.0.1");
        userInfo.setPhone("11111111111");
        userInfo.setEmail("isharlan.hu@gmail.com");
        userInfo.setBirthday(new Date());
        userInfo.setAge(1);
        userInfo.setRegistrationTime(new Date());
        userInfo.setAvatar("default");
        userInfo.setIntroduction("测试内容!");
        userInfoDao.insertUserInfo(userInfo);
    }

    @Test
    public void testSelectUserInfoByUsername(){
        UserInfo userInfo = userInfoDao.selectUserInfoByUsername("test");
        System.out.println(userInfo);
    }

    @Test
    public void testUpdateEmailByUsername(){
        userInfoDao.updateUserInfoEmailByUsername("testInsert", "0000@000");
    }
}
