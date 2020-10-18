package glod.study.blog.config;

import glod.study.blog.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @Author Harlan
 * @Date 2020/10/16
 */
@EnableWebSecurity
public class MySecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserInfoService userInfoService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userInfoService).passwordEncoder(new BCryptPasswordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers( "/userInfo/registered", "/userInfo/login", "/userInfo/failLogin").permitAll()
        .antMatchers("/info").hasAnyRole("ADMIN", "USER");
        
        //关闭跨域请求保护
        http.csrf().disable();
        //判断重复登录
        http.sessionManagement().maximumSessions(1);
        //指定登录成功及失败的跳转
        http.formLogin().loginPage("/login")
                .loginProcessingUrl("/login")
                .successForwardUrl("/userInfo/info")
                .failureForwardUrl("/userInfo/failLogin");
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
