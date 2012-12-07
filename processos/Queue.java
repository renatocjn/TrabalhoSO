package processos;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Queue {
	Map<Process, Long> processes = new HashMap<Process, Long>();
	ScheduleAlgorithm scheduler;

	public Process next() {
		return scheduler.getNext(this);
	}

	public long getArrivelTime(Process p) {
		// TODO
		return processes.get(p);
	}

	public Set<Process> getProcesses() {
		return processes.keySet();
	}

	public void addProcess(Process p) {
		long time = System.currentTimeMillis();
		processes.put(p, time);
	}
}
