package glod.study.blog.service;

import glod.study.blog.domain.Article;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @Author Harlan
 * @Date 2020/10/19
 */
@SpringBootTest
public class ArticleServiceTest {

    @Autowired
    private ArticleService articleService;

    @Test
    public void testSelectByArticleByUsername(){
        List<Article> articleList = articleService.selectArticleByUsername("t");
        for (Article article : articleList) {
            System.out.println(article);
        }
    }

    @Test
    public void testSelectByArticleBySortName(){
        List<Article> articleList = articleService.selectArticleBySortName("测试");
        for (Article article : articleList) {
            System.out.println(article);
        }
    }
}
