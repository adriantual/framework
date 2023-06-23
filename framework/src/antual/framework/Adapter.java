package antual.framework;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public class Adapter implements Callable<Adapter> {
	private Accion accion;

	public Adapter(Accion accion) {
		this.accion = accion;
	}

	public Adapter call() throws Exception {
		// TODO Auto-generated method stub
		this.accion.ejecutar();
		TimeUnit.MILLISECONDS.sleep(3000);
		return null;
	}
}
