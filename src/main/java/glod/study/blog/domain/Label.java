package glod.study.blog.domain;

import java.io.Serializable;
import java.util.List;

/**
 * @Author Harlan
 * @Date 2020/10/17
 */
public class Label implements Serializable {

    private String name;
    private String description;
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

    public List<Article> getArticleList() {
        return articleList;
    }

    public void setArticleList(List<Article> articleList) {
        this.articleList = articleList;
    }

    @Override
    public String toString() {
        return "LabelDao{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", articleList=" + articleList +
                '}';
    }
}
