package com.merida.tecnm.gym_backend.persistence;

import com.merida.tecnm.gym_backend.domain.Member;
import com.merida.tecnm.gym_backend.domain.repository.MemberRepository;
import com.merida.tecnm.gym_backend.persistence.crud.MiembroCrudRepository;
import com.merida.tecnm.gym_backend.persistence.entity.Miembro;
import com.merida.tecnm.gym_backend.persistence.mapper.MemberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class MiembroRepository implements MemberRepository {

    @Autowired
    private MiembroCrudRepository miembroCrudRepository;

    @Autowired
    private MemberMapper mapper;

    @Override
    public List<Member> getAll() {
        List<Miembro> miembros = (List<Miembro>) miembroCrudRepository.findAll();
        return mapper.toMembers(miembros);
    }

    @Override
    public Optional<Member> getMember(String memberId) {
        return miembroCrudRepository.findById(memberId).map(mapper::toMember);
    }

    @Override
    public Optional<Member> getByEmail(String email) {
        return miembroCrudRepository.findByCorreoElectronico(email).map(mapper::toMember);
    }

    @Override
    public Member save(Member member) {
        Miembro miembro = mapper.toMiembro(member);
        return mapper.toMember(miembroCrudRepository.save(miembro));
    }

    @Override
    public void delete(String memberId) {
        miembroCrudRepository.deleteById(memberId);
    }
}
