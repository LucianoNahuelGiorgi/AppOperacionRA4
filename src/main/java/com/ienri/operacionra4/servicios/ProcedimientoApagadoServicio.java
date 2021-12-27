package com.ienri.operacionra4.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ienri.operacionra4.entidades.ProcedimientoApagado;
import com.ienri.operacionra4.repositorios.ProcedimientoApagadoRepositorio;

@Service
public class ProcedimientoApagadoServicio {
	
	@Autowired
	ProcedimientoApagadoRepositorio procedimientoApagadoRepositorio;
	
	@Transactional
	public void guardar(Boolean check1, Boolean check2, Boolean check3, Boolean check4, Boolean check5, Boolean check6, Boolean check7, Boolean check8, String observaciones) {

		ProcedimientoApagado pa = new ProcedimientoApagado(check1, check2, check3, check4, check5, check6, check7, check8, observaciones);
	
		try {
			procedimientoApagadoRepositorio.save(pa);			
		} catch (Exception e) {
			System.out.println("No se pudo persistir el procedimiento de apagado");
		}
	}	
}
