const formulario = document.getElementById('formulario');
const inputs = document.querySelectorAll('#formulario input');
const selects = document.querySelectorAll('#formulario select');

const expresiones = {
	entero: /^\d{1,14}$/, // 1 a 14 numeros.
	real: /^-?[0-9]+([\.,][0-9]+)?$/, // Numeros reales.
	notacionCientifica: /[-]?\d{1,2}[.,]\d[eE][-]?\d{1,2}/ // Notacion cientifica con letra e ó E
}

const campos = {
	indicacion_01: false,
	indicacion_02: false,
	indicacion_03: false,
	indicacion_04: false,
	indicacion_05: false,
	indicacion_06: false,
	indicacion_07: false,
	indicacion_08: false,
	indicacion_09: false,
	indicacion_10: false,
	indicacion_11: false,
	indicacion_12: false,
	indicacion_13: false,
	indicacion_14: false,
	indicacion_15: false,
	indicacion_16: false,
	indicacion_17: false,
	indicacion_18: false,
	indicacion_19: false,
	indicacion_20: false,
	indicacion_21: false,
	indicacion_22: false,
	indicacion_23: false,
	indicacion_24: false,
	indicacion_25: false,
	indicacion_26: false,
	indicacion_29: false,
	indicacion_30: false,
}

const validarFormulario = (e) => {
	switch (e.target.name) {
		case "indicacion_01":
			validarCampo(expresiones.entero, e.target, 'indicacion_01');
			break;
		case "indicacion_02":
			validarCampo(expresiones.entero, e.target, 'indicacion_02');
			break;
		case "indicacion_03":
			validarCampo(expresiones.entero, e.target, 'indicacion_03');
			break;
		case "indicacion_04":
			validarCampo(expresiones.real, e.target, 'indicacion_04');
			break;
		case "indicacion_05":
			validarCampo(expresiones.entero, e.target, 'indicacion_05');
			break;
		case "indicacion_06":
			validarCampo(expresiones.notacionCientifica, e.target, 'indicacion_06');
			break;
		case "indicacion_07":
			validarCampo(expresiones.notacionCientifica, e.target, 'indicacion_07');
			break;
		case "indicacion_08":
			validarCampo(expresiones.entero, e.target, 'indicacion_08');
			break;
		case "indicacion_09":
			validarCampo(expresiones.notacionCientifica, e.target, 'indicacion_09');
			break;
		case "indicacion_10":
			validarCampo(expresiones.notacionCientifica, e.target, 'indicacion_10');
			break;
		case "indicacion_11":
			validarCampo(expresiones.notacionCientifica, e.target, 'indicacion_11');
			break;
		case "indicacion_12":
			validarCampo(expresiones.notacionCientifica, e.target, 'indicacion_12');
			break;
		case "indicacion_13":
			validarCampo(expresiones.notacionCientifica, e.target, 'indicacion_13');
			break;
		case "indicacion_14":
			validarCampo(expresiones.entero, e.target, 'indicacion_14');
			break;
		case "indicacion_15":
			validarCampo(expresiones.notacionCientifica, e.target, 'indicacion_15');
			break;
		case "indicacion_16":
			validarCampo(expresiones.entero, e.target, 'indicacion_16');
			break;
		case "indicacion_17":
			validarCampo(expresiones.notacionCientifica, e.target, 'indicacion_17');
			break;
		case "indicacion_18":
			validarCampo(expresiones.entero, e.target, 'indicacion_18');
			break;
		case "indicacion_19":
			validarCampo(expresiones.notacionCientifica, e.target, 'indicacion_19');
			break;
		case "indicacion_20":
			validarCampo(expresiones.entero, e.target, 'indicacion_20');
			break;
		case "indicacion_21":
			validarCampo(expresiones.notacionCientifica, e.target, 'indicacion_21');
			break;
		case "indicacion_22":
			validarCampo(expresiones.entero, e.target, 'indicacion_22');
			break;
		case "indicacion_23":
			validarCampo(expresiones.notacionCientifica, e.target, 'indicacion_23');
			break;
		case "indicacion_24":
			validarCampo(expresiones.entero, e.target, 'indicacion_24');
			break;
		case "indicacion_25":
			validarCampo(expresiones.notacionCientifica, e.target, 'indicacion_25');
			break;
		case "indicacion_26":
			validarCampo(expresiones.entero, e.target, 'indicacion_26');
			break;
		case "indicacion_29":
			validarCampo(expresiones.entero, e.target, 'indicacion_29');
			break;
		case "indicacion_30":
			validarCampo(expresiones.entero, e.target, 'indicacion_30');
			break;
	}
}

