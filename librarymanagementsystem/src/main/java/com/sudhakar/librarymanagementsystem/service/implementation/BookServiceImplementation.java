package com.sudhakar.librarymanagementsystem.service.implementation;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.sudhakar.librarymanagementsystem.entity.Book;
import com.sudhakar.librarymanagementsystem.exception.DuplicateBookException;
import com.sudhakar.librarymanagementsystem.repository.BookRepository;
import com.sudhakar.librarymanagementsystem.service.BookService;

@Service
public class BookServiceImplementation implements BookService {

    @Autowired
    BookRepository bookRepository;

    public ResponseEntity<List<Book>> getAllBooks() {
        try {
            List<Book> books = bookRepository.findAll();
            return new ResponseEntity<>(books, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<Book> getBookByBookIdOrIsbn(String bookIdOrIsbn) {
        try {
            Optional<Book> optionalBook = bookRepository.findByBookIdOrIsbn(bookIdOrIsbn, bookIdOrIsbn);
            return optionalBook.map(book -> new ResponseEntity<>(book, HttpStatus.OK))
                    .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<Book> saveBook(Book book) {
        try {
            if (bookRepository.existsByBookIdOrIsbn(book.getBookId(), book.getIsbn())) {
                throw new DuplicateBookException("BookId  already exists.");
            }

            Book savedBook = bookRepository.save(book);
            return new ResponseEntity<>(savedBook, HttpStatus.CREATED);
        } catch (DuplicateBookException e) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<Book> updateBookByBookIdOrIsbn(String bookIdOrIsbn, Book updatedBook) {
        try {
            if (updatedBook == null) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            Optional<Book> optionalBook = bookRepository.findByBookIdOrIsbn(bookIdOrIsbn, bookIdOrIsbn);

            if (optionalBook.isPresent()) {

                Book existingBook = optionalBook.get();

                existingBook.setBookId(
                        updatedBook.getBookId() != null ? updatedBook.getBookId() : existingBook.getBookId());
                existingBook
                        .setTitle(updatedBook.getTitle() != null ? updatedBook.getTitle() : existingBook.getTitle());
                existingBook.setAuthor(
                        updatedBook.getAuthor() != null ? updatedBook.getAuthor() : existingBook.getAuthor());
                existingBook
                        .setGenre(updatedBook.getGenre() != null ? updatedBook.getGenre() : existingBook.getGenre());
                existingBook.setIsbn(updatedBook.getIsbn() != null ? updatedBook.getIsbn() : existingBook.getIsbn());
                existingBook.setPublicationYear(updatedBook.getPublicationYear() != 0 ? updatedBook.getPublicationYear()
                        : existingBook.getPublicationYear());
                existingBook.setCreatedAt(
                        updatedBook.getCreatedAt() != null ? updatedBook.getCreatedAt() : existingBook.getCreatedAt());

                Book savedBook = bookRepository.save(existingBook);
                return new ResponseEntity<>(savedBook, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<Void> deleteBookByBookIdOrIsbn(String bookIdOrIsbn) {
        try {
            Optional<Book> optionalBook = bookRepository.findByBookIdOrIsbn(bookIdOrIsbn, bookIdOrIsbn);
            if (optionalBook.isPresent()) {
                bookRepository.delete(optionalBook.get());
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<List<Book>> getBooksByGenre(String genre) {
        try {
            List<Book> books = bookRepository.findByGenre(genre);
            return new ResponseEntity<>(books, HttpStatus.OK);
        } catch (NullPointerException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<List<Book>> getBooksByTitle(String title) {
        try {
            List<Book> books = bookRepository.findByTitle(title);
            return new ResponseEntity<>(books, HttpStatus.OK);
        } catch (NullPointerException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<List<Book>> getBooksByAuthorId(String author) {
        try {
            List<Book> books = bookRepository.findByAuthorId(author);
            return new ResponseEntity<>(books, HttpStatus.OK);
        } catch (NullPointerException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}

