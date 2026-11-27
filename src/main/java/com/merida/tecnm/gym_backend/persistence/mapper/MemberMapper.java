package com.merida.tecnm.gym_backend.persistence.mapper;

import com.merida.tecnm.gym_backend.domain.Member;
import com.merida.tecnm.gym_backend.persistence.entity.Miembro;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MemberMapper {

    @Mappings({
            @Mapping(source = "idMiembro", target = "memberId"),
            @Mapping(source = "nombre", target = "name"),
            @Mapping(source = "apellidos", target = "lastName"),
            @Mapping(source = "celular", target = "cellphone"),
            @Mapping(source = "correoElectronico", target = "email"),
            @Mapping(source = "password", target = "password"),
            @Mapping(source = "estado", target = "active")
    })
    Member toMember(Miembro miembro);

    List<Member> toMembers(List<Miembro> miembros);

    @InheritInverseConfiguration
    @Mapping(target = "membresias", ignore = true)
    Miembro toMiembro(Member member);
}
