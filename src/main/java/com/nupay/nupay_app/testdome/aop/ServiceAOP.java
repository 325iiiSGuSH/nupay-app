package com.nupay.nupay_app.testdome.aop;

import com.nupay.nupay_app.testdome.callback.RepositoryCallback;
import com.nupay.nupay_app.testdome.callback.SearchCallback;
import com.nupay.nupay_app.testdome.callback.ServiceCallback;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ServiceAOP {

    @Autowired
    private ServiceCallback serviceCallback;  // Injecting ServiceCallback

    @Autowired
    private SearchCallback searchCallback;  // Injecting SearchCallback

    @Autowired
    private RepositoryCallback repositoryCallback;  // Injecting RepositoryCallback

    // Intercept all methods in the com.testdome.service package
    @Before("execution(* com.testdome.service..*(..))")
    public void serviceAdvice(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        serviceCallback.callback(methodName);  // Invoke callback with the method name
    }

    // Intercept the bookExists method of BookSearchService
    @Before("execution(* com.testdome.service.BookSearchService.bookExists(..)) && args(bookName)")
    public void searchServiceAdvice(JoinPoint joinPoint, String bookName) {
        searchCallback.callback(bookName);  // Invoke callback with the book name
    }

    // Intercept the getBooks method of BookRepository
    @Before("execution(* com.testdome.service.BookRepository.getBooks(..))")
    public void repositoryAdvice(JoinPoint joinPoint) {
        repositoryCallback.callback();  // Invoke callback
    }
}
