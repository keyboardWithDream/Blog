package glod.study.blog.controller;

import glod.study.blog.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author Harlan
 * @Date 2020/10/21
 */
@Controller
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @GetMapping("/sort/{name}")
    public String selectArticleBySortName(@PathVariable("name") String sortName, Model model){
        model.addAttribute("articleList", articleService.selectArticleBySortName(sortName));
        return "userInfo_info";
    }

    @GetMapping("/all")
    public String selectAllArticle(Model model){
        model.addAttribute("articleList", articleService.selectAllArticle());
        return "userInfo_info";
    }

    public String selectAllArticle(){
        return "";
    }
}
