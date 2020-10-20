package glod.study.blog.dao;

import glod.study.blog.domain.Article;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
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


    /**
     * 通过标签名模糊查询文章
     * @param labelName 标签名
     * @return 文章信息
     */
    @Select("select * from article where id in (" +
            "select article_id from article_label where label_id in (" +
            "select id from labels where name like #{name}" +
            "))")
    List<Article> selectArticleByLabelsName(String labelName);

    /**
     * 通过类别模糊查询文章
     * @param sortName 类别名称
     * @return 文章信息
     */
    @Select("select * from article where id in (" +
            "select article_id from article_sort where sort_id in (" +
            "select id from sort where name like #{sortName}" +
            "))")
    List<Article> selectArticleBySortName(String sortName);
}
