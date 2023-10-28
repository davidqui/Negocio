package com.develop.negocio.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Getter
@Setter
@Entity
@Table(name = "EMPLEADO")
public class Empleado {
    @Id
    @Column(name = "EMPLEADO_ID", nullable = false)
    private Integer id;

    @Size(max = 50)
    @Column(name = "NOMBRE", length = 50)
    private String nombre;

    @Size(max = 50)
    @Column(name = "APELLIDO", length = 50)
    private String apellido;

    @Column(name = "SALARIO", precision = 10, scale = 2)
    private BigDecimal salario;

    @Size(max = 15)
    @Column(name = "NIT", length = 15)
    private String nit;

    @Size(max = 100)
    @Column(name = "CORREO", length = 100)
    private String correo;

    @Column(name = "FECHA_CONTRATO")
    private LocalDate fechaContrato;

}