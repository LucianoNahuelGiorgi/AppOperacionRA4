package com.ienri.operacionra4.serviciosauxiliares;

import org.springframework.stereotype.Service;

import com.ienri.operacionra4.entidades.Usuario;

@Service
public class UsuarioAuxiliar {
	private Usuario usuario;
	private Boolean logeado = false;
	
	public Usuario getUsuario() {
		return usuario;
	}
	
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public Boolean getLogeado() {
		return logeado;
	}
	
	public void setLogeado(Boolean logeado) {
		this.logeado = logeado;
	}
	
	@Override
	public String toString() {
		return "UsuarioAuxiliar [usuario=" + usuario + ", logeado=" + logeado + "]";
	}
}