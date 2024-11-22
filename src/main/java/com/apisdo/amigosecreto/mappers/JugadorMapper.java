package com.apisdo.amigosecreto.mappers;

import com.apisdo.amigosecreto.dtos.JugadorResponseDto;
import com.apisdo.amigosecreto.entities.JugadorEntity;

public class JugadorMapper {
  public static JugadorResponseDto toDto(JugadorEntity jugador) {
    return new JugadorResponseDto(
        jugador.getNombre(),
        jugador.getEmail(),
        jugador.getTelefono()
    );
  }

  public static JugadorEntity toEntity(JugadorResponseDto jugadorDto) {
    return new JugadorEntity(
        null,
        jugadorDto.nombre,
        jugadorDto.email,
        jugadorDto.telefono
    );
  }

}
