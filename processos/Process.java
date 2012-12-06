package processos;

public abstract class Process {
	public int priority;
	long burstTime;
	
	public Process(int pri, long burst) {
		priority = pri;
		burstTime = burst;
	}
	
	public Process(long burst) {
		priority = 0;
		burstTime = burst;
	}
	
	public long getRemainingBurst() {
		return burstTime;
	}
	
	public abstract void exec();
}
