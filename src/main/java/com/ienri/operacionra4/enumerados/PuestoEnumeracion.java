package com.ienri.operacionra4.enumerados;

public enum PuestoEnumeracion {
	JEFE_REACTOR(1 , "Jefe de Reactor"), OPERADOR(2 , "Operador"), OFICIAL_RP(3 , "Oficial de RP");
	
	private Integer llave;
	private String valor;

	private PuestoEnumeracion(Integer llave, String valor){
		this.llave = llave;
		this.valor = valor;
	}

	public Integer getLLave(){
		return llave;
	}

	public String getValor(){
		return valor;
	}
}
