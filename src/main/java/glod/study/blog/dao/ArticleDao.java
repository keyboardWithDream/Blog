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
     * @param userId 用户id
     * @return 文章信息
     */
    @Select("select * from article where id = #{userId}")
    List<Article> selectArticleByUserId(String userId);
}
