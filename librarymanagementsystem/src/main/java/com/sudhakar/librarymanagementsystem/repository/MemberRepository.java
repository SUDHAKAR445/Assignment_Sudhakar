package com.sudhakar.librarymanagementsystem.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sudhakar.librarymanagementsystem.entity.Member;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {

    boolean existsByUsernameOrEmail(String username, String email);

    Optional<Member> findByUsernameOrEmail(String usernameOrEmail);

    List<Member> findByRole(String role);
}
