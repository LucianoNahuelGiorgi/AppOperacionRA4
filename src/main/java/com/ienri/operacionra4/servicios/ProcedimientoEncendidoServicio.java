package com.ienri.operacionra4.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ienri.operacionra4.entidades.ProcedimientoEncendido;
import com.ienri.operacionra4.repositorios.ProcedimientoEncendidoRepositorio;

@Service
public class ProcedimientoEncendidoServicio {
	@Autowired
	ProcedimientoEncendidoRepositorio procedimientoEncendidoRepositorio;
	
	@Transactional
	public void guardar(Boolean check1, Boolean check2, Boolean check3, Boolean check4, Boolean check5, Boolean check6, Boolean check7, Boolean check8,
			Boolean check9, Boolean check10, Boolean check11, Boolean check12, Boolean check13, Boolean check14, Boolean check15,
			Boolean check16, Boolean check17, Boolean check18, Boolean check19, Boolean check20, Boolean check21, Boolean check22,
			Boolean check23, Boolean check24, Boolean check25, Boolean check26, String observacones) {

		ProcedimientoEncendido pe = new ProcedimientoEncendido(check1, check2, check3, check4, check5, check6, check7, check8, check9, check10,
															   check11, check12, check13, check14, check15, check16, check17, check18, check19,
															   check20, check21, check22, check23, check24, check25, check26, observacones);
		
		procedimientoEncendidoRepositorio.save(pe);
	}

}