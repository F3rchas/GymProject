package com.merida.tecnm.gym_backend.persistence.crud;

import com.merida.tecnm.gym_backend.persistence.entity.Membresia;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface MembresiaCrudRepository extends CrudRepository<Membresia, Integer> {

    Optional<List<Membresia>> findByIdMiembro(String idMiembro);
}
