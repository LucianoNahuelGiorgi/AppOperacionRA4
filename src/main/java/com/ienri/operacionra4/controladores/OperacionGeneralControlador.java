package com.ienri.operacionra4.controladores;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.ienri.operacionra4.avisos.ErrorAviso;
import com.ienri.operacionra4.entidades.Operacion;
import com.ienri.operacionra4.servicios.OperacionGeneralServicio;
import com.ienri.operacionra4.servicios.OperacionServicio;
import com.ienri.operacionra4.servicios.ProcedimientoApagadoServicio;
import com.ienri.operacionra4.servicios.ProcedimientoEncendidoServicio;
import com.ienri.operacionra4.servicios.PruebaFuncionServicio;
import com.ienri.operacionra4.servicios.UsuarioServicio;
import com.ienri.operacionra4.serviciosauxiliares.UsuarioAuxiliar;

@Controller
@RequestMapping("/operacion-general")
public class OperacionGeneralControlador {

	@Autowired
	UsuarioServicio usuarioServicio;

	@Autowired
	OperacionGeneralServicio operacionGeneralServicio;

	@Autowired
	ProcedimientoEncendidoServicio procedimientoEncendidoServicio;

	@Autowired
	ProcedimientoApagadoServicio procedimientoApagadoServicio;

	@Autowired
	PruebaFuncionServicio pruebaFuncionServicio;

	@Autowired
	OperacionServicio operacionServicio;

	@Autowired
	UsuarioAuxiliar usuarioAuxiliar;

	@PreAuthorize("hasAnyRole('ROLE_ACTIVO')")
	@GetMapping("/general")
	public ModelAndView general() {
		if (usuarioAuxiliar.getLogeado() == true) {
			if (usuarioAuxiliar.getUsuario() != null && usuarioAuxiliar.getUsuario().getRol().equals("administrador")) {
				ModelAndView mav = new ModelAndView("operacion-general");

				mav.addObject("logeado", true);
				mav.addObject("login", false);
				mav.addObject("nombre", usuarioAuxiliar.getUsuario().getNombre());
				mav.addObject("apellido", usuarioAuxiliar.getUsuario().getApellido());
				mav.addObject("admin", true);

				return mav;
			} else {
				ModelAndView mav = new ModelAndView("operacion-general");

				mav.addObject("logeado", true);
				mav.addObject("login", false);
				mav.addObject("nombre", usuarioAuxiliar.getUsuario().getNombre());
				mav.addObject("apellido", usuarioAuxiliar.getUsuario().getApellido());
				mav.addObject("admin", false);

				return mav;
			}
		} else {
			ModelAndView mav = new ModelAndView("operacion-general");

			mav.addObject("logeado", false);

			return mav;
		}
	}

	@PreAuthorize("hasAnyRole('ROLE_ACTIVO')")
	@GetMapping("/nueva")
	public ModelAndView nuevaOperacionGeneral() {
		if (usuarioAuxiliar.getLogeado() == true) {
			if (usuarioAuxiliar.getUsuario() != null && usuarioAuxiliar.getUsuario().getRol().equals("administrador")) {
				ModelAndView mav = new ModelAndView("nueva-operacion-general");

				operacionGeneralServicio.inicioNuevaOperacionGeneral();

				mav.addObject("logeado", true);
				mav.addObject("login", false);
				mav.addObject("nombre", usuarioAuxiliar.getUsuario().getNombre());
				mav.addObject("apellido", usuarioAuxiliar.getUsuario().getApellido());
				mav.addObject("admin", true);

				return mav;
			} else {
				ModelAndView mav = new ModelAndView("nueva-operacion-general");

				operacionGeneralServicio.inicioNuevaOperacionGeneral();

				mav.addObject("logeado", true);
				mav.addObject("login", false);
				mav.addObject("nombre", usuarioAuxiliar.getUsuario().getNombre());
				mav.addObject("apellido", usuarioAuxiliar.getUsuario().getApellido());
				mav.addObject("admin", false);

				return mav;
			}
		} else {
			ModelAndView mav = new ModelAndView("nueva-operacion-general");

			mav.addObject("logeado", false);

			return mav;
		}
	}

	@PreAuthorize("hasAnyRole('ROLE_ACTIVO')")
	@GetMapping("/busca")
	public ModelAndView buescaOperacionGeneral() {
		ModelAndView mav = new ModelAndView("busca-operacion-general");

		return mav;
	}

