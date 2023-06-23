package antual.utilizacion;

import antual.framework.Accion;

public class AccionCinco implements Accion {

	@Override
	public void ejecutar() {
		System.out.println("ejecutando accion 5");

	}

	@Override
	public String nombreItemMenu() {

		return "accion 5";
	}

	@Override
	public String descripcionItemMenu() {

		return "enviar mail";
	}

}