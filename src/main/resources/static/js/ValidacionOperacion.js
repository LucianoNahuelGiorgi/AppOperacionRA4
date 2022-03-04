const formulario = document.getElementById('formulario');
const inputs = document.querySelectorAll('#formulario input');
const selects = document.querySelectorAll('#formulario select');

const expresiones = {
	entero: /^\d{1,14}$/, // 1 a 14 numeros.
	real: /^-?[0-9]+([\.,][0-9]+)?$/, // Numeros reales.
	notacionCientifica: /[-]?\d{1,2}[.,]\d[eE][-]?\d{1,2}/ // Notacion cientifica con letra e ó E
}

const campos = {
	temperaturaN: false,
	poscFuente:false,
	poscNucleo: false,
	poscBC1: false,
	poscBC2: false,
	escalimetro: false,
	intLogaritmico: false,
	intLineal: false,
	intLogPotencia: false,
	intLinPotencia: false,
	potencia: false,
	gammaConsola: false,
	gammaReactor: false,
}

const validarFormulario = (e) => {
	switch (e.target.name) {
		case "temperaturaN":
			validarCampo(expresiones.real, e.target, 'temperaturaN');
			break;
		case "poscFuente":
			validarCampo(expresiones.real, e.target, 'poscFuente');
			break;
		case "poscNucleo":
			validarCampo(expresiones.real, e.target, 'poscNucleo');
			break;
		case "poscBC1":
			validarCampo(expresiones.real, e.target, 'poscBC1');
			break;
		case "poscBC2":
			validarCampo(expresiones.real, e.target, 'poscBC2');
			break;
		case "escalimetro":
			validarCampo(expresiones.entero, e.target, 'escalimetro');
			break;
		case "intLogaritmico":
			validarCampo(expresiones.notacionCientifica, e.target, 'intLogaritmico');
			break;
		case "intLineal":
			validarCampo(expresiones.notacionCientifica, e.target, 'intLineal');
			break;
		case "intLogPotencia":
			validarCampo(expresiones.notacionCientifica, e.target, 'intLogPotencia');
			break;
		case "intLinPotencia":
			validarCampo(expresiones.notacionCientifica, e.target, 'intLinPotencia');
			break;
		case "potencia":
			validarCampo(expresiones.real, e.target, 'potencia');
			break;
		case "gammaConsola":
			validarCampo(expresiones.real, e.target, 'gammaConsola');
			break;
		case "gammaReactor":
			validarCampo(expresiones.real, e.target, 'gammaReactor');
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