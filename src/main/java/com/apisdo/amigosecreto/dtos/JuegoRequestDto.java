package com.apisdo.amigosecreto.dtos;

import java.time.LocalDate;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
public class JuegoRequestDto {
  public Integer juegoId;
  public String nombre;
  public String reglas;
  public Long precioMinimo;
  public Long precioMaximo;
  public LocalDate fechaInicio;
  public LocalDate fechaSorteo;
}
