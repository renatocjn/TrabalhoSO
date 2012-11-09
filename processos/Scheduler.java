package processos;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Scheduler {

	private Map<Long, Schedulable> SetofSchedulables = new HashMap<Long, Schedulable>();
	private long pcont = 1;

	public void addSchedulable(Schedulable newschd) {
		SetofSchedulables.put(new Long(pcont++), newschd);
	}

	public long decideNext() {
		Long[] v = new Long[SetofSchedulables.size()];
		SetofSchedulables.keySet().toArray(v);
		return v[new Random().nextInt(v.length)].longValue();
	}

	public Schedulable getSchedulable(long pid) {
		Long id = new Long(pid);
		return SetofSchedulables.get(id);
	}

	public boolean removeSchedulable(long pid) {
		Long id = new Long(pid);
		if (!SetofSchedulables.containsKey(id))
			return false;
		SetofSchedulables.remove(id);
		return true;
	}

}
