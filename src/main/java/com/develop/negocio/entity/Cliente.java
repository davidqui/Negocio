package com.develop.negocio.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.springframework.http.ResponseEntity;

import java.sql.Date;
import java.util.Objects;
import java.util.Optional;

@Data
@Entity
@Table(name = "CLIENTE", schema = "C##NEGOCIO", catalog = "")
public class Cliente {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "CLIENTE_ID")
    private Integer clienteId;

    @Basic
    @Column(name = "PERSONA_ID")
    private Integer personaId;

    @Basic
    @Column(name = "TELEFONO")
    private String telefono;

    @Basic
    @Column(name = "DIRECCION")
    private String direccion;

    @Basic
    @Column(name = "PREFERENCIAS")
    private String preferencias;

    @Basic
    @Column(name = "PUNTUACION")
    private Short puntuacion;

    @Basic
    @Column(name = "FECHA_REGISTRO")
    private Date fechaRegistro;

    @Basic
    @Column(name = "ULTIMA_COMPRA")
    private Date ultimaCompra;

    @Basic
    @Column(name = "CATEGORIA")
    private String categoria;

    @Column(name = "NOTAS", length = 255) // Ajusta la longitud de la columna
    private String notas;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cliente that = (Cliente) o;
        return Objects.equals(clienteId, that.clienteId) && Objects.equals(personaId, that.personaId) && Objects.equals(telefono, that.telefono) && Objects.equals(direccion, that.direccion) && Objects.equals(preferencias, that.preferencias) && Objects.equals(puntuacion, that.puntuacion) && Objects.equals(fechaRegistro, that.fechaRegistro) && Objects.equals(ultimaCompra, that.ultimaCompra) && Objects.equals(categoria, that.categoria) && Objects.equals(notas, that.notas);
    }

    @Override
    public int hashCode() {
        return Objects.hash(clienteId, personaId, telefono, direccion, preferencias, puntuacion, fechaRegistro, ultimaCompra, categoria, notas);
    }

    public Optional<ResponseEntity<Object>> map(Object o) {
        return Optional.empty();
    }
}
