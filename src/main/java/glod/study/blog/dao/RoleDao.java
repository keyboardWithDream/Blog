package glod.study.blog.dao;

import glod.study.blog.domain.Role;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author Harlan
 * @Date 2020/10/16
 */
@Repository
public interface RoleDao {

    /**
     * 通过用户名查询角色
     * @param username 用户username
     * @return 角色信息
     */
    @Select("select * from t_role where role_name in (select role_name from t_userinfo_role where username = #{username})")
    List<Role> selectRoleByUsername(String username);

    /**
     * 更改用户权限
     * @param username 用户名
     * @param roleName 权限名
     */
    @Update("update t_userinfo_role set role_name = #{roleName} where username = #{username}")
    void updateRoleByUsername(@Param("username") String username, @Param("roleName") String roleName);
}
