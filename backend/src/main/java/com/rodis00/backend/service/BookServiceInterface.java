package com.rodis00.backend.service;

import com.rodis00.backend.model.Book;

import java.util.List;

public interface BookServiceInterface {
    Book saveBook(Book book);
    Book getBookById(Long id);
    List<Book> getBooks();
    Book updateBook(Long id, Book book);
    Book patchUpdateBook(Long id, Book book);
    Book deleteBook(Long id);
}
