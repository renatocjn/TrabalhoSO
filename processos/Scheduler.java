package processos;

import java.security.InvalidParameterException;
import java.util.LinkedList;
import java.util.List;

import processos.Configuration.QueueDescription;

public class Scheduler { // TODO
	Dispatcher dispatcher = new Dispatcher();
	ProcessorCollection processors;
	List<MultiLevelQueue> multilevels = new LinkedList<MultiLevelQueue>();

	public Scheduler(Configuration c) {
		if (!Configuration.chkConfig(c))
			throw new InvalidParameterException("Configuration Invalid");

		int nprocessors = (Integer) c.getConf(Configuration.NPROCESSORS);
		processors = new ProcessorCollection(nprocessors);
		int nmultqueues = (Integer) c.getConf(Configuration.NMULTLVLQUEUES);
		for (int i = 0; i < nmultqueues; i++) {
			multilevels.add(new MultiLevelQueue(null)); // TODO adicionar
														// manager 'aging'
		}
		@SuppressWarnings("unchecked")
		List<QueueDescription> qd = (List<QueueDescription>) c
				.getConf(Configuration.QUEUES);

		for (QueueDescription desc : qd) {
			int mlq = desc.mqid;
			int pid = desc.pid;

			@SuppressWarnings("unused")
			String alg = desc.algorithm;
			ScheduleAlgorithm aux = null;
			Queue q = new Queue(aux); // TODO ajeitar isso depois de
										// implementar dos algoritmos
			multilevels.get(mlq - 1).addQueue(q);
			dispatcher.addPair(processors.getProcessor(pid - 1), q);
		}
	}

	public void loadProcess(Process p, int mlq, int queue) {
		multilevels.get(mlq).getQueue(queue).addProcess(p);
	}
}
