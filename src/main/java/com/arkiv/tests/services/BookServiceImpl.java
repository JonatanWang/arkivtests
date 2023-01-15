package com.arkiv.tests.services;

import com.arkiv.tests.models.Book;
import com.arkiv.tests.repositories.BookRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepositoryImpl bookRepositoryImpl;

    @Override
    public List<Book> getBooks() {

        return bookRepositoryImpl.getAllBooks();
    }

    @Override
    public Book getBookById(String id) {

        return bookRepositoryImpl.findById(id);
    }

    @Override
    public List<Book> searchBooks(String title) {

        return bookRepositoryImpl.search(title);
    }
}