	@PreAuthorize("hasAnyRole('ROLE_ACTIVO')")
	@GetMapping("/encendido")
	public ModelAndView encendido() {
		if (usuarioAuxiliar.getLogeado() == true) {
			if (usuarioAuxiliar.getUsuario() != null && usuarioAuxiliar.getUsuario().getRol().equals("administrador")) {
				ModelAndView mav = new ModelAndView("procedimiento-encendido");
				Integer num = operacionGeneralServicio.ultimaOperacionGeneral();
				Date fechaHoraInicio = operacionGeneralServicio.fechaInicioOpGeneral();

				mav.addObject("logeado", true);
				mav.addObject("login", false);
				mav.addObject("nombre", usuarioAuxiliar.getUsuario().getNombre());
				mav.addObject("apellido", usuarioAuxiliar.getUsuario().getApellido());
				mav.addObject("admin", true);

				mav.addObject("num", num);
				mav.addObject("fechaHoraInicio", fechaHoraInicio);

				return mav;
			} else {
				ModelAndView mav = new ModelAndView("procedimiento-encendido");
				Integer num = operacionGeneralServicio.ultimaOperacionGeneral();
				Date fechaHoraInicio = operacionGeneralServicio.fechaInicioOpGeneral();

				mav.addObject("logeado", true);
				mav.addObject("login", false);
				mav.addObject("nombre", usuarioAuxiliar.getUsuario().getNombre());
				mav.addObject("apellido", usuarioAuxiliar.getUsuario().getApellido());
				mav.addObject("admin", false);

				mav.addObject("num", num);
				mav.addObject("fechaHoraInicio", fechaHoraInicio);

				return mav;
			}
		} else {
			ModelAndView mav = new ModelAndView("nueva-operacion-general");

			mav.addObject("logeado", false);

			return mav;
		}
	}

	@PreAuthorize("hasAnyRole('ROLE_ACTIVO')")
	@GetMapping("/apagado")
	public ModelAndView apagado() {
		if (usuarioAuxiliar.getLogeado() == true) {
			if (usuarioAuxiliar.getUsuario() != null && usuarioAuxiliar.getUsuario().getRol().equals("administrador")) {
				ModelAndView mav = new ModelAndView("procedimiento-apagado");
				Integer num = operacionGeneralServicio.ultimaOperacionGeneral();

				mav.addObject("logeado", true);
				mav.addObject("login", false);
				mav.addObject("nombre", usuarioAuxiliar.getUsuario().getNombre());
				mav.addObject("apellido", usuarioAuxiliar.getUsuario().getApellido());
				mav.addObject("admin", true);

				mav.addObject("num", num);

				return mav;
			} else {
				ModelAndView mav = new ModelAndView("procedimiento-apagado");
				Integer num = operacionGeneralServicio.ultimaOperacionGeneral();

				mav.addObject("logeado", true);
				mav.addObject("login", false);
				mav.addObject("nombre", usuarioAuxiliar.getUsuario().getNombre());
				mav.addObject("apellido", usuarioAuxiliar.getUsuario().getApellido());
				mav.addObject("admin", false);

				mav.addObject("num", num);

				return mav;
			}
		} else {
			ModelAndView mav = new ModelAndView("nueva-operacion-general");

			mav.addObject("logeado", false);

			return mav;
		}
	}

	@PreAuthorize("hasAnyRole('ROLE_ACTIVO')")
	@GetMapping("/prueba-funcion")
	public ModelAndView pruebaFuncion() {
		if (usuarioAuxiliar.getLogeado() == true) {
			if (usuarioAuxiliar.getUsuario() != null && usuarioAuxiliar.getUsuario().getRol().equals("administrador")) {
				ModelAndView mav = new ModelAndView("prueba-funcion");
				Integer num = operacionGeneralServicio.ultimaOperacionGeneral();

				mav.addObject("logeado", true);
				mav.addObject("login", false);
				mav.addObject("nombre", usuarioAuxiliar.getUsuario().getNombre());
				mav.addObject("apellido", usuarioAuxiliar.getUsuario().getApellido());
				mav.addObject("admin", true);

				mav.addObject("num", num);

				return mav;
			} else {
				ModelAndView mav = new ModelAndView("prueba-funcion");
				Integer num = operacionGeneralServicio.ultimaOperacionGeneral();

				mav.addObject("logeado", true);
				mav.addObject("login", false);
				mav.addObject("nombre", usuarioAuxiliar.getUsuario().getNombre());
				mav.addObject("apellido", usuarioAuxiliar.getUsuario().getApellido());
				mav.addObject("admin", false);

				mav.addObject("num", num);

				return mav;
			}
		} else {
			ModelAndView mav = new ModelAndView("nueva-operacion-general");

			mav.addObject("logeado", false);

			return mav;
		}
	}

