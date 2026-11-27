package com.merida.tecnm.gym_backend.domain.repository;

import com.merida.tecnm.gym_backend.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {

    List<Member> getAll();
    Optional<Member> getMember(String memberId);
    Optional<Member> getByEmail(String email);
    Member save(Member member);
    void delete(String memberId);
}
