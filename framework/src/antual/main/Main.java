package antual.main;

import antual.framework.Framework;

public class Main {
	private static final String json = "C:\\Users\\User\\developers workspace\\framework\\resources\\accions.json";

	private static final String properties = "/accions.propierties";

	public static void main(String[] args) {

		Framework m = new Framework(json);
		// Framework f = new Framework(properties);
		m.init();
		// f.init();

	}

}
