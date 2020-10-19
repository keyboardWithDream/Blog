package glod.study.blog.service.impl;

import glod.study.blog.dao.ArticleDao;
import glod.study.blog.domain.Article;
import glod.study.blog.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author Harlan
 * @Date 2020/10/18
 */
@Service
@Transactional(rollbackFor = {Exception.class})
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleDao articleDao;

    @Override
    public List<Article> selectAllArticle() {
        return articleDao.selectAllArticles();
    }

    @Override
    public List<Article> selectArticleByTittle(String tittle) {
        String t = "%"+tittle+"%";
        return articleDao.selectArticleByTittle(t);
    }

    @Override
    public List<Article> selectArticleByUsername(String username) {
        String t = "%"+username+"%";
        return articleDao.selectArticleByUsername(t);
    }

    @Override
    public List<Article> selectArticleByContent(String content) {
        String c = "%"+content+"%";
        return articleDao.selectArticleByContent(c);
    }

}
