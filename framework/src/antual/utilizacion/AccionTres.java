package antual.utilizacion;

import antual.framework.Accion;

public class AccionTres implements Accion {

	@Override
	public void ejecutar() {
		System.out.println("ejecutando accion 3");

	}

	@Override
	public String nombreItemMenu() {

		return "accion 3";
	}

	@Override
	public String descripcionItemMenu() {

		return "suscribirse";
	}

}