package com.apisdo.amigosecreto.services;

import com.apisdo.amigosecreto.dtos.JuegoRequestDto;
import com.apisdo.amigosecreto.dtos.JuegoResponseDto;
import com.apisdo.amigosecreto.mappers.JuegoMapper;
import com.apisdo.amigosecreto.repositories.Interfaces.IJuegoRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class JuegoService {

  private final IJuegoRepository iJuegoRepository;

  public JuegoService(IJuegoRepository iJuegoRepository) {
    this.iJuegoRepository = iJuegoRepository;
  }

  public JuegoResponseDto getJuego(int juegoId) {
    return iJuegoRepository.findById(juegoId)
        .map(JuegoMapper::toDto)
        .orElseThrow(() -> new EntityNotFoundException("Juego no encontrado con ID: " + juegoId));
  }

  @Transactional
  public JuegoResponseDto actualizarJuego(JuegoRequestDto juego) {
    return iJuegoRepository.findById(juego.juegoId)
        .map(juegoExistente -> {
          JuegoMapper.updateEntity(juego, juegoExistente);
          return iJuegoRepository.save(juegoExistente);
        })
        .map(JuegoMapper::toDto)
        .orElseThrow(() -> new EntityNotFoundException("Juego no encontrado con ID: " + juego.juegoId));
  }

  @Transactional
  public JuegoResponseDto crearJuego(JuegoRequestDto juego) {
    try {
      return JuegoMapper.toDto(iJuegoRepository.save(JuegoMapper.toEntity(juego)));
    } catch (Exception e) {
      throw new EntityNotFoundException("Error al guardar el juego: " + e.getMessage());
    }
  }
}
