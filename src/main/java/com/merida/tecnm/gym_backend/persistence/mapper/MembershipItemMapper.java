package com.merida.tecnm.gym_backend.persistence.mapper;

import com.merida.tecnm.gym_backend.domain.MembershipItem;
import com.merida.tecnm.gym_backend.persistence.entity.MembresiaPlan;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface MembershipItemMapper {

    @Mappings({
            @Mapping(source = "id.idPlan", target = "planId"),
            @Mapping(source = "cantidad", target = "quantity"),
            @Mapping(source = "total", target = "total"),
            @Mapping(source = "estado", target = "active")
    })
    MembershipItem toMembershipItem(MembresiaPlan membresiaPlan);

    @InheritInverseConfiguration
    @Mappings({
            @Mapping(target = "membresia", ignore = true),
            @Mapping(target = "plan", ignore = true),
            @Mapping(target = "id.idMembresia", ignore = true)
    })
    MembresiaPlan toMembresiaPlan(MembershipItem item);
}
