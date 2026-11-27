package com.merida.tecnm.gym_backend.persistence.crud;

import com.merida.tecnm.gym_backend.persistence.entity.Miembro;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface MiembroCrudRepository extends CrudRepository<Miembro, String> {

    Optional<Miembro> findByCorreoElectronico(String correoElectronico);
}
