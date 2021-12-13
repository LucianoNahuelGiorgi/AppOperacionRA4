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
	public RedirectView valoresPruebaFuncion(Boolean check1, Boolean check2, Boolean check3, Boolean check4, Boolean check5, Boolean check6, Boolean check7, Boolean check8,
											Boolean check9, Boolean check10, Boolean check11, Boolean check12, Boolean check13, Boolean check14, Boolean check15,
											Boolean check16, Boolean check17, Boolean check18, Boolean check19, Boolean check20, Boolean check21, Boolean check22,
											Boolean check23, Boolean check24, Boolean check25, Boolean check27, String observacones) {

		return new RedirectView("/operacion-general/operacion");
	}
}