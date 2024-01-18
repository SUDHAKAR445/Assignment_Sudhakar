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

import com.sudhakar.librarymanagementsystem.entity.Author;
import com.sudhakar.librarymanagementsystem.entity.Book;
import com.sudhakar.librarymanagementsystem.service.AuthorService;

@RestController
@RequestMapping("/api/author")
public class AuthorController {

    @Autowired
    AuthorService authorService;

    @GetMapping("/get-all-authors")
    public ResponseEntity<List<Author>> getAllAuthors() {
        return authorService.getAllAuthors();
    }

    @GetMapping("/get-all-books/{authorId}")
    public ResponseEntity<List<Book>> getAllBooksByAuthor(@PathVariable String authorId) {
        return authorService.getAllBooksByAuthorId(authorId);
    }

    @GetMapping("/get-all-books/{authorName}")
    public ResponseEntity<List<Book>> getAllBooksByAuthorName(@PathVariable String authorId) {
        return authorService.getAllBooksByAuthorName(authorId);
    }

    @PostMapping("/create-author")
    public ResponseEntity<Author> createAuthor(@RequestBody Author author) {
        return authorService.createAuthor(author);
    }

    @PutMapping("/update-author/{authorId}")
    public ResponseEntity<Author> updateAuthorByAuthorId(@PathVariable String authorId, @RequestBody Author updatedAuthor) {
        return authorService.updateAuthorByAuthorId(authorId, updatedAuthor);
    }

    @DeleteMapping("/delete-author/{authorId}")
    public ResponseEntity<Void> deleteAuthorByAuthorId(@PathVariable String authorId) {
        return authorService.deleteAuthorByAuthorId(authorId);
    }
}

