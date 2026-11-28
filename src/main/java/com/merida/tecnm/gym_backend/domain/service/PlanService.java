package com.merida.tecnm.gym_backend.domain.service;

import com.merida.tecnm.gym_backend.domain.Plan;
import com.merida.tecnm.gym_backend.domain.repository.PlanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlanService {

    @Autowired
    private PlanRepository planRepository;

    public List<Plan> getAll() {
        return planRepository.getAll();
    }

    public List<Plan> getActivePlans() {
        return planRepository.getActivePlans();
    }

    public Optional<Plan> getPlan(int planId) {
        return planRepository.getPlan(planId);
    }

    public Plan save(Plan plan) {
        if (plan.getActive() == null) {
            plan.setActive(true);
        }
        return planRepository.save(plan);
    }

    public Optional<Plan> update(int planId, Plan plan) {
        return getPlan(planId).map(existing -> {
            plan.setPlanId(planId);
            if (plan.getActive() == null) {
                plan.setActive(existing.getActive());
            }
            return planRepository.save(plan);
        });
    }

    public boolean delete(int planId) {
        return getPlan(planId).map(plan -> {
            planRepository.delete(planId);
            return true;
        }).orElse(false);
    }
}
