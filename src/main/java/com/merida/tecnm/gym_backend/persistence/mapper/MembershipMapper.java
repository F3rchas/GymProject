package com.merida.tecnm.gym_backend.persistence.mapper;

import com.merida.tecnm.gym_backend.domain.Membership;
import com.merida.tecnm.gym_backend.persistence.entity.Membresia;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {MembershipItemMapper.class})
public interface MembershipMapper {

    @Mappings({
            @Mapping(source = "idMembresia", target = "membershipId"),
            @Mapping(source = "idMiembro", target = "memberId"),
            @Mapping(source = "fechaInicio", target = "startDate"),
            @Mapping(source = "medioPago", target = "paymentMethod"),
            @Mapping(source = "comentario", target = "comment"),
            @Mapping(source = "estado", target = "state"),
            @Mapping(source = "planes", target = "items")
    })
    Membership toMembership(Membresia membresia);

    List<Membership> toMemberships(List<Membresia> membresias);

    @InheritInverseConfiguration
    @Mapping(target = "miembro", ignore = true)
    Membresia toMembresia(Membership membership);
}
