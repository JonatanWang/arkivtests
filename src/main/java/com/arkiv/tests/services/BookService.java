package com.arkiv.tests.services;

import com.arkiv.tests.models.Book;
import java.util.List;

public interface BookService {
    List<Book> getBooks();
    Book getBookById(String id);
    List<Book> searchBooks(String title);
}
