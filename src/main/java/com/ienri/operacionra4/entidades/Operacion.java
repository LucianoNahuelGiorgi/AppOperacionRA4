package com.ienri.operacionra4.entidades;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Operacion {
	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	private String id;
	/* PERSONAL A CARGO DE LA OPERACION */
	private String jefeReactor;
	private String operador;
	private String oficialRP;
	/* FACILIDAD PARA EXPERIMENTACION */
	private String canalCentralHorizontal;
	private String canalLateralSupHorizontal;
	private String canalLateralInfHorizontal;
	private String canalCentralVertical;
	private String canalLateralVertical;
	/* DATOS DE LA OPERACION */
	private String motivo;
	private String scram;
	private Boolean muestra;
	/* INHIBIDORES DE DISPARO */
	private Boolean puertaConsola;
	private Boolean puertaReactor;
	private Boolean expPotenciaCero;
	private Boolean expNucleo;
	/* TOMA DE DATOS DE LA OPERACION */
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaHora;
	private Double tempNucleo;
	private Boolean fuenteAdentro;
	private Double posNucleo;
	private Double posBC1;
	private Double posBC2;
	private Integer escalimetro;
	private Double intLogCA;
	private Double intLinCA;
	private Double intLinCP;
	private Double intLogCP;
	private Double gammaConsola;
	private Double gammaReactor;
	private Double potencia;
	private String regimen;
	private String observaciones;
	
	/* Constructor */
	public Operacion() {
	}
	
	public Operacion(String jefeReactor, String operador, String oficialRP, String canalCentralHorizontal,
			String canalLateralSupHorizontal, String canalLateralInfHorizontal, String canalCentralVertical,
			String canalLateralVertical, String motivo, String scram, Boolean muestra, Boolean puertaConsola,
			Boolean puertaReactor, Boolean expPotenciaCero, Boolean expNucleo, Date fechaHora, Double tempNucleo, Boolean fuenteAdentro,
			Double posNucleo, Double posBC1, Double posBC2, Integer escalimetro, Double intLogCA, Double intLinCA,
			Double intLinCP, Double intLogCP, Double gammaConsola, Double gammaReactor, Double potencia, String regimen,
			String observaciones) {
		
		this.jefeReactor = jefeReactor;
		this.operador = operador;
		this.oficialRP = oficialRP;
		this.canalCentralHorizontal = canalCentralHorizontal;
		this.canalLateralSupHorizontal = canalLateralSupHorizontal;
		this.canalLateralInfHorizontal = canalLateralInfHorizontal;
		this.canalCentralVertical = canalCentralVertical;
		this.canalLateralVertical = canalLateralVertical;
		this.motivo = motivo;
		this.scram = scram;
		this.muestra = muestra;
		this.puertaConsola = puertaConsola;
		this.puertaReactor = puertaReactor;
		this.expPotenciaCero = expPotenciaCero;
		this.expNucleo = expNucleo;
		this.fechaHora = fechaHora;
		this.tempNucleo = tempNucleo;
		this.fuenteAdentro = fuenteAdentro;
		this.posNucleo = posNucleo;
		this.posBC1 = posBC1;
		this.posBC2 = posBC2;
		this.escalimetro = escalimetro;
		this.intLogCA = intLogCA;
		this.intLinCA = intLinCA;
		this.intLinCP = intLinCP;
		this.intLogCP = intLogCP;
		this.gammaConsola = gammaConsola;
		this.gammaReactor = gammaReactor;
		this.potencia = potencia;
		this.regimen = regimen;
		this.observaciones = observaciones;
	}

	/* Getter, Setters y toString() */
	public Date getFechaHora() {
		return fechaHora;
	}

	public void setFechaHora(Date fechaHora) {
		this.fechaHora = fechaHora;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getJefeReactor() {
		return jefeReactor;
	}

	public void setJefeReactor(String jefeReactor) {
		this.jefeReactor = jefeReactor;
	}

	public String getOperador() {
		return operador;
	}

	public void setOperador(String operador) {
		this.operador = operador;
	}

	public String getOficialRP() {
		return oficialRP;
	}

	public void setOficialRP(String oficialRP) {
		this.oficialRP = oficialRP;
	}

	public String getCanalCentralHorizontal() {
		return canalCentralHorizontal;
	}

	public void setCanalCentralHorizontal(String canalCentralHorizontal) {
		this.canalCentralHorizontal = canalCentralHorizontal;
	}

	public String getCanalLateralSupHorizontal() {
		return canalLateralSupHorizontal;
	}

	public void setCanalLateralSupHorizontal(String canalLateralSupHorizontal) {
		this.canalLateralSupHorizontal = canalLateralSupHorizontal;
	}

	public String getCanalLateralInfHorizontal() {
		return canalLateralInfHorizontal;
	}

	public void setCanalLateralInfHorizontal(String canalLateralInfHorizontal) {
		this.canalLateralInfHorizontal = canalLateralInfHorizontal;
	}

	public String getCanalCentralVertical() {
		return canalCentralVertical;
	}

	public void setCanalCentralVertical(String canalCentralVertical) {
		this.canalCentralVertical = canalCentralVertical;
	}

	public String getCanalLateralVertical() {
		return canalLateralVertical;
	}

	public void setCanalLateralVertical(String canalLateralVertical) {
		this.canalLateralVertical = canalLateralVertical;
	}

	public String getMotivo() {
		return motivo;
	}

	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}

	public String getScram() {
		return scram;
	}

	public void setScram(String scram) {
		this.scram = scram;
	}

	public Boolean getMuestra() {
		return muestra;
	}

	public void setMuestra(Boolean muestra) {
		this.muestra = muestra;
	}

	public Boolean getPuertaConsola() {
		return puertaConsola;
	}

	public void setPuertaConsola(Boolean puertaConsola) {
		this.puertaConsola = puertaConsola;
	}

	public Boolean getPuertaReactor() {
		return puertaReactor;
	}

	public void setPuertaReactor(Boolean puertaReactor) {
		this.puertaReactor = puertaReactor;
	}

	public Boolean getExpPotenciaCero() {
		return expPotenciaCero;
	}

	public void setExpPotenciaCero(Boolean expPotenciaCero) {
		this.expPotenciaCero = expPotenciaCero;
	}

	public Boolean getExpNucleo() {
		return expNucleo;
	}

	public void setExpNucleo(Boolean expNucleo) {
		this.expNucleo = expNucleo;
	}

	public Double getTempNucleo() {
		return tempNucleo;
	}

	public void setTempNucleo(Double tempNucleo) {
		this.tempNucleo = tempNucleo;
	}

	public Boolean getPosFuente() {
		return fuenteAdentro;
	}

	public void setPosFuente(Boolean fuenteAdentro) {
		this.fuenteAdentro = fuenteAdentro;
	}

	public Double getPosNucleo() {
		return posNucleo;
	}

	public void setPosNucleo(Double posNucleo) {
		this.posNucleo = posNucleo;
	}

	public Double getPosBC1() {
		return posBC1;
	}

	public void setPosBC1(Double posBC1) {
		this.posBC1 = posBC1;
	}

	public Double getPosBC2() {
		return posBC2;
	}

	public void setPosBC2(Double posBC2) {
		this.posBC2 = posBC2;
	}

	public Integer getEscalimetro() {
		return escalimetro;
	}

	public void setEscalimetro(Integer escalimetro) {
		this.escalimetro = escalimetro;
	}

	public Double getIntLogCA() {
		return intLogCA;
	}

	public void setIntLogCA(Double intLogCA) {
		this.intLogCA = intLogCA;
	}

	public Double getIntLinCA() {
		return intLinCA;
	}

	public void setIntLinCA(Double intLinCA) {
		this.intLinCA = intLinCA;
	}

	public Double getIntLinCP() {
		return intLinCP;
	}

	public void setIntLinCP(Double intLinCP) {
		this.intLinCP = intLinCP;
	}

	public Double getIntLogCP() {
		return intLogCP;
	}

	public void setIntLogCP(Double intLogCP) {
		this.intLogCP = intLogCP;
	}

	public Double getGammaConsola() {
		return gammaConsola;
	}

	public void setGammaConsola(Double gammaConsola) {
		this.gammaConsola = gammaConsola;
	}

	public Double getGammaReactor() {
		return gammaReactor;
	}

	public void setGammaReactor(Double gammaReactor) {
		this.gammaReactor = gammaReactor;
	}

	public Double getPotencia() {
		return potencia;
	}

	public void setPotencia(Double potencia) {
		this.potencia = potencia;
	}

	public String getRegimen() {
		return regimen;
	}

	public void setRegimen(String regimen) {
		this.regimen = regimen;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	@Override
	public String toString() {
		return "Operacion [id=" + id + ", jefeReactor=" + jefeReactor + ", operador=" + operador + ", oficialRP="
				+ oficialRP + ", canalCentralHorizontal=" + canalCentralHorizontal + ", canalLateralSupHorizontal="
				+ canalLateralSupHorizontal + ", canalLateralInfHorizontal=" + canalLateralInfHorizontal
				+ ", canalCentralVertical=" + canalCentralVertical + ", canalLateralVertical=" + canalLateralVertical
				+ ", motivo=" + motivo + ", scram=" + scram + ", muestra=" + muestra + ", puertaConsola="
				+ puertaConsola + ", puertaReactor=" + puertaReactor + ", expPotenciaCero=" + expPotenciaCero
				+ ", expNucleo=" + expNucleo + ", fechaHora=" + fechaHora + ", tempNucleo=" + tempNucleo
				+ ", posFuente=" + fuenteAdentro + ", posNucleo=" + posNucleo + ", posBC1=" + posBC1 + ", posBC2=" + posBC2
				+ ", escalimetro=" + escalimetro + ", intLogCA=" + intLogCA + ", intLinCA=" + intLinCA + ", intLinCP="
				+ intLinCP + ", intLogCP=" + intLogCP + ", gammaConsola=" + gammaConsola + ", gammaReactor="
				+ gammaReactor + ", potencia=" + potencia + ", regimen=" + regimen + ", observaciones=" + observaciones
				+ "]";
	}
}