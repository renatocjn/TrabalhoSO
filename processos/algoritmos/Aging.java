package processos.algoritmos;

import processos.Queue;
import processos.QueueManager;
import processos.Process;

public class Aging implements QueueManager {

	@Override
	public void updateQueue(Queue q) {
		long t = System.currentTimeMillis();
		for (Process p : q.getProcesses()) {
			long arr = q.getArrivelTime(p);
			p.priority -= 0.05 * (t - arr);
		}
	}
}
