package com.apisdo.amigosecreto.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DeseoDto {
  public String nombre;
  public String descripcion;
  public String url;
  public long precio;
}
