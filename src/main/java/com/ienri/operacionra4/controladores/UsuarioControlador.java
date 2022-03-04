package com.ienri.operacionra4.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.ienri.operacionra4.avisos.ErrorAviso;
import com.ienri.operacionra4.entidades.Usuario;
import com.ienri.operacionra4.servicios.PuestoEnumeracionServicio;
import com.ienri.operacionra4.servicios.UsuarioServicio;
import com.ienri.operacionra4.serviciosauxiliares.UsuarioAuxiliar;

@Controller
@RequestMapping("/usuario")
public class UsuarioControlador {
	@Autowired
	PuestoEnumeracionServicio puestoEnumeracionServicio;

	@Autowired
	UsuarioServicio usuarioServicio;

	@Autowired
	UsuarioAuxiliar usuarioAuxiliar;

	@GetMapping("/jefe-reactor-activo")
	public ModelAndView mostrarJRActivo() throws ErrorAviso {
		if (usuarioAuxiliar.getLogeado() == true) {
			if (usuarioAuxiliar.getUsuario() != null && usuarioAuxiliar.getUsuario().getRol().equals("administrador")) {
				ModelAndView mav = new ModelAndView("usuario");

				List<Usuario> u = usuarioServicio.buscarJefeReactorActivo();
				mav.addObject("u", u);

				List<String> puestos = puestoEnumeracionServicio.arregloPuesto();

				mav.addObject("logeado", true);
				mav.addObject("nombre", usuarioAuxiliar.getUsuario().getNombre());
				mav.addObject("apellido", usuarioAuxiliar.getUsuario().getApellido());
				mav.addObject("puesto", puestos);
				mav.addObject("admin", true);

				return mav;
			} else {
				ModelAndView mav = new ModelAndView("usuario");

				List<Usuario> u = usuarioServicio.buscarJefeReactorActivo();
				mav.addObject("u", u);

				mav.addObject("logeado", true);
				mav.addObject("nombre", usuarioAuxiliar.getUsuario().getNombre());
				mav.addObject("apellido", usuarioAuxiliar.getUsuario().getApellido());
				mav.addObject("admin", false);

				return mav;
			}
		} else {
			ModelAndView mav = new ModelAndView("usuario");

			List<Usuario> u = usuarioServicio.buscarJefeReactorActivo();
			mav.addObject("u", u);

			mav.addObject("logeado", false);

			return mav;
		}
	}

	@GetMapping("/operador-activo")
	public ModelAndView mostrarOpActivo() throws ErrorAviso {
		if (usuarioAuxiliar.getLogeado() == true) {
			if (usuarioAuxiliar.getUsuario() != null && usuarioAuxiliar.getUsuario().getRol().equals("administrador")) {
				ModelAndView mav = new ModelAndView("usuario");

				List<Usuario> u = usuarioServicio.buscarOperadorActivo();
				mav.addObject("u", u);

				List<String> puestos = puestoEnumeracionServicio.arregloPuesto();

				mav.addObject("logeado", true);
				mav.addObject("nombre", usuarioAuxiliar.getUsuario().getNombre());
				mav.addObject("apellido", usuarioAuxiliar.getUsuario().getApellido());
				mav.addObject("puesto", puestos);
				mav.addObject("admin", true);

				return mav;
			} else {
				ModelAndView mav = new ModelAndView("usuario");

				List<Usuario> u = usuarioServicio.buscarOperadorActivo();
				mav.addObject("u", u);

				mav.addObject("logeado", true);
				mav.addObject("nombre", usuarioAuxiliar.getUsuario().getNombre());
				mav.addObject("apellido", usuarioAuxiliar.getUsuario().getApellido());
				mav.addObject("admin", false);

				return mav;
			}
		} else {
			ModelAndView mav = new ModelAndView("usuario");

			List<Usuario> u = usuarioServicio.buscarOperadorActivo();
			mav.addObject("u", u);

			mav.addObject("logeado", false);

			return mav;
		}
	}

	@GetMapping("/oficial-activo")
	public ModelAndView mostrarOficialRPActivo() throws ErrorAviso {
		if (usuarioAuxiliar.getLogeado() == true) {
			if (usuarioAuxiliar.getUsuario() != null && usuarioAuxiliar.getUsuario().getRol().equals("administrador")) {
				ModelAndView mav = new ModelAndView("usuario");

				List<Usuario> u = usuarioServicio.buscarOficialRPActivo();
				mav.addObject("u", u);

				List<String> puestos = puestoEnumeracionServicio.arregloPuesto();

				mav.addObject("logeado", true);
				mav.addObject("nombre", usuarioAuxiliar.getUsuario().getNombre());
				mav.addObject("apellido", usuarioAuxiliar.getUsuario().getApellido());
				mav.addObject("puesto", puestos);
				mav.addObject("admin", true);

				return mav;
			} else {
				ModelAndView mav = new ModelAndView("usuario");

				List<Usuario> u = usuarioServicio.buscarOficialRPActivo();
				mav.addObject("u", u);

				mav.addObject("logeado", true);
				mav.addObject("nombre", usuarioAuxiliar.getUsuario().getNombre());
				mav.addObject("apellido", usuarioAuxiliar.getUsuario().getApellido());
				mav.addObject("admin", false);

				return mav;
			}
		} else {
			ModelAndView mav = new ModelAndView("usuario");

			List<Usuario> u = usuarioServicio.buscarOficialRPActivo();
			mav.addObject("u", u);

			mav.addObject("logeado", false);

			return mav;
		}
	}

