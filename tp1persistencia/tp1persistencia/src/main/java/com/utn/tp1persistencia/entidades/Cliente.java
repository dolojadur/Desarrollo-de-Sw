package com.utn.tp1persistencia.entidades;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Cliente implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String nombre;
    private String apellido;
    private String telefono;
    private String email;

    //Relacion con Pedido
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch= FetchType.EAGER)
    @JoinColumn(name="pedido_id")

    @Builder.Default
    private List<Pedido> pedidos = new ArrayList<>();

    public void agregarPedido(Pedido pedi){
        pedidos.add(pedi);
    }

    public void mostrarPedidos(){
        System.out.println("Pedidos de " + nombre + " " + apellido + ":");
        for (Pedido pedido: pedidos){
            System.out.println("El pedido de id: " + pedido.getId() +" con fecha: "+pedido.getFecha() + " cuyo estado es "+pedido.getEstado() + " con tipo de envio igual a " + pedido.getTipoEnvio() + " tiene un precio total de: " + pedido.getTotal());
        }
    }

    //Relacion con Domicilio
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch= FetchType.EAGER)
    @JoinColumn(name="domicilio_id")

    @Builder.Default
    private List<Domicilio> domicilios= new ArrayList<>();

    public void agregarDomicilio(Domicilio domi){
        domicilios.add(domi);
    }
    public void mostrarDomicilios() {
        System.out.println("Domicilios de " + nombre + " " + apellido + ":");
        for (Domicilio domicilio : domicilios) {
            System.out.println("Calle: " + domicilio.getCalle() + ", Número: " + domicilio.getNumero() + ", Localidad: " + domicilio.getLocalidad());
        }
    }

    }
