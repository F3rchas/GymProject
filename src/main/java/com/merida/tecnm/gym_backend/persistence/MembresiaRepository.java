package com.merida.tecnm.gym_backend.persistence;

import com.merida.tecnm.gym_backend.domain.Membership;
import com.merida.tecnm.gym_backend.domain.repository.MembershipRepository;
import com.merida.tecnm.gym_backend.persistence.crud.MembresiaCrudRepository;
import com.merida.tecnm.gym_backend.persistence.entity.Membresia;
import com.merida.tecnm.gym_backend.persistence.mapper.MembershipMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class MembresiaRepository implements MembershipRepository {

    @Autowired
    private MembresiaCrudRepository membresiaCrudRepository;

    @Autowired
    private MembershipMapper mapper;

    @Override
    public List<Membership> getAll() {
        return mapper.toMemberships((List<Membresia>) membresiaCrudRepository.findAll());
    }

    @Override
    public Optional<List<Membership>> getByMember(String memberId) {
        return membresiaCrudRepository.findByIdMiembro(memberId)
                .map(mapper::toMemberships);
    }

    @Override
    public Optional<Membership> getMembership(int membershipId) {
        return membresiaCrudRepository.findById(membershipId).map(mapper::toMembership);
    }

    @Override
    public Membership save(Membership membership) {
        Membresia membresia = mapper.toMembresia(membership);
        if (membresia.getPlanes() != null) {
            membresia.getPlanes().forEach(plan -> plan.setMembresia(membresia));
        }
        return mapper.toMembership(membresiaCrudRepository.save(membresia));
    }

    @Override
    public void delete(int membershipId) {
        membresiaCrudRepository.deleteById(membershipId);
    }
}
