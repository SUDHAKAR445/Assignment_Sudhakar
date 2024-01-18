package com.sudhakar.librarymanagementsystem.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.sudhakar.librarymanagementsystem.entity.Member;

public interface MemberService {

    ResponseEntity<List<Member>> getAllMembers();

    ResponseEntity<Member> saveMember(Member member);

    ResponseEntity<Member> getMemberByUsernameOrEmail(String usernameOrEmail);

    ResponseEntity<Member> updateMemberByUsernameOrEmail(String usernameOrEmail, Member member);

    ResponseEntity<Void> deleteMemberByUsernameOrEmail(String usernameOrEmail);

    ResponseEntity<List<Member>> getMembersByRole(String role);
}