package antual.utilizacion;

import antual.framework.Accion;

public class AccionDos implements Accion {

	@Override
	public void ejecutar() {
		System.out.println("ejecutando accion 2");

	}

	@Override
	public String nombreItemMenu() {

		return "accion 2";
	}

	@Override
	public String descripcionItemMenu() {

		return "traer tws de maradona";
	}

}
