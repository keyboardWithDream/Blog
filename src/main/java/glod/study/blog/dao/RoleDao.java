package glod.study.blog.dao;

import glod.study.blog.domain.Role;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author Harlan
 * @Date 2020/10/16
 */
@Repository
public interface RoleDao {

    /**
     * 通过用户id查询角色
     * @param userId 用户id
     * @return 角色信息
     */
    @Select("select * from roles where id in (select role_id from user_role where user_id = #{userId})")
    List<Role> selectRoleByUserId(String userId);
}
