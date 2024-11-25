package com.apisdo.amigosecreto.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "juego")
@Entity
public class JuegoEntity {
  @Id
  @Column(name = "juego_id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer juegoId;

  @Column(name = "nombre", nullable = false)
  private String nombre;

  @Column(name = "reglas")
  private  String reglas;

  @Column(name = "precio_minimo")
  private Long precioMinimo;

  @Column(name = "precio_maximo")
  private Long precioMaximo;

  @Column(name = "fecha_inicio", nullable = false)
  private LocalDate fechaInicio;

  @Column(name = "fecha_sorteo", nullable = false)
  private LocalDate fechaSorteo;

}
