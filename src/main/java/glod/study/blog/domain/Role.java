package glod.study.blog.domain;

import java.io.Serializable;
import java.util.List;

/**
 * @Author Harlan
 * @Date 2020/10/16
 */
public class Role implements Serializable {

    private String roleName;
    private String description;
    private List<UserInfo> userInfo;

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<UserInfo> getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(List<UserInfo> userInfo) {
        this.userInfo = userInfo;
    }

    @Override
    public String toString() {
        return "Role{" +
                "roleName='" + roleName + '\'' +
                ", description='" + description + '\'' +
                ", userInfo=" + userInfo +
                '}';
    }
}
