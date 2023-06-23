package antual.framework;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Framework {

	private CargarAcciones cargarAcciones;
	private Map<Integer, Accion> accions;
	private Lanterna lanterna;

	public Framework(String path) {
		this.accions = new HashMap<>();
		this.cargarAcciones = new ImplementacionCargarAcciones(path);
	}

	public final void init() {

		this.buscarAccions();

		this.mostrarMenu();
	}

	private void mostrarMenu() {

		this.lanterna = new Lanterna(new ArrayList<>(accions.values()), cargarAcciones.CantidadThreads());
		lanterna.mostrar();

	}

	private void buscarAccions() {

		this.accions = cargarAcciones.cargar();

	}

}