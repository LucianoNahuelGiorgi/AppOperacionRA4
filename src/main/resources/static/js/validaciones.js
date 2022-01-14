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

function validacionNotCientifica(evt) {
	let charCode = (evt.which) ? evt.which : evt.keyCode;
	let campo = document.getElementById("notCientificaCA");
	cadena = campo.value;

	if ((charCode == 46 && cadena == "") || (charCode == 69 && cadena == "") || (charCode == 101 && cadena == "") || (charCode == 45 && cadena == "")) {
		return false;
	} else {
		if ((charCode > 47 && charCode < 58) || charCode == 46 || charCode == 69 || charCode == 101 || charCode == 45) {
			if ((charCode == 46 && cadena.includes(".")) ||
				(charCode == 69 && cadena.includes("E")) ||
				(charCode == 101 && cadena.includes("e")) ||
				(charCode == 45 && cadena.includes("-"))) {

				return false;
			}
			else {

				return true;
			}
		} else {

			return false;
		}
	}
}

function cargaProcEncendido() {
	//console.log("OnLoad");
	let cbox1 = document.getElementById("cbox1");
	cbox1.disabled = false;

	let cbox2 = document.getElementById("cbox2");
	cbox2.disabled = true;

	let cbox3 = document.getElementById("cbox3");
	cbox3.disabled = true;

	let cbox4 = document.getElementById("cbox4");
	cbox4.disabled = true;

	let cbox5 = document.getElementById("cbox5");
	cbox5.disabled = true;

	let cbox6 = document.getElementById("cbox6");
	cbox6.disabled = true;

	let cbox7 = document.getElementById("cbox7");
	cbox7.disabled = true;

	let cbox8 = document.getElementById("cbox8");
	cbox8.disabled = true;

	let cbox9 = document.getElementById("cbox9");
	cbox9.disabled = true;

	let cbox10 = document.getElementById("cbox10");
	cbox10.disabled = true;

	let cbox11 = document.getElementById("cbox11");
	cbox11.disabled = true;

	let cbox12 = document.getElementById("cbox12");
	cbox12.disabled = true;

	let cbox13 = document.getElementById("cbox13");
	cbox13.disabled = true;

	let cbox14 = document.getElementById("cbox14");
	cbox14.disabled = true;

	let cbox15 = document.getElementById("cbox15");
	cbox15.disabled = true;

	let cbox16 = document.getElementById("cbox16");
	cbox16.disabled = true;

	let cbox17 = document.getElementById("cbox17");
	cbox17.disabled = true;

	let cbox18 = document.getElementById("cbox18");
	cbox18.disabled = true;

	let cbox19 = document.getElementById("cbox19");
	cbox19.disabled = true;

	let cbox20 = document.getElementById("cbox20");
	cbox20.disabled = true;

	let cbox21 = document.getElementById("cbox21");
	cbox21.disabled = true;

	let cbox22 = document.getElementById("cbox22");
	cbox22.disabled = true;

	let cbox23 = document.getElementById("cbox23");
	cbox23.disabled = true;

	let cbox24 = document.getElementById("cbox24");
	cbox24.disabled = true;

	let cbox25 = document.getElementById("cbox25");
	cbox25.disabled = true;

	let cbox26 = document.getElementById("cbox26");
	cbox26.disabled = true;

	let cbox27 = document.getElementById("cbox27");
	cbox27.disabled = true;

	let btnAceptar = document.getElementById("btnAceptar");
	btnAceptar.disabled = true;
}

