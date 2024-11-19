package com.apisdo.amigosecreto.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@Entity
@Table(name = "jugador")
@AllArgsConstructor
@NoArgsConstructor
public class JugadorEntity {
  @Id
  @Column(name = "jugador_id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer jugadorId;

  @Column(name = "nombre", nullable = false)
  private String nombre;

  @Column(name = "email", nullable = false)
  private String email;

  @Column(name = "telefono", nullable = false)
  private Long telefono;
}
