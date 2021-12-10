package com.ienri.operacionra4.entidades;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class OperacionGeneral {
	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	private String id;
	private Integer numero;

	@Temporal(TemporalType.DATE)
	private Date fechaHoraInicio;
	@Temporal(TemporalType.DATE)
	private Date fechaHoraFin;

	@OneToMany
	private List<ProcedimientoEncendido> procedimientoEncendio;
	@OneToMany
	private List<ProcedimientoApagado> procedimientoApagado;
	@OneToMany
	private List<PruebaFuncion> pruebaFuncion;
	@OneToMany
	private List<Operacion> operacion;

	/* Constructor */
	public OperacionGeneral() {
	}

	/* Getter, Setters y toString() */
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public Date getFechaHoraInicio() {
		return fechaHoraInicio;
	}

	public void setFechaHoraInicio(Date fechaHoraInicio) {
		this.fechaHoraInicio = fechaHoraInicio;
	}

	public Date getFechaHoraFin() {
		return fechaHoraFin;
	}

	public void setFechaHoraFin(Date fechaHoraFin) {
		this.fechaHoraFin = fechaHoraFin;
	}

	public List<ProcedimientoEncendido> getProcedimientoEncendio() {
		return procedimientoEncendio;
	}

	public void setProcedimientoEncendio(List<ProcedimientoEncendido> procedimientoEncendio) {
		this.procedimientoEncendio = procedimientoEncendio;
	}

	public List<ProcedimientoApagado> getProcedimientoApagado() {
		return procedimientoApagado;
	}

	public void setProcedimientoApagado(List<ProcedimientoApagado> procedimientoApagado) {
		this.procedimientoApagado = procedimientoApagado;
	}

	public List<PruebaFuncion> getPruebaFuncion() {
		return pruebaFuncion;
	}

	public void setPruebaFuncion(List<PruebaFuncion> pruebaFuncion) {
		this.pruebaFuncion = pruebaFuncion;
	}

	public List<Operacion> getOperacion() {
		return operacion;
	}

	public void setOperacion(List<Operacion> operacion) {
		this.operacion = operacion;
	}

	@Override
	public String toString() {
		return "OperacionGeneral [id=" + id + ", numero=" + numero + ", fechaHoraInicio=" + fechaHoraInicio
				+ ", fechaHoraFin=" + fechaHoraFin + ", procedimientoEncendio=" + procedimientoEncendio
				+ ", procedimientoApagado=" + procedimientoApagado + ", pruebaFuncion=" + pruebaFuncion + ", operacion="
				+ operacion + "]";
	}
}
