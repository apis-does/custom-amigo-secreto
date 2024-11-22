package com.apisdo.amigosecreto.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DeseoDto {
  public int deseoId;
  public String nombre;
  public String descripcion;
  public String url;
  public long precio;
}
