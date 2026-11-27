package com.merida.tecnm.gym_backend.persistence.crud;

import com.merida.tecnm.gym_backend.persistence.entity.PlanGimnasio;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PlanCrudRepository extends CrudRepository<PlanGimnasio, Integer> {

    List<PlanGimnasio> findByEstadoTrueOrderByNombreAsc();
}
