package com.ienri.operacionra4.repositorios;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ienri.operacionra4.entidades.OperacionGeneral;

@Repository
public interface OperacionGeneralRepositorio extends JpaRepository<OperacionGeneral, String> {
	
	@Query(value = "SELECT MAX(o.numero) FROM OperacionGeneral o")
	public Integer ultimaOperacionGeneral();
	
	@Query(value = "SELECT MAX(o.fechaHoraInicio) FROM OperacionGeneral o")
	public Date fechaInicioOpGeneral();	
}
