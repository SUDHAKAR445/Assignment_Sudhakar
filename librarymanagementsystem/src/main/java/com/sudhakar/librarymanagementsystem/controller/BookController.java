package com.sudhakar.librarymanagementsystem.controller;

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

import com.sudhakar.librarymanagementsystem.entity.Book;
import com.sudhakar.librarymanagementsystem.service.BookService;

@RestController
@RequestMapping("api/book")
public class BookController {

    @Autowired
    BookService bookService;

    @GetMapping("/get-all-books")
    public ResponseEntity<List<Book>> getAllBooks() {
        return bookService.getAllBooks();
    }

    @GetMapping("/get/{bookIdOrIsbn}")
    public ResponseEntity<Book> getBookByBookIdOrIsbn(@PathVariable String bookIdOrIsbn) {
        return bookService.getBookByBookIdOrIsbn(bookIdOrIsbn);
    }

    @PostMapping("/save-book")
    public ResponseEntity<Book> saveBook(@RequestBody Book book) {
        return bookService.saveBook(book);
    }

    @PutMapping("/update/{bookIdOrIsbn}")
    public ResponseEntity<Book> updateBookByBookIdOrIsbn(@PathVariable String bookIdOrIsbn,
            @RequestBody Book updateBook) {
        return bookService.updateBookByBookIdOrIsbn(bookIdOrIsbn, updateBook);
    }

    @DeleteMapping("/delete/{bookIdOrIsbn}")
    public ResponseEntity<Void> deleteBookByBookIdOrIsbn(@PathVariable String bookIdOrIsbn) {
        return bookService.deleteBookByBookIdOrIsbn(bookIdOrIsbn);
    }

    @GetMapping("/get/by-genre")
    public ResponseEntity<List<Book>> getBooksByGenre(@PathVariable String genre) {
        return bookService.getBooksByGenre(genre);
    }

    @GetMapping("/get/by-title")
    public ResponseEntity<List<Book>> getBookByTitle(@PathVariable String title) {
        return bookService.getBooksByTitle(title);
    }

    @GetMapping("/get/by-author/{authorId}")
    public ResponseEntity<List<Book>> getBooksByAuthorId(@PathVariable String authorId) {
        return bookService.getBooksByAuthorId(authorId);
    }

}
