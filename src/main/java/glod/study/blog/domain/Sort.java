package glod.study.blog.domain;

import java.io.Serializable;
import java.util.List;

/**
 * @Author Harlan
 * @Date 2020/10/17
 */
public class Sort implements Serializable {

    private String id;
    private String name;
    private String alias;
    private String description;
    private String parentSortId;
    private List<Article> articleList;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getParentSortId() {
        return parentSortId;
    }

    public void setParentSortId(String parentSortId) {
        this.parentSortId = parentSortId;
    }

    public List<Article> getArticleList() {
        return articleList;
    }

    public void setArticleList(List<Article> articleList) {
        this.articleList = articleList;
    }

    @Override
    public String toString() {
        return "Sort{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", alias='" + alias + '\'' +
                ", description='" + description + '\'' +
                ", parentSortId='" + parentSortId + '\'' +
                ", articleList=" + articleList +
                '}';
    }
}