	@GetMapping("/buscar")
	public ModelAndView buscarPorNombre(@RequestParam String nombre) throws ErrorAviso {
		ModelAndView mav = new ModelAndView("usuario");

		List<Usuario> u = usuarioServicio.buscarPorNombre(nombre);
		mav.addObject("u", u);

		return mav;
	}

	@PreAuthorize("hasAnyRole('ROLE_ACTIVO')")
	@GetMapping("/agregar")
	public ModelAndView agregar() throws ErrorAviso {
		/* Carga Usuario administrador */
//		usuarioServicio.agregar(null, "Luciano Nahuel", "Giorgi", 32908433, "123456789", "lgiorgi", "lgiorgi@fceia.unr.edu.ar", "123456", "123456", "Operador", "administrador");

		if (usuarioAuxiliar.getLogeado() == true) {
			if (usuarioAuxiliar.getUsuario() != null && usuarioAuxiliar.getUsuario().getRol().equals("administrador")) {
				ModelAndView mav = new ModelAndView("agregar-usuario");

				List<String> puestos = puestoEnumeracionServicio.arregloPuesto();

				mav.addObject("logeado", true);
				mav.addObject("nombre", usuarioAuxiliar.getUsuario().getNombre());
				mav.addObject("apellido", usuarioAuxiliar.getUsuario().getApellido());
				mav.addObject("puesto", puestos);
				mav.addObject("admin", true);

				return mav;
			} else {
				ModelAndView mav = new ModelAndView("inicio");

				mav.addObject("logeado", true);
				mav.addObject("nombre", usuarioAuxiliar.getUsuario().getNombre());
				mav.addObject("apellido", usuarioAuxiliar.getUsuario().getApellido());
				mav.addObject("admin", false);

				return mav;
			}
		} else {
			ModelAndView mav = new ModelAndView("inicio");

			mav.addObject("logeado", false);

			return mav;
		}
	}

	@PreAuthorize("hasAnyRole('ROLE_ACTIVO')")
	@GetMapping("/editar")
	public ModelAndView editar() {
		if (usuarioAuxiliar.getLogeado() == true) {
			if (usuarioAuxiliar.getUsuario() != null && usuarioAuxiliar.getUsuario().getRol().equals("administrador")) {
				ModelAndView mav = new ModelAndView("editar-usuario");

				List<Usuario> usuarios = usuarioServicio.buscarUsuarios();

				mav.addObject("logeado", true);
				mav.addObject("nombre", usuarioAuxiliar.getUsuario().getNombre());
				mav.addObject("apellido", usuarioAuxiliar.getUsuario().getApellido());
				mav.addObject("admin", true);
				mav.addObject("u", usuarios);

				return mav;
			} else {
				ModelAndView mav = new ModelAndView("inicio");

				mav.addObject("logeado", true);
				mav.addObject("nombre", usuarioAuxiliar.getUsuario().getNombre());
				mav.addObject("apellido", usuarioAuxiliar.getUsuario().getApellido());
				mav.addObject("admin", false);

				return mav;
			}
		} else {
			ModelAndView mav = new ModelAndView("inicio");

			mav.addObject("logeado", false);

			return mav;
		}
	}

	@PreAuthorize("hasAnyRole('ROLE_ACTIVO')")
	@GetMapping("/editar-usuario/{id}")
	public ModelAndView editarUsuario(@PathVariable(required = true) String id) throws ErrorAviso {
		ModelAndView mav = new ModelAndView("editar");

		Usuario u = usuarioServicio.buscarPorId(id);
		List<String> puestos = puestoEnumeracionServicio.arregloPuesto();

		mav.addObject("u", u);
		mav.addObject("puesto", puestos);

		return mav;
	}

	@PreAuthorize("hasAnyRole('ROLE_ACTIVO')")
	@GetMapping("/borrar")
	public ModelAndView borrar(@RequestParam(required = false) String id) {
		if (usuarioAuxiliar.getLogeado() == true) {
			if (usuarioAuxiliar.getUsuario() != null && usuarioAuxiliar.getUsuario().getRol().equals("administrador")) {
				ModelAndView mav = new ModelAndView("borrar-usuario");

				List<Usuario> usuarios = usuarioServicio.buscarUsuarios();

				mav.addObject("logeado", true);
				mav.addObject("nombre", usuarioAuxiliar.getUsuario().getNombre());
				mav.addObject("apellido", usuarioAuxiliar.getUsuario().getApellido());
				mav.addObject("admin", true);
				mav.addObject("u", usuarios);

				return mav;
			} else {
				ModelAndView mav = new ModelAndView("inicio");

				mav.addObject("logeado", true);
				mav.addObject("nombre", usuarioAuxiliar.getUsuario().getNombre());
				mav.addObject("apellido", usuarioAuxiliar.getUsuario().getApellido());
				mav.addObject("admin", false);

				return mav;
			}
		} else {
			ModelAndView mav = new ModelAndView("inicio");

			mav.addObject("logeado", false);

			return mav;
		}
	}

