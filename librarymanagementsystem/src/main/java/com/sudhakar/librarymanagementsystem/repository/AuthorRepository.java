package com.sudhakar.librarymanagementsystem.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sudhakar.librarymanagementsystem.entity.Author;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long>{

    Optional<Author> findByAuthorId(String authorId);

    Optional<Author> findByAuthorName(String authorName);

    boolean existsByAuthorId(String authorId);
}
