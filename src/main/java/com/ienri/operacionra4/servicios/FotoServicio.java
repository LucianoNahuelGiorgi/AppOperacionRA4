package com.ienri.operacionra4.servicios;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.ienri.operacionra4.avisos.ErrorAviso;
import com.ienri.operacionra4.entidades.Foto;
import com.ienri.operacionra4.repositorios.FotoRepositorio;

@Service
public class FotoServicio {
	
	@Autowired
	private FotoRepositorio fotoRepositorio;
	
	public Foto guardar(MultipartFile archivo) throws ErrorAviso {
		if (archivo != null) {
			try {
				Foto foto = new Foto();
				
				foto.setMime(archivo.getContentType());
				foto.setNombre(archivo.getName());
				foto.setContenido(archivo.getBytes());
				
				return fotoRepositorio.save(foto);
				
			} catch (Exception e) {
				throw new ErrorAviso("No se pudo guardar la foto");
			}
		}else {
			return null;
		}
	}
	
	public Foto editar(String id, MultipartFile archivo) throws ErrorAviso {
		if (archivo != null) {
			try {
				Foto foto = new Foto();
	
				if (id != null) {
					Optional<Foto> respuesta = fotoRepositorio.findById(id);
					if (respuesta.isPresent()) {
						foto = respuesta.get();
					}
				}
				
				foto.setMime(archivo.getContentType());
				foto.setNombre(archivo.getName());
				foto.setContenido(archivo.getBytes());
				
				return fotoRepositorio.save(foto);
			} catch (Exception e) {
				throw new ErrorAviso("No se pudo guardar la foto");
			}
		}else {
			return null;
		}
	}
}