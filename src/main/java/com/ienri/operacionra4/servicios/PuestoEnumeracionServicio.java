package com.ienri.operacionra4.servicios;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.ienri.operacionra4.enumerados.PuestoEnumeracion;

@Service
public class PuestoEnumeracionServicio {

	public List<String> arregloPuesto() {
		String[] arreglo = new String[3];
		Integer i = 0;

		for (PuestoEnumeracion aux : PuestoEnumeracion.values()) {
			arreglo[i] = aux.getValor();
			i += 1;  
		}
		
		List<String> puestos = Arrays.asList(arreglo);

		return puestos;
	}
}
