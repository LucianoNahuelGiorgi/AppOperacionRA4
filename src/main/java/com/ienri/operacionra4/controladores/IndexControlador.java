package com.ienri.operacionra4.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ienri.operacionra4.servicios.UsuarioServicio;

@Controller
@RequestMapping("/")
public class IndexControlador {

	@Autowired
	UsuarioServicio usuarioServicio;

	@GetMapping("/")
	public ModelAndView index() {
		ModelAndView mav = new ModelAndView("index");

		return mav;
	}

	@GetMapping("/login")
	public String sesionIn(@RequestParam(required = false) String error, @RequestParam(required = false) String logout, ModelMap modelo) {
//		administradorServicio.agregar("Luciano Nahuel", "Giorgi", 32908433, "lGiorgi", "lgiorgi@fceia.unr.edu.ar", "123456");

		if (error != null) {
			modelo.put("error", "Nombre de usuario o clave incorrectos");
		}

		if (logout != null) {
			modelo.put("logout", "Ha cerrado sesión exitosamente");
		}
		
		return "ingresar.html";
	}
	
	@PreAuthorize("hasAnyRole('ROLE_ACTIVO')")
	@GetMapping("/inicio")
	public ModelAndView inicio() {
		ModelAndView mav = new ModelAndView("inicio");
		
		return mav;
	}
}