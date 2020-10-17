package glod.study.blog.dao;


import glod.study.blog.domain.UserInfo;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
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
    @Select("select * from userinfo")
    List<UserInfo> selectAllUserInfo() throws Exception;

    /**
     * 保存用户信息
     * @param userInfo 用户信息
     * @throws Exception 异常
     */
    @Insert("insert into userinfo values(#{id}, #{ip}, #{username}, #{password}, #{email}, #{profilePhoto}, #{registrationTime}, #{birthday}, #{age}, #{nikeName})")
    void insertUserInfo(UserInfo userInfo) throws Exception;

    /**
     * 通过id删除用户
     * @param id 用户id
     * @throws Exception 异常
     */
    @Delete("delete * from userinfo where id = #{id}")
    void deleteUserInfo(Integer id) throws Exception;

    /**
     * 添加用户角色
     * @param userId 用户id
     * @param roleId 角色id
     */
    @Insert("insert into user_role values(#{userId}, #{roleId})")
    void insertUserInfoAndRole(@Param("userId") String userId, @Param("roleId") String roleId);

    /**
     * 通过
     * @param username
     * @return
     */
    @Select("select * from userinfo where username = #{username}")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "username", column = "username"),
            @Result(property = "password", column = "password"),
            @Result(property = "email", column = "email"),
            @Result(property = "age", column = "age"),
            @Result(property = "profilePhoto", column = "profile_photo"),
            @Result(property = "birthday", column = "birthday"),
            @Result(property = "registrationTime", column = "registration_time"),
            @Result(property = "nikeName", column = "nike_name"),
            @Result(property = "roleList", column = "id", javaType = List.class, many = @Many(select = "glod.study.blog.dao.RoleDao.selectRoleByUserInfoId"))
    })
    UserInfo selectUserInfoByUsername(String username);
}
