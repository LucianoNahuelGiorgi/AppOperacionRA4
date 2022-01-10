function validacionEnvio() {
	valor = document.getElementById("indicacionFATCA").value;
	if (valor == null || valor.length == 0 || /^\s+$/.test(valor)) {
		alert('[ERROR] El campo debe tener un valor de...');

		return false;
	}

	return true;
}


function validacionNumEntero(evt) {
	var charCode = (evt.which) ? evt.which : evt.keyCode

	if (charCode > 47 && charCode < 58)
		return true;
	else
		console.log("Por favor, ingresar sólo números enteros");

	return false;
}

function validacionNumReal(evt) {
	let charCode = (evt.which) ? evt.which : evt.keyCode;
	let campo = document.getElementById("temperaturaN");
	let cadena = campo.value;
	console.log(cadena);

	if (charCode == 46 && campo.value == "") {

		return false;
	} else {
		if ((charCode > 47 && charCode < 58) || charCode == 46) {
			if ((charCode == 46) && (cadena.includes(".", 0))) {
				return false;
			}
			else {
				return true;
			}
		}
		else {
			console.log("Por favor, ingresar sólo números y/o un solo punto decimal");
			return false;
		}
	}
}

/*
function validacionNotCientifica(evt) {
	let charCode = (evt.which) ? evt.which : evt.keyCode;

}
*/