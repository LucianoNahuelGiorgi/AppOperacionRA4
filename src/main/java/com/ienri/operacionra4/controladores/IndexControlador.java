package com.ienri.operacionra4.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ienri.operacionra4.serviciosauxiliares.UsuarioAuxiliar;

@Controller
@RequestMapping("/")
public class IndexControlador {

	@Autowired
	private UsuarioAuxiliar usuarioAuxiliar;

	@GetMapping("/")
	public ModelAndView index() {
		if (usuarioAuxiliar.getLogeado() == true) {
			ModelAndView mav = new ModelAndView("index");

			mav.addObject("logeado", true);
			mav.addObject("login", false);
			mav.addObject("nombre", usuarioAuxiliar.getUsuario().getNombre());
			mav.addObject("apellido", usuarioAuxiliar.getUsuario().getApellido());

			return mav;
		} else {
			usuarioAuxiliar.setLogeado(false);
			ModelAndView mav = new ModelAndView("index");

			mav.addObject("logeado", false);
			mav.addObject("login", false);

			return mav;
		}
	}

	@GetMapping("/login")
	public ModelAndView sesionIn(@RequestParam(required = false) String error,
			@RequestParam(required = false) String logout) {
		ModelAndView mav = new ModelAndView("ingresar");

		if (error != null) {
			usuarioAuxiliar.setLogeado(false);
			
			mav.addObject("logeado", false);
			mav.addObject("login", true);
			mav.addObject("error", "Nombre de usuario o clave incorrectos");
		}

		if (logout != null) {
			usuarioAuxiliar.setLogeado(false);
			
			mav.addObject("logeado", false);
			mav.addObject("login", true);
			mav.addObject("logout", "Ha cerrado sesión exitosamente");
		}

		return mav;
	}

	@PreAuthorize("hasAnyRole('ROLE_ACTIVO')")
	@GetMapping("/inicio")
	public ModelAndView inicio() {
		if (usuarioAuxiliar.getLogeado() == true) {
			if (usuarioAuxiliar.getUsuario() != null && usuarioAuxiliar.getUsuario().getRol().equals("administrador")) {
				ModelAndView mav = new ModelAndView("inicio");

				mav.addObject("logeado", true);
				mav.addObject("login", false);
				mav.addObject("nombre", usuarioAuxiliar.getUsuario().getNombre());
				mav.addObject("apellido", usuarioAuxiliar.getUsuario().getApellido());
				mav.addObject("admin", true);

				return mav;
			} else {
				ModelAndView mav = new ModelAndView("inicio");

				mav.addObject("logeado", true);
				mav.addObject("login", false);
				mav.addObject("nombre", usuarioAuxiliar.getUsuario().getNombre());
				mav.addObject("apellido", usuarioAuxiliar.getUsuario().getApellido());
				mav.addObject("admin", false);

				return mav;
			}
		} else {
			usuarioAuxiliar.setLogeado(false);
			ModelAndView mav = new ModelAndView("inicio");

			mav.addObject("logeado", false);
			mav.addObject("login", false);

			return mav;
		}
	}
}