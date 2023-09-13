package com.utn.tp1persistencia.repositorios;

import com.utn.tp1persistencia.entidades.DetallePedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DetallePedidoRepository extends JpaRepository<DetallePedido, Long> {
}
