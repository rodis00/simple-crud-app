package com.rodis00.backend.controller;

import com.rodis00.backend.exception.BookNotFoundException;
import com.rodis00.backend.model.Book;
import com.rodis00.backend.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
@CrossOrigin("*")
public class BookController {
    @Autowired
    private BookService bookService;

    @PostMapping("/add-book")
    public ResponseEntity<Book> saveBook(@RequestBody Book book) {
        Book newBook = bookService.saveBook(book);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(newBook);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getBookById(@PathVariable Long id) {
        try {
            Book book = bookService.getBookById(id);
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(book);
        } catch (BookNotFoundException e) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(e.getErrorDetails());
        }

    }

    @GetMapping("")
    public ResponseEntity<List<Book>> getAllBooks() {
        List<Book> books = bookService.getBooks();
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(books);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateBook(@PathVariable Long id, @RequestBody Book book) {
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(bookService.updateBook(id, book));
        } catch (BookNotFoundException e) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(e.getErrorDetails());
        }
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Object> patchUpdateBook(@PathVariable Long id, @RequestBody Book book) {
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(bookService.patchUpdateBook(id, book));
        } catch (BookNotFoundException e) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(e.getErrorDetails());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteBook(@PathVariable Long id) {
        try {
            return ResponseEntity
                    .status(HttpStatus.NO_CONTENT)
                    .body(bookService.deleteBook(id));
        } catch (BookNotFoundException e) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(e.getErrorDetails());
        }
    }
}
