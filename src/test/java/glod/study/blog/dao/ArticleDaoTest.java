package glod.study.blog.dao;

import glod.study.blog.domain.Article;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @Author Harlan
 * @Date 2020/10/17
 */
@SpringBootTest
public class ArticleDaoTest {

    @Autowired
    private ArticleDao articleDao;

    /**
     * 查询所有测试
     */
    @Test
    public void testSelectAllArticles(){
        List<Article> articleList = articleDao.selectAllArticles();
        for (Article article : articleList) {
            System.out.println(article);
        }
    }

    @Test
    public void testSelectArticleByTittle(){
        List<Article> articleList = articleDao.selectArticleByTittle("%测%");
        for (Article article : articleList) {
            System.out.println(article);
        }
    }

    /**
     * 通过用户名查询文章
     */
    @Test
    public void testSelectArticleByUsername(){
        List<Article> articleList = articleDao.selectArticleByUsername("%t%");
        for (Article article : articleList) {
            System.out.println(article);
        }
    }


    @Test
    public void testSelectArticleByContent(){
        List<Article> articleList = articleDao.selectArticleByContent("%Java%");
        for (Article article : articleList) {
            System.out.println(article);
        }
    }


    @Test
    public void testSelectArticleByLabelsName(){
        List<Article> articleList = articleDao.selectArticleByLabelsName("%标签测试%");
        for (Article article : articleList) {
            System.out.println(article);
        }
    }

    @Test
    public void testSelectArticleBySortName(){
        List<Article> articleList = articleDao.selectArticleBySortName("%类别测试%");
        for (Article article : articleList) {
            System.out.println(article);
        }
    }
}
