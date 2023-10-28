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
@Table(name = "PERSONA")
public class Persona {
    @Id
    @Column(name = "ID", nullable = false)
    private Integer id;

    @Size(max = 50)
    @Column(name = "NOMBRE", length = 50)
    private String nombre;

    @Size(max = 50)
    @Column(name = "APELLIDO", length = 50)
    private String apellido;

    @Column(name = "FECHA_NACIMIENTO")
    private LocalDate fechaNacimiento;

    @Size(max = 15)
    @Column(name = "NIT", length = 15)
    private String nit;

    @Column(name = "EDAD")
    private Short edad;

    @Column(name = "FECHA_CONTRATO")
    private LocalDate fechaContrato;

    @Size(max = 100)
    @Column(name = "CORREO", length = 100)
    private String correo;

    @Column(name = "SALARIO", precision = 10, scale = 2)
    private BigDecimal salario;

}