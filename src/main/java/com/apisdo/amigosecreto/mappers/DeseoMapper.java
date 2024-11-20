package com.apisdo.amigosecreto.mappers;

import com.apisdo.amigosecreto.dtos.DeseoResponseDto;
import com.apisdo.amigosecreto.entities.DeseoEntity;

public class DeseoMapper {
  public static DeseoResponseDto toDto(DeseoEntity deseo) {
    return new DeseoResponseDto(
        deseo.getNombre(),
        deseo.getDescripcion(),
        deseo.getUrl(),
        deseo.getPrecio()
    );
  }
}
