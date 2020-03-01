package com.liverpool.catalogo.domain.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
public class Articulo {
    private String id;
    private String nombre;
    private String descripcion;
    private BigDecimal precio;
    private String modelo;

    @Id
    @Column(name = "id", nullable = false, length = 10)
    @Size(max = 10)
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Basic
    @Column(name = "nombre", length = 20)
    @Size(max = 20)
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Basic
    @Column(name = "descripcion", length = 200)
    @Size(max = 200)
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Basic
    @Column(name = "precio", precision = 2)
    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    @Basic
    @Column(name = "modelo", length = 10)
    @Size(max = 10)
    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Articulo articulo = (Articulo) o;
        return Objects.equals(id, articulo.id) &&
                Objects.equals(nombre, articulo.nombre) &&
                Objects.equals(descripcion, articulo.descripcion) &&
                Objects.equals(precio, articulo.precio) &&
                Objects.equals(modelo, articulo.modelo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre, descripcion, precio, modelo);
    }
}
