package processos;

import java.util.LinkedList;
import java.util.List;

public class MultiLevelQueue extends Thread {
	List<Queue> queues = new LinkedList<Queue>();
	QueueManager manager;
	public static final long SLEEP_DURATION = 10000;
	
	public MultiLevelQueue(QueueManager qm) {
		manager = qm;
	}
	
	public void addQueue(Queue q) {
		queues.add(q);
	}
	
	public Queue getQueue(int index) {
		return queues.get(index);
	}
	
	public void managerLoop() {
		this.start();
	}
	
	@Override
	public void run() {
		while(manager != null) {
			try {
				Thread.sleep(SLEEP_DURATION);
				for(Queue q : queues) {
					manager.updateQueue(q);
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void stopLoop() {
		manager = null;
	}
}
