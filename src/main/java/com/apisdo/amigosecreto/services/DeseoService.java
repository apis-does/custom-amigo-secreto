package com.apisdo.amigosecreto.services;

import com.apisdo.amigosecreto.dtos.DeseoDto;
import com.apisdo.amigosecreto.dtos.ListaDeseosRequestDto;
import com.apisdo.amigosecreto.entities.DeseoEntity;
import com.apisdo.amigosecreto.mappers.DeseoMapper;
import com.apisdo.amigosecreto.repositories.Interfaces.IDeseoRepository;
import com.apisdo.amigosecreto.repositories.Interfaces.IJugadorRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import java.util.List;
import org.aspectj.lang.reflect.DeclareSoft;
import org.springframework.stereotype.Service;

@Service
public class DeseoService {

  private final IDeseoRepository iDeseoRepository;

  public DeseoService(IDeseoRepository iDeseoRepository) {
    this.iDeseoRepository = iDeseoRepository;
  }

  public List<DeseoDto> getDeseos(int jugadorId, int juegoId) {
    return iDeseoRepository.findByJugador_JugadorIdAndJuego_JuegoId(jugadorId, juegoId)
        .stream()
        .map(DeseoMapper::toDto)
        .toList();
  }

  @Transactional
  public List<DeseoDto> actualizarListaDeseos(ListaDeseosRequestDto listaDeseos) {
    return listaDeseos.deseos
        .stream()
        .map(deseo -> DeseoMapper.toDto(actualizarDeseoBD(listaDeseos.jugadorId, listaDeseos.juegoId, deseo)))
        .toList();
  }

  private DeseoEntity actualizarDeseoBD(int jugadorId, int juegoId, DeseoDto deseoDto) {
    return iDeseoRepository.findById(deseoDto.deseoId)
        .map(deseo -> {
          return guardarDeseoBD(jugadorId, juegoId, deseoDto);
        })
        .orElseThrow(() -> new EntityNotFoundException("Deseo no encontrado con ID: " + deseoDto.deseoId));

  }

  @Transactional
  public List<DeseoDto> crearListaDeseos(ListaDeseosRequestDto listaDesos) {
    return listaDesos.deseos
        .stream()
        .map(deseo -> {
          return DeseoMapper.toDto(guardarDeseoBD(listaDesos.jugadorId, listaDesos.juegoId, deseo));
        })
        .toList();
  }

  private DeseoEntity guardarDeseoBD(int jugadorId, int juegoId, DeseoDto deseoDto) {
    return iDeseoRepository.save(DeseoMapper.toEntity(deseoDto, jugadorId, juegoId));
  }
}
