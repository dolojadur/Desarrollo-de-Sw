package com.utn.tp1persistencia.entidades;

import com.utn.tp1persistencia.enumeracion.estadoPedido;
import com.utn.tp1persistencia.enumeracion.tipoEnvioPedido;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Pedido implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private estadoPedido estado;
    private LocalDate fecha;
    private tipoEnvioPedido tipoEnvio;
    private double total;

    //Relacion con DetallePedido
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @JoinColumn(name= "detallePedido_id")

    @Builder.Default
    private List<DetallePedido> detalles = new ArrayList<>();

    public void agregarDetallePedido(DetallePedido deta){
        detalles.add(deta);
    }

    public void mostrarDetalles(){
        System.out.println("Detalles de pedido del pedido " + id);
        for (DetallePedido detallePedido: detalles){
            System.out.println("La cantidad pedida es: " + detallePedido.getCantidad() + "y el subtotal es: " + detallePedido.getSubtotal());
        }
    }

    //Relacion con Factura
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true, optional = true)
    @JoinColumn(name="factura_id")
    private Factura factura;
}