	@PreAuthorize("hasAnyRole('ROLE_ACTIVO')")
	@GetMapping("/operacion")
	public ModelAndView operacion() throws ErrorAviso {
		if (usuarioAuxiliar.getLogeado() == true) {
			if (usuarioAuxiliar.getUsuario() != null && usuarioAuxiliar.getUsuario().getRol().equals("administrador")) {
				ModelAndView mav = new ModelAndView("operacion");
				Integer num = operacionGeneralServicio.ultimaOperacionGeneral();

				List<String> jrLista = usuarioServicio.buscarNombreJefeReactorActivo();
				List<String> opLista = usuarioServicio.buscarNombreOperadorActivo();
				List<String> ofLista = usuarioServicio.buscarNombreOficialRPActivo();
				List<Operacion> o = operacionServicio.operacionFechaDesc();

				mav.addObject("logeado", true);
				mav.addObject("login", false);
				mav.addObject("nombre", usuarioAuxiliar.getUsuario().getNombre());
				mav.addObject("apellido", usuarioAuxiliar.getUsuario().getApellido());
				mav.addObject("admin", true);

				mav.addObject("num", num);

				mav.addObject("jrLista", jrLista);
				mav.addObject("opLista", opLista);
				mav.addObject("ofLista", ofLista);
				mav.addObject("num", num);

				mav.addObject("o", o);

				return mav;
			} else {
				ModelAndView mav = new ModelAndView("operacion");
				Integer num = operacionGeneralServicio.ultimaOperacionGeneral();

				List<String> jrLista = usuarioServicio.buscarNombreJefeReactorActivo();
				List<String> opLista = usuarioServicio.buscarNombreOperadorActivo();
				List<String> ofLista = usuarioServicio.buscarNombreOficialRPActivo();
				List<Operacion> o = operacionServicio.operacionFechaDesc();

				mav.addObject("logeado", true);
				mav.addObject("login", false);
				mav.addObject("nombre", usuarioAuxiliar.getUsuario().getNombre());
				mav.addObject("apellido", usuarioAuxiliar.getUsuario().getApellido());
				mav.addObject("admin", true);

				mav.addObject("num", num);

				mav.addObject("jrLista", jrLista);
				mav.addObject("opLista", opLista);
				mav.addObject("ofLista", ofLista);
				mav.addObject("num", num);

				mav.addObject("o", o);

				return mav;
			}
		} else {
			ModelAndView mav = new ModelAndView("nueva-operacion-general");

			mav.addObject("logeado", false);

			return mav;
		}
	}

	@PreAuthorize("hasAnyRole('ROLE_ACTIVO')")
	@PostMapping("/procedimiento-encendido")
	public RedirectView checkListEncendido(Boolean realizado, String observaciones) {
		procedimientoEncendidoServicio.guardar(realizado, observaciones);

		return new RedirectView("/operacion-general/prueba-funcion");
	}

	@PreAuthorize("hasAnyRole('ROLE_ACTIVO')")
	@PostMapping("/procedimiento-apagado")
	public RedirectView checkListApagado(Boolean realizado, String observaciones) {
		procedimientoApagadoServicio.guardar(realizado, observaciones);

		return new RedirectView("/operacion-general/general");
	}

