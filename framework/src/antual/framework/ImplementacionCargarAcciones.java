package antual.framework;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Properties;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;
import com.google.gson.JsonSyntaxException;

public class ImplementacionCargarAcciones implements CargarAcciones {

	private String path;

	public ImplementacionCargarAcciones(String path) {

		this.path = path;
	}

	@Override
	public HashMap<Integer, Accion> cargar() {
		if (esJson()) {
			return cargarConFormatoJson();
		}
		return cargarConFormatoNormal();
	}

	private HashMap<Integer, Accion> cargarConFormatoNormal() {
		Properties prop = new Properties();
		HashMap<Integer, Accion> lista = new HashMap<>();

		try (InputStream configFile = getClass().getResourceAsStream(this.path);) {

			prop.load(configFile);

			String clase = prop.getProperty("accions");

			String[] clases = clase.split("; ");

			for (int i = 0; i < clases.length; i++) {

				Accion accionTemp = (Accion) Class.forName(clases[i]).getDeclaredConstructor().newInstance();

				lista.put((i + 1), accionTemp);
			}

			lista.put(clases.length + 1, new AccionSalida());

		} catch (Exception e) {
			// e.printStackTrace();
			throw new RuntimeException("Ocurrio un error con el archivo .config: " + e.getMessage());

		}

		return lista;
	}

	private HashMap<Integer, Accion> cargarConFormatoJson() {
		HashMap<Integer, Accion> lista = new HashMap<>();
		Gson gson = new GsonBuilder().create();
		int i = 0;

		try (BufferedReader reader = new BufferedReader(new FileReader(this.path))) {
			JsonObject jsonObject = gson.fromJson(reader, JsonObject.class);
			JsonArray jsonArray = jsonObject.getAsJsonArray("acciones");
			for (JsonElement jsonElement : jsonArray) {
				String clase = jsonElement.getAsString();
				Accion nuevaAccion = (Accion) Class.forName(clase).getDeclaredConstructor().newInstance();
				lista.put(i, nuevaAccion);
				i++;
			}
		} catch (IOException | JsonSyntaxException | JsonIOException | InstantiationException | IllegalAccessException
				| ClassNotFoundException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException
				| SecurityException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return lista;
	}

	private boolean esJson() {
		if (this.path.endsWith(".json")) {
			return true;
		}
		return false;
	}

	@Override
	public int CantidadThreads() {
		int threads = 1;
		if (esJson()) {
			Gson gson = new GsonBuilder().create();
			try (BufferedReader reader = new BufferedReader(new FileReader(this.path))) {
				JsonObject jsonObject = gson.fromJson(reader, JsonObject.class);
				threads = jsonObject.get("max-threads").getAsInt();
			} catch (IOException | JsonSyntaxException | JsonIOException | IllegalArgumentException
					| SecurityException e) {
				System.out.println(e.getMessage());
				e.printStackTrace();
			}
		}
		return threads;
	}

}
