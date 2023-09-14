package com.utn.tp1persistencia.entidades;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Rubro implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String denominacion;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @JoinColumn(name= "rubro_id")

    @Builder.Default
    private List<Producto> productos = new ArrayList<>();

    public void agregarProducto(Producto prod){
        productos.add(prod);
    }
    public void mostrarProductos(){
        System.out.println("Producto del rubro " + denominacion);
        for (Producto producto : productos){
            System.out.println("De Tipo: " + producto.getTipo() + "Con un tiempo estimado de cocina " + producto.getTiempoEstimadoCocina() + "Denominacion:" + producto.getDenominacion() + "receta:" + producto.getReceta());
        }
    }
}
