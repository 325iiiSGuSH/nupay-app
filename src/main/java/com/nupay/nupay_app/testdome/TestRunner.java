package com.nupay.nupay_app.testdome;

import com.nupay.nupay_app.testdome.service.BookSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class TestRunner implements CommandLineRunner {

    @Autowired
    private BookSearchService bookSearchService;

    @Override
    public void run(String... args) {
        // Test the AOP functionality
        System.out.println("Does 'Book' exist? " + bookSearchService.bookExists("Book"));
        System.out.println("Does 'Non-existing Book' exist? " + bookSearchService.bookExists("Non-existing Book"));
    }
}
