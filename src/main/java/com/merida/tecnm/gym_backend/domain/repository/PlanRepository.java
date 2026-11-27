package com.merida.tecnm.gym_backend.domain.repository;

import com.merida.tecnm.gym_backend.domain.Plan;

import java.util.List;
import java.util.Optional;

public interface PlanRepository {

    List<Plan> getAll();
    List<Plan> getActivePlans();
    Optional<Plan> getPlan(int planId);
    Plan save(Plan plan);
    void delete(int planId);
}
