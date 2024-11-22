package com.apisdo.amigosecreto.dtos;

import java.util.Base64;
import java.util.List;

public class JugadorRequestDto {
  public String nombre;
  public String email;
  public long telefono;
  public List<DeseoDto> deseos;
}
