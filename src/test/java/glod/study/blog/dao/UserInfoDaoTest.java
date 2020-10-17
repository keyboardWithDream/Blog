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
        userInfo.setId("testInsert");
        userInfo.setPassword("123456");
        userInfo.setIp("127.0.0.1");
        userInfo.setEmail("test@tset.com");
        userInfo.setBirthday(new Date());
        userInfo.setAge(1);
        userInfo.setNikeName("insert");
        userInfo.setRegistrationTime(new Date());
        userInfo.setUsername("testInsert");
        userInfoDao.insertUserInfo(userInfo);
    }

    @Test
    public void testSelectUserInfoByUsername(){
        UserInfo userInfo = userInfoDao.selectUserInfoByUsername("test");
        System.out.println(userInfo);
    }
}
