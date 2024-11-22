package com.apisdo.amigosecreto.controllers;

import com.apisdo.amigosecreto.dtos.DeseoDto;
import com.apisdo.amigosecreto.dtos.ListaDeseosRequestDto;
import com.apisdo.amigosecreto.services.DeseoService;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeseoController {

  private final DeseoService deseoService;

  public DeseoController(DeseoService deseoService) {
    this.deseoService = deseoService;
  }

  @GetMapping("/{jugador_id}/{juego_id}/deseos")
  public List<DeseoDto> getDeseos(@PathVariable("jugador_id") int jugadorId, @PathVariable("juego_id") int juegoId) {
    return deseoService.getDeseos(jugadorId, juegoId);
  }

  @PostMapping("/lista/deseos/crear")
  public List<DeseoDto> guardarListaDeseos(@RequestBody final ListaDeseosRequestDto listaDesosRequest) {
    return deseoService.crearListaDeseos(listaDesosRequest);
  }

  @PutMapping("/lista/deseos/actualizar")
  public List<DeseoDto> actualizarListaDeseos(@RequestBody final ListaDeseosRequestDto listaDesosRequest) {
    return deseoService.actualizarListaDeseos(listaDesosRequest);
  }

}
