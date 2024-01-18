package com.sudhakar.library.service.implementation;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.sudhakar.library.entity.Author;
import com.sudhakar.library.entity.Book;
import com.sudhakar.library.entity.Publisher;
import com.sudhakar.library.exception.DuplicateBookException;
import com.sudhakar.library.repository.AuthorRepository;
import com.sudhakar.library.repository.BookRepository;
import com.sudhakar.library.repository.PublisherRepository;
import com.sudhakar.library.service.BookService;

@Service
public class BookServiceImplementation implements BookService {

    @Autowired
    BookRepository bookRepository;

    @Autowired
    AuthorRepository authorRepository;

    @Autowired
    PublisherRepository publisherRepository;

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
                throw new DuplicateBookException("BookId or ISBN already exists.");
            }

            Optional<Author> optionalAuthor = authorRepository.findByAuthorId(book.getAuthor().getAuthorId());
            Optional<Publisher> optionalPublisher = publisherRepository.findByPublisherId(book.getPublisher().getPublisherId());

            book.setCreatedAt(new Date());
            Book savedBook;
            if (optionalAuthor.isPresent() && optionalPublisher.isPresent()) {
                book.setAuthor(optionalAuthor.get());
                savedBook = bookRepository.save(book);
            } else {
                savedBook = bookRepository.save(book);
            }
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
                existingBook.setBookId(updatedBook.getBookId() != null ? updatedBook.getBookId() : existingBook.getBookId());
                existingBook.setTitle(updatedBook.getTitle() != null ? updatedBook.getTitle() : existingBook.getTitle());
                existingBook.setAuthor(updatedBook.getAuthor() != null ? updatedBook.getAuthor() : existingBook.getAuthor());
                existingBook.setGenre(updatedBook.getGenre() != null ? updatedBook.getGenre() : existingBook.getGenre());
                existingBook.setIsbn(updatedBook.getIsbn() != null ? updatedBook.getIsbn() : existingBook.getIsbn());
                existingBook.setPublicationYear(
                        updatedBook.getPublicationYear() != 0 ? updatedBook.getPublicationYear() : existingBook.getPublicationYear());
                existingBook.setCreatedAt(
                        updatedBook.getCreatedAt() != null ? updatedBook.getCreatedAt() : existingBook.getCreatedAt());
                existingBook.setPublisher(
                        updatedBook.getPublisher() != null ? updatedBook.getPublisher() : existingBook.getPublisher());
                existingBook.setAvailableQuantity(
                        updatedBook.getAvailableQuantity() != 0 ? updatedBook.getAvailableQuantity() : existingBook.getAvailableQuantity());
    
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

    public ResponseEntity<List<Book>> getAllBooksByPublisherIdOrPublisherName(String publisherIdOrPublisherName) {
        try {
            List<Book> books = bookRepository.findByPublisherPublisherIdOrPublisherPublisherName(
                    publisherIdOrPublisherName, publisherIdOrPublisherName);
    
            if (!books.isEmpty()) {
                return new ResponseEntity<>(books, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @Override
    public ResponseEntity<List<Book>> getAllBooksByAuthorIdOrAuthorName(String authorIdOrAuthorName) {
        try {
            List<Book> books = bookRepository.findByAuthorAuthorIdOrAuthorAuthorName(
                    authorIdOrAuthorName, authorIdOrAuthorName);
    
            if (!books.isEmpty()) {
                return new ResponseEntity<>(books, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
}
