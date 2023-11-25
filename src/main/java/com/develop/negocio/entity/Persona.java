package com.develop.negocio.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import java.time.LocalDate;
import java.util.Objects;
import java.util.List;

@Data
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "PERSONA", schema = "C##NEGOCIO", catalog = "")
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Integer id;

    @Column(name = "NOMBRE", length = 200)
    private String nombre;

    @Column(name = "APELLIDO", length = 200)
    private String apellido;

    @Column(name = "FECHA_NACIMIENTO")
    private LocalDate fechaNacimiento;

    @Size(max = 15)
    @Column(name = "NIT")
    private String nit;

    @Column(name = "EDAD")
    private Byte edad;

    @Size(max = 100)
    @Column(name = "CORREO", length = 100)
    private String correo;

    @JsonIgnore
    @OneToMany(mappedBy = "persona", fetch = FetchType.EAGER)
    private List<Empleado> empleados;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Persona that = (Persona) o;
        return Objects.equals(id, that.id) && Objects.equals(nombre, that.nombre) && Objects.equals(apellido, that.apellido) && Objects.equals(fechaNacimiento, that.fechaNacimiento) && Objects.equals(nit, that.nit) && Objects.equals(edad, that.edad) && Objects.equals(correo, that.correo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre, apellido, fechaNacimiento, nit, edad, correo);
    }
}
