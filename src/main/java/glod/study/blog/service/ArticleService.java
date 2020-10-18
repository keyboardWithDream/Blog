package glod.study.blog.service;

import glod.study.blog.domain.Article;

import java.util.List;

/**
 * @Author Harlan
 * @Date 2020/10/18
 */
public interface ArticleService {

    /**
     * 查询所有文章
     * @return 所有文章信息
     */
    List<Article> selectAllArticle();
}
