package processos;

import java.util.HashMap;
import java.util.Map;

public class Configuration {
	Map<String, Object> conf = new HashMap<String, Object>();
	
	public Object getConf(String key) {
		return conf.get(key);
	}
	
	public void setConf(String key, Object val) {
		conf.put(key, val);
	}
}
