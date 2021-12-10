package com.ienri.operacionra4.entidades;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class PruebaFuncion {
	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	private String id;

	@OneToMany
	private List<Usuario> usuario;

	/* FUENTES DE ALTA TENSIÓN */
	private Integer indicadorFATCA;
	private Integer indicadorFATMG;
	private Integer indicadorFATCP;
	/* TEMPERATURA DEL NUCLEO */
	private Double temperaturaN;
	/* REGISTRADORES */
	private Boolean registradorLogaritmico;
	private Boolean registradorLineal;
	/* CANAL DE ARRANQUE */
	private Integer escalimetroTCUno;
	private Double indicadorIntLogaritmicoTCUno;
	private Double indicadorIntLinealTCUno;
	private Integer escalimetroTCDos;
	private Double indicadorIntLogaritmicoTCDos;
	private Double indicadorIntLinealTCDos;
	/* DISPAROS CANAL LOG. DE ARRANQUE */
	private Double indicadorIntensidadFDB;
	private Double indicadorIntensidadFDA;
	private Double indicadorDesconexionTC;
	private Double registradorDesconexionTC;
	private Double indicadorConexionTC;
	private Double registradorConexionTC;
	private Double indicadorFDBCanalLog;
	private Double registradorFDBCanalLog;
	private Double indicadorPreAlertaCanalLog;
	private Double registradorPreAlertaCanalLog;
	private Double indicadorFDACanalLog;
	private Double registradorFDACanalLog;
	/* DISPAROS CANAL LIN. DE ARRANQUE */
	private Double indicadorConmutarCanalLineal;
	private Double registradorCanalLineal;
	private Double indicadorFDACanalLineal;
	private Double registradorFDACanalLineal;
	/* FALLAS FAT */
	private Boolean fallaEquipoCL;
	private Boolean fallaATCP;
	/* DISPAROS MONITORES GAMMA */
	private String indicadorDGammaAlta;
	private String indicadorFallaMG;

	private String observaciones;

	/* Constructor */
	public PruebaFuncion() {
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

	public Integer getIndicadorFATCA() {
		return indicadorFATCA;
	}

	public void setIndicadorFATCA(Integer indicadorFATCA) {
		this.indicadorFATCA = indicadorFATCA;
	}

	public Integer getIndicadorFATMG() {
		return indicadorFATMG;
	}

	public void setIndicadorFATMG(Integer indicadorFATMG) {
		this.indicadorFATMG = indicadorFATMG;
	}

	public Integer getIndicadorFATCP() {
		return indicadorFATCP;
	}

	public void setIndicadorFATCP(Integer indicadorFATCP) {
		this.indicadorFATCP = indicadorFATCP;
	}

	public Double getTemperaturaN() {
		return temperaturaN;
	}

	public void setTemperaturaN(Double temperaturaN) {
		this.temperaturaN = temperaturaN;
	}

	public Boolean getRegistradorLogaritmico() {
		return registradorLogaritmico;
	}

	public void setRegistradorLogaritmico(Boolean registradorLogaritmico) {
		this.registradorLogaritmico = registradorLogaritmico;
	}

	public Boolean getRegistradorLineal() {
		return registradorLineal;
	}

	public void setRegistradorLineal(Boolean registradorLineal) {
		this.registradorLineal = registradorLineal;
	}

	public Integer getEscalimetroTCUno() {
		return escalimetroTCUno;
	}

	public void setEscalimetroTCUno(Integer escalimetroTCUno) {
		this.escalimetroTCUno = escalimetroTCUno;
	}

	public Double getIndicadorIntLogaritmicoTCUno() {
		return indicadorIntLogaritmicoTCUno;
	}

	public void setIndicadorIntLogaritmicoTCUno(Double indicadorIntLogaritmicoTCUno) {
		this.indicadorIntLogaritmicoTCUno = indicadorIntLogaritmicoTCUno;
	}

	public Double getIndicadorIntLinealTCUno() {
		return indicadorIntLinealTCUno;
	}

	public void setIndicadorIntLinealTCUno(Double indicadorIntLinealTCUno) {
		this.indicadorIntLinealTCUno = indicadorIntLinealTCUno;
	}

	public Integer getEscalimetroTCDos() {
		return escalimetroTCDos;
	}

	public void setEscalimetroTCDos(Integer escalimetroTCDos) {
		this.escalimetroTCDos = escalimetroTCDos;
	}

	public Double getIndicadorIntLogaritmicoTCDos() {
		return indicadorIntLogaritmicoTCDos;
	}

	public void setIndicadorIntLogaritmicoTCDos(Double indicadorIntLogaritmicoTCDos) {
		this.indicadorIntLogaritmicoTCDos = indicadorIntLogaritmicoTCDos;
	}

	public Double getIndicadorIntLinealTCDos() {
		return indicadorIntLinealTCDos;
	}

	public void setIndicadorIntLinealTCDos(Double indicadorIntLinealTCDos) {
		this.indicadorIntLinealTCDos = indicadorIntLinealTCDos;
	}

	public Double getIndicadorIntensidadFDB() {
		return indicadorIntensidadFDB;
	}

	public void setIndicadorIntensidadFDB(Double indicadorIntensidadFDB) {
		this.indicadorIntensidadFDB = indicadorIntensidadFDB;
	}

	public Double getIndicadorIntensidadFDA() {
		return indicadorIntensidadFDA;
	}

	public void setIndicadorIntensidadFDA(Double indicadorIntensidadFDA) {
		this.indicadorIntensidadFDA = indicadorIntensidadFDA;
	}

	public Double getIndicadorDesconexionTC() {
		return indicadorDesconexionTC;
	}

	public void setIndicadorDesconexionTC(Double indicadorDesconexionTC) {
		this.indicadorDesconexionTC = indicadorDesconexionTC;
	}

	public Double getRegistradorDesconexionTC() {
		return registradorDesconexionTC;
	}

	public void setRegistradorDesconexionTC(Double registradorDesconexionTC) {
		this.registradorDesconexionTC = registradorDesconexionTC;
	}

	public Double getIndicadorConexionTC() {
		return indicadorConexionTC;
	}

	public void setIndicadorConexionTC(Double indicadorConexionTC) {
		this.indicadorConexionTC = indicadorConexionTC;
	}

	public Double getRegistradorConexionTC() {
		return registradorConexionTC;
	}

	public void setRegistradorConexionTC(Double registradorConexionTC) {
		this.registradorConexionTC = registradorConexionTC;
	}

	public Double getIndicadorFDBCanalLog() {
		return indicadorFDBCanalLog;
	}

	public void setIndicadorFDBCanalLog(Double indicadorFDBCanalLog) {
		this.indicadorFDBCanalLog = indicadorFDBCanalLog;
	}

	public Double getRegistradorFDBCanalLog() {
		return registradorFDBCanalLog;
	}

	public void setRegistradorFDBCanalLog(Double registradorFDBCanalLog) {
		this.registradorFDBCanalLog = registradorFDBCanalLog;
	}

	public Double getIndicadorPreAlertaCanalLog() {
		return indicadorPreAlertaCanalLog;
	}

	public void setIndicadorPreAlertaCanalLog(Double indicadorPreAlertaCanalLog) {
		this.indicadorPreAlertaCanalLog = indicadorPreAlertaCanalLog;
	}

	public Double getRegistradorPreAlertaCanalLog() {
		return registradorPreAlertaCanalLog;
	}

	public void setRegistradorPreAlertaCanalLog(Double registradorPreAlertaCanalLog) {
		this.registradorPreAlertaCanalLog = registradorPreAlertaCanalLog;
	}

	public Double getIndicadorFDACanalLog() {
		return indicadorFDACanalLog;
	}

	public void setIndicadorFDACanalLog(Double indicadorFDACanalLog) {
		this.indicadorFDACanalLog = indicadorFDACanalLog;
	}

	public Double getRegistradorFDACanalLog() {
		return registradorFDACanalLog;
	}

	public void setRegistradorFDACanalLog(Double registradorFDACanalLog) {
		this.registradorFDACanalLog = registradorFDACanalLog;
	}

	public Double getIndicadorConmutarCanalLineal() {
		return indicadorConmutarCanalLineal;
	}

	public void setIndicadorConmutarCanalLineal(Double indicadorConmutarCanalLineal) {
		this.indicadorConmutarCanalLineal = indicadorConmutarCanalLineal;
	}

	public Double getRegistradorCanalLineal() {
		return registradorCanalLineal;
	}

	public void setRegistradorCanalLineal(Double registradorCanalLineal) {
		this.registradorCanalLineal = registradorCanalLineal;
	}

	public Double getIndicadorFDACanalLineal() {
		return indicadorFDACanalLineal;
	}

	public void setIndicadorFDACanalLineal(Double indicadorFDACanalLineal) {
		this.indicadorFDACanalLineal = indicadorFDACanalLineal;
	}

	public Double getRegistradorFDACanalLineal() {
		return registradorFDACanalLineal;
	}

	public void setRegistradorFDACanalLineal(Double registradorFDACanalLineal) {
		this.registradorFDACanalLineal = registradorFDACanalLineal;
	}

	public Boolean getFallaEquipoCL() {
		return fallaEquipoCL;
	}

	public void setFallaEquipoCL(Boolean fallaEquipoCL) {
		this.fallaEquipoCL = fallaEquipoCL;
	}

	public Boolean getFallaATCP() {
		return fallaATCP;
	}

	public void setFallaATCP(Boolean fallaATCP) {
		this.fallaATCP = fallaATCP;
	}

	public String getIndicadorDGammaAlta() {
		return indicadorDGammaAlta;
	}

	public void setIndicadorDGammaAlta(String indicadorDGammaAlta) {
		this.indicadorDGammaAlta = indicadorDGammaAlta;
	}

	public String getIndicadorFallaMG() {
		return indicadorFallaMG;
	}

	public void setIndicadorFallaMG(String indicadorFallaMG) {
		this.indicadorFallaMG = indicadorFallaMG;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	@Override
	public String toString() {
		return "PruebaFuncion [id=" + id + ", usuario=" + usuario + ", indicadorFATCA=" + indicadorFATCA
				+ ", indicadorFATMG=" + indicadorFATMG + ", indicadorFATCP=" + indicadorFATCP + ", temperaturaN="
				+ temperaturaN + ", registradorLogaritmico=" + registradorLogaritmico + ", registradorLineal="
				+ registradorLineal + ", escalimetroTCUno=" + escalimetroTCUno + ", indicadorIntLogaritmicoTCUno="
				+ indicadorIntLogaritmicoTCUno + ", indicadorIntLinealTCUno=" + indicadorIntLinealTCUno
				+ ", escalimetroTCDos=" + escalimetroTCDos + ", indicadorIntLogaritmicoTCDos="
				+ indicadorIntLogaritmicoTCDos + ", indicadorIntLinealTCDos=" + indicadorIntLinealTCDos
				+ ", indicadorIntensidadFDB=" + indicadorIntensidadFDB + ", indicadorIntensidadFDA="
				+ indicadorIntensidadFDA + ", indicadorDesconexionTC=" + indicadorDesconexionTC
				+ ", registradorDesconexionTC=" + registradorDesconexionTC + ", indicadorConexionTC="
				+ indicadorConexionTC + ", registradorConexionTC=" + registradorConexionTC + ", indicadorFDBCanalLog="
				+ indicadorFDBCanalLog + ", registradorFDBCanalLog=" + registradorFDBCanalLog
				+ ", indicadorPreAlertaCanalLog=" + indicadorPreAlertaCanalLog + ", registradorPreAlertaCanalLog="
				+ registradorPreAlertaCanalLog + ", indicadorFDACanalLog=" + indicadorFDACanalLog
				+ ", registradorFDACanalLog=" + registradorFDACanalLog + ", indicadorConmutarCanalLineal="
				+ indicadorConmutarCanalLineal + ", registradorCanalLineal=" + registradorCanalLineal
				+ ", indicadorFDACanalLineal=" + indicadorFDACanalLineal + ", registradorFDACanalLineal="
				+ registradorFDACanalLineal + ", fallaEquipoCL=" + fallaEquipoCL + ", fallaATCP=" + fallaATCP
				+ ", indicadorDGammaAlta=" + indicadorDGammaAlta + ", indicadorFallaMG=" + indicadorFallaMG
				+ ", observaciones=" + observaciones + "]";
	}
}
