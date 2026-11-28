package com.merida.tecnm.gym_backend.domain.service;

import com.merida.tecnm.gym_backend.domain.Membership;
import com.merida.tecnm.gym_backend.domain.repository.MembershipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class MembershipService {

    @Autowired
    private MembershipRepository membershipRepository;

    public List<Membership> getAll() {
        return membershipRepository.getAll();
    }

    public Optional<List<Membership>> getByMember(String memberId) {
        return membershipRepository.getByMember(memberId);
    }

    public Optional<Membership> getMembership(int membershipId) {
        return membershipRepository.getMembership(membershipId);
    }

    @Transactional
    public Membership save(Membership membership) {
        if (membership.getStartDate() == null) {
            membership.setStartDate(LocalDateTime.now());
        }
        if (membership.getState() == null || membership.getState().isBlank()) {
            membership.setState("ACTIVA");
        }
        if (membership.getItems() != null) {
            membership.getItems().forEach(item -> {
                if (item.getQuantity() == null) {
                    item.setQuantity(1);
                }
                if (item.getActive() == null) {
                    item.setActive(true);
                }
            });
        }
        return membershipRepository.save(membership);
    }

    @Transactional
    public Optional<Membership> update(int membershipId, Membership membership) {
        return getMembership(membershipId).map(existing -> {
            membership.setMembershipId(membershipId);
            if (membership.getStartDate() == null) {
                membership.setStartDate(existing.getStartDate());
            }
            if (membership.getMemberId() == null) {
                membership.setMemberId(existing.getMemberId());
            }
            if (membership.getItems() == null || membership.getItems().isEmpty()) {
                membership.setItems(existing.getItems());
            }
            return membershipRepository.save(membership);
        });
    }

    @Transactional
    public boolean delete(int membershipId) {
        return getMembership(membershipId).map(membership -> {
            membershipRepository.delete(membershipId);
            return true;
        }).orElse(false);
    }
}
