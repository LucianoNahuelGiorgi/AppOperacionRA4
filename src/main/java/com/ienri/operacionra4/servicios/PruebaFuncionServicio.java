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
	public void guardar(Integer indicacionFATCA, Integer indicadorFATMG, Integer indicadorFATCP,
			 Double temperaturaN, Integer escalimetroTCUno, Double indicadorIntLogaritmicoTCUno, Double indicadorIntLinealTCUno,
			 Integer escalimetroTCDos, Double indicadorIntLogaritmicoTCDos, Double indicadorIntLinealTCDos,
			 Double indicadorIntensidadFDB, Double indicadorIntensidadFDA,
			 Double indicadorDesconexionTC, Double registradorDesconexionTC, Double indicadorConexionTC, Double registradorConexionTC,
			 Double indicadorFDBCanalLog, Double registradorFDBCanalLog, Double indicadorPreAlertaCanalLog, Double registradorPreAlertaCanalLog,
			 Double indicadorFDACanalLog, Double registradorFDACanalLog,
			 Double indicadorConmutarCanalLineal, Double registradorCanalLineal,
			 Double indicadorFDACanalLineal, Double registradorFDACanalLineal,
			 Boolean fallaEquipoCL, Boolean fallaATCP,
			 Integer indicadorDGammaAlta, Integer indicadorFallaMG,
			 String observacones) {
		
		PruebaFuncion pf = new PruebaFuncion(indicacionFATCA, indicadorFATMG, indicadorFATCP, temperaturaN,
											 escalimetroTCUno, indicadorIntLogaritmicoTCUno,
											 indicadorIntLinealTCUno, escalimetroTCDos, indicadorIntLogaritmicoTCDos, indicadorIntLinealTCDos, indicadorIntensidadFDB,
											 indicadorIntensidadFDA, indicadorDesconexionTC, registradorDesconexionTC, indicadorConexionTC, registradorConexionTC,
											 indicadorFDBCanalLog, registradorFDBCanalLog, indicadorPreAlertaCanalLog, registradorPreAlertaCanalLog, indicadorFDACanalLog,
											 registradorFDACanalLog, indicadorConmutarCanalLineal, registradorCanalLineal, indicadorFDACanalLineal, registradorFDACanalLineal,
											 fallaEquipoCL, fallaATCP, indicadorDGammaAlta, indicadorFallaMG, observacones);
		
		pruebaFuncionRepositorio.save(pf);
	}
}
