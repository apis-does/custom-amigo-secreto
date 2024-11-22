package com.apisdo.amigosecreto.mappers;

import com.apisdo.amigosecreto.dtos.DeseoDto;
import com.apisdo.amigosecreto.entities.DeseoEntity;
import com.apisdo.amigosecreto.entities.JuegoEntity;
import com.apisdo.amigosecreto.entities.JugadorEntity;

public class DeseoMapper {
  public static DeseoDto toDto(DeseoEntity deseo) {
    return new DeseoDto(
        deseo.getNombre(),
        deseo.getDescripcion(),
        deseo.getUrl(),
        deseo.getPrecio()
    );
  }

  public static DeseoEntity toEntity(DeseoDto deseoDto, int jugadorId, int juegoId) {
    return new DeseoEntity(
        null,
        deseoDto.nombre,
        deseoDto.descripcion,
        deseoDto.url,
        deseoDto.precio,
        JugadorEntity.builder().jugadorId(jugadorId).build(),
        JuegoEntity.builder().juegoId(juegoId).build()
    );
  }
}
