package com.apisdo.amigosecreto.services;

import com.apisdo.amigosecreto.entities.JuegoEntity;
import com.apisdo.amigosecreto.entities.JugadorEntity;
import com.apisdo.amigosecreto.entities.SorteoEntity;
import com.apisdo.amigosecreto.repositories.Interfaces.ISorteoRepository;
import jakarta.transaction.Transactional;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
public class SorteoService {

  private final ISorteoRepository iSorteoRepository;

  public SorteoService(ISorteoRepository iSorteoRepository) {
    this.iSorteoRepository = iSorteoRepository;
  }

  /**
   * Retorna los sorteos existentes para un juego dado.
   *
   * @param juegoId Identificador del juego.
   * @return Lista de sorteos.
   */
  public List<SorteoEntity> getSorteosPorJuego(int juegoId) {
    return iSorteoRepository.findByJuego_JuegoId(juegoId);
  }

  /**
   * Crea los sorteos para un juego si no existen previamente.
   *
   * @param juegoId       Identificador del juego.
   * @param jugadorIdList Lista de IDs de jugadores.
   * @return Lista de sorteos creados.
   */
  @Transactional
  public List<SorteoEntity> crearSorteo(int juegoId, List<Integer> jugadorIdList) {
    List<SorteoEntity> sorteosExistentes = iSorteoRepository.findByJuego_JuegoId(juegoId);
    if (!sorteosExistentes.isEmpty()) {
      return sorteosExistentes;
    }

    List<SorteoEntity> sorteos = asignarAmigosSecretos(juegoId, jugadorIdList);

    return iSorteoRepository.saveAll(sorteos);
  }

  /**
   * Asigna amigos secretos de forma circular y retorna los sorteos generados.
   *
   * @param juegoId       Identificador del juego.
   * @param jugadorIdList Lista de IDs de jugadores.
   * @return Lista de sorteos generados.
   */
  private List<SorteoEntity> asignarAmigosSecretos(int juegoId, List<Integer> jugadorIdList) {
    Collections.shuffle(jugadorIdList);

    return jugadorIdList.stream()
        .map(jugadorId -> {
          int amigoSecretoId = obtenerAmigoSiguiente(jugadorIdList, jugadorId);
          return construirSorteo(juegoId, jugadorId, amigoSecretoId);
        })
        .toList();
  }

  /**
   * Retorna el siguiente jugador en la lista como el amigo secreto.
   *
   * @param jugadorIdList Lista de IDs de jugadores.
   * @param jugadorId     ID del jugador actual.
   * @return ID del amigo secreto asignado.
   */
  private int obtenerAmigoSiguiente(List<Integer> jugadorIdList, int jugadorId) {
    int index = jugadorIdList.indexOf(jugadorId);
    return jugadorIdList.get((index + 1) % jugadorIdList.size());
  }

  /**
   * Construye un objeto SorteoEntity con los datos dados.
   *
   * @param juegoId        Identificador del juego.
   * @param jugadorId      Identificador del jugador.
   * @param amigoSecretoId Identificador del amigo secreto.
   * @return Objeto SorteoEntity construido.
   */
  private SorteoEntity construirSorteo(int juegoId, int jugadorId, int amigoSecretoId) {
    return new SorteoEntity().builder()
        .juego(JuegoEntity.builder().juegoId(juegoId).build())
        .jugador(JugadorEntity.builder().jugadorId(jugadorId).build())
        .amigoSecreto(JugadorEntity.builder().jugadorId(amigoSecretoId).build())
        .build();
  }
}