	@PreAuthorize("hasAnyRole('ROLE_ACTIVO')")
	@PostMapping("/prueba-funcion")
	public RedirectView valoresPruebaFuncion(Integer indicacion_01, Integer indicacion_02, Integer indicacion_03, Double indicacion_04,
			Integer indicacion_05, String indicacion_06, String indicacion_07, Integer indicacion_08,
			String indicacion_09, String indicacion_10, String indicacion_11, String indicacion_12,
			String indicacion_13, Integer indicacion_14, String indicacion_15, Integer indicacion_16,
			String indicacion_17, Integer indicacion_18, String indicacion_19, Integer indicacion_20,
			String indicacion_21, Integer indicacion_22, String indicacion_23, Double indicacion_24,
			String indicacion_25, Double indicacion_26, Boolean indicacion_27, Boolean indicacion_28,
			Integer indicacion_29, Integer indicacion_30, String observaciones) {

		/* Conversion notación científica a Double CANAL DE ARRANQUE */
		String sIndicacion_06 = String.valueOf(new BigDecimal(indicacion_06));
		Double dIndicacion_06 = Double.parseDouble(sIndicacion_06);
//		System.out.println("Integrador log TC Uno: " + sIndicacion_06);
//		System.out.println(dIndicacion_06);
		String sIndicacion_07 = String.valueOf(new BigDecimal(indicacion_07));
		Double dIndicacion_07 = Double.parseDouble(sIndicacion_07);
//		System.out.println("Integrador lineal TC Uno: " + sIndicacion_07);
//		System.out.println(dIndicacion_07);
		String sIndicacion_09 = String.valueOf(new BigDecimal(indicacion_09));
		Double dIndicacion_09 = Double.parseDouble(sIndicacion_09);
//		System.out.println("Integrador log TC Dos: " + sIndicacion_09);
//		System.out.println(dIndicacion_09);
		String sIndicacion_10 = String.valueOf(new BigDecimal(indicacion_10));
		Double dIndicacion_10 = Double.parseDouble(sIndicacion_10);
//		System.out.println("Integrador lineal TC Uno: " + sIndicacion_10);
//		System.out.println(dIndicacion_10);
		
		/* INTEGRADOR LOGARÍTMICO DE ARRANQUE */
		String sIndicacion_11 = String.valueOf(new BigDecimal(indicacion_11));
		Double dIndicacion_11 = Double.parseDouble(sIndicacion_11);
		String sIndicacion_12 = String.valueOf(new BigDecimal(indicacion_12));
		Double dIndicacion_12 = Double.parseDouble(sIndicacion_12);

		/* CANAL DE POTENCIA */
		String sIndicacion_13 = String.valueOf(new BigDecimal(indicacion_13));
		Double dIndicacion_13 = Double.parseDouble(sIndicacion_13);
		String sIndicacion_15 = String.valueOf(new BigDecimal(indicacion_15));
		Double dIndicacion_15 = Double.parseDouble(sIndicacion_15);
		String sIndicacion_17 = String.valueOf(new BigDecimal(indicacion_17));
		Double dIndicacion_17 = Double.parseDouble(sIndicacion_17);
		String sIndicacion_19 = String.valueOf(new BigDecimal(indicacion_19));
		Double dIndicacion_19 = Double.parseDouble(sIndicacion_19);
		String sIndicacion_21 = String.valueOf(new BigDecimal(indicacion_21));
		Double dIndicacion_21 = Double.parseDouble(sIndicacion_21);

		/* AMPLIFICADOR LINEAL */
		String sIndicacion_23 = String.valueOf(new BigDecimal(indicacion_23));
		Double dIndicacion_23 = Double.parseDouble(sIndicacion_23);
		String sIndicacion_25 = String.valueOf(new BigDecimal(indicacion_25));
		Double dIndicacion_25 = Double.parseDouble(sIndicacion_25);

		pruebaFuncionServicio.guardar(indicacion_01, indicacion_02, indicacion_03, indicacion_04, indicacion_05,
				dIndicacion_06, dIndicacion_07, indicacion_08, dIndicacion_09, dIndicacion_10, dIndicacion_11, dIndicacion_12,
				dIndicacion_13, indicacion_14, dIndicacion_15, indicacion_16, dIndicacion_17, indicacion_18, dIndicacion_19,
				indicacion_20, dIndicacion_21, indicacion_22, dIndicacion_23, indicacion_24, dIndicacion_25, indicacion_26,
				indicacion_27, indicacion_28, indicacion_29, indicacion_30, observaciones);

		return new RedirectView("/operacion-general/operacion");
	}

	@PreAuthorize("hasAnyRole('ROLE_ACTIVO')")
	@PostMapping("/operacion")
	public RedirectView valoresOperacion(String jefeReactor, String operador, String oficialRP,
			String canalCentralHorizontal, String canalLateralSupHorizontal, String canalLateralInfHorizontal,
			String canalCentralVertical, String canalLateralVertical, String motivo, String scram, Boolean muestra,
			Boolean cbox1, Boolean cbox2, Boolean cbox3, Boolean cbox4, Double tempNucleo, Boolean fuenteAdentro,
			Double posNucleo, Double posBC1, Double posBC2, Integer escalimetro, Double intLogCA, String intLinCA,
			Double intLinCP, Double intLogCP, Double gammaConsola, Double gammaReactor, Double potencia, String regimen,
			String observaciones) {

		String sintLinCA = String.valueOf(new BigDecimal(intLinCA));
		System.out.println("numeroReal = " + sintLinCA);

		Double numeroReal = Double.parseDouble(sintLinCA);
		System.out.println(numeroReal);
//        DecimalFormat df = new DecimalFormat("0000.0");
//        System.out.println("numeroReal=" + df.format(numeroReal));

		operacionServicio.guardar(jefeReactor, operador, oficialRP, canalCentralHorizontal, canalLateralSupHorizontal,
				canalLateralInfHorizontal, canalCentralVertical, canalLateralVertical, motivo, scram, muestra, cbox1,
				cbox2, cbox3, cbox4, tempNucleo, fuenteAdentro, posNucleo, posBC1, posBC2, escalimetro, intLogCA,
				numeroReal, intLinCP, intLogCP, gammaConsola, gammaReactor, potencia, regimen, observaciones);

		return new RedirectView("/operacion-general/operacion");
	}
}