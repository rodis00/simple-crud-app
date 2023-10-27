package com.rodis00.backend.controller;

import com.rodis00.backend.exception.BookNotFoundException;
import com.rodis00.backend.model.Book;
import com.rodis00.backend.service.BookService;
import com.rodis00.backend.utils.JwtTokenUtil;
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

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

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

    @GetMapping("/restricted-books")
    public ResponseEntity<Object> getRestrictedBooks(@RequestHeader(name = "Authorization", required = false) String token) {
        if (token == null)
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Unauthorized. Token required.");
        else {
            String realToken = token.substring(7);
            String checkToken = jwtTokenUtil.validateToken(realToken);
            if(checkToken.equalsIgnoreCase("valid")) {
                List<String> restrictedBooks = List.of(
                        "\"Magical Hieroglyphs and Logograms\" by Bathilda Bagshot",
                        "Moste Potente Potions",
                        "The Invisible Book of Invisibility",
                        "\"Achievements in Charming\" by S. F. Newt",
                        "\"Magical Theory\" by Adalbert Waffling"
                );
                return ResponseEntity.ok(restrictedBooks);
            }
            else
                return  ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Dear Student, you are Unauthorized to be here :)");
        }
    }
}
