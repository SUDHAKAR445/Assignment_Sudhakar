package com.sudhakar.library.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.sudhakar.library.entity.Author;
import com.sudhakar.library.service.AuthorService;

@RestController
@RequestMapping("/api/authors")
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @GetMapping("/all")
    public ResponseEntity<List<Author>> getAllAuthors() {
        return authorService.getAllAuthors();
    }

    @PostMapping("/create")
    public ResponseEntity<Author> createAuthor(@RequestBody Author author) {
        return authorService.createAuthor(author);
    }

    @PutMapping("/update/{authorId}")
    public ResponseEntity<Author> updateAuthorById(@PathVariable String authorId, @RequestBody Author updatedAuthor) {
        return authorService.updateAuthorByAuthorId(authorId, updatedAuthor);
    }

    @DeleteMapping("/delete/{authorId}")
    public ResponseEntity<Void> deleteAuthorById(@PathVariable String authorId) {
        return authorService.deleteAuthorByAuthorId(authorId);
    }
}
