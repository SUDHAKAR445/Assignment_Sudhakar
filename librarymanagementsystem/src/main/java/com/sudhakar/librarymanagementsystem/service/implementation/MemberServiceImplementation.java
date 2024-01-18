package com.sudhakar.librarymanagementsystem.service.implementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.sudhakar.librarymanagementsystem.entity.Member;
import com.sudhakar.librarymanagementsystem.entity.Role;
import com.sudhakar.librarymanagementsystem.exception.DuplicateMemberException;
import com.sudhakar.librarymanagementsystem.repository.MemberRepository;
import com.sudhakar.librarymanagementsystem.service.MemberService;

@Service
public class MemberServiceImplementation implements MemberService {

    @Autowired
    MemberRepository memberRepository;

    public ResponseEntity<List<Member>> getAllMembers() {
        try {
            List<Member> members = memberRepository.findAll();
            return new ResponseEntity<>(members, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<Member> saveMember(Member member) {
        try {
            if (memberRepository.existsByUsernameOrEmail(member.getUsername(), member.getEmail())) {
                throw new DuplicateMemberException("Username or email already exists.");
            }

            Member savedMember = memberRepository.save(member);
            return new ResponseEntity<>(savedMember, HttpStatus.CREATED);
        } catch (DuplicateMemberException e) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<Member> getMemberByUsernameOrEmail(String usernameOrEmail) {
        try {
            Optional<Member> optionalMember = memberRepository.findByUsernameOrEmail(usernameOrEmail);
            return optionalMember.map(member -> new ResponseEntity<>(member, HttpStatus.OK))
                    .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<Member> updateMemberByUsernameOrEmail(String usernameOrEmail, Member updateMember) {
        try {
            Optional<Member> optionalMember = memberRepository.findByUsernameOrEmail(usernameOrEmail);

            if (optionalMember.isPresent()) {
                Member existingMember = optionalMember.get();

                existingMember.setFirstName(updateMember.getFirstName() != null ? updateMember.getFirstName()
                        : existingMember.getFirstName());
                existingMember.setLastName(
                        updateMember.getLastName() != null ? updateMember.getLastName() : existingMember.getLastName());
                existingMember.setEmail(
                        updateMember.getEmail() != null ? updateMember.getEmail() : existingMember.getEmail());
                existingMember.setUsername(
                        updateMember.getUsername() != null ? updateMember.getUsername() : existingMember.getUsername());
                existingMember.setPassword(
                        updateMember.getPassword() != null ? updateMember.getPassword() : existingMember.getPassword());
                existingMember.setRole(existingMember.getRole());

                Member savedMember = memberRepository.save(existingMember);
                return new ResponseEntity<>(savedMember, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<Void> deleteMemberByUsernameOrEmail(String usernameOrEmail) {
        try {
            Optional<Member> optionalMember = memberRepository.findByUsernameOrEmail(usernameOrEmail);
            if (optionalMember.isPresent()) {
                memberRepository.delete(optionalMember.get());
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<List<Member>> getMembersByRole(String role) {
        try {
            if (isValidRole(role)) {
                List<Member> members = memberRepository.findByRole(role);
                return new ResponseEntity<>(members, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    private boolean isValidRole(String role) {
        try {
            Role.valueOf(role.toUpperCase());
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }
}

