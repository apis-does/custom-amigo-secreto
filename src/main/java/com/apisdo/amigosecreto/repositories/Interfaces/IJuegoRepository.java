package com.apisdo.amigosecreto.repositories.Interfaces;

import com.apisdo.amigosecreto.entities.JuegoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IJuegoRepository extends JpaRepository<JuegoEntity, Integer> {
}
