package com.sudhakar.library.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sudhakar.library.entity.Transaction;
import com.sudhakar.library.entity.TransactionStatus;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {

        List<Transaction> findByTransactionStatus(TransactionStatus status);

        Transaction findByUserUsernameOrUserEmailAndBookBookIdAndTransactionStatus(String username,
                        String email, String bookId, TransactionStatus status);

        List<Transaction> findByUserUsernameOrUserEmailAndTransactionStatus(String username, String email,
                        TransactionStatus status);

        List<Transaction> findByUserUsernameOrUserEmail(String username, String email);

}
