package com.ienri.operacionra4.servicios;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;

import com.ienri.operacionra4.avisos.ErrorAviso;
import com.ienri.operacionra4.entidades.Foto;
import com.ienri.operacionra4.entidades.Usuario;
import com.ienri.operacionra4.repositorios.UsuarioRepositorio;

@Service
public class UsuarioServicio implements UserDetailsService {
	@Autowired
	private UsuarioRepositorio usuarioRepositorio;
	
	@Autowired
	private FotoServicio fotoServicio;

	/*******************************
	 * Seguridad Spring
	 *************************************/
	@Override
	public UserDetails loadUserByUsername(String correo) throws UsernameNotFoundException {
		Usuario a = usuarioRepositorio.buscarPorCorreo(correo);

		if (a != null) {
			List<GrantedAuthority> permisos = new ArrayList<>();
			GrantedAuthority activo = new SimpleGrantedAuthority("ROLE_ACTIVO");
			permisos.add(activo);

			User user = new User(a.getCorreo(), a.getContrasena(), permisos);

			// Guardamos sus atributos
			ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
			HttpSession session = attr.getRequest().getSession(true);
			session.setAttribute("usersession", a);

			return user;
		} else {
			throw new UsernameNotFoundException("El usuario no fue encontrado");
		}
	}
	
	/* Buscadores */
	public Usuario buscarPorId(String id) throws ErrorAviso {
		
		return usuarioRepositorio.findById(id).orElseThrow();
	}
	
	public Usuario buscarPorCorreo(String correo) throws ErrorAviso{
		
		return usuarioRepositorio.buscarPorCorreo(correo);
	}
	
	public List<Usuario> buscarJefeReactorActivo() throws ErrorAviso{
		
		return usuarioRepositorio.buscarJefeReactorActivo();
	}
	
	public List<Usuario> buscarOperadorActivo() throws ErrorAviso{
		
		return usuarioRepositorio.buscarOperadorActivo();
	}

	public List<Usuario> buscarOficialRP() throws ErrorAviso{
		
		return usuarioRepositorio.buscarOficialRPActivo();
	}
	/**************/

	/***************************************************************************************/
	/*
	 * @Transactional(readOnly = true) public List<Administrador> listar() { return
	 * administradorRepositorio.findAll(); }
	 * 
	 * @Transactional(readOnly = true) public List<Administrador> listarActivos() {
	 * return administradorRepositorio.listarActivos(); }
	 * 
	 * @Transactional(readOnly = true) public
	 * List<Administrador>buscarPorNombre(String nombre) { try { return
	 * administradorRepositorio.buscarPorNombre(nombre); } catch (Exception e) {
	 * System.out.println("No se encontró el ususario buscado"); return null; } }
	 * 
	 * @Transactional(readOnly = true) public Administrador buscarPorId(String id) {
	 * try { Administrador a = new Administrador(); a =
	 * administradorRepositorio.findById(id).orElse(null);
	 * 
	 * return a; } catch (Exception e) {
	 * System.out.println("No se encontró el ususario buscado"); return null; } }
	 */

	@Transactional
	public void agregar(MultipartFile archivo, String nombre, String apellido, Integer dni,
						String nombreUsuario, String correo, String contrasena, String verificarContrasena,
						String puesto, String rol) throws ErrorAviso {
		
		validar(nombre, apellido, dni, nombreUsuario, correo, contrasena, verificarContrasena, puesto, rol);
		
		try {
			Usuario u = new Usuario();
			u.setNombre(nombre);
			u.setApellido(apellido);
			u.setDni(dni);
			u.setNombreUsuario(nombreUsuario);
			u.setCorreo(correo);
			BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
			u.setContrasena(encoder.encode(contrasena));
			u.setPuesto(puesto);
			u.setRol(rol);
			u.setFechaAlta(new Date());
			u.setAlta(true);

			Foto foto = fotoServicio.guardar(archivo);
			u.setFoto(foto);
			
			usuarioRepositorio.save(u);
		} catch (Exception e) {
			System.out.println("No se pudo agregar un usuario");
		}
	}

	@Transactional
	public void editar(MultipartFile archivo, String id, String nombre, String apellido, Integer dni,
						String nombreUsuario, String correo, String contrasena, String verificarContrasena,
						String puesto, String rol) throws ErrorAviso {
		
		validar(nombre, apellido, dni, nombreUsuario, correo, contrasena, verificarContrasena, puesto, rol);
		
		try {
			Optional<Usuario> respuesta = usuarioRepositorio.findById(id);
			if (respuesta.isPresent()) {
				Usuario u = new Usuario(id, nombre, apellido, dni, nombreUsuario, correo, contrasena, puesto, rol, true);
				
				String idFoto = null;
				if (u.getFoto() != null) {
					idFoto = u.getFoto().getId();
				}
				
				Foto foto = fotoServicio.editar(idFoto, archivo);
				u.setFoto(foto);
				
				usuarioRepositorio.save(u);
			}
		} catch (Exception e) {
			System.out.println("No se pudo editar el usuario");
		}
	}

	@Transactional
	public void darDeBaja(String id) {
		try {
			Optional<Usuario> respuesta = usuarioRepositorio.findById(id);
			if (respuesta.isPresent()) {
				Usuario u = respuesta.get();
				u.setId(id);
				u.setNombre(u.getNombre());
				u.setApellido(u.getApellido());
				u.setDni(u.getDni());
				u.setNombreUsuario(u.getNombreUsuario());
				u.setCorreo(u.getCorreo());
				u.setContrasena(u.getContrasena());
				u.setPuesto(u.getPuesto());
				u.setRol(u.getRol());
				u.setFechaBaja(new Date());
				u.setAlta(false);

				usuarioRepositorio.save(u);
			}
		} catch (Exception e) {
			System.out.println("No se pudo dar de baja el usuario");
		}
	}
	
	public void validar(String nombre, String apellido, Integer dni,
						String nombreUsuario, String correo, String contrasena, String verificarContrasena,
						String puesto, String rol) throws ErrorAviso {

		if (usuarioRepositorio.buscarPorCorreo(correo) != null) {
			throw new ErrorAviso("El mail ya fue utilizado.");
		}
		
		if (usuarioRepositorio.buscarPorNombreUsuario(nombreUsuario) != null) {
			throw new ErrorAviso("El nombre de usuario ya existe");
		}
		
		if (nombre == null || nombre.isEmpty()) {
			throw new ErrorAviso("El nombre de usuario no puede quedar vacío");
		}
		
		if (apellido == null || apellido.isEmpty()) {
			throw new ErrorAviso("El apellido de usuario no puede quedar vacío");
		}
		
		if (dni == null) {
			throw new ErrorAviso("El DNI de usuario no puede quedar vacío");
		}
		
		if (nombreUsuario == null || nombreUsuario.isEmpty()) {
			throw new ErrorAviso("El nombre de usuario no puede quedar vacío");
		}
		
		if (correo == null || correo.isEmpty()) {
			throw new ErrorAviso("El correo de usuario no puede quedar vacío");
		}

		// Si las contraseñas son iguales guarda el ususario
		if (!contrasena.equals(verificarContrasena)) {
			throw new ErrorAviso("Las contraseñas no coinciden");
		}
		
		if (puesto == null || puesto.isEmpty()) {
			throw new ErrorAviso("El puedto de usuario no puede quedar vacío");
		}
		
		if (rol == null || rol.isEmpty()) {
			throw new ErrorAviso("El rol de usuario no puede quedar vacío");
		}
	}
}