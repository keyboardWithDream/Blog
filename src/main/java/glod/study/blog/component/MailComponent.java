package glod.study.blog.component;

import glod.study.blog.domain.UserInfo;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.text.SimpleDateFormat;
import java.util.Date;

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
        System.out.println(userInfo);
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        //发送高级邮件
        try {
            MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage, true);
            messageHelper.setSubject("欢迎注册1024.glod博客");
            messageHelper.setText("<div style=\"background-color:#ECECEC; padding: 35px;\">\n" +
                    "    <table cellpadding=\"0\" align=\"center\"\n" +
                    "           style=\"width: 600px; margin: 0px auto; text-align: left; position: relative; border-top-left-radius: 5px; border-top-right-radius: 5px; border-bottom-right-radius: 5px; border-bottom-left-radius: 5px; font-size: 14px; font-family:微软雅黑, 黑体; line-height: 1.5; box-shadow: rgb(153, 153, 153) 0px 0px 5px; border-collapse: collapse; background-position: initial initial; background-repeat: initial initial;background:#fff;\">\n" +
                    "        <tbody>\n" +
                    "        <tr>\n" +
                    "            <th valign=\"middle\"\n" +
                    "                style=\"height: 25px; line-height: 25px; padding: 15px 35px; border-bottom-width: 1px; border-bottom-style: solid; border-bottom-color: #42a3d3; background-color: #49bcff; border-top-left-radius: 5px; border-top-right-radius: 5px; border-bottom-right-radius: 0px; border-bottom-left-radius: 0px;\">\n" +
                    "                <font face=\"微软雅黑\" size=\"5\" style=\"color: rgb(255, 255, 255); \">注册成功! （阿里云）</font>\n" +
                    "            </th>\n" +
                    "        </tr>\n" +
                    "        <tr>\n" +
                    "            <td>\n" +
                    "                <div style=\"padding:25px 35px 40px; background-color:#fff;\">\n" +
                    "                    <h2 style=\"margin: 5px 0px; \">\n" +
                    "                        <font color=\"#333333\" style=\"line-height: 20px; \">\n" +
                    "                            <font style=\"line-height: 22px; \" size=\"4\">\n" +
                    "                                亲爱的 "+ userInfo.getUsername() +"</font>\n" +
                    "                        </font>\n" +
                    "                    </h2>\n" +
                    "                    <p>首先感谢您加入1024.glod！下面是您的账号信息<br>\n" +
                    "                        您的邮箱：<b>"+userInfo.getEmail()+"</b><br>\n" +
                    "                        您注册时的日期：<b>"+userInfo.getRegistrationTime()+"</b><br>\n" +
                    "                        您注册时的IP：<b>"+userInfo.getIp()+"</b><br>\n" +
                    "                        当您在使用本网站时，请遵守法律法规。<br>\n" +
                    "                        如果您有什么疑问请联系，Email: 1353662613@qq.com\n" +
                    "                    <p align=\"right\">1024.glod</p>\n" +
                    "                    <p align=\"right\">"+ new SimpleDateFormat( "yyyy年MM月dd HH时mm分").format(new Date()) +"</p>\n" +
                    "                    <div style=\"width:700px;margin:0 auto;\">\n" +
                    "                        <div style=\"padding:10px 10px 0;border-top:1px solid #ccc;color:#747474;margin-bottom:20px;line-height:1.3em;font-size:12px;\">\n" +
                    "                            <p>此为系统邮件，请勿回复<br>\n" +
                    "                                请保管好您的邮箱，避免账号被他人盗用\n" +
                    "                            </p>\n" +
                    "                            <p>©1024.glod</p>\n" +
                    "                        </div>\n" +
                    "                    </div>\n" +
                    "                </div>\n" +
                    "            </td>\n" +
                    "        </tr>\n" +
                    "        </tbody>\n" +
                    "    </table>\n" +
                    "</div>", true);
            messageHelper.setTo(userInfo.getEmail());
            messageHelper.setFrom("i102443@163.com");
            mailSender.send(mimeMessage);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
