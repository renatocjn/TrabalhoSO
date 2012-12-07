package processos.algoritmos;

import processos.Process;
import processos.Queue;
import processos.ScheduleAlgorithm;

public class Priority implements ScheduleAlgorithm{

	@Override
	public Process getNext(Queue q) {
		int priority = Integer.MAX_VALUE;
		Process aux = null;
		
		for(Process p : q.getProcesses())
		{
			if(p.priority < priority)
			{
				priority = p.priority;
				aux = p;
			}
		}
		
		return aux;
	}
}
