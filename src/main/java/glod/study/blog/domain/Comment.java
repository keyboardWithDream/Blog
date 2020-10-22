package glod.study.blog.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author Harlan
 * @Date 2020/10/17
 */
public class Comment implements Serializable {

    private String id;
    private String username;
    private String articleId;
    private Date date;
    private String content;
    private Long likeCount;
    private String parentCommentId;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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
        return "Comment{" +
                "id='" + id + '\'' +
                ", username='" + username + '\'' +
                ", articleId='" + articleId + '\'' +
                ", date=" + date +
                ", content='" + content + '\'' +
                ", likeCount=" + likeCount +
                ", parentCommentId='" + parentCommentId + '\'' +
                '}';
    }
}
