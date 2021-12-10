package com.ienri.operacionra4.entidades;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Usuario {
	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	private String id;
	private String nombre;
	private String apellido;
	private Integer dni;
	private String nombreUsuario;
	private String correo;
	private String contrasena;
	@OneToOne
	private Foto foto;
	private String puesto;			// Puesto de trabajo
	private String rol;				// Tipo de ususario, administrador/usuario
	private Boolean alta;
	
	@Temporal(TemporalType.DATE)
	private Date fechaAlta;
	@Temporal(TemporalType.DATE)
	private Date fechaBaja;
	
	/* Constructor vacio */
	public Usuario() {
	}
	
	/* Constructor dar de alta */
	public Usuario(String nombre, String apellido, Integer dni, String nombreUsuario, String correo, String contrasena, Boolean alta) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.nombreUsuario = nombreUsuario;
		this.correo = correo;
		this.contrasena = contrasena;
		this.alta = alta;
	}
	
	/* Constructor editar */
	public Usuario(String id, String nombre, String apellido, Integer dni, String nombreUsuario, String correo, String contrasena, String puesto, String rol, Boolean alta) {
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.nombreUsuario = nombreUsuario;
		this.correo = correo;
		this.contrasena = contrasena;
		this.puesto = puesto;
		this.rol = rol;
		this.alta = alta;
	}
	
	/* Constructor dar de baja */
	public Usuario(String id, Boolean alta) {
		this.id = id;
		this.alta = alta;
	}
	
	public Usuario(String nombre, String apellido, Integer dni, String nombreUsuario, String correo, String contrasena, Boolean alta, Date fechaAlta) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.nombreUsuario = nombreUsuario;
		this.correo = correo;
		this.contrasena = contrasena;
		this.alta = alta;
	}

	/* Getter, Setters y toString() */
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public Integer getDni() {
		return dni;
	}

	public void setDni(Integer dni) {
		this.dni = dni;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}
	
	public Foto getFoto() {
		return foto;
	}

	public void setFoto(Foto foto) {
		this.foto = foto;
	}	

	public String getPuesto() {
		return puesto;
	}

	public void setPuesto(String puesto) {
		this.puesto = puesto;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

	public Boolean getAlta() {
		return alta;
	}

	public void setAlta(Boolean alta) {
		this.alta = alta;
	}

	public Date getFechaAlta() {
		return fechaAlta;
	}

	public void setFechaAlta(Date fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

	public Date getFechaBaja() {
		return fechaBaja;
	}

	public void setFechaBaja(Date fechaBaja) {
		this.fechaBaja = fechaBaja;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", dni=" + dni
				+ ", nombreUsuario=" + nombreUsuario + ", correo=" + correo + ", contrasena=" + contrasena + ", puesto="
				+ puesto + ", rol=" + rol + ", alta=" + alta + ", fechaAlta=" + fechaAlta + ", fechaBaja=" + fechaBaja
				+ "]";
	}
}