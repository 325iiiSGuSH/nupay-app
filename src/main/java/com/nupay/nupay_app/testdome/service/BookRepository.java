package com.nupay.nupay_app.testdome.service;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class BookRepository {

    /**
     * Retrieves a list of available books.
     *
     * @return List of book names
     */
    public List<String> getBooks() {
        List<String> books = new ArrayList<>();
        books.add("Book");
        books.add("Short book");
        books.add("Long book");

        return books;  // Returns the list of books
    }
}
