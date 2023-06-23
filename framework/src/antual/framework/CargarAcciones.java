package antual.framework;

import java.util.HashMap;

public interface CargarAcciones {

	HashMap<Integer, Accion> cargar();

	int CantidadThreads();
}
