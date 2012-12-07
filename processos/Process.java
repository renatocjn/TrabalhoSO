package processos;

public class Process {
	public int priority;
	long burstTime;
	static int pid_counter = 1;
	int pid;

	public Process(int pri, long burst) {
		priority = pri;
		burstTime = burst;
		pid = pid_counter++;
	}

	public Process(long burst) {
		this(0, burst);
	}

	public long getRemainingBurst() {
		return burstTime;
	}

	public void exec() {
		try {
			System.out.println("Executando processo: " + pid);
			Thread.sleep(burstTime);
			System.out.println("terminado: " + pid);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		this.burstTime = 0;
	}
}
