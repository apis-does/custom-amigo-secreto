package com.apisdo.amigosecreto.controllers;

import com.apisdo.amigosecreto.dtos.DeseoDto;
import com.apisdo.amigosecreto.dtos.JuegoRequestDto;
import com.apisdo.amigosecreto.dtos.JuegoResponseDto;
import com.apisdo.amigosecreto.dtos.ListaDeseosRequestDto;
import com.apisdo.amigosecreto.services.DeseoService;
import com.apisdo.amigosecreto.services.JuegoService;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JuegoController {

  private final JuegoService juegoService;

  public JuegoController(JuegoService juegoService) {
    this.juegoService = juegoService;
  }

  @GetMapping("/juego/{juegoId}")
  public JuegoResponseDto getJuego(@PathVariable int juegoId) {
    return juegoService.getJuego(juegoId);
  }

  @PostMapping("/crear/juego")
  public JuegoResponseDto crearJuego(@RequestBody final JuegoRequestDto juego) {
    return juegoService.crearJuego(juego);
  }

  @PutMapping("/actualizar/juego")
  public JuegoResponseDto actualizarJuego(@RequestBody final JuegoRequestDto juego) {
    return juegoService.actualizarJuego(juego);
  }
}
