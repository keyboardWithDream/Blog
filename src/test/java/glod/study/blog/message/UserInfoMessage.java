package glod.study.blog.message;

import org.junit.jupiter.api.Test;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

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
        template.convertAndSend("amq.direct", "user.email","test@test.com");
    }

    @Test
    void testReceive(){
        Object email = template.receiveAndConvert("user.email");
        System.out.println(email);
    }
}
