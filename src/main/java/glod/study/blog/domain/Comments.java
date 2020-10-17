package glod.study.blog.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author Harlan
 * @Date 2020/10/17
 */
public class Comments implements Serializable {

    private String id;
    private String userId;
    private String articleId;
    private Long likeCount;
    private Date date;
    private String parentCommentId;
    private String content;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getArticleId() {
        return articleId;
    }

    public void setArticleId(String articleId) {
        this.articleId = articleId;
    }

    public Long getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(Long likeCount) {
        this.likeCount = likeCount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getParentCommentId() {
        return parentCommentId;
    }

    public void setParentCommentId(String parentCommentId) {
        this.parentCommentId = parentCommentId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Comments{" +
                "id='" + id + '\'' +
                ", userId='" + userId + '\'' +
                ", articleId='" + articleId + '\'' +
                ", likeCount=" + likeCount +
                ", date=" + date +
                ", parentCommentId='" + parentCommentId + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
