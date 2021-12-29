	package com.ienri.operacionra4.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.ienri.operacionra4.avisos.ErrorAviso;
import com.ienri.operacionra4.entidades.Usuario;
import com.ienri.operacionra4.servicios.PuestoEnumeracionServicio;
import com.ienri.operacionra4.servicios.UsuarioServicio;

@Controller
@RequestMapping("/usuario")
public class UsuarioControlador {
	@Autowired
	PuestoEnumeracionServicio puestoEnumeracionServicio;
	
	@Autowired
	UsuarioServicio usuarioServicio;

	@GetMapping("/jefe-reactor-activo")
	public ModelAndView mostrarJRActivo() throws ErrorAviso {
		ModelAndView mav = new ModelAndView("usuario");
		
		List<Usuario> u = usuarioServicio.buscarJefeReactorActivo();
		mav.addObject("u", u);
		
		return mav;
	}
	
	@GetMapping("/operador-activo")
	public ModelAndView mostrarOpActivo() throws ErrorAviso {
		ModelAndView mav = new ModelAndView("usuario");
		
		List<Usuario> u = usuarioServicio.buscarOperadorActivo();
		mav.addObject("u", u);
		
		return mav;
	}
	
	@GetMapping("/oficial-activo")
	public ModelAndView mostrarOficialRPActivo() throws ErrorAviso {
		ModelAndView mav = new ModelAndView("usuario");
		
		List<Usuario> u = usuarioServicio.buscarOficialRPActivo();
		mav.addObject("u", u);
		
		return mav;
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
		ModelAndView mav = new ModelAndView("agregar-usuario");
		/* Usuario administrador */
		//usuarioServicio.agregar(null, "Luciano Nahuel", "Giorgi", 32908433, "lgiorgi", "lgiorgi@fceia.unr.edu.ar", "123456", "123456", "Operador", "Administrador");

		List<String> puestos = puestoEnumeracionServicio.arregloPuesto();
		mav.addObject("puesto", puestos);
		
		return mav;
	}

	@PreAuthorize("hasAnyRole('ROLE_ACTIVO')")
	@GetMapping("/editar")
	public ModelAndView editar(@RequestParam(required = false) String id) {
		ModelAndView mav = new ModelAndView("editar-usuario");
		
		List<String> puestos = puestoEnumeracionServicio.arregloPuesto();
		mav.addObject("puesto", puestos);
		
		return mav;
	}

	@PreAuthorize("hasAnyRole('ROLE_ACTIVO')")
	@GetMapping("/borrar")
	public ModelAndView borrar(@RequestParam(required = false) String id) {
		ModelAndView mav = new ModelAndView("borrar-usuario");
		
		return mav;
	}
	
	@PostMapping("/agregar-usuario")
	public String agregarUsuario(ModelMap modelo, @RequestParam(required = false) MultipartFile archivo, @RequestParam(required = true) String nombre, @RequestParam(required = true) String apellido, @RequestParam(required = true) Integer dni,
										@RequestParam(required = true) String nombreUsuario, @RequestParam(required = true) String correo, @RequestParam(required = true) String contrasena, @RequestParam(required = true) String verificarContrasena,
										@RequestParam(required = true) String puesto, @RequestParam(required = true) String rol) throws ErrorAviso {
		
		try {
			usuarioServicio.agregar(archivo, nombre, apellido, dni, nombreUsuario, correo, contrasena, verificarContrasena, puesto, rol);			
		} catch (Exception e) {
			List<String> puestos = puestoEnumeracionServicio.arregloPuesto();

			modelo.put("puesto", puestos);
			modelo.put("error", e.getMessage());
			modelo.put("nombre", nombre);
			modelo.put("apellido", apellido);
			modelo.put("dni", dni);
			modelo.put("nombreUsuario", nombreUsuario);
			modelo.put("correo", correo);
			
			return "agregar-usuario";
		}
		
		return "/inicio";
	}
	
//	@PostMapping("/buscar")
//	public ModelAndView buscarPorNombre(@RequestParam String nombre) throws ErrorAviso {
//		ModelAndView mav = new ModelAndView("usuario");
//		
//		List<Usuario> u = usuarioServicio.buscarPorNombre(nombre);
//		mav.addObject("u", u);
//		
//		return mav;
//	}
}