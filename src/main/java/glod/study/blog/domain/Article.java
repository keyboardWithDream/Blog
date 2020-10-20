package glod.study.blog.domain;

import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

/**
 * @Author Harlan
 * @Date 2020/10/17
 */
public class Article implements Serializable {

    private String id;
    private String userId;
    private String tittle;
    private String content;
    private Long views;
    private Long commentCount;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private Date date;
    private Long likeCount;
    private List<Labels> labelsList;
    private List<Sort> sortList;

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

    public List<Labels> getLabelsList() {
        return labelsList;
    }

    public void setLabelsList(List<Labels> labelsList) {
        this.labelsList = labelsList;
    }

    public List<Sort> getSortList() {
        return sortList;
    }

    public void setSortList(List<Sort> sortList) {
        this.sortList = sortList;
    }

    @Override
    public String toString() {
        return "Article{" +
                "id='" + id + '\'' +
                ", userId='" + userId + '\'' +
                ", tittle='" + tittle + '\'' +
                ", content='" + content + '\'' +
                ", views=" + views +
                ", commentCount=" + commentCount +
                ", date=" + date +
                ", likeCount=" + likeCount +
                ", labelsList=" + labelsList +
                ", sortList=" + sortList +
                '}';
    }
}
