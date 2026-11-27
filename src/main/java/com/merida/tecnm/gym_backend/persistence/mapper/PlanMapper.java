package com.merida.tecnm.gym_backend.persistence.mapper;

import com.merida.tecnm.gym_backend.domain.Plan;
import com.merida.tecnm.gym_backend.persistence.entity.PlanGimnasio;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PlanMapper {

    @Mappings({
            @Mapping(source = "idPlan", target = "planId"),
            @Mapping(source = "nombre", target = "name"),
            @Mapping(source = "precio", target = "price"),
            @Mapping(source = "duracionDias", target = "durationDays"),
            @Mapping(source = "estado", target = "active")
    })
    Plan toPlan(PlanGimnasio planGimnasio);

    List<Plan> toPlans(List<PlanGimnasio> planes);

    @InheritInverseConfiguration
    @Mapping(target = "membresiasPlanes", ignore = true)
    PlanGimnasio toPlanGimnasio(Plan plan);
}
