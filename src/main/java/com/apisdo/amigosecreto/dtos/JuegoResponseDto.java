package com.apisdo.amigosecreto.dtos;

import java.util.List;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class JuegoResponseDto {
  public String nombre;
  public String fecha;
  public List<JugadorResponseDto> jugadores;
}
