package processos;

import java.security.InvalidParameterException;
import java.util.LinkedList;
import java.util.List;
import processos.algoritmos.*;
import processos.Configuration.QueueDescription;

public class Scheduler {
	Dispatcher dispatcher = new Dispatcher();
	ProcessorCollection processors;
	List<MultiLevelQueue> multilevels = new LinkedList<MultiLevelQueue>();

	public Scheduler(Configuration c) {
//		if (!Configuration.chkConfig(c))
//			throw new InvalidParameterException("Configuration Invalid");

		int nprocessors = (Integer) c.getConf(Configuration.NPROCESSORS);
		processors = new ProcessorCollection(nprocessors);
		int nmultqueues = (Integer) c.getConf(Configuration.NMULTLVLQUEUES);
		for (int i = 0; i < nmultqueues; i++) {
			MultiLevelQueue mlq = new MultiLevelQueue(new Aging());
			mlq.managerLoop();
			multilevels.add(mlq);
			
		}
		@SuppressWarnings("unchecked")
		List<QueueDescription> qd = (List<QueueDescription>) c
				.getConf(Configuration.QUEUES);

		for (QueueDescription desc : qd) {
			int mlq = desc.mqid;
			int pid = desc.pid;

			String alg = desc.algorithm.trim();
			ScheduleAlgorithm aux = null;
			if (alg.toUpperCase().equals("FCFS"))
				aux = new FCFS();
			else if (alg.toUpperCase().equals("PRIORITY"))
				aux = new Priority();
			else if (alg.toUpperCase().equals("SJF"))
				aux = new SJF();
			if (aux == null)
				throw new IllegalArgumentException("Configuracao invalida");

			Queue q = new Queue(aux);
			multilevels.get(mlq - 1).addQueue(q);
			dispatcher.addPair(processors.getProcessor(pid - 1), q);
		}
		dispatcher.chkLoop();
	}

	public void loadProcess(Process p, int mlq, int queue) {
		multilevels.get(mlq).getQueue(queue).addProcess(p);
	}
}
