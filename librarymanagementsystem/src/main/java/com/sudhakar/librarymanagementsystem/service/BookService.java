package com.sudhakar.librarymanagementsystem.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.sudhakar.librarymanagementsystem.entity.Book;

public interface BookService {

    ResponseEntity<List<Book>> getAllBooks();

    ResponseEntity<Book> getBookByBookIdOrIsbn(String bookIdOrIsbn);

    ResponseEntity<Book> saveBook(Book book);

    ResponseEntity<Book> updateBookByBookIdOrIsbn(String bookIdOrIsbn, Book updatedBook);

    ResponseEntity<Void> deleteBookByBookIdOrIsbn(String bookIdOrIsbn);

    ResponseEntity<List<Book>> getBooksByGenre(String genre);

    ResponseEntity<List<Book>> getBooksByAuthorId(String author);

    ResponseEntity<List<Book>> getBooksByTitle(String title);
}