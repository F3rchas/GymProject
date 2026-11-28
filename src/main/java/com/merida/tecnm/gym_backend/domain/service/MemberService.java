package com.merida.tecnm.gym_backend.domain.service;

import com.merida.tecnm.gym_backend.domain.Member;
import com.merida.tecnm.gym_backend.domain.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MemberService {

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public List<Member> getAll() {
        return memberRepository.getAll();
    }

    public Optional<Member> getMember(String memberId) {
        return memberRepository.getMember(memberId);
    }

    public Optional<Member> getByEmail(String email) {
        return memberRepository.getByEmail(email);
    }

    public Member save(Member member) {
        if (member.getPassword() != null && !member.getPassword().isBlank()) {
            if (!member.getPassword().startsWith("$2a$")) {
                member.setPassword(passwordEncoder.encode(member.getPassword()));
            }
        }
        if (member.getActive() == null) {
            member.setActive(true);
        }
        return memberRepository.save(member);
    }

    public Optional<Member> update(String memberId, Member member) {
        return memberRepository.getMember(memberId).map(existing -> {
            member.setMemberId(memberId);
            if (member.getPassword() != null && !member.getPassword().isBlank()) {
                if (!member.getPassword().startsWith("$2a$")) {
                    member.setPassword(passwordEncoder.encode(member.getPassword()));
                }
            } else {
                member.setPassword(existing.getPassword());
            }
            if (member.getActive() == null) {
                member.setActive(existing.getActive());
            }
            return memberRepository.save(member);
        });
    }

    public boolean delete(String memberId) {
        return getMember(memberId).map(member -> {
            memberRepository.delete(memberId);
            return true;
        }).orElse(false);
    }
}
