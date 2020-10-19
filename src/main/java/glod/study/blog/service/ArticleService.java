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

    /**
     * 根据文章标题模糊查询文章
     * @param tittle 文章标题
     * @return 文章信息
     */
    List<Article> selectArticleByTittle(String tittle);

    /**
     * 模糊查询文章内容
     * @param content 文章内容
     * @return 文章信息
     */
    List<Article> selectArticleByContent(String content);

    /**
     * 通过用户名模糊查询文章
     * @param username 用户名
     * @return 文章信息
     */
    List<Article> selectArticleByUsername(String username);
}
