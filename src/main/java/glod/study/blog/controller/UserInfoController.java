package glod.study.blog.controller;

import glod.study.blog.domain.UserInfo;
import glod.study.blog.service.UserInfoService;
import glod.study.blog.service.impl.UserInfoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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

    /**
     * 用户注册
     * @param userInfo 用户信息
     * @param req request对象
     * @return 返回主页
     * @throws Exception 异常
     */
    @PostMapping("/registered")
    public String registered(UserInfo userInfo, HttpServletRequest req) throws Exception {
        String ip = req.getRemoteAddr();
        userInfo.setIp(ip);
        userInfoService.insertUserInfo(userInfo);
        return "index";
    }

    @RequestMapping("/failLogin")
    public String failLogin(Model model){
        model.addAttribute("msg", "用户名或密码错误!");
        return "login";
    }

    /**
     * 跳转注册页面
     * @return 注册
     */
    @GetMapping("/registered")
    public String transToRegistered(){
        return "registered";
    }

    /**
     * 跳转登录页面
     * @return 登录
     */
    @GetMapping("/login")
    public String transToLogin(){
        return "login";
    }

    @RequestMapping("/info")
    public String transToInfo(Model model){
        return "info";
    }
}
