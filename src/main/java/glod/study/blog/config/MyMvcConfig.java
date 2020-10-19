package glod.study.blog.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Author Harlan
 * @Date 2020/10/16
 */
@Configuration
public class MyMvcConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("userInfo_index");
        registry.addViewController("/index.html").setViewName("userInfo_index");
        registry.addViewController("/login").setViewName("userInfo_login");
        registry.addViewController("/login.html").setViewName("userInfo_login");
        registry.addViewController("/signIn").setViewName("userInfo_signIn");
        registry.addViewController("/signIn.html").setViewName("userInfo_signIn");
    }

}
