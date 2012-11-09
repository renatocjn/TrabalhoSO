package processos;

import java.util.HashMap;
import java.util.Map;

public class Process implements Schedulable {

	private Map<String,Object> variables = new HashMap<String, Object>();

	private int icounter;
	private int sleepc;
	
	public void sleep() {
		// TODO
	}

	public void sleep(int t) {
		// TODO
	}

	@Override
	public void runNext() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String genLogString() {
		// TODO Auto-generated method stub
		return null;
	}

}
