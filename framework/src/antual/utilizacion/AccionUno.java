package antual.utilizacion;

import antual.framework.Accion;

public class AccionUno implements Accion {

	@Override
	public void ejecutar() {
		System.out.println("ejecutando accion 1");

	}

	@Override
	public String nombreItemMenu() {

		return "accion 1";
	}

	@Override
	public String descripcionItemMenu() {

		return "traer 10 personas de la base de datos";
	}

}
