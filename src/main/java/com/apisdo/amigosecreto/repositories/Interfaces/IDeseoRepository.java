package com.apisdo.amigosecreto.repositories.Interfaces;

import com.apisdo.amigosecreto.entities.DeseoEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDeseoRepository extends JpaRepository<DeseoEntity, Integer> {
  List<DeseoEntity> findByJugador_JugadorIdAndJuego_JuegoId(Integer jugadorId, Integer juegoId);
}
