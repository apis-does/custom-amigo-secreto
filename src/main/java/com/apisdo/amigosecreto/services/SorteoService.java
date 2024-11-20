package com.apisdo.amigosecreto.services;

import com.apisdo.amigosecreto.dtos.SorteoResponseDto;
import com.apisdo.amigosecreto.entities.DeseoEntity;
import com.apisdo.amigosecreto.entities.JuegoEntity;
import com.apisdo.amigosecreto.entities.JugadorEntity;
import com.apisdo.amigosecreto.entities.SorteoEntity;
import com.apisdo.amigosecreto.mappers.SorteoMapper;
import com.apisdo.amigosecreto.repositories.Interfaces.IDeseoRepository;
import com.apisdo.amigosecreto.repositories.Interfaces.ISorteoRepository;
import jakarta.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class SorteoService {

  private final ISorteoRepository iSorteoRepository;
  private final IDeseoRepository iDeseoRepository;

  public SorteoService(ISorteoRepository iSorteoRepository,
                       IDeseoRepository iDeseoRepository) {
    this.iSorteoRepository = iSorteoRepository;
    this.iDeseoRepository = iDeseoRepository;
  }

  /**
   * Retorna los sorteos existentes para un juego dado.
   *
   * @param juegoId Identificador del juego.
   * @return Lista de sorteos.
   */
  public List<SorteoResponseDto> getSorteosPorJuego(int juegoId) {
    List<SorteoEntity> sorteos = iSorteoRepository.findByJuego_JuegoId(juegoId);

    return sorteos.stream()
        .map(sorteo -> {
          List<DeseoEntity> deseosAmigo = iDeseoRepository.findByJugador_JugadorIdAndJuego_JuegoId(
              sorteo.getAmigoSecreto().getJugadorId(),
              juegoId
          );
          return SorteoMapper.toDto(sorteo, deseosAmigo);
        })
        .toList();
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
   * Asigna amigos secretos de forma aleatoria y valida las asignaciones.
   *
   * @param juegoId       Identificador del juego.
   * @param jugadorIdList Lista de IDs de jugadores.
   * @return Lista de sorteos generados.
   */
  private List<SorteoEntity> asignarAmigosSecretos(int juegoId, List<Integer> jugadorIdList) {
    List<Integer> amigosSecretos;

    do {
      amigosSecretos = new ArrayList<>(jugadorIdList);
      Collections.shuffle(amigosSecretos);
    } while (!esSorteoValido(jugadorIdList, amigosSecretos));

    List<Integer> finalAmigosSecretos = amigosSecretos;
    return jugadorIdList.stream()
        .map(jugadorId -> {
          int amigoSecretoId = finalAmigosSecretos.get(jugadorIdList.indexOf(jugadorId));
          return construirSorteo(juegoId, jugadorId, amigoSecretoId);
        })
        .toList();
  }

  /**
   * Verifica que un sorteo sea válido (ningún jugador puede ser su propio amigo secreto).
   *
   * @param jugadorIdList Lista de IDs de jugadores.
   * @param amigosSecretos Lista de IDs asignados como amigos secretos.
   * @return true si el sorteo es válido, false si no lo es.
   */
  private boolean esSorteoValido(List<Integer> jugadorIdList, List<Integer> amigosSecretos) {
    for (int i = 0; i < jugadorIdList.size(); i++) {
      if (jugadorIdList.get(i).equals(amigosSecretos.get(i))) {
        return false; // Un jugador no puede ser su propio amigo secreto.
      }
    }
    return true;
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
