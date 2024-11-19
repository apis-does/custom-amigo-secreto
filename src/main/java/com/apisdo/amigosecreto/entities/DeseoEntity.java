package com.apisdo.amigosecreto.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "deseo")
@Entity
public class DeseoEntity {
  @Id
  @Column(name = "deseo_id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer deseoId;

  @Column(name = "nombre", nullable = false)
  private String nombre;

  @Column(name = "descripcion")
  private String descripcion;

  @Column(name = "url")
  private String url;

  @Column(name = "precio")
  private Long precio;

  @ManyToOne
  @JoinColumn(name = "jugador_id")
  private JugadorEntity jugador;

  @ManyToOne
  @JoinColumn(name = "juego_id")
  private JuegoEntity juego;
}
