package glod.study.blog.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

/**
 * @Author Harlan
 * @Date 2020/10/20
 */
@Configuration
@EnableSwagger2
public class MySwaggerConfig {

    public Docket docket(Environment environment){

        Profiles profiles = Profiles.of("swagger");
        boolean flag = environment.acceptsProfiles(profiles);

        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .enable(flag)
                .select()
                .apis(RequestHandlerSelectors.basePackage("glod.study.blog.controller"))
                .build();
    }

    private ApiInfo apiInfo(){
        Contact contact = new Contact("Harlan", "http:localhost", "1353662613@qq.com");
        return new ApiInfo("swagger", "Api Doc", "v1.0", "http:localhost", contact, "Apache 2.0", "http://www.apache.org.org/licenses/LICENSE2.0", new ArrayList<>());
    }
}
