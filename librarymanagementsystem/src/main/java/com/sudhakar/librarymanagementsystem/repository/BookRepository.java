package com.sudhakar.librarymanagementsystem.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sudhakar.librarymanagementsystem.entity.Author;
import com.sudhakar.librarymanagementsystem.entity.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long>{

    Optional<Book> findByBookIdOrIsbn(String bookId, String isbn);

    boolean existsByBookIdOrIsbn(String bookId, String isbn);

    List<Book> findByGenre(String genre);

    List<Book> findByTitle(String title);
}
