package com.ienri.operacionra4.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ienri.operacionra4.avisos.ErrorAviso;
import com.ienri.operacionra4.entidades.Usuario;
import com.ienri.operacionra4.servicios.UsuarioServicio;

@Controller
@RequestMapping("/foto")
public class FotoControlador {

	@Autowired
	private UsuarioServicio usuarioServicio;
	
	@GetMapping("/usuario/{id}")
	public ResponseEntity<byte[]> fotoUsuario(@PathVariable String id) {
		try {
			System.out.println("********");
			System.out.println(id);
			System.out.println("********");
			Usuario u = usuarioServicio.buscarPorId(id);
			
			if (u.getFoto() == null) {
				throw new ErrorAviso("El usuario no dispone de una foto");
			}
			
			byte[] foto = u.getFoto().getContenido();
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.IMAGE_PNG);
			
			return new ResponseEntity<>(foto, headers, HttpStatus.OK);			
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}