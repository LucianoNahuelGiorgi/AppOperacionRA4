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
	
	/*
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
	*/

	private Boolean realizado;
	private String observaciones;

	/* Constructor */
	public ProcedimientoEncendido() {
	}
	
	public ProcedimientoEncendido(Boolean realizado, String observaciones) {
		this.realizado = realizado;
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

	public Boolean getRealizado() {
		return realizado;
	}

	public void setRealizado(Boolean realizado) {
		this.realizado = realizado;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	@Override
	public String toString() {
		return "ProcedimientoEncendido [id=" + id + ", usuario=" + usuario + ", realizado=" + realizado
				+ ", observaciones=" + observaciones + "]";
	}
}