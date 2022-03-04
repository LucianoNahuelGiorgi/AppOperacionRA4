function cargaProcApagado() {
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

	let btnAceptar = document.getElementById("btnAceptar");
	btnAceptar.disabled = true;
}

function checkProcApagado() {
	//console.log("OnClick");
	let cbox1 = document.getElementById("cbox1");
	let cbox2 = document.getElementById("cbox2");
	let cbox3 = document.getElementById("cbox3");
	let cbox4 = document.getElementById("cbox4");
	let cbox5 = document.getElementById("cbox5");
	let cbox6 = document.getElementById("cbox6");
	let cbox7 = document.getElementById("cbox7");
	let cbox8 = document.getElementById("cbox8");

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
		btnAceptar.disabled = false;
	} else {
		btnAceptar.disabled = true;
	}
}