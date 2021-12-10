package com.ienri.operacionra4.entidades;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Operacion {
	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	private String id;
	
	@OneToMany
	private List<Usuario> usuario;

	private String canalCentralHorizontal;
	private String canalLateralSupHorizontal;
	private String canalLateralInfHorizontal;
	private String canalCentralVertical;
	private String canalLateralVertical;
	private String motivo;
	private String scram;
	private Boolean muestra;

//	@OneToMany
//	private List<PlanillaIrradiacion> planillaIrradiacion;

	private Boolean puertaConsola;
	private Boolean puertaReactor;
	private Boolean expPotenciaCero;
	private Boolean expNucleo;

//	@OneToMany
//	List<AdquisicionDatosOperacion> AdquisicionDatosOperacion;

	/* Constructor */
	public Operacion() {
		super();
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

	@Override
	public String toString() {
		return "Operacion [id=" + id + ", usuario=" + usuario + ", canalCentralHorizontal=" + canalCentralHorizontal
				+ ", canalLateralSupHorizontal=" + canalLateralSupHorizontal + ", canalLateralInfHorizontal="
				+ canalLateralInfHorizontal + ", canalCentralVertical=" + canalCentralVertical
				+ ", canalLateralVertical=" + canalLateralVertical + ", motivo=" + motivo + ", scram=" + scram
				+ ", muestra=" + muestra + ", puertaConsola=" + puertaConsola + ", puertaReactor=" + puertaReactor
				+ ", expPotenciaCero=" + expPotenciaCero + ", expNucleo=" + expNucleo + "]";
	}	
}
