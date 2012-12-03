package processos;

import java.util.HashMap;
import java.util.Map;

public class Statistics {
	Map<String, Object> stats = new HashMap<String, Object>();
	
	public Object getConf(String key) {
		return stats.get(key);
	}
	
	public void setConf(String key, Object val) {
		stats.put(key, val);
	}
}
