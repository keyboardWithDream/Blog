package glod.study.blog.controller;

import glod.study.blog.domain.UserInfo;
import glod.study.blog.service.ArticleService;
import glod.study.blog.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.annotation.security.PermitAll;
import javax.servlet.http.HttpServletRequest;

/**
 * @Author Harlan
 * @Date 2020/10/16
 */
@Controller
@RequestMapping("/userInfo")
public class UserInfoController {

    @Autowired
    private UserInfoService userInfoService;
    @Autowired
    private ArticleService articleService;

    /**
     * 用户注册
     * @param userInfo 用户信息
     * @param req request对象
     * @return 返回主页
     * @throws Exception 异常
     */
    @PostMapping("/signIn")
    @PermitAll
    public String registered(UserInfo userInfo, HttpServletRequest req, Model model) throws Exception {
        String ip = req.getRemoteAddr();
        userInfo.setIp(ip);
        UserInfo user = userInfoService.insertUserInfo(userInfo);
        model.addAttribute("email", user.getEmail());
        model.addAttribute("username", user.getUsername());
        return "userInfo_active";
    }

    /**
     * 跳转登录失败页面
     * @param model 失败信息
     * @return 登录页面
     */
    @RequestMapping("/failLogin")
    @PermitAll
    public String failLogin(Model model){
        model.addAttribute("msg", "用户名或密码错误!");
        return "userInfo_login";
    }


    /**
     * 跳转登录成功页面
     * @param model 展现信息
     * @return 信息页面
     */
    @RequestMapping("/info")
    @PreAuthorize("hasAnyRole({'ADMIN', 'TOURIST', 'USER'})")
    public String transToInfo(Model model){
        model.addAttribute("articleList", articleService.selectAllArticle());
        return "userInfo_info";
    }


    /**
     * 账户激活
     * @param id 用户id
     * @return 激活成功页面
     */
    @GetMapping("/active/{id}")
    @PermitAll
    public String activeUserInfo(@PathVariable("id") String id){
        userInfoService.activeUserInfo(id);
        return "userInfo_active_success";
    }
}
