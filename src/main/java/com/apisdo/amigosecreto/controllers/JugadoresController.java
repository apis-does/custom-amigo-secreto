package com.apisdo.amigosecreto.controllers;

import com.apisdo.amigosecreto.dtos.DeseoResponseDto;
import com.apisdo.amigosecreto.dtos.JugadorResponseDto;
import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JugadoresController {

  // Retorna los jugadores de un juego específico
  @GetMapping("/{id_juego}/jugadores")
  public List<JugadorResponseDto> get(@PathVariable Long id_juego) {
    List<DeseoResponseDto> deseosDoris = List.of(
        DeseoResponseDto.builder()
            .nombre("Libro de arte")
            .descripcion("Libro de arte digital avanzado")
            .url("https://example.com/libro-arte")
            .precio(15990)
            .build(),
        DeseoResponseDto.builder()
            .nombre("Audífonos")
            .build()
    );
    List<JugadorResponseDto> jugadores = new ArrayList<>();
    jugadores.add(new JugadorResponseDto("Doris", "doris.salazar.jv@gmail.com",994376854, deseosDoris));
    jugadores.add(new JugadorResponseDto("Valentina", "vale.salazar.fernandez.12@gmail.com",994376854, deseosDoris));
    return jugadores;
  }
}
