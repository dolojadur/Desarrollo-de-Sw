package com.utn.tp1persistencia.repositorios;

import com.utn.tp1persistencia.entidades.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Producto, Long> {
}
