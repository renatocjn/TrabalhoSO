package processos;

import java.util.HashMap;
import java.util.Map;

public class Process implements Schedulable {

	private Map<String, Object> variables = new HashMap<String, Object>();

	private int icounter;

	private int sleepc;

	public Process(int pid) {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String genLogString() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean runStep() {
		// TODO Auto-generated method stub
		return true;
	}

	public void sleep() {
		// TODO
	}

	public void sleep(int t) {
		// TODO
	}
}
