package processos.algoritmos;

import processos.Process;
import processos.Queue;
import processos.ScheduleAlgorithm;

public class FCFS implements ScheduleAlgorithm {

	@Override
	public Process getNext(Queue q) {
		long time = Long.MAX_VALUE;
		Process aux = null;

		for (Process p : q.getProcesses()) {
			if (q.getArrivelTime(p) < time) // pega o processo com o menor tempo de chegada!!!
			{
				time = q.getArrivelTime(p);
				aux = p;
			}
		}

		return aux;
	}

}
