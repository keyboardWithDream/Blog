package glod.study.blog.domain;

import java.io.Serializable;
import java.util.List;

/**
 * @Author Harlan
 * @Date 2020/10/17
 */
public class Sort implements Serializable {

    private String name;
    private String description;
    private String parentSortId;
    private List<Article> articleList;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", parentSortId='" + parentSortId + '\'' +
                ", articleList=" + articleList +
                '}';
    }
}
