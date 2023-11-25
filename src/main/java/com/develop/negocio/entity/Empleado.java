package com.develop.negocio.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.*;
import java.sql.Date;

@Data
@Getter
@Setter
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

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PERSONA_ID", insertable = false, updatable = false)
    private Persona persona;
}
