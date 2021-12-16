package com.ienri.operacionra4.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ienri.operacionra4.entidades.Operacion;

@Repository
public interface OperacionRepositorio extends JpaRepository<Operacion, String> {
	
	@Query(value= "SELECT o FROM Operacion o ORDER BY o.fechaHora DESC")
	public List<Operacion> operacionFechaDesc();
}