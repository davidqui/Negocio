package com.develop.negocio.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.sql.Date;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "EMPLEADO", schema = "C##NEGOCIO", catalog = "")
public class Empleado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "EMPLEADO_ID")
    private Integer empleadoId;

    @Basic
    @Column(name = "PERSONA_ID")
    private Integer personaId;

    @Basic
    @Column(name = "SALARIO")
    private String salario;

    @Basic
    @Column(name = "FECHA_CONTRATO")
    private Date fechaContrato;

    @Basic
    @Column(name = "CATEGORIA")
    private String categoria;

    @Basic
    @Column(name = "CARGO")
    private String cargo;
}