	@PreAuthorize("hasAnyRole('ROLE_ACTIVO')")
	@GetMapping("/dar-baja-usuario/{id}")
	public RedirectView darBajaUsuario(@PathVariable String id) throws ErrorAviso {
		if (usuarioAuxiliar.getLogeado() == true) {
			if (usuarioAuxiliar.getUsuario() != null && usuarioAuxiliar.getUsuario().getRol().equals("administrador")) {
				usuarioServicio.darDeBaja(id);

				return new RedirectView("/usuario/borrar");
			} else {

				return new RedirectView("/inicio");
			}
		} else {

			return new RedirectView("/");
		}
	}

	@PreAuthorize("hasAnyRole('ROLE_ACTIVO')")
	@PostMapping("/agregar-usuario")
	public ModelAndView agregarUsuario(@RequestParam(required = false) MultipartFile archivo,
			@RequestParam(required = true) String nombre, @RequestParam(required = true) String apellido,
			@RequestParam(required = false) Integer dni, @RequestParam(required = true) String telefono, 
			@RequestParam(required = true) String usuario, @RequestParam(required = true) String correo,
			@RequestParam(required = true) String contrasena, @RequestParam(required = true) String verificarContrasena,
			@RequestParam(required = true) String puesto, @RequestParam(required = true) String rol) throws ErrorAviso {

		if (usuarioAuxiliar.getLogeado() == true) {
			if (usuarioAuxiliar.getUsuario() != null && usuarioAuxiliar.getUsuario().getRol().equals("administrador")) {
				try {
					usuarioServicio.agregar(archivo, nombre, apellido, dni, telefono, usuario, correo, contrasena,
							verificarContrasena, puesto, rol);
				} catch (Exception e) {
					ModelAndView mav = new ModelAndView("agregar-usuario");
					List<String> puestos = puestoEnumeracionServicio.arregloPuesto();

					mav.addObject("puesto", puestos);
					mav.addObject("error", e.getMessage());
					mav.addObject("nombre", nombre);
					mav.addObject("apellido", apellido);
					mav.addObject("dni", dni);
					mav.addObject("telefono", telefono);
					mav.addObject("nombreUsuario", usuario);
					mav.addObject("correo", correo);

					return mav;
				}
			} else {
				ModelAndView mav = new ModelAndView("inicio");

				return mav;
			}
		} else {
			ModelAndView mav = new ModelAndView("index");

			return mav;
		}

		ModelAndView mav = new ModelAndView("index");
		return mav;
	}

	@PreAuthorize("hasAnyRole('ROLE_ACTIVO')")
	@PostMapping("/editar-usuario")
	public ModelAndView editarUsuario(@RequestParam(required = false) MultipartFile archivo,
			@RequestParam(required = true) String id, @RequestParam(required = true) String nombre,
			@RequestParam(required = true) String apellido, @RequestParam(required = false) Integer dni,
			@RequestParam(required = true) String nombreUsuario, @RequestParam(required = true) String correo,
			@RequestParam(required = true) String contrasena, @RequestParam(required = true) String verificarContrasena,
			@RequestParam(required = true) String puesto, @RequestParam(required = true) String rol) throws ErrorAviso {

		if (usuarioAuxiliar.getLogeado() == true) {
			if (usuarioAuxiliar.getUsuario() != null && usuarioAuxiliar.getUsuario().getRol().equals("administrador")) {
				try {
					usuarioServicio.editar(archivo, id, nombre, apellido, dni, nombreUsuario, correo, contrasena,
							verificarContrasena, puesto, rol);
				} catch (Exception e) {
					ModelAndView mav = new ModelAndView("index");
					List<String> puestos = puestoEnumeracionServicio.arregloPuesto();

					mav.addObject("puesto", puestos);
					mav.addObject("error", e.getMessage());
					mav.addObject("nombre", nombre);
					mav.addObject("apellido", apellido);
					mav.addObject("dni", dni);
					mav.addObject("nombreUsuario", nombreUsuario);
					mav.addObject("correo", correo);

					return mav;
				}
			} else {
				ModelAndView mav = new ModelAndView("index");

				return mav;
			}
		} else {
			ModelAndView mav = new ModelAndView("index");

			return mav;
		}

		ModelAndView mav = new ModelAndView("index");
		return mav;
	}
}