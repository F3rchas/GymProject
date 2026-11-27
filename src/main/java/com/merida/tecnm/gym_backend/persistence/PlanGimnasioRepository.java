package com.merida.tecnm.gym_backend.persistence;

import com.merida.tecnm.gym_backend.domain.Plan;
import com.merida.tecnm.gym_backend.domain.repository.PlanRepository;
import com.merida.tecnm.gym_backend.persistence.crud.PlanCrudRepository;
import com.merida.tecnm.gym_backend.persistence.entity.PlanGimnasio;
import com.merida.tecnm.gym_backend.persistence.mapper.PlanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class PlanGimnasioRepository implements PlanRepository {

    @Autowired
    private PlanCrudRepository planCrudRepository;

    @Autowired
    private PlanMapper mapper;

    @Override
    public List<Plan> getAll() {
        List<PlanGimnasio> planes = (List<PlanGimnasio>) planCrudRepository.findAll();
        return mapper.toPlans(planes);
    }

    @Override
    public List<Plan> getActivePlans() {
        List<PlanGimnasio> planes = planCrudRepository.findByEstadoTrueOrderByNombreAsc();
        return mapper.toPlans(planes);
    }

    @Override
    public Optional<Plan> getPlan(int planId) {
        return planCrudRepository.findById(planId).map(mapper::toPlan);
    }

    @Override
    public Plan save(Plan plan) {
        PlanGimnasio planGimnasio = mapper.toPlanGimnasio(plan);
        return mapper.toPlan(planCrudRepository.save(planGimnasio));
    }

    @Override
    public void delete(int planId) {
        planCrudRepository.deleteById(planId);
    }
}
