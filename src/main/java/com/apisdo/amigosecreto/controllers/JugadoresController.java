package com.apisdo.amigosecreto.controllers;

import com.apisdo.amigosecreto.dtos.DeseoDto;
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
    List<DeseoDto> deseosDoris = List.of(
        DeseoDto.builder()
            .nombre("Libro de arte")
            .descripcion("Libro de arte digital avanzado")
            .url("https://example.com/libro-arte")
            .precio(15990)
            .build(),
        DeseoDto.builder()
            .nombre("Audífonos")
            .build()
    );
    List<JugadorResponseDto> jugadores = new ArrayList<>();
    return jugadores;
  }
}
