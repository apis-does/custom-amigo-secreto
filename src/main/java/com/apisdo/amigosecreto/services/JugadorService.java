package com.apisdo.amigosecreto.services;

import com.apisdo.amigosecreto.dtos.JugadorDeseoResponseDto;
import com.apisdo.amigosecreto.dtos.JugadorResponseDto;
import com.apisdo.amigosecreto.mappers.JugadorMapper;
import com.apisdo.amigosecreto.repositories.Interfaces.IDeseoRepository;
import com.apisdo.amigosecreto.repositories.Interfaces.IJugadorRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class JugadorService {

  private final IDeseoRepository iDeseoRepository;
  private final IJugadorRepository iJugadorRepository;

  public JugadorService(IDeseoRepository iDeseoRepository,
                         IJugadorRepository iJugadorRepository) {
    this.iDeseoRepository = iDeseoRepository;
    this.iJugadorRepository = iJugadorRepository;
  }

  public JugadorResponseDto getJugador(int jugadorId) {
    return iJugadorRepository.findById(jugadorId)
        .map(jugador -> JugadorMapper.toDto(jugador))
        .orElse(null);
  }
}
