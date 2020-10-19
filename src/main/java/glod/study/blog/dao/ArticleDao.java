package glod.study.blog.dao;

import glod.study.blog.domain.Article;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author Harlan
 * @Date 2020/10/17
 */
@Repository
public interface ArticleDao {

    /**
     * 查询所有文章
     * @return 文章list
     */
    @Select("select * from article")
    List<Article> selectAllArticles();

    /**
     * 通过用户id查询文章
     * @param username 用户名
     * @return 文章信息
     */
    @Select("select * from article where id in (select id from userinfo where username like #{username})")
    List<Article> selectArticleByUsername(String username);

    /**
     * 根据文章标题模糊查询
     * @param tittle 文章标题
     * @return 文章信息
     */
    @Select("select * from article where tittle like #{tittle}")
    List<Article> selectArticleByTittle(String tittle);

    /**
     * 模糊查询文章内容
     * @param content 文章内容
     * @return 文章信息
     */
    @Select("select * from article where content like #{content}")
    List<Article> selectArticleByContent(String content);


}
