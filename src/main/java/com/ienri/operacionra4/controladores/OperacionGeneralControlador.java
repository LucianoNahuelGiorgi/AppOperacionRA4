package com.ienri.operacionra4.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.ienri.operacionra4.avisos.ErrorAviso;
import com.ienri.operacionra4.servicios.ProcedimientoEncendidoServicio;
import com.ienri.operacionra4.servicios.PruebaFuncionServicio;
import com.ienri.operacionra4.servicios.UsuarioServicio;

@Controller
@RequestMapping("/operacion-general")
public class OperacionGeneralControlador {
	
	@Autowired
	UsuarioServicio usuarioServicio;
	
	@Autowired
	ProcedimientoEncendidoServicio procedimientoEncendidoServicio;
	
	@Autowired
	PruebaFuncionServicio pruebaFuncionServicio;

	@PreAuthorize("hasAnyRole('ROLE_ACTIVO')")
	@GetMapping("/general")
	public ModelAndView general() {
		ModelAndView mav = new ModelAndView("operacion-general");
		
		return mav;
	}

	@PreAuthorize("hasAnyRole('ROLE_ACTIVO')")
	@GetMapping("/encendido")
	public ModelAndView encendido() {
		ModelAndView mav = new ModelAndView("procedimiento-encendido");
		
		return mav;
	}

	@PreAuthorize("hasAnyRole('ROLE_ACTIVO')")
	@GetMapping("/apagado")
	public ModelAndView apagado() {
		ModelAndView mav = new ModelAndView("procedimiento-apagado");
		
		return mav;
	}

	@PreAuthorize("hasAnyRole('ROLE_ACTIVO')")
	@GetMapping("/prueba-funcion")
	public ModelAndView pruebaFuncion() {
		ModelAndView mav = new ModelAndView("prueba-funcion");
		
		return mav;
	}

	@PreAuthorize("hasAnyRole('ROLE_ACTIVO')")
	@GetMapping("/operacion")
	public ModelAndView operacion() throws ErrorAviso {
		ModelAndView mav = new ModelAndView("operacion");
		
		List<String> jrLista = usuarioServicio.buscarNombreJefeReactorActivo();
		List<String> opLista = usuarioServicio.buscarNombreOperadorActivo();
		List<String> ofLista = usuarioServicio.buscarNombreOficialRPActivo();

		mav.addObject("jrLista", jrLista);
		mav.addObject("opLista", opLista);
		mav.addObject("ofLista", ofLista);
		
		return mav;
	}

	@PreAuthorize("hasAnyRole('ROLE_ACTIVO')")
	@PostMapping("/procedimiento-encendido")
	public RedirectView checkListEncendido(Boolean cbox1, Boolean cbox2, Boolean cbox3, Boolean cbox4, Boolean cbox5, Boolean cbox6, Boolean cbox7, Boolean cbox8,
											Boolean cbox9, Boolean cbox10, Boolean cbox11, Boolean cbox12, Boolean cbox13, Boolean cbox14, Boolean cbox15,
											Boolean cbox16, Boolean cbox17, Boolean cbox18, Boolean cbox19, Boolean cbox20, Boolean cbox21, Boolean cbox22,
											Boolean cbox23, Boolean cbox24, Boolean cbox25, Boolean cbox26, String observaciones) {
		
		procedimientoEncendidoServicio.guardar(cbox1, cbox2, cbox3, cbox4, cbox5, cbox6, cbox7, cbox8, cbox9, cbox10,
												cbox11, cbox12, cbox13, cbox14, cbox15, cbox16, cbox17, cbox18, cbox19, cbox20,
												cbox21, cbox22, cbox23, cbox24, cbox25, cbox26, observaciones);
		
		return new RedirectView("/operacion-general/operacion");
	}

	@PreAuthorize("hasAnyRole('ROLE_ACTIVO')")
	@PostMapping("/prueba-funcion")
	public RedirectView valoresPruebaFuncion(Integer indicacionFATCA, Integer indicadorFATMG, Integer indicadorFATCP,
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
		
		pruebaFuncionServicio.guardar(indicacionFATCA, indicadorFATMG, indicadorFATCP, temperaturaN, escalimetroTCUno, indicadorIntLogaritmicoTCUno, indicadorIntLinealTCUno, escalimetroTCDos, indicadorIntLogaritmicoTCDos, indicadorIntLinealTCDos, indicadorIntensidadFDB, indicadorIntensidadFDA, indicadorDesconexionTC, registradorDesconexionTC, indicadorConexionTC, registradorConexionTC, indicadorFDBCanalLog, registradorFDBCanalLog, indicadorPreAlertaCanalLog, registradorPreAlertaCanalLog, indicadorFDACanalLog, registradorFDACanalLog, indicadorConmutarCanalLineal, registradorCanalLineal, indicadorFDACanalLineal, registradorFDACanalLineal, fallaEquipoCL, fallaATCP, indicadorDGammaAlta, indicadorFallaMG, observacones);

		return new RedirectView("/operacion-general/operacion");
	}
}