package ru.monya.firstWebSB.notesSpringBootDatabase;

//import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//import springfox.documentation.builders.RequestHandlerSelectors;
//import springfox.documentation.spi.DocumentationType;
//import springfox.documentation.spring.web.plugins.Docket;
//import springfox.documentation.swagger2.annotations.EnableSwagger2;

//@EnableSwagger2
@Configuration
public class SwaggerConfig {
//    @Bean
//    public Docket api() {
//        return new Docket(DocumentationType.SWAGGER_2)
//                .select()
//                .apis(RequestHandlerSelectors.basePackage("ru.monya.notesSpringBootDatabase"))
//                .build();
//    }

    @Bean
    public OpenAPI apiInfo() {
        return new OpenAPI().info(new Info().title("API для внесения комментариев, сообщений, пожеланий и жалоб в мою базу данных. Для чтения всех заметок воспользуйтесь методом GET/Try it out/Execute").version("1.0.0"));
    }

    @Bean
    public GroupedOpenApi httpApi() {
        return GroupedOpenApi.builder()
                .group("http")
                .pathsToMatch("/api/notes/**")
                .build();
    }
}

