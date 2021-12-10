package com.ienri.operacionra4.entidades;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class ProcedimientoEncendido {
	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	private String id;

	@OneToMany
	private List<Usuario> usuario;

	private Boolean energizarConsola;	 // 1. Energizar el sistema de control utilizando el tablero eléctrico
	private Boolean puentesNoColocados;	 // 2. Verificar que ninguno de los puentes de anulación se encuentre colocado
	private Boolean ajusteFinoFATCP;	 // 3. Ajuste fino de la FAT canal de potencia en 0 V
	private Boolean apagadoFATCP;		 // 4. Verificar que este apagada la FAT canal de potencia
	private Boolean selectorFATCP;		 // 5. Selector de tensión de la FAT del canal de potencia en 0,6 kV
	private Boolean selectorFATMG;		 // 6. Selector de tensión de la FAT del monitor gamma en 650 V
	private Boolean selectorFCControl;	 // 7. Selector de la FC de control en 1x10-12 A
	private Boolean ajusteFinoFFControl; // 8. Ajuste fino de FC de control en 0 %
	private Boolean llaveOperacion;		 // 9. Llave selectora en posición "OPERACION"
	private Boolean selectoraDesactivada; // 10. Selectora desactivada
	private Boolean apagadoRegistradores; // 11. Verificar que esten apagados los registradores
	private Boolean selectorConmutadorCL; // 12. Selector conmutador canal lineal en 3x10-8 A
	private Boolean selectorIntegradorLinCA; // 13. Selector Integrador Canal Lineal de Arranque en 5x10+1 pulsos/seg
	private Boolean selectorBaseTiempoIntLinCA; // 14. Selector Base de Tiempo Integrador Canal Lineal de Arranque en 4 seg
	private Boolean selectorMessIntLogCA;		// 15. Selector posicionado en "Mess operate" Integrador Logaritmico Canal de Arranque 
	private Boolean selectorOscilosocio; 		// 16. Selector "Oszilloskop" en 2
	private Boolean apagadoFATCA; 				// 17. Verificar que la FATCA este apagada
	private Boolean presetTime; 				// 18. Selector "preset time" en x2x10+2
	private Boolean selectorEscalimetroReloj; 	// 19. Selector "Escalimetro" en "Betrieb operation"
	private Boolean presetCount; 				// 20. Selector "preset count" x2 infinito
	private Boolean encendidoConsola; 			// 21. Encender consola de control
	private Boolean encendidoMA; 				// 22. Encender Monitores de área
	private Boolean encendidoPC; 				// 23. Encender PC
	private Boolean tensionFATCA; 				// 24. Encender FAT Canal de Arranque
	private Boolean encendidoFATMG; 			// 25. Encender FAT Monitor gamma
	private Boolean encendidoFATCP; 			// 26. Encender FAT Canal de Potencia
												// 27. Espera de al menos 30 minutos para que ingrese en regimen la instrumetnal de la consola

	private String observaciones;

	/* Constructor */
	public ProcedimientoEncendido() {
	}

	public ProcedimientoEncendido(Boolean energizarConsola, Boolean puentesNoColocados,
			Boolean ajusteFinoFATCP, Boolean apagadoFATCP, Boolean selectorFATCP, Boolean selectorFATMG,
			Boolean selectorFCControl, Boolean ajusteFinoFFControl, Boolean llaveOperacion,
			Boolean selectoraDesactivada, Boolean apagadoRegistradores, Boolean selectorConmutadorCL,
			Boolean selectorIntegradorLinCA, Boolean selectorBaseTiempoIntLinCA, Boolean selectorMessIntLogCA,
			Boolean selectorOscilosocio, Boolean apagadoFATCA, Boolean presetTime, Boolean selectorEscalimetroReloj,
			Boolean presetCount, Boolean encendidoConsola, Boolean encendidoMA, Boolean encendidoPC,
			Boolean tensionFATCA, Boolean encendidoFATMG, Boolean encendidoFATCP, String observaciones) {

		this.energizarConsola = energizarConsola;
		this.puentesNoColocados = puentesNoColocados;
		this.ajusteFinoFATCP = ajusteFinoFATCP;
		this.apagadoFATCP = apagadoFATCP;
		this.selectorFATCP = selectorFATCP;
		this.selectorFATMG = selectorFATMG;
		this.selectorFCControl = selectorFCControl;
		this.ajusteFinoFFControl = ajusteFinoFFControl;
		this.llaveOperacion = llaveOperacion;
		this.selectoraDesactivada = selectoraDesactivada;
		this.apagadoRegistradores = apagadoRegistradores;
		this.selectorConmutadorCL = selectorConmutadorCL;
		this.selectorIntegradorLinCA = selectorIntegradorLinCA;
		this.selectorBaseTiempoIntLinCA = selectorBaseTiempoIntLinCA;
		this.selectorMessIntLogCA = selectorMessIntLogCA;
		this.selectorOscilosocio = selectorOscilosocio;
		this.apagadoFATCA = apagadoFATCA;
		this.presetTime = presetTime;
		this.selectorEscalimetroReloj = selectorEscalimetroReloj;
		this.presetCount = presetCount;
		this.encendidoConsola = encendidoConsola;
		this.encendidoMA = encendidoMA;
		this.encendidoPC = encendidoPC;
		this.tensionFATCA = tensionFATCA;
		this.encendidoFATMG = encendidoFATMG;
		this.encendidoFATCP = encendidoFATCP;
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

	public Boolean getEnergizarConsola() {
		return energizarConsola;
	}

	public void setEnergizarConsola(Boolean energizarConsola) {
		this.energizarConsola = energizarConsola;
	}

	public Boolean getPuentesNoColocados() {
		return puentesNoColocados;
	}

	public void setPuentesNoColocados(Boolean puentesNoColocados) {
		this.puentesNoColocados = puentesNoColocados;
	}

	public Boolean getAjusteFinoFATCP() {
		return ajusteFinoFATCP;
	}

	public void setAjusteFinoFATCP(Boolean ajusteFinoFATCP) {
		this.ajusteFinoFATCP = ajusteFinoFATCP;
	}

	public Boolean getApagadoFATCP() {
		return apagadoFATCP;
	}

	public void setApagadoFATCP(Boolean apagadoFATCP) {
		this.apagadoFATCP = apagadoFATCP;
	}

	public Boolean getSelectorFATCP() {
		return selectorFATCP;
	}

	public void setSelectorFATCP(Boolean selectorFATCP) {
		this.selectorFATCP = selectorFATCP;
	}

	public Boolean getSelectorFATMG() {
		return selectorFATMG;
	}

	public void setSelectorFATMG(Boolean selectorFATMG) {
		this.selectorFATMG = selectorFATMG;
	}

	public Boolean getSelectorFCControl() {
		return selectorFCControl;
	}

	public void setSelectorFCControl(Boolean selectorFCControl) {
		this.selectorFCControl = selectorFCControl;
	}

	public Boolean getAjusteFinoFFControl() {
		return ajusteFinoFFControl;
	}

	public void setAjusteFinoFFControl(Boolean ajusteFinoFFControl) {
		this.ajusteFinoFFControl = ajusteFinoFFControl;
	}

	public Boolean getLlaveOperacion() {
		return llaveOperacion;
	}

	public void setLlaveOperacion(Boolean llaveOperacion) {
		this.llaveOperacion = llaveOperacion;
	}

	public Boolean getSelectoraDesactivada() {
		return selectoraDesactivada;
	}

	public void setSelectoraDesactivada(Boolean selectoraDesactivada) {
		this.selectoraDesactivada = selectoraDesactivada;
	}

	public Boolean getApagadoRegistradores() {
		return apagadoRegistradores;
	}

	public void setApagadoRegistradores(Boolean apagadoRegistradores) {
		this.apagadoRegistradores = apagadoRegistradores;
	}

	public Boolean getSelectorConmutadorCL() {
		return selectorConmutadorCL;
	}

	public void setSelectorConmutadorCL(Boolean selectorConmutadorCL) {
		this.selectorConmutadorCL = selectorConmutadorCL;
	}

	public Boolean getSelectorIntegradorLinCA() {
		return selectorIntegradorLinCA;
	}

	public void setSelectorIntegradorLinCA(Boolean selectorIntegradorLinCA) {
		this.selectorIntegradorLinCA = selectorIntegradorLinCA;
	}

	public Boolean getSelectorBaseTiempoIntLinCA() {
		return selectorBaseTiempoIntLinCA;
	}

	public void setSelectorBaseTiempoIntLinCA(Boolean selectorBaseTiempoIntLinCA) {
		this.selectorBaseTiempoIntLinCA = selectorBaseTiempoIntLinCA;
	}

	public Boolean getSelectorMessIntLogCA() {
		return selectorMessIntLogCA;
	}

	public void setSelectorMessIntLogCA(Boolean selectorMessIntLogCA) {
		this.selectorMessIntLogCA = selectorMessIntLogCA;
	}

	public Boolean getSelectorOscilosocio() {
		return selectorOscilosocio;
	}

	public void setSelectorOscilosocio(Boolean selectorOscilosocio) {
		this.selectorOscilosocio = selectorOscilosocio;
	}

	public Boolean getApagadoFATCA() {
		return apagadoFATCA;
	}

	public void setApagadoFATCA(Boolean apagadoFATCA) {
		this.apagadoFATCA = apagadoFATCA;
	}

	public Boolean getPresetTime() {
		return presetTime;
	}

	public void setPresetTime(Boolean presetTime) {
		this.presetTime = presetTime;
	}

	public Boolean getSelectorEscalimetroReloj() {
		return selectorEscalimetroReloj;
	}

	public void setSelectorEscalimetroReloj(Boolean selectorEscalimetroReloj) {
		this.selectorEscalimetroReloj = selectorEscalimetroReloj;
	}

	public Boolean getPresetCount() {
		return presetCount;
	}

	public void setPresetCount(Boolean presetCount) {
		this.presetCount = presetCount;
	}

	public Boolean getEncendidoConsola() {
		return encendidoConsola;
	}

	public void setEncendidoConsola(Boolean encendidoConsola) {
		this.encendidoConsola = encendidoConsola;
	}

	public Boolean getEncendidoMA() {
		return encendidoMA;
	}

	public void setEncendidoMA(Boolean encendidoMA) {
		this.encendidoMA = encendidoMA;
	}

	public Boolean getEncendidoPC() {
		return encendidoPC;
	}

	public void setEncendidoPC(Boolean encendidoPC) {
		this.encendidoPC = encendidoPC;
	}

	public Boolean getTensionFATCA() {
		return tensionFATCA;
	}

	public void setTensionFATCA(Boolean tensionFATCA) {
		this.tensionFATCA = tensionFATCA;
	}

	public Boolean getEncendidoFATMG() {
		return encendidoFATMG;
	}

	public void setEncendidoFATMG(Boolean encendidoFATMG) {
		this.encendidoFATMG = encendidoFATMG;
	}

	public Boolean getEncendidoFATCP() {
		return encendidoFATCP;
	}

	public void setEncendidoFATCP(Boolean encendidoFATCP) {
		this.encendidoFATCP = encendidoFATCP;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	@Override
	public String toString() {
		return "ProcedimientoEncendido [id=" + id + ", usuario=" + usuario + ", energizarConsola=" + energizarConsola
				+ ", puentesNoColocados=" + puentesNoColocados + ", ajusteFinoFATCP=" + ajusteFinoFATCP
				+ ", apagadoFATCP=" + apagadoFATCP + ", selectorFATCP=" + selectorFATCP + ", selectorFATMG="
				+ selectorFATMG + ", selectorFCControl=" + selectorFCControl + ", ajusteFinoFFControl="
				+ ajusteFinoFFControl + ", llaveOperacion=" + llaveOperacion + ", selectoraDesactivada="
				+ selectoraDesactivada + ", apagadoRegistradores=" + apagadoRegistradores + ", selectorConmutadorCL="
				+ selectorConmutadorCL + ", selectorIntegradorLinCA=" + selectorIntegradorLinCA
				+ ", selectorBaseTiempoIntLinCA=" + selectorBaseTiempoIntLinCA + ", selectorMessIntLogCA="
				+ selectorMessIntLogCA + ", selectorOscilosocio=" + selectorOscilosocio + ", apagadoFATCA="
				+ apagadoFATCA + ", presetTime=" + presetTime + ", selectorEscalimetroReloj=" + selectorEscalimetroReloj
				+ ", presetCount=" + presetCount + ", encendidoConsola=" + encendidoConsola + ", encendidoMA="
				+ encendidoMA + ", encendidoPC=" + encendidoPC + ", tensionFATCA=" + tensionFATCA + ", encendidoFATMG="
				+ encendidoFATMG + ", encendidoFATCP=" + encendidoFATCP + ", observaciones=" + observaciones + "]";
	}
}