package processos;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.List;

public class Dispatcher extends Thread {
	Map<Processor, List<Queue>> pairs = new HashMap<Processor, List<Queue>>();
	Map<Processor, Integer> counters = new HashMap<Processor, Integer>();
	static final long SLEEPTIME = 500; 
	public void addPair(Processor p, Queue q) {
		if (!pairs.containsKey(p)) {
			pairs.put(p, new LinkedList<Queue>());
			counters.put(p, 0);
		}
		List<Queue> set = pairs.get(p);
		set.add(q);
	}

	void chkLoop() {
		this.start();
	}

	@Override
	public void run() {
		while (true) {
			for (Processor proc : pairs.keySet()) {
				try {
					this.sleep(SLEEPTIME);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("Dispatcher inicio");
				if (!proc.chkState()) {
					System.out.println("Dispatcher exec");
					List<Queue> queues = pairs.get(proc);
					Integer counter = counters.get(proc);
					Queue q = queues.get(counter);
					counters.put(proc, (counter + 1) % queues.size());
					Process p = q.next();
					proc.exec(p);
					System.out.println("Dispatcher exec fim");
				}
				System.out.println("Dispatcher FIM");
			}
		}
	}
}
