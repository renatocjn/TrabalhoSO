package processos;

public class Processor extends Thread {
	Process currentProcess = null;
	private boolean state;

	public Processor() {
		state = false;
		this.start();
	}

	public Process getCurrentProcess() {
		return currentProcess;
	}

	public void exec(Process p) {
		currentProcess = p;
		state = true;
		synchronized (this) {
			this.notify();
		}
	}

	@Override
	public void run() {
		while (true) {
			if (currentProcess != null) {
				currentProcess.exec();
				state = false;
				currentProcess = null;
			}
			synchronized (this) {
				try {
					wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public boolean chkState() {
		return state;
	}
}