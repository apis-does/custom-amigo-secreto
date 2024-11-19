package com.apisdo.amigosecreto.controllers;

import com.apisdo.amigosecreto.dtos.DeseoResponseDto;
import com.apisdo.amigosecreto.dtos.JugadorResponseDto;
import com.apisdo.amigosecreto.dtos.SorteoResponseDto;
import com.apisdo.amigosecreto.entities.SorteoEntity;
import com.apisdo.amigosecreto.services.SorteoService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SorteoController {

  private final SorteoService sorteoService;

  public SorteoController(SorteoService sorteoService) {
    this.sorteoService = sorteoService;
  }

  //Retorna el sorteo de un juego específico y de un jugador específico
  @GetMapping("/{id_juego}/{id_jugador}/sorteo")
  public SorteoResponseDto getSorteoPorJugador(@PathVariable Long id_juego) {
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
    JugadorResponseDto jugadorD = new JugadorResponseDto("Doris",
        "doris.salazar.jv@gmail.com",
        994376854,
        new ArrayList<>());
    JugadorResponseDto jugadorV = new JugadorResponseDto("Valentina", "vale.salazar.fernandez.12@gmail.com",994376854,
        deseosDoris);

    return new ArrayList<>(
        List.of(new SorteoResponseDto(jugadorD, jugadorV),
            new SorteoResponseDto(jugadorV, jugadorD))
    ).stream().findFirst().orElse(null);
  }

  @GetMapping("/{juego_id}/sorteo")
  public List<SorteoEntity> getSorteoPorJuego(@PathVariable("juego_id") int juegoId) {
    return sorteoService.getSorteosPorJuego(juegoId);
  }

  @PostMapping("/juego/sorteo")
  public List<SorteoEntity> crearSorteo(@RequestParam("juego_id") int juegoId, @RequestParam("list_jugador_id") List<Integer> listJugadorId) {
    return sorteoService.crearSorteo(juegoId, listJugadorId);
  }

}
