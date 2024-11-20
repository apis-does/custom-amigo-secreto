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

  @GetMapping("/{juego_id}/sorteo")
  public List<SorteoResponseDto> getSorteoPorJuego(@PathVariable("juego_id") int juegoId) {
    return sorteoService.getSorteosPorJuego(juegoId);
  }

  @PostMapping("/juego/sorteo")
  public List<SorteoEntity> crearSorteo(@RequestParam("juego_id") int juegoId, @RequestParam("list_jugador_id") List<Integer> listJugadorId) {
    return sorteoService.crearSorteo(juegoId, listJugadorId);
  }

}
