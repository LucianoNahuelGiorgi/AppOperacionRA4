package com.ienri.operacionra4.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.ienri.operacionra4.servicios.ProcedimientoEncendidoServicio;

@Controller
@RequestMapping("/operacion-general")
public class OperacionGeneralControlador {
	@Autowired
	ProcedimientoEncendidoServicio procedimientoEncendidoServicio;

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
	public ModelAndView operacion() {
		ModelAndView mav = new ModelAndView("operacion");
		
		return mav;
	}

	@PreAuthorize("hasAnyRole('ROLE_ACTIVO')")
	@PostMapping("/procedimiento-encendido")
	public RedirectView checkListEncendido(Boolean check1, Boolean check2, Boolean check3, Boolean check4, Boolean check5, Boolean check6, Boolean check7, Boolean check8,
											Boolean check9, Boolean check10, Boolean check11, Boolean check12, Boolean check13, Boolean check14, Boolean check15,
											Boolean check16, Boolean check17, Boolean check18, Boolean check19, Boolean check20, Boolean check21, Boolean check22,
											Boolean check23, Boolean check24, Boolean check25, Boolean check26, String observacones) {
		
		procedimientoEncendidoServicio.guardar(check1, check2, check3, check4, check5, check6, check7, check8, check9, check10,
												check11, check12, check13, check14, check15, check16, check17, check18, check19, check20,
												check21, check22, check23, check24, check25, check26, observacones);
		
		return new RedirectView("/operacion-general/prueba-funcion");
	}

	@PreAuthorize("hasAnyRole('ROLE_ACTIVO')")
	@PostMapping("/prueba-funcion")
	public RedirectView valoresPruebaFuncion(Boolean check1, Boolean check2, Boolean check3, Boolean check4, Boolean check5, Boolean check6, Boolean check7, Boolean check8,
											Boolean check9, Boolean check10, Boolean check11, Boolean check12, Boolean check13, Boolean check14, Boolean check15,
											Boolean check16, Boolean check17, Boolean check18, Boolean check19, Boolean check20, Boolean check21, Boolean check22,
											Boolean check23, Boolean check24, Boolean check25, Boolean check27, String observacones) {
		
		
		return new RedirectView("/operacion-general/operacion");
	}
}