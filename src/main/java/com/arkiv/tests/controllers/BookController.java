package com.arkiv.tests.controllers;

import com.arkiv.tests.models.Book;
import com.arkiv.tests.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/api/v1/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping
    public List<Book> findAllBooks() {
        return bookService.getBooks();
    }

    @GetMapping("{id}")
    public Book findBookById(@PathVariable String id) {
        return bookService.getBookById(id);
    }

    @GetMapping("/search/{title}")
    public List<Book> searchBooks(@PathVariable String title) {
        return bookService.searchBooks(title);
    }
}
