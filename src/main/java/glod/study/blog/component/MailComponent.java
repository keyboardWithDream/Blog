package glod.study.blog.component;

import glod.study.blog.domain.UserInfo;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.UnsupportedEncodingException;

/**
 * @Author Harlan
 * @Date 2020/10/16
 */
@Component
public class MailComponent {

    @Autowired
    private JavaMailSender mailSender;

    /**
     * 发送注册邮件
     * 监听队列
     * @param userInfo 用户信息
     */
    @RabbitHandler
    @RabbitListener(bindings = @QueueBinding(
            value = @Queue("user.email"),
            exchange = @Exchange("amq.direct")
    ))
    public void activeUser(UserInfo userInfo){
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        //发送高级邮件
        try {
            MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage, false);
            messageHelper.setSubject("验证");
            messageHelper.setText("用户名：" + userInfo.getUsername() + "验证链接：<a href='http://localhost/userInfo/active/"+userInfo.getId()+">立即激活</a>'" , true);
            messageHelper.setTo(userInfo.getEmail());
            messageHelper.setFrom("i102443@163.com", "1024.glod博客");
            mailSender.send(mimeMessage);
        } catch (MessagingException | UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}
