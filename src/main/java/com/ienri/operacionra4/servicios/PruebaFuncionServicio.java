package com.ienri.operacionra4.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ienri.operacionra4.entidades.PruebaFuncion;
import com.ienri.operacionra4.repositorios.PruebaFuncionRepositorio;

@Service
public class PruebaFuncionServicio {

	@Autowired
	PruebaFuncionRepositorio pruebaFuncionRepositorio;

	@Transactional
	public void guardar(Integer indicacion_01, Integer indicacion_02, Integer indicacion_03, Double indicacion_04,
			Integer indicacion_05, Double indicacion_06, Double indicacion_07, Integer indicacion_08,
			Double indicacion_09, Double indicacion_10, Double indicacion_11, Double indicacion_12,
			Double indicacion_13, Integer indicacion_14, Double indicacion_15, Integer indicacion_16,
			Double indicacion_17, Integer indicacion_18, Double indicacion_19, Integer indicacion_20,
			Double indicacion_21, Integer indicacion_22, Double indicacion_23, Double indicacion_24,
			Double indicacion_25, Double indicacion_26, Boolean indicacion_27, Boolean indicacion_28,
			Integer indicacion_29, Integer indicacion_30, String observaciones) {

		PruebaFuncion pf = new PruebaFuncion(indicacion_01, indicacion_02, indicacion_03, indicacion_04, indicacion_05,
				indicacion_06, indicacion_07, indicacion_08, indicacion_09, indicacion_10, indicacion_11, indicacion_12,
				indicacion_13, indicacion_14, indicacion_15, indicacion_16, indicacion_17, indicacion_18, indicacion_19,
				indicacion_20, indicacion_21, indicacion_22, indicacion_23, indicacion_24, indicacion_25, indicacion_26,
				indicacion_27, indicacion_28, indicacion_29, indicacion_30, observaciones);

		pruebaFuncionRepositorio.save(pf);
	}
}
