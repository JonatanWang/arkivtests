package com.arkiv.tests.repositories;

import com.arkiv.tests.models.Book;
import java.util.List;

public interface BookRepository {
    List<Book> getAllBooks();
    Book findById(String id);
    List<Book> search(String title);
}
