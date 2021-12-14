package com.ienri.operacionra4.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ienri.operacionra4.entidades.PruebaFuncion;

@Repository
public interface PruebaFuncionRepositorio extends JpaRepository<PruebaFuncion, String> {

}
