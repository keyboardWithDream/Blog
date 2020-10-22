package glod.study.blog.dao;

import glod.study.blog.domain.Role;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @Author Harlan
 * @Date 2020/10/16
 */
@SpringBootTest
public class RoleDaoTest {

    @Autowired
    private RoleDao roleDao;

    @Test
    public void testSelectRoleByUsername(){
        List<Role> roles = roleDao.selectRoleByUsername("admin");
        for (Role role : roles) {
            System.out.println(role);
        }
    }

    @Test
    public void updateRoleByUsername(){
        roleDao.updateRoleByUsername("test", "USER");
    }
}
