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
	private Integer indicacion_01; // Fuente de alta tensión Canal de Arranque
	private Integer indicacion_02; // Fuente de alta tensión Monitor Gamma
	private Integer indicacion_03; // Fuente de alta tensión Canal de Potencia
	/* TEMPERATURA DEL NUCLEO */
	private Double indicacion_04; // Temperatura de núcleo
	/* CANAL DE ARRANQUE */
	private Integer indicacion_05; // Tubo contador Uno: escalímetro
	private Double indicacion_06; // Tubo contador Uno: Integrador lineal. Notacion cientifica
	private Double indicacion_07; // Tubo contador Uno: Integrador loga. Notacion cientifica
	private Integer indicacion_08; // Tubo contador Dos: escalímetro
	private Double indicacion_09; // Tubo contador Dos: Integrador lineal. Notacion cientifica
	private Double indicacion_10; // Tubo contador Dos: Integrador loga. Notacion cientifica
	/*
	 * INTEGRADOR LOGARÍTMICO DE ARRANQUE PRUEBA DE LOS VALORES LÍMITES
	 */
	private Double indicacion_11; // Intensidad de fuente o flujo demasiado baja. Notacion cientifica
	private Double indicacion_12; // Multiplicación demasiado alta. Notacion cientifica
	/* CANAL DE POTENCIA AMPLIFICADOR LOGARITMICO */
	private Double indicacion_13; // Desconectar tensión contador. Notacion cientifica
	private Integer indicacion_14; // Registrador de Desconectar tensión contador
	private Double indicacion_15; // Conectar tensión contador. Notacion cientifica
	private Integer indicacion_16; // Registrador Conectar tensión contador
	private Double indicacion_17; // Intensidad de fuente o flujo demasiado baja. Notacion cientifica
	private Integer indicacion_18; // Registrador Intensidad de fuente o flujo demasiado baja
	private Double indicacion_19; // Pre-alerta canal logarítmnico. Notacion cientifica
	private Integer indicacion_20; // Registrador Pre-alerta canal logarítmnico
	private Double indicacion_21; // Canal logarít. - Flujo demasiado alto. Notacion cientifica
	private Integer indicacion_22; // Registrador Canal logarít. - Flujo demasiado alto
	/* DISPAROS CANAL LIN. DE ARRANQUE */
	private Double indicacion_23; // Conmutar canal lineal
	private Double indicacion_24; // Registrador Conmutar canal lineal
	private Double indicacion_25; // Flujo demasiado alto
	private Double indicacion_26; // Registrador Flujo demasiado alto
	/* FALLAS FAT */
	private Boolean indicacion_27; // Indicación Falla de equipo Canal lineal
	private Boolean indicacion_28; // Indicación Falla de alta tensión
	/* DISPAROS MONITORES GAMMA */
	private Integer indicacion_29; // Dosis gamma demasiado alta
	private Integer indicacion_30; // Falla del monitor gamma
	/* OBSERVACIONES */
	private String observaciones;

	/* Constructor */
	public PruebaFuncion() {
	}

	/* Constructor guardar */
	public PruebaFuncion(Integer indicacion_01, Integer indicacion_02, Integer indicacion_03, Double indicacion_04,
			Integer indicacion_05, Double indicacion_06, Double indicacion_07, Integer indicacion_08,
			Double indicacion_09, Double indicacion_10, Double indicacion_11, Double indicacion_12,
			Double indicacion_13, Integer indicacion_14, Double indicacion_15, Integer indicacion_16,
			Double indicacion_17, Integer indicacion_18, Double indicacion_19, Integer indicacion_20,
			Double indicacion_21, Integer indicacion_22, Double indicacion_23, Double indicacion_24,
			Double indicacion_25, Double indicacion_26, Boolean indicacion_27, Boolean indicacion_28,
			Integer indicacion_29, Integer indicacion_30, String observaciones) {
		super();
		this.indicacion_01 = indicacion_01;
		this.indicacion_02 = indicacion_02;
		this.indicacion_03 = indicacion_03;
		this.indicacion_04 = indicacion_04;
		this.indicacion_05 = indicacion_05;
		this.indicacion_06 = indicacion_06;
		this.indicacion_07 = indicacion_07;
		this.indicacion_08 = indicacion_08;
		this.indicacion_09 = indicacion_09;
		this.indicacion_10 = indicacion_10;
		this.indicacion_11 = indicacion_11;
		this.indicacion_12 = indicacion_12;
		this.indicacion_13 = indicacion_13;
		this.indicacion_14 = indicacion_14;
		this.indicacion_15 = indicacion_15;
		this.indicacion_16 = indicacion_16;
		this.indicacion_17 = indicacion_17;
		this.indicacion_18 = indicacion_18;
		this.indicacion_19 = indicacion_19;
		this.indicacion_20 = indicacion_20;
		this.indicacion_21 = indicacion_21;
		this.indicacion_22 = indicacion_22;
		this.indicacion_23 = indicacion_23;
		this.indicacion_24 = indicacion_24;
		this.indicacion_25 = indicacion_25;
		this.indicacion_26 = indicacion_26;
		this.indicacion_27 = indicacion_27;
		this.indicacion_28 = indicacion_28;
		this.indicacion_29 = indicacion_29;
		this.indicacion_30 = indicacion_30;
		this.observaciones = observaciones;
	}

	/* getter, setter y toString() */
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

	public Integer getIndicacion_01() {
		return indicacion_01;
	}

	public void setIndicacion_01(Integer indicacion_01) {
		this.indicacion_01 = indicacion_01;
	}

	public Integer getIndicacion_02() {
		return indicacion_02;
	}

	public void setIndicacion_02(Integer indicacion_02) {
		this.indicacion_02 = indicacion_02;
	}

	public Integer getIndicacion_03() {
		return indicacion_03;
	}

	public void setIndicacion_03(Integer indicacion_03) {
		this.indicacion_03 = indicacion_03;
	}

	public Double getIndicacion_04() {
		return indicacion_04;
	}

	public void setIndicacion_04(Double indicacion_04) {
		this.indicacion_04 = indicacion_04;
	}

	public Integer getIndicacion_05() {
		return indicacion_05;
	}

	public void setIndicacion_05(Integer indicacion_05) {
		this.indicacion_05 = indicacion_05;
	}

	public Double getIndicacion_06() {
		return indicacion_06;
	}

	public void setIndicacion_06(Double indicacion_06) {
		this.indicacion_06 = indicacion_06;
	}

	public Double getIndicacion_07() {
		return indicacion_07;
	}

	public void setIndicacion_07(Double indicacion_07) {
		this.indicacion_07 = indicacion_07;
	}

	public Integer getIndicacion_08() {
		return indicacion_08;
	}

	public void setIndicacion_08(Integer indicacion_08) {
		this.indicacion_08 = indicacion_08;
	}

	public Double getIndicacion_09() {
		return indicacion_09;
	}

	public void setIndicacion_09(Double indicacion_09) {
		this.indicacion_09 = indicacion_09;
	}

	public Double getIndicacion_10() {
		return indicacion_10;
	}

	public void setIndicacion_10(Double indicacion_10) {
		this.indicacion_10 = indicacion_10;
	}

	public Double getIndicacion_11() {
		return indicacion_11;
	}

	public void setIndicacion_11(Double indicacion_11) {
		this.indicacion_11 = indicacion_11;
	}

	public Double getIndicacion_12() {
		return indicacion_12;
	}

	public void setIndicacion_12(Double indicacion_12) {
		this.indicacion_12 = indicacion_12;
	}

	public Double getIndicacion_13() {
		return indicacion_13;
	}

	public void setIndicacion_13(Double indicacion_13) {
		this.indicacion_13 = indicacion_13;
	}

	public Integer getIndicacion_14() {
		return indicacion_14;
	}

	public void setIndicacion_14(Integer indicacion_14) {
		this.indicacion_14 = indicacion_14;
	}

	public Double getIndicacion_15() {
		return indicacion_15;
	}

	public void setIndicacion_15(Double indicacion_15) {
		this.indicacion_15 = indicacion_15;
	}

	public Integer getIndicacion_16() {
		return indicacion_16;
	}

	public void setIndicacion_16(Integer indicacion_16) {
		this.indicacion_16 = indicacion_16;
	}

	public Double getIndicacion_17() {
		return indicacion_17;
	}

	public void setIndicacion_17(Double indicacion_17) {
		this.indicacion_17 = indicacion_17;
	}

	public Integer getIndicacion_18() {
		return indicacion_18;
	}

	public void setIndicacion_18(Integer indicacion_18) {
		this.indicacion_18 = indicacion_18;
	}

	public Double getIndicacion_19() {
		return indicacion_19;
	}

	public void setIndicacion_19(Double indicacion_19) {
		this.indicacion_19 = indicacion_19;
	}

	public Integer getIndicacion_20() {
		return indicacion_20;
	}

	public void setIndicacion_20(Integer indicacion_20) {
		this.indicacion_20 = indicacion_20;
	}

	public Double getIndicacion_21() {
		return indicacion_21;
	}

	public void setIndicacion_21(Double indicacion_21) {
		this.indicacion_21 = indicacion_21;
	}

	public Integer getIndicacion_22() {
		return indicacion_22;
	}

	public void setIndicacion_22(Integer indicacion_22) {
		this.indicacion_22 = indicacion_22;
	}

	public Double getIndicacion_23() {
		return indicacion_23;
	}

	public void setIndicacion_23(Double indicacion_23) {
		this.indicacion_23 = indicacion_23;
	}

	public Double getIndicacion_24() {
		return indicacion_24;
	}

	public void setIndicacion_24(Double indicacion_24) {
		this.indicacion_24 = indicacion_24;
	}

	public Double getIndicacion_25() {
		return indicacion_25;
	}

	public void setIndicacion_25(Double indicacion_25) {
		this.indicacion_25 = indicacion_25;
	}

	public Double getIndicacion_26() {
		return indicacion_26;
	}

	public void setIndicacion_26(Double indicacion_26) {
		this.indicacion_26 = indicacion_26;
	}

	public Boolean getIndicacion_27() {
		return indicacion_27;
	}

	public void setIndicacion_27(Boolean indicacion_27) {
		this.indicacion_27 = indicacion_27;
	}

	public Boolean getIndicacion_28() {
		return indicacion_28;
	}

	public void setIndicacion_28(Boolean indicacion_28) {
		this.indicacion_28 = indicacion_28;
	}

	public Integer getIndicacion_29() {
		return indicacion_29;
	}

	public void setIndicacion_29(Integer indicacion_29) {
		this.indicacion_29 = indicacion_29;
	}

	public Integer getIndicacion_30() {
		return indicacion_30;
	}

	public void setIndicacion_30(Integer indicacion_30) {
		this.indicacion_30 = indicacion_30;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	@Override
	public String toString() {
		return "PruebaFuncion [indicacion_01=" + indicacion_01 + ", indicacion_02=" + indicacion_02 + ", indicacion_03="
				+ indicacion_03 + ", indicacion_04=" + indicacion_04 + ", indicacion_05=" + indicacion_05
				+ ", indicacion_06=" + indicacion_06 + ", indicacion_07=" + indicacion_07 + ", indicacion_08="
				+ indicacion_08 + ", indicacion_09=" + indicacion_09 + ", indicacion_10=" + indicacion_10
				+ ", indicacion_11=" + indicacion_11 + ", indicacion_12=" + indicacion_12 + ", indicacion_13="
				+ indicacion_13 + ", indicacion_14=" + indicacion_14 + ", indicacion_15=" + indicacion_15
				+ ", indicacion_16=" + indicacion_16 + ", indicacion_17=" + indicacion_17 + ", indicacion_18="
				+ indicacion_18 + ", indicacion_19=" + indicacion_19 + ", indicacion_20=" + indicacion_20
				+ ", indicacion_21=" + indicacion_21 + ", indicacion_22=" + indicacion_22 + ", indicacion_23="
				+ indicacion_23 + ", indicacion_24=" + indicacion_24 + ", indicacion_25=" + indicacion_25
				+ ", indicacion_26=" + indicacion_26 + ", indicacion_27=" + indicacion_27 + ", indicacion_28="
				+ indicacion_28 + ", indicacion_29=" + indicacion_29 + ", indicacion_30=" + indicacion_30
				+ ", observaciones=" + observaciones + "]";
	}
}