package com.merida.tecnm.gym_backend.domain.repository;

import com.merida.tecnm.gym_backend.domain.Membership;

import java.util.List;
import java.util.Optional;

public interface MembershipRepository {

    List<Membership> getAll();
    Optional<List<Membership>> getByMember(String memberId);
    Optional<Membership> getMembership(int membershipId);
    Membership save(Membership membership);
    void delete(int membershipId);
}
