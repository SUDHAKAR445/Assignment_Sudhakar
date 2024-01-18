package com.sudhakar.librarymanagementsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sudhakar.librarymanagementsystem.entity.Member;
import com.sudhakar.librarymanagementsystem.service.MemberService;


@RestController
// @RequiredArgsConstructor
@RequestMapping("api/member")
public class MemberController {

    @Autowired
    MemberService memberService;

    @GetMapping("/get-all-members")
    public ResponseEntity<List<Member>> getAllMember() {
        return memberService.getAllMembers();
    }

    @GetMapping("/get/{usernameOrEmail}")
    public ResponseEntity<Member> getMemberByUsernameOrEmail(@PathVariable String usernameOrEmail) {
        return memberService.getMemberByUsernameOrEmail(usernameOrEmail);
    }

    @PostMapping("/save-member")
    public ResponseEntity<Member> saveMember(@RequestBody Member member) {
        return memberService.saveMember(member);
    }

    @PutMapping("/update/{usernameOrEmail}")
    public ResponseEntity<Member> updateMemberByUsernameOrEmail(@PathVariable String usernameOrEmail,
            @RequestBody Member updateMember) {
        return memberService.updateMemberByUsernameOrEmail(usernameOrEmail, updateMember);
    }

    @DeleteMapping("/delete/{usernameOrEmail}")
    public ResponseEntity<Void> deleteMemberByUsernameOrEmail(@PathVariable String usernameOrEmail) {
        return memberService.deleteMemberByUsernameOrEmail(usernameOrEmail);
    }

    @GetMapping("/get/by-role/{role}")
    public ResponseEntity<List<Member>> getMemberByRole(@PathVariable String role) {
        return memberService.getMembersByRole(role);
    }
}

