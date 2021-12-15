package com.ienri.operacionra4.entidades;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class ProcedimientoApagado {
	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	private String id;

	@OneToMany
	private List<Usuario> usuario;

	private Boolean apagadoFATCP; // 1. Apagar FAT canal de potencia.
	private Boolean apagadoFATMG; // 2. Apagar FAT monitor gamma.
	private Boolean apagadoRegistradores; // 3. Apagar registradores.
	private Boolean apagadoFATCA; // 4. Apagar FAT canal de arranque.
	private Boolean apagadoConsola; // 5. Apagar consola.
	private Boolean apagadoMA; // 6. Apagar monitores de área.
	private Boolean apagadoPC; // 7. Apagar PC.
	private Boolean desenergizarConsola; // 8. Desenergizar la consola.

	private String observaciones;

	/* Constructor */
	public ProcedimientoApagado() {
	}
	
	public ProcedimientoApagado(Boolean apagadoFATCP, Boolean apagadoFATMG,
			Boolean apagadoRegistradores, Boolean apagadoFATCA, Boolean apagadoConsola, Boolean apagadoMA,
			Boolean apagadoPC, Boolean desenergizarConsola, String observaciones) {

		this.apagadoFATCP = apagadoFATCP;
		this.apagadoFATMG = apagadoFATMG;
		this.apagadoRegistradores = apagadoRegistradores;
		this.apagadoFATCA = apagadoFATCA;
		this.apagadoConsola = apagadoConsola;
		this.apagadoMA = apagadoMA;
		this.apagadoPC = apagadoPC;
		this.desenergizarConsola = desenergizarConsola;
		this.observaciones = observaciones;
	}

	/* Getter, Setters y toString() */
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<Usuario> getUsuario() {
		return usuario;
	}

	public void setUsuario(List<Usuario> usuario) {
		this.usuario = usuario;
	}

	public Boolean getApagadoFATCP() {
		return apagadoFATCP;
	}

	public void setApagadoFATCP(Boolean apagadoFATCP) {
		this.apagadoFATCP = apagadoFATCP;
	}

	public Boolean getApagadoFATMG() {
		return apagadoFATMG;
	}

	public void setApagadoFATMG(Boolean apagadoFATMG) {
		this.apagadoFATMG = apagadoFATMG;
	}

	public Boolean getApagadoRegistradores() {
		return apagadoRegistradores;
	}

	public void setApagadoRegistradores(Boolean apagadoRegistradores) {
		this.apagadoRegistradores = apagadoRegistradores;
	}

	public Boolean getApagadoFATCA() {
		return apagadoFATCA;
	}

	public void setApagadoFATCA(Boolean apagadoFATCA) {
		this.apagadoFATCA = apagadoFATCA;
	}

	public Boolean getApagadoConsola() {
		return apagadoConsola;
	}

	public void setApagadoConsola(Boolean apagadoConsola) {
		this.apagadoConsola = apagadoConsola;
	}

	public Boolean getApagadoMA() {
		return apagadoMA;
	}

	public void setApagadoMA(Boolean apagadoMA) {
		this.apagadoMA = apagadoMA;
	}

	public Boolean getApagadoPC() {
		return apagadoPC;
	}

	public void setApagadoPC(Boolean apagadoPC) {
		this.apagadoPC = apagadoPC;
	}

	public Boolean getDesenergizarConsola() {
		return desenergizarConsola;
	}

	public void setDesenergizarConsola(Boolean desenergizarConsola) {
		this.desenergizarConsola = desenergizarConsola;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	@Override
	public String toString() {
		return "ProcedimientoApagado [id=" + id + ", usuario=" + usuario + ", apagadoFATCP=" + apagadoFATCP
				+ ", apagadoFATMG=" + apagadoFATMG + ", apagadoRegistradores=" + apagadoRegistradores
				+ ", apagadoFATCA=" + apagadoFATCA + ", apagadoConsola=" + apagadoConsola + ", apagadoMA=" + apagadoMA
				+ ", apagadoPC=" + apagadoPC + ", desenergizarConsola=" + desenergizarConsola + ", observaciones="
				+ observaciones + "]";
	}
}