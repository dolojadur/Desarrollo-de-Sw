package com.utn.tp1persistencia.repositorios;

import com.utn.tp1persistencia.entidades.Rubro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RubroRepository extends JpaRepository<Rubro, Long> {
}
