package com.utn.tp1persistencia.repositorios;

import com.utn.tp1persistencia.entidades.Domicilio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DomicilioRepository extends JpaRepository<Domicilio, Long> {
}
