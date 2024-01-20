package com.sudhakar.library.repository;

import java.util.List;
import java.util.Optional;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sudhakar.library.entity.Author;
import com.sudhakar.library.entity.Book;
import com.sudhakar.library.entity.Publisher;

@Repository
public interface BookRepository extends JpaRepository<Book, Long>{

    @Query("SELECT b FROM Book b WHERE b.publicationYear BETWEEN :startYear AND :endYear AND b.genre = :genre")
    List<Book> findBooksByPublicationYearAndGenre(
            @Param("startYear") int startYear,
            @Param("endYear") int endYear,
            @Param("genre") String genre
    );

    @Query("SELECT b FROM Book b WHERE b.publicationYear BETWEEN :startYear AND :endYear")
    List<Book> findBooksByPublicationYear(
            @Param("startYear") int startYear,
            @Param("endYear") int endYear
    );


    List<Book> findByPublicationYear(int year);

    boolean existsByBookIdOrIsbn(String bookId, String isbn);

    List<Book> findByGenre(String genre);

    List<Book> findByTitle(String title);

    List<Book> findByAuthorAuthorIdOrAuthorAuthorName(String authorId, String authorName);

    Optional<Book> findByBookIdOrIsbn(String bookId, String isbn);

    List<Book> findByPublisherPublisherIdOrPublisherPublisherName(String publisherId, String publisherName);

    List<Book> findByAuthor(Author existingAuthor);

    Optional<Book> findByBookId(String bookId);

    List<Book> findByPublisher(Publisher existingPublisher);
}
