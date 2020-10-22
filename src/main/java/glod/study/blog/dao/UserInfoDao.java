package glod.study.blog.dao;


import glod.study.blog.domain.UserInfo;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import javax.websocket.server.PathParam;
import java.util.List;

/**
 * @Author Harlan
 * @Date 2020/10/16
 */
@Repository
public interface UserInfoDao {

    /**
     * 查询所有用户信息
     * @return 所有用户信息
     * @throws Exception 异常
     */
    @Select("select * from t_userinfo")
    List<UserInfo> selectAllUserInfo() throws Exception;

    /**
     * 保存用户信息
     * @param userInfo 用户信息
     * @throws Exception 异常
     */
    @Insert("insert into t_userinfo(username, password, token, email, phone, birthday, age, avatar, ip, registration_time) values(#{username}, #{password}, #{token}, #{email}, #{phone}, #{birthday}, #{age}, #{avatar}, #{ip}, #{registrationTime})")
    void insertUserInfo(UserInfo userInfo) throws Exception;

    /**
     * 通过用户名删除用户
     * @param username 用户名
     * @throws Exception 异常
     */
    @Delete("delete * from t_userinfo where id = #{username}")
    void deleteUserInfo(String username) throws Exception;

    /**
     * 添加用户角色
     * @param username 用户名
     * @param roleName 角色名
     */
    @Insert("insert into t_userinfo_role values(#{username}, #{roleName})")
    void insertUserInfoAndRole(@Param("username") String username, @Param("roleName") String roleName);

    /**
     * 通过用户名查询用户信息
     * @param username 用户名
     * @return 用户信息
     */
    @Select("select * from t_userinfo where username = #{username}")
    @Results({
            @Result(id = true, property = "username", column = "username"),
            @Result(property = "roleList", column = "username", javaType = List.class, many = @Many(select = "glod.study.blog.dao.RoleDao.selectRoleByUsername")),
            @Result(property = "articleList", column = "username", javaType = List.class, many = @Many(select = "glod.study.blog.dao.ArticleDao.selectArticleByUsername"))
    })
    UserInfo selectUserInfoByUsername(String username);

    /**
     * 通过用户名更改邮箱
     * @param username 用户名
     * @param email 邮箱
     */
    @Update("update t_userinfo set email = #{email} where username = #{username}")
    void updateUserInfoEmailByUsername(@PathParam("username") String username,@PathParam("email") String email);

}
