package processos;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Dispatcher extends Thread {
	Map<Processor, Set<Queue>> pairs = new HashMap<Processor, Set<Queue>>();

	public void addPair(Processor p, Queue q) {
		if (!pairs.containsKey(p)) {
			pairs.put(p, new HashSet<Queue>());
		}
		Set<Queue> set = pairs.get(p);
		set.add(q);
	}

	void chkLoop() {
		this.start();
	}

	@Override
	public void run() {
		while (true) {
			for (Processor p : pairs.keySet()) {
				if (p.isInterrupted()) {
					// TODO
				}
			}
		}
	}
}
