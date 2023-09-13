package com.utn.tp1persistencia.repositorios;

import com.utn.tp1persistencia.entidades.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
