package com.utn.tp1persistencia.repositorios;

import com.utn.tp1persistencia.entidades.Factura;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FacturaRepository extends JpaRepository<Factura, Long> {
}
