package com.sudhakar.library.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.sudhakar.library.entity.Book;

public interface BookService {

    ResponseEntity<List<Book>> getAllBooks();

    ResponseEntity<Book> getBookByBookIdOrIsbn(String bookIdOrIsbn);

    ResponseEntity<Book> saveBook(Book book);

    ResponseEntity<Book> updateBookByBookIdOrIsbn(String bookIdOrIsbn, Book updatedBook);

    ResponseEntity<Void> deleteBookByBookIdOrIsbn(String bookIdOrIsbn);

    ResponseEntity<List<Book>> getBooksByGenre(String genre);

    ResponseEntity<List<Book>> getBooksByTitle(String title);

    ResponseEntity<List<Book>> getAllBooksByPublisherIdOrPublisherName(String publisherIdOrPublisherName);

    ResponseEntity<List<Book>> getAllBooksByAuthorIdOrAuthorName(String authorIdOrAuthorName);
}