const validarCampo = (expresion, input, campo) => {
	if (expresion.test(input.value)) {
		document.getElementById(`grupo__${campo}`).classList.remove('formulario__grupo-incorrecto');
		document.getElementById(`grupo__${campo}`).classList.add('formulario__grupo-correcto');
		document.querySelector(`#grupo__${campo} i`).classList.add('fa-check-circle');
		document.querySelector(`#grupo__${campo} i`).classList.remove('fa-times-circle');
		document.querySelector(`#grupo__${campo} .formulario__input-error`).classList.remove('formulario__input-error-activo');
		campos[campo] = true;
	} else {
		document.getElementById(`grupo__${campo}`).classList.add('formulario__grupo-incorrecto');
		document.getElementById(`grupo__${campo}`).classList.remove('formulario__grupo-correcto');
		document.querySelector(`#grupo__${campo} i`).classList.add('fa-times-circle');
		document.querySelector(`#grupo__${campo} i`).classList.remove('fa-check-circle');
		document.querySelector(`#grupo__${campo} .formulario__input-error`).classList.add('formulario__input-error-activo');
		campos[campo] = false;
	}
}

const validarSelect = (input, campo) => {
	console.log("Estoy en validar select " + input);
	if (input === "vacio") {
		console.log("Estoy dentro del if " + input);
		document.getElementById(`grupo__${campo}`).classList.remove('formulario__grupo-incorrecto');
		document.getElementById(`grupo__${campo}`).classList.add('formulario__grupo-correcto');
		//		document.querySelector(`#grupo__${campo} i`).classList.add('fa-check-circle');
		//		document.querySelector(`#grupo__${campo} i`).classList.remove('fa-times-circle');
		//		document.querySelector(`#grupo__${campo} .formulario__input-error`).classList.remove('formulario__input-error-activo');
		campos[campo] = false;
	} else {
		console.log("Estoy dentro del else " + input);
		document.getElementById(`grupo__${campo}`).classList.add('formulario__grupo-incorrecto');
		document.getElementById(`grupo__${campo}`).classList.remove('formulario__grupo-correcto');
		//		document.querySelector(`#grupo__${campo} i`).classList.add('fa-times-circle');
		//		document.querySelector(`#grupo__${campo} i`).classList.remove('fa-check-circle');
		//		document.querySelector(`#grupo__${campo} .formulario__input-error`).classList.add('formulario__input-error-activo');
		campos[campo] = true;
	}
}

inputs.forEach((input) => {
	input.addEventListener('keyup', validarFormulario);
	input.addEventListener('blur', validarFormulario);
});

selects.forEach((select) => {
	select.addEventListener('click', validarFormulario)
});

formulario.addEventListener('submit', (e) => {
	//e.preventDefault();

	//const terminos = document.getElementById('terminos');
	if (campos.nombre && campos.apellido && campos.dni && campos.telefono && campos.usuario && campos.correo && campos.puesto && campos.rol) {
		//formulario.reset();
		document.getElementById('formulario__mensaje-exito').classList.add('formulario__mensaje-exito-activo');
		setTimeout(() => {
			document.getElementById('formulario__mensaje-exito').classList.remove('formulario__mensaje-exito-activo');
		}, 5000);

		document.querySelectorAll('.formulario__grupo-correcto').forEach((icono) => {
			icono.classList.remove('formulario__grupo-correcto');
		});
	} else {
		document.getElementById('formulario__mensaje').classList.add('formulario__mensaje-activo');
	}
});