package com.ienri.operacionra4.servicios;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ienri.operacionra4.entidades.Operacion;
import com.ienri.operacionra4.repositorios.OperacionRepositorio;

@Service
public class OperacionServicio {

	@Autowired
	OperacionRepositorio operacionRepositorio;
	
	@Transactional
	public void guardar(String jefeReactor, String operador, String oficialRP,
						String canalCentralHorizontal, String canalLateralSupHorizontal, String canalLateralInfHorizontal, String canalCentralVertical, String canalLateralVertical,
						String motivo, String scram, Boolean muestra,
						Boolean cbox1, Boolean cbox2, Boolean cbox3, Boolean cbox4,
						Double tempNucleo,
						Double posFuente, Double posNucleo, Double posBC1, Double posBC2,
						Integer escalimetro, Double intLogCA, Double intLinCA,
						Double intLinCP, Double intLogCP,
						Double gammaConsola, Double gammaReactor,
						Double potencia, String regimen,
						String observaciones) {
		
		Operacion op = new Operacion(jefeReactor, operador, oficialRP, canalCentralHorizontal, canalLateralSupHorizontal, canalLateralInfHorizontal, canalCentralVertical,
									 canalLateralVertical, motivo, scram, muestra, cbox1, cbox2, cbox3, cbox4, new Date(), tempNucleo, posFuente, posNucleo, posBC1, posBC2,
									 escalimetro, intLogCA, intLinCA, intLinCP, intLogCP, gammaConsola, gammaReactor, potencia, regimen, observaciones);
		try {
			operacionRepositorio.save(op);			
		} catch (Exception e) {
			System.out.println("No se pudo guardar la operación");
		}
	}
	
	@Transactional(readOnly = true)
	public List<Operacion> operacionFechaDesc(){
		List<Operacion> opLista = new ArrayList<>(); 
		try {
			opLista = operacionRepositorio.operacionFechaDesc();
		} catch (Exception e) {
			System.out.println("No se pudo realizar la operación solicitada");
		}
		
		return opLista;
	}	
}