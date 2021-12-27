package com.ienri.operacionra4.servicios;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ienri.operacionra4.entidades.OperacionGeneral;
import com.ienri.operacionra4.repositorios.OperacionGeneralRepositorio;

@Service
public class OperacionGeneralServicio {
	
	@Autowired
	OperacionGeneralRepositorio operacionGeneralRepositorio;
	
	/* Buscadores */
	@Transactional(readOnly = true)
	public Integer ultimaOperacionGeneral() {
		
		return operacionGeneralRepositorio.ultimaOperacionGeneral();
	}
	
	@Transactional(readOnly = true)
	public Date fechaInicioOpGeneral() {
		
		return operacionGeneralRepositorio.fechaInicioOpGeneral();
	}	
	/* ***************** */
	@Transactional
	public void inicioNuevaOperacionGeneral() {
		OperacionGeneral opG = new OperacionGeneral();
		
		Integer num = ultimaOperacionGeneral();
		
		try {
			if(num == null) {
				opG.setNumero(1);
				opG.setFechaHoraInicio(new Date());
			}else {
				opG.setNumero(num += 1);
				opG.setFechaHoraInicio(new Date());
			}
			
			operacionGeneralRepositorio.save(opG);
		} catch (Exception e) {
			System.out.println("No se pudo realizar la operación solicitada");
		}
	}
	
	@Transactional
	public void finNuevaOperacionGeneral() {
		OperacionGeneral opG = new OperacionGeneral();
		
		try {
			opG.setFechaHoraFin(new Date());
		} catch (Exception e) {
			System.out.println("No se pudo realizar la operación solicitada");
		}
	}
}