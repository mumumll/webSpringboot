package com.mumu.demo.config;

import com.google.common.collect.Lists;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @program: springBootDemo
 * @description: swagger文档
 * @author: mumu
 * @create: 2021-03-23 23:09
 **/
@Configuration
@EnableSwagger2
public class SwaggerConfig {
    // http://localhost:8080/swagger-ui.html#/
    @Bean
    public Docket docket() {
        ParameterBuilder builder = new ParameterBuilder();
        builder.parameterType("header").name("token")
                .description("token值")
                .required(true)
                .modelRef(new ModelRef("string")); // 在swagger里显示header

        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("user_interface")
                .apiInfo(apiInfo())
                .globalOperationParameters(Lists.newArrayList(builder.build()))
                .select().paths(PathSelectors.any()).build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("user-mini系统")
                .description("user-mini接口文档")
                .contact(new Contact("mumu", "", "103@qq.com"))
                .version("1.0")
                .build();
    }
}
