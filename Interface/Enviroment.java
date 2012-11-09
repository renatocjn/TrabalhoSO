package Interface;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Enviroment {
	private final String DELIM = ":";
	private String path = "";
	private Map<String, String> variables = new HashMap<String, String>();

	public void addToPath(String newloc) throws Exception {
		File tester = new File(newloc);
		if (tester.isDirectory()) {
			path = path + DELIM + newloc;
		} else {
			throw new Exception("parameter is not a directory");
		}
	}

	public boolean addVariable(String id, String val) {
		if (variables.containsKey(id)) {
			return false;
		}
		variables.put(id, val);
		return true;
	}

	public StringTokenizer getPaths() {
		return new StringTokenizer(path, DELIM);
	}

	public String getvar(String id) {
		return variables.get(id);
	}
}
