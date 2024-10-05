package com.nupay.nupay_app.testdome.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BookSearchService {

    @Autowired
    public BookRepository bookRepository;

    public boolean bookExists(String bookName) {
        // Check if the book exists in the repository
        return bookRepository.getBooks().contains(bookName);
    }
}