function checkProcEncendido() {
	//console.log("OnClick");
	let cbox1 = document.getElementById("cbox1");
	let cbox2 = document.getElementById("cbox2");
	let cbox3 = document.getElementById("cbox3");
	let cbox4 = document.getElementById("cbox4");
	let cbox5 = document.getElementById("cbox5");
	let cbox6 = document.getElementById("cbox6");
	let cbox7 = document.getElementById("cbox7");
	let cbox8 = document.getElementById("cbox8");
	let cbox9 = document.getElementById("cbox9");
	let cbox10 = document.getElementById("cbox10");
	let cbox11 = document.getElementById("cbox11");
	let cbox12 = document.getElementById("cbox12");
	let cbox13 = document.getElementById("cbox13");
	let cbox14 = document.getElementById("cbox14");
	let cbox15 = document.getElementById("cbox15");
	let cbox16 = document.getElementById("cbox16");
	let cbox17 = document.getElementById("cbox17");
	let cbox18 = document.getElementById("cbox18");
	let cbox19 = document.getElementById("cbox19");
	let cbox20 = document.getElementById("cbox20");
	let cbox21 = document.getElementById("cbox21");
	let cbox22 = document.getElementById("cbox22");
	let cbox23 = document.getElementById("cbox23");
	let cbox24 = document.getElementById("cbox24");
	let cbox25 = document.getElementById("cbox25");
	let cbox26 = document.getElementById("cbox26");
	let cbox27 = document.getElementById("cbox27");

	if (cbox1.checked) {
		cbox2.disabled = false;
	}

	if (cbox2.checked && cbox1.checked) {
		cbox3.disabled = false;
	}

	if (cbox3.checked && cbox2.checked && cbox1.checked) {
		cbox4.disabled = false;
	}

	if (cbox4.checked && cbox3.checked && cbox2.checked && cbox1.checked) {
		cbox5.disabled = false;
	}

	if (cbox5.checked && cbox4.checked && cbox3.checked && cbox2.checked && cbox1.checked) {
		cbox6.disabled = false;
	}

	if (cbox6.checked && cbox5.checked && cbox4.checked && cbox3.checked && cbox2.checked && cbox1.checked) {
		cbox7.disabled = false;
	}

	if (cbox7.checked && cbox6.checked && cbox5.checked && cbox4.checked && cbox3.checked && cbox2.checked && cbox1.checked) {
		cbox8.disabled = false;
	}

	if (cbox8.checked && cbox7.checked && cbox6.checked && cbox5.checked && cbox4.checked && cbox3.checked && cbox2.checked && cbox1.checked) {
		cbox9.disabled = false;
	}

	if (cbox9.checked && cbox8.checked && cbox7.checked && cbox6.checked && cbox5.checked && cbox4.checked && cbox3.checked && cbox2.checked && cbox1.checked) {
		cbox10.disabled = false;
	}

	if (cbox10.checked && cbox9.checked && cbox8.checked && cbox7.checked && cbox6.checked && cbox5.checked && cbox4.checked && cbox3.checked && cbox2.checked && cbox1.checked) {
		cbox11.disabled = false;
	}

	if (cbox11.checked && cbox10.checked && cbox9.checked && cbox8.checked && cbox7.checked && cbox6.checked && cbox5.checked && cbox4.checked && cbox3.checked && cbox2.checked && cbox1.checked) {
		cbox12.disabled = false;
	}

	if (cbox12.checked && cbox11.checked && cbox10.checked && cbox9.checked && cbox8.checked && cbox7.checked && cbox6.checked && cbox5.checked && cbox4.checked && cbox3.checked && cbox2.checked && cbox1.checked) {
		cbox13.disabled = false;
	}

	if (cbox13.checked && cbox12.checked && cbox11.checked && cbox10.checked && cbox9.checked && cbox8.checked && cbox7.checked && cbox6.checked && cbox5.checked && cbox4.checked && cbox3.checked && cbox2.checked && cbox1.checked) {
		cbox14.disabled = false;
	}

	if (cbox14.checked && cbox13.checked && cbox12.checked && cbox11.checked && cbox10.checked && cbox9.checked && cbox8.checked && cbox7.checked && cbox6.checked && cbox5.checked && cbox4.checked && cbox3.checked && cbox2.checked && cbox1.checked) {
		cbox15.disabled = false;
	}

	if (cbox15.checked && cbox14.checked && cbox13.checked && cbox12.checked && cbox11.checked && cbox10.checked && cbox9.checked && cbox8.checked && cbox7.checked && cbox6.checked && cbox5.checked && cbox4.checked && cbox3.checked && cbox2.checked && cbox1.checked) {
		cbox16.disabled = false;
	}

	if (cbox16.checked && cbox15.checked && cbox14.checked && cbox13.checked && cbox12.checked && cbox11.checked && cbox10.checked && cbox9.checked && cbox8.checked && cbox7.checked && cbox6.checked && cbox5.checked && cbox4.checked && cbox3.checked && cbox2.checked && cbox1.checked) {
		cbox17.disabled = false;
	}
	
	if (cbox17.checked && cbox16.checked && cbox15.checked && cbox14.checked && cbox13.checked && cbox12.checked && cbox11.checked && cbox10.checked && cbox9.checked && cbox8.checked && cbox7.checked && cbox6.checked && cbox5.checked && cbox4.checked && cbox3.checked && cbox2.checked && cbox1.checked) {
		cbox18.disabled = false;
	}
	
	if (cbox18.checked && cbox17.checked && cbox16.checked && cbox15.checked && cbox14.checked && cbox13.checked && cbox12.checked && cbox11.checked && cbox10.checked && cbox9.checked && cbox8.checked && cbox7.checked && cbox6.checked && cbox5.checked && cbox4.checked && cbox3.checked && cbox2.checked && cbox1.checked) {
		cbox19.disabled = false;
	}
	
	if (cbox19.checked && cbox18.checked && cbox17.checked && cbox16.checked && cbox15.checked && cbox14.checked && cbox13.checked && cbox12.checked && cbox11.checked && cbox10.checked && cbox9.checked && cbox8.checked && cbox7.checked && cbox6.checked && cbox5.checked && cbox4.checked && cbox3.checked && cbox2.checked && cbox1.checked) {
		cbox20.disabled = false;
	}
	
	if (cbox20.checked && cbox19.checked && cbox18.checked && cbox17.checked && cbox16.checked && cbox15.checked && cbox14.checked && cbox13.checked && cbox12.checked && cbox11.checked && cbox10.checked && cbox9.checked && cbox8.checked && cbox7.checked && cbox6.checked && cbox5.checked && cbox4.checked && cbox3.checked && cbox2.checked && cbox1.checked) {
		cbox21.disabled = false;
	}
	
	if (cbox21.checked && cbox20.checked && cbox19.checked && cbox18.checked && cbox17.checked && cbox16.checked && cbox15.checked && cbox14.checked && cbox13.checked && cbox12.checked && cbox11.checked && cbox10.checked && cbox9.checked && cbox8.checked && cbox7.checked && cbox6.checked && cbox5.checked && cbox4.checked && cbox3.checked && cbox2.checked && cbox1.checked) {
		cbox22.disabled = false;
	}
	
	if (cbox22.checked && cbox21.checked && cbox20.checked && cbox19.checked && cbox18.checked && cbox17.checked && cbox16.checked && cbox15.checked && cbox14.checked && cbox13.checked && cbox12.checked && cbox11.checked && cbox10.checked && cbox9.checked && cbox8.checked && cbox7.checked && cbox6.checked && cbox5.checked && cbox4.checked && cbox3.checked && cbox2.checked && cbox1.checked) {
		cbox23.disabled = false;
	}
	
	if (cbox23.checked && cbox22.checked && cbox21.checked && cbox20.checked && cbox19.checked && cbox18.checked && cbox17.checked && cbox16.checked && cbox15.checked && cbox14.checked && cbox13.checked && cbox12.checked && cbox11.checked && cbox10.checked && cbox9.checked && cbox8.checked && cbox7.checked && cbox6.checked && cbox5.checked && cbox4.checked && cbox3.checked && cbox2.checked && cbox1.checked) {
		cbox24.disabled = false;
	}
	
	if (cbox24.checked && cbox23.checked && cbox22.checked && cbox21.checked && cbox20.checked && cbox19.checked && cbox18.checked && cbox17.checked && cbox16.checked && cbox15.checked && cbox14.checked && cbox13.checked && cbox12.checked && cbox11.checked && cbox10.checked && cbox9.checked && cbox8.checked && cbox7.checked && cbox6.checked && cbox5.checked && cbox4.checked && cbox3.checked && cbox2.checked && cbox1.checked) {
		cbox25.disabled = false;
	}
	
	if (cbox25.checked && cbox24.checked && cbox23.checked && cbox22.checked && cbox21.checked && cbox20.checked && cbox19.checked && cbox18.checked && cbox17.checked && cbox16.checked && cbox15.checked && cbox14.checked && cbox13.checked && cbox12.checked && cbox11.checked && cbox10.checked && cbox9.checked && cbox8.checked && cbox7.checked && cbox6.checked && cbox5.checked && cbox4.checked && cbox3.checked && cbox2.checked && cbox1.checked) {
		cbox26.disabled = false;
	}
	
	if (cbox26.checked && cbox25.checked && cbox24.checked && cbox23.checked && cbox22.checked && cbox21.checked && cbox20.checked && cbox19.checked && cbox18.checked && cbox17.checked && cbox16.checked && cbox15.checked && cbox14.checked && cbox13.checked && cbox12.checked && cbox11.checked && cbox10.checked && cbox9.checked && cbox8.checked && cbox7.checked && cbox6.checked && cbox5.checked && cbox4.checked && cbox3.checked && cbox2.checked && cbox1.checked) {
		cbox27.disabled = false;
	}
	
	if (cbox27.checked && cbox26.checked && cbox26.checked && cbox25.checked && cbox24.checked && cbox23.checked && cbox22.checked && cbox21.checked && cbox20.checked && cbox19.checked && cbox18.checked && cbox17.checked && cbox16.checked && cbox15.checked && cbox14.checked && cbox13.checked && cbox12.checked && cbox11.checked && cbox10.checked && cbox9.checked && cbox8.checked && cbox7.checked && cbox6.checked && cbox5.checked && cbox4.checked && cbox3.checked && cbox2.checked && cbox1.checked) {
		btnAceptar.disabled = false;
	}else{
		btnAceptar.disabled = true;
	}
}