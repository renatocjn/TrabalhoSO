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
		System.out.println("testeProcessors start");
		state = true;
		synchronized (this) {
			this.notify();
		}
		System.out.println("testeProcessors start fim");
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
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	public boolean chkState() {
		return state;
	}
}