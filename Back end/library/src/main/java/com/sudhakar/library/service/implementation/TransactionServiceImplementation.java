package com.sudhakar.library.service.implementation;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.sudhakar.library.entity.Book;
import com.sudhakar.library.entity.Transaction;
import com.sudhakar.library.entity.TransactionStatus;
import com.sudhakar.library.entity.User;
import com.sudhakar.library.repository.BookRepository;
import com.sudhakar.library.repository.TransactionRepository;
import com.sudhakar.library.repository.UserRepository;
import com.sudhakar.library.service.TransactionService;

import ch.qos.logback.core.util.Duration;

@Service
public class TransactionServiceImplementation implements TransactionService {

    @Autowired
    TransactionRepository transactionRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    BookRepository bookRepository;

    public ResponseEntity<List<Transaction>> getAllTransactions() {
        try {
            List<Transaction> transactions = transactionRepository.findAll();
            return new ResponseEntity<>(transactions, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<List<Transaction>> getTransactionsByUsernameOrEmail(String usernameOrEmail) {
        try {
            List<Transaction> transactions = transactionRepository.findByUserUsernameOrUserEmail(usernameOrEmail, usernameOrEmail);
            if (!transactions.isEmpty()) {
                return new ResponseEntity<>(transactions, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    

    public ResponseEntity<Transaction> createTransaction(Transaction transaction) {
        try {
            Optional<Book> optionalBook = bookRepository.findByBookId(transaction.getBook().getBookId());
            Optional<User> optionalUser = userRepository.findByUsername(transaction.getUser().getUsername());
    
            if (optionalBook.isPresent() && optionalUser.isPresent()) {
                Book book = optionalBook.get();
    
                if (book.getAvailableQuantity() <= 0) {
                    return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
                }
    
                transaction.setBook(book);
                transaction.setUser(optionalUser.get());
                transaction.setBorrowDate(new Date());
    
                Transaction savedTransaction = transactionRepository.save(transaction);
    
                book.setAvailableQuantity(book.getAvailableQuantity() - 1);
                bookRepository.save(book);
    
                return new ResponseEntity<>(savedTransaction, HttpStatus.CREATED);
            } else {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<Transaction> returnBook(String usernameOrEmail, String bookId) {
        try {
            Optional<User> optionalUser = userRepository.findByUsernameOrEmail(usernameOrEmail, usernameOrEmail);
            Optional<Book> optionalBook = bookRepository.findByBookId(bookId);

            if (optionalUser.isPresent() && optionalBook.isPresent()) {
                Book book = optionalBook.get();

                Transaction borrowedTransaction = transactionRepository.findByUserUsernameOrUserEmailAndBookBookIdAndTransactionStatus(usernameOrEmail,usernameOrEmail, bookId, TransactionStatus.BORROW);

                if (borrowedTransaction != null) {
                    borrowedTransaction.setReturnDate(new Date());
                    borrowedTransaction.setTransactionStatus(TransactionStatus.RETURN);

                    //Calculate the fine amount
                    Duration duration = Duration.
                    book.setAvailableQuantity(book.getAvailableQuantity() + 1);
                    bookRepository.save(book);

                    Transaction savedTransaction = transactionRepository.save(borrowedTransaction);
                    return new ResponseEntity<>(savedTransaction, HttpStatus.OK);
                } else {
                    return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
                }
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<List<Transaction>> getTransactionsByStatus(TransactionStatus status) {
        try {
            List<Transaction> transactions = transactionRepository.findByTransactionStatus(status);

            if (!transactions.isEmpty()) {
                return new ResponseEntity<>(transactions, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<List<Transaction>> getTransactionByUsernameOrEmailWithStatus(String usernameOrEmail, TransactionStatus status) {
        try {
            List<Transaction> transactions = transactionRepository.findByUserUsernameOrUserEmailAndTransactionStatus(usernameOrEmail, usernameOrEmail, status);

            if (!transactions.isEmpty()) {
                return new ResponseEntity<>(transactions, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    
}

