package com.rodis00.backend.service;

import com.rodis00.backend.exception.BookNotFoundException;
import com.rodis00.backend.model.Book;
import com.rodis00.backend.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService implements BookServiceInterface {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Book saveBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public Book getBookById(Long id) {
        return bookRepository.findById(id)
                .orElseThrow(() -> new BookNotFoundException(id));
    }

    @Override
    public List<Book> getBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Book updateBook(Long id, Book book) {
        Book oldBook = getBookById(id);
        oldBook.setTitle(book.getTitle());
        oldBook.setRating(book.getRating());
        return bookRepository.save(oldBook);
    }

    @Override
    public Book patchUpdateBook(Long id, Book book) {
        Book oldBook = getBookById(id);
        if (book.getTitle() != null) oldBook.setTitle(book.getTitle());
        if (book.getRating() > 0) oldBook.setRating(book.getRating());
        return bookRepository.save(oldBook);
    }

    @Override
    public Book deleteBook(Long id) {
        Book toDelete = getBookById(id);
        bookRepository.delete(toDelete);
        return toDelete;
    }
}
