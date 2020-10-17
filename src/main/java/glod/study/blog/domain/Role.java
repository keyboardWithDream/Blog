package glod.study.blog.domain;

import java.io.Serializable;

/**
 * @Author Harlan
 * @Date 2020/10/16
 */
public class Role implements Serializable {

    private String id;
    private String role;
    private String UserInfo;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getUserInfo() {
        return UserInfo;
    }

    public void setUserInfo(String userInfo) {
        UserInfo = userInfo;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id='" + id + '\'' +
                ", role='" + role + '\'' +
                ", UserInfo='" + UserInfo + '\'' +
                '}';
    }
}
