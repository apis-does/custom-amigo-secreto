package com.apisdo.amigosecreto.services;

import com.apisdo.amigosecreto.dtos.DeseoDto;
import com.apisdo.amigosecreto.dtos.JugadorResponseDto;
import com.apisdo.amigosecreto.dtos.ListaDesosRequestDto;
import com.apisdo.amigosecreto.entities.DeseoEntity;
import com.apisdo.amigosecreto.mappers.DeseoMapper;
import com.apisdo.amigosecreto.mappers.JugadorMapper;
import com.apisdo.amigosecreto.repositories.Interfaces.IDeseoRepository;
import com.apisdo.amigosecreto.repositories.Interfaces.IJugadorRepository;
import jakarta.transaction.Transactional;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class Deseoervice {

  private final IDeseoRepository iDeseoRepository;
  private final IJugadorRepository iJugadorRepository;

  public Deseoervice(IDeseoRepository iDeseoRepository,
                     IJugadorRepository iJugadorRepository) {
    this.iDeseoRepository = iDeseoRepository;
    this.iJugadorRepository = iJugadorRepository;
  }

  public List<DeseoDto> getDeseos(int jugadorId, int juegoId) {
    return iDeseoRepository.findByJugador_JugadorIdAndJuego_JuegoId(jugadorId, juegoId)
        .stream()
        .map(DeseoMapper::toDto)
        .toList();
  }

  @Transactional
  public List<DeseoDto> crearListaDeseos(ListaDesosRequestDto listaDesos) {
    return listaDesos.deseos
        .stream()
        .map(deseo -> {
          return DeseoMapper.toDto(crearDeseo(listaDesos.jugadorId, listaDesos.juegoId, deseo));
        })
        .toList();
  }

  private DeseoEntity crearDeseo(int jugadorId, int juegoId, DeseoDto deseoDto) {
    return iDeseoRepository.save(DeseoMapper.toEntity(deseoDto, jugadorId, juegoId));
  }
}
