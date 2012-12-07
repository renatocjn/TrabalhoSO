package processos;

public class Processor extends Thread {
	Process currentProcess = null;

	public Processor() {
		//this.start();
		//this.interrupt();
	}

	public Process getCurrentProcess() {
		return currentProcess;
	}

	public void exec(Process p) {
		currentProcess = p;
		System.out.println("testeProcessors start");
		this.start();
		System.out.println("testeProcessors start fim");
	}

	@Override
	public void run() {
//		while(true){
//			if(currentProcess != null) {
//				currentProcess.exec();
//			}
//			this.interrupt();
//		}
		System.out.println("testeProcessors run");
		currentProcess.exec();
		System.out.println("testeProcessors run fim");
	}
}