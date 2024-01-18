package com.sudhakar.librarymanagementsystem.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.sudhakar.librarymanagementsystem.entity.Author;
import com.sudhakar.librarymanagementsystem.entity.Book;

public interface AuthorService {

    ResponseEntity<List<Author>> getAllAuthors();

    ResponseEntity<List<Book>> getAllBooksByAuthorId(String authorId);

    ResponseEntity<List<Book>> getAllBooksByAuthorName(String authorName);

    ResponseEntity<Author> createAuthor(Author author);

    ResponseEntity<Author> updateAuthorByAuthorId(String authorId, Author updatedAuthor);

    ResponseEntity<Void> deleteAuthorByAuthorId(String authorId);
}
