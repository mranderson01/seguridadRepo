package es.rodrigo.seguridad.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;


public class SpringFoxConfig  {

   /* @Bean
    public Docket api(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiDetails())
                .select()
                .apis(RequestHandlerSelectors.withClassAnnotation(RestController.class))
                .paths(PathSelectors.ant("/api/**"))
                .build();
    }

    private ApiInfo apiDetails(){
        return new ApiInfo("Swagger API REST",
                "api doc",
                "1.0",
                "http://www.google.es",
                new Contact("Rodrigo","http://www.google.es","rodrigo.sucapuca.external@eviden.com"),
                "MIT",
                "htt`://www.google.es",
                Collections.emptyList());
    }*/
}
