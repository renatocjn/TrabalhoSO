package processos.algoritmos;

import processos.Process;
import processos.Queue;
import processos.ScheduleAlgorithm;

public class SJF implements ScheduleAlgorithm{

	@Override
	public Process getNext(Queue q) {
		long time = Long.MAX_VALUE;
		Process aux = null;
		
		for(Process p : q.getProcesses())
		{
			if(p.getRemainingBurst() < time)
			{
				time = p.getRemainingBurst();
				aux = p;
			}
		}
		
		return aux;
	}

}
