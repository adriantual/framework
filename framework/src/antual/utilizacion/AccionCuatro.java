package antual.utilizacion;

import antual.framework.Accion;

public class AccionCuatro implements Accion {

	@Override
	public void ejecutar() {
		System.out.println("ejecutando accion 4");

	}

	@Override
	public String nombreItemMenu() {

		return "accion 4";
	}

	@Override
	public String descripcionItemMenu() {

		return "reporte del clima";
	}

}