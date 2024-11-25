package com.apisdo.amigosecreto.mappers;

import com.apisdo.amigosecreto.dtos.JuegoRequestDto;
import com.apisdo.amigosecreto.dtos.JuegoResponseDto;
import com.apisdo.amigosecreto.entities.JuegoEntity;
import java.util.List;
import java.util.Optional;

public class JuegoMapper {
  public static JuegoResponseDto toDto(JuegoEntity juego) {
    return new JuegoResponseDto(
        juego.getJuegoId(),
        juego.getNombre(),
        juego.getReglas(),
        juego.getPrecioMinimo(),
        juego.getPrecioMaximo(),
        juego.getFechaInicio(),
        juego.getFechaSorteo(),
        List.of()
    );
  }

  public static JuegoEntity toEntity(JuegoRequestDto juego) {
    return new JuegoEntity(
        juego.juegoId,
        juego.nombre,
        juego.reglas,
        juego.precioMinimo,
        juego.precioMaximo,
        juego.fechaInicio,
        juego.fechaSorteo
    );
  }

  public static void updateEntity(JuegoRequestDto juego, JuegoEntity juegoEntity) {
    JuegoEntity.builder()
        .juegoId(juegoEntity.getJuegoId())
        .nombre(Optional.ofNullable(juego.nombre).orElse(juegoEntity.getNombre()))
        .reglas(Optional.ofNullable(juego.reglas).orElse(juegoEntity.getReglas()))
        .fechaInicio(Optional.ofNullable(juego.fechaInicio).orElse(juegoEntity.getFechaInicio()))
        .fechaSorteo(Optional.ofNullable(juego.fechaSorteo).orElse(juegoEntity.getFechaSorteo()))
        .precioMinimo(Optional.ofNullable(juego.precioMinimo).orElse(juegoEntity.getPrecioMinimo()))
        .precioMaximo(Optional.ofNullable(juego.precioMaximo).orElse(juegoEntity.getPrecioMaximo()))
        .build();
  }

}
