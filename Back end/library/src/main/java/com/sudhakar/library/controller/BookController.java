package com.sudhakar.library.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sudhakar.library.entity.Book;
import com.sudhakar.library.service.BookService;

@RestController
@RequestMapping("api/book")
public class BookController {

    @Autowired
    BookService bookService;

    @GetMapping("/get/all-books")
    public ResponseEntity<List<Book>> getAllBooks() {
        return bookService.getAllBooks();
    }

    @GetMapping("/get/book-id-or-isbn/{bookIdOrIsbn}")
    public ResponseEntity<Book> getBookByBookIdOrIsbn(@PathVariable String bookIdOrIsbn) {
        return bookService.getBookByBookIdOrIsbn(bookIdOrIsbn);
    }

    @PostMapping("/save/book")
    public ResponseEntity<Book> saveBook(@RequestBody Book book) {
        return bookService.saveBook(book);
    }

    @PutMapping("/update/book-id-or-isbn/{bookIdOrIsbn}")
    public ResponseEntity<Book> updateBookByIdentifier(@PathVariable String bookIdOrIsbn,
            @RequestBody Book updatedBook) {
        return bookService.updateBookByBookIdOrIsbn(bookIdOrIsbn, updatedBook);
    }

    @DeleteMapping("/delete/{bookIdOrIsbn}")
    public ResponseEntity<Void> deleteBookByBookIdOrIsbn(@PathVariable String bookIdOrIsbn) {
        return bookService.deleteBookByBookIdOrIsbn(bookIdOrIsbn);
    }

    @GetMapping("/get/genre")
    public ResponseEntity<List<Book>> getBooksByGenre(@PathVariable String genre) {
        return bookService.getBooksByGenre(genre);
    }

    @GetMapping("/get/by-title")
    public ResponseEntity<List<Book>> getBookByTitle(@PathVariable String title) {
        return bookService.getBooksByTitle(title);
    }

    @GetMapping("/get/book/author-id-or-name/{authorIdOrAuthorName}")
    public ResponseEntity<List<Book>> getAllBooksByAuthorIdOrAuthorName(@PathVariable String authorIdOrAuthorName) {
        return bookService.getAllBooksByAuthorIdOrAuthorName(authorIdOrAuthorName);
    }

}
