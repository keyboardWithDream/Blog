package glod.study.blog.message;

import glod.study.blog.domain.UserInfo;
import org.junit.jupiter.api.Test;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

/**
 * RabbitMQ测试
 * @Author Harlan
 * @Date 2020/10/17
 */
@SpringBootTest
public class UserInfoMessage {

    @Autowired
    RabbitTemplate template;

    @Test
    void testSendEmail(){
        UserInfo userInfo = new UserInfo();
        userInfo.setUsername("Harlan");
        userInfo.setIp("127.0.0.1");
        userInfo.setRegistrationTime(new Date());
        userInfo.setEmail("isharlan.hu@gmail.com");
        template.convertAndSend("amq.direct", "user.email",userInfo);
    }

    @Test
    void testReceive(){
        Object email = template.receiveAndConvert("user.email");
        System.out.println(email);
    }
}
