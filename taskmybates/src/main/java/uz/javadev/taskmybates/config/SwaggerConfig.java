package uz.javadev.taskmybates.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI openAPI(){
        return new OpenAPI()
                .info(new Info()
                        .title("CRUD-MyBatis")
                        .description("2-topshiriq uchun berilgan")
                        .contact(new Contact()
                                .name("O'ktamov Sardorbek")
                                .url("https://t.me/s_uktamov")
                                .email("uktamov9198@mail.ru"))
                        .version("1.0.0")
                );
    }
}
