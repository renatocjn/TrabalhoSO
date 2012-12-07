package processos;

public class Processor extends Thread {
	Process currentProcess;

	public Processor() {
		try {
			this.start();
			this.wait();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public Process getCurrentProcess() {
		return currentProcess;
	}

	public void exec(Process p) {
		currentProcess = p;
		this.notify();
	}

	@Override
	public void run() {
		//TODO
		super.run();
	}
}