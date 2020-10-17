package glod.study.blog.domain;

import java.io.Serializable;

/**
 * @Author Harlan
 * @Date 2020/10/17
 */
public class Friends implements Serializable {

    private String id;
    private String friendId;
    private String note;
    /**
     * 0 离线
     * 1 在线
     */
    private Integer status;
    private String userId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFriendId() {
        return friendId;
    }

    public void setFriendId(String friendId) {
        this.friendId = friendId;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getStatus() {
        if (status != null){
            if (status == 1){
                return "在线";
            }
        }
        return "离线";
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Friends{" +
                "id='" + id + '\'' +
                ", friendId='" + friendId + '\'' +
                ", note='" + note + '\'' +
                ", status=" + status +
                ", userId='" + userId + '\'' +
                '}';
    }
}
