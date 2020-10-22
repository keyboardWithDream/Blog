package glod.study.blog.domain;


import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @Author Harlan
 * @Date 2020/10/17
 */
public class Article implements Serializable {

    private String id;
    private String username;
    private String sortName;
    private String tittle;
    private String content;
    private Long views;
    private Long commentCount;
    private Long likeCount;
    private Date date;
    private List<Label> labelList;

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

    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Long getViews() {
        return views;
    }

    public void setViews(Long views) {
        this.views = views;
    }

    public Long getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(Long commentCount) {
        this.commentCount = commentCount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Long getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(Long likeCount) {
        this.likeCount = likeCount;
    }

    public List<Label> getLabelsList() {
        return labelList;
    }

    public void setLabelsList(List<Label> labelList) {
        this.labelList = labelList;
    }

    @Override
    public String toString() {
        return "Article{" +
                "id='" + id + '\'' +
                ", username='" + username + '\'' +
                ", sortName='" + sortName + '\'' +
                ", tittle='" + tittle + '\'' +
                ", content='" + content + '\'' +
                ", views=" + views +
                ", commentCount=" + commentCount +
                ", likeCount=" + likeCount +
                ", date=" + date +
                ", labelList=" + labelList +
                '}';
    }
}
