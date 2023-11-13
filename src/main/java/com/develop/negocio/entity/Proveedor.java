package com.develop.negocio.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.Objects;

@Data
@Entity
@Table(name = "PROVEEDOR", schema = "C##NEGOCIO", catalog = "")
public class Proveedor {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "PROVEEDOR_ID")
    private Integer proveedorId;

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
    @Column(name = "CORREO_ELECTRONICO")
    private String correoElectronico;

    @Basic
    @Column(name = "PAGINA_WEB")
    private String paginaWeb;

    @Size(max = 255)
    @Column(name = "INFORMACION_BANCARIA")
    private String informacionBancaria;


    @Basic
    @Column(name = "PRODUCTOS_OFRECIDOS")
    private String productosOfrecidos;

    @Basic
    @Column(name = "TIEMPO_ENTREGA")
    private Byte tiempoEntrega;

    @Basic
    @Column(name = "CALIFICACION")
    private Short calificacion;

    @Basic
    @Column(name = "ESTADO")
    private String estado;

    @Column(name = "NOTAS", length = 255) // Ajusta la longitud de la columna
    private String notas;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Proveedor that = (Proveedor) o;
        return Objects.equals(proveedorId, that.proveedorId) && Objects.equals(personaId, that.personaId) && Objects.equals(telefono, that.telefono) && Objects.equals(direccion, that.direccion) && Objects.equals(correoElectronico, that.correoElectronico) && Objects.equals(paginaWeb, that.paginaWeb) && Objects.equals(informacionBancaria, that.informacionBancaria) && Objects.equals(productosOfrecidos, that.productosOfrecidos) && Objects.equals(tiempoEntrega, that.tiempoEntrega) && Objects.equals(calificacion, that.calificacion) && Objects.equals(estado, that.estado) && Objects.equals(notas, that.notas);
    }

    @Override
    public int hashCode() {
        return Objects.hash(proveedorId, personaId, telefono, direccion, correoElectronico, paginaWeb, informacionBancaria, productosOfrecidos, tiempoEntrega, calificacion, estado, notas);
    }
}
