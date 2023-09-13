package com.utn.tp1persistencia.repositorios;

import com.utn.tp1persistencia.entidades.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
}
