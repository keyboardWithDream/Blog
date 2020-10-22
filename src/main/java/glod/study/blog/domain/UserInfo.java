package glod.study.blog.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;


/**
 * @Author Harlan
 * @Date 2020/10/16
 */
public class UserInfo implements Serializable {

    private String username;
    private String password;
    private String token;
    private String email;
    private String phone;
    private Integer sex;
    private Date birthday;
    private Integer age;
    private String avatar;
    private String introduction;
    private String ip;
    private Date registrationTime;
    private List<Role> roleList;
    private List<Article> articleList;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getRegistrationTime() {
        return registrationTime;
    }

    public void setRegistrationTime(Date registrationTime) {
        this.registrationTime = registrationTime;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getIntroduction() {
        if (introduction == null){
            return "这个用户还未设置简介";
        }
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public List<Role> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<Role> roleList) {
        this.roleList = roleList;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public List<Article> getArticleList() {
        return articleList;
    }

    public void setArticleList(List<Article> articleList) {
        this.articleList = articleList;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", token='" + token + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", sex=" + sex +
                ", birthday=" + birthday +
                ", age=" + age +
                ", avatar='" + avatar + '\'' +
                ", introduction='" + introduction + '\'' +
                ", ip='" + ip + '\'' +
                ", registrationTime=" + registrationTime +
                ", roleList=" + roleList +
                ", articleList=" + articleList +
                '}';
    }
}
