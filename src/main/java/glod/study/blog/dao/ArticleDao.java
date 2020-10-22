package glod.study.blog.dao;

import glod.study.blog.domain.Article;
import org.apache.ibatis.annotations.Many;
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
    @Select("select * from t_article")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "labelList", column = "id", javaType = List.class, many = @Many(select = "glod.study.blog.dao.LabelDao.selectLabelByArticleId"))
    })
    List<Article> selectAllArticles();

    /**
     * 通过用户名查询文章
     * @param username 用户名
     * @return 文章信息
     */
    @Select("select * from t_article where username like #{username}")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "labelList", column = "id", javaType = List.class, many = @Many(select = "glod.study.blog.dao.LabelDao.selectLabelByArticleId"))
    })
    List<Article> selectArticleByUsername(String username);

    /**
     * 根据文章标题模糊查询
     * @param tittle 文章标题
     * @return 文章信息
     */
    @Select("select * from t_article where tittle like #{tittle}")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "labelList", column = "id", javaType = List.class, many = @Many(select = "glod.study.blog.dao.LabelDao.selectLabelByArticleId"))
    })
    List<Article> selectArticleByTittle(String tittle);

    /**
     * 模糊查询文章内容
     * @param content 文章内容
     * @return 文章信息
     */
    @Select("select * from t_article where content like #{content}")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "labelList", column = "id", javaType = List.class, many = @Many(select = "glod.study.blog.dao.LabelDao.selectLabelByArticleId"))
    })
    List<Article> selectArticleByContent(String content);


    /**
     * 通过标签名模糊查询文章
     * @param labelName 标签名
     * @return 文章信息
     */
    @Select("select * from t_article where id in (" +
            "select article_id from t_article_label where label_name like #{labelName})")
    List<Article> selectArticleByLabelsName(String labelName);

    /**
     * 通过类别模糊查询文章
     * @param sortName 类别名称
     * @return 文章信息
     */
    @Select("select * from t_article where sort_name like #{sortName}")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "labelList", column = "id", javaType = List.class, many = @Many(select = "glod.study.blog.dao.LabelDao.selectLabelByArticleId"))
    })
    List<Article> selectArticleBySortName(String sortName);
}
