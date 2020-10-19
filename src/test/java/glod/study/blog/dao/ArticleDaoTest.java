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

    /**
     * 通过用户名查询文章
     */
    @Test
    public void testSelectArticleByUserId(){
        List<Article> articleList = articleDao.selectArticleByUsername("test");
        for (Article article : articleList) {
            System.out.println(article);
        }
    }


    @Test
    public void testSelectArticleByUsername(){
        List<Article> articleList = articleDao.selectArticleByUsername("%t%");
        for (Article article : articleList) {
            System.out.println(article);
        }
    }


    @Test
    public void testSelectArticleByContent(){
        List<Article> articleList = articleDao.selectArticleByContent("%感谢%");
        for (Article article : articleList) {
            System.out.println(article);
        }
    }
}
