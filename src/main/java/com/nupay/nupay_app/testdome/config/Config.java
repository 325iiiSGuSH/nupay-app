package com.nupay.nupay_app.testdome.config;

import com.nupay.nupay_app.testdome.callback.RepositoryCallback;
import com.nupay.nupay_app.testdome.callback.SearchCallback;
import com.nupay.nupay_app.testdome.callback.ServiceCallback;
import com.nupay.nupay_app.testdome.aop.ServiceAOP;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;


@Configuration
@EnableAspectJAutoProxy
@Import(ServiceAOP.class)
@ComponentScan(basePackages="com.testdome")
class Config {

    @Bean
    public ServiceCallback serviceCallback() {
        return (methodName) -> System.out.println("Executing service method: " + methodName);
    }

    @Bean
    public SearchCallback searchCallback() {
        return (book) -> System.out.println("Searching for book: " + book);
    }

    @Bean
    public RepositoryCallback repositoryCallback() {
        return () -> System.out.println("Repository called!");
    }
}
