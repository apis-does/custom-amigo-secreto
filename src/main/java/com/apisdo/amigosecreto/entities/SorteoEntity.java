package com.apisdo.amigosecreto.entities;

import com.apisdo.amigosecreto.entities.JuegoEntity;
import com.apisdo.amigosecreto.entities.JugadorEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Builder;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "sorteo")
@Builder
public class SorteoEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "sorteo_id")
  private Long sorteoId;

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "juego_id", nullable = false)
  private JuegoEntity juego;

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "jugador_id", nullable = false)
  private JugadorEntity jugador;

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "amigo_secreto_id", nullable = false)
  private JugadorEntity amigoSecreto;
}
