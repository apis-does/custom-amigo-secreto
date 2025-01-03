package com.apisdo.amigosecreto.dtos;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class JugadorResponseDto {
  public String nombre;
  public String email;
  public long telefono;
}
