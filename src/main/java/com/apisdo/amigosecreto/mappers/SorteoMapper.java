package com.apisdo.amigosecreto.mappers;

import com.apisdo.amigosecreto.dtos.JugadorDeseoResponseDto;
import com.apisdo.amigosecreto.dtos.DeseoDto;
import com.apisdo.amigosecreto.dtos.JugadorResponseDto;
import com.apisdo.amigosecreto.dtos.SorteoResponseDto;
import com.apisdo.amigosecreto.entities.DeseoEntity;
import com.apisdo.amigosecreto.entities.SorteoEntity;
import java.util.ArrayList;
import java.util.List;

public class SorteoMapper {

  public static SorteoResponseDto toDto(SorteoEntity sorteo, List<DeseoEntity> deseos) {
    List<DeseoDto> deseosDto = new ArrayList<>();
    for (DeseoEntity deseo : deseos) {
      deseosDto.add(DeseoMapper.toDto(deseo));
    }
    return new SorteoResponseDto(
        new JugadorResponseDto(
            sorteo.getJugador().getNombre(),
            sorteo.getJugador().getEmail(),
            sorteo.getJugador().getTelefono()
        ),
        new JugadorDeseoResponseDto(
            sorteo.getAmigoSecreto().getNombre(),
            sorteo.getAmigoSecreto().getEmail(),
            sorteo.getAmigoSecreto().getTelefono(),
            deseosDto
        )
    );
  }
}
