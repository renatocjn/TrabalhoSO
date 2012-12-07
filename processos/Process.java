package processos;

public class Process {
	public int priority;
	long burstTime;
	static int pid_counter=1;
	int pid;
	public Process(int pri, long burst) {
		priority = pri;
		burstTime = burst;
		pid = pid_counter++;
	}

	public Process(long burst) {
		priority = 0;
		burstTime = burst;
	}

	public long getRemainingBurst() {
		return burstTime;
	}

	public void exec() {
		try {
			System.out.println("Executando processo: "+pid);
			Thread.currentThread().sleep(burstTime);
			System.out.println("terminado: "+pid);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		this.burstTime = 0;
	}
}
