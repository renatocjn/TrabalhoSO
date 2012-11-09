package kernel;

import processos.Scheduler;
import Interface.CommandPrompt;

public class Kernel {
	public static void main(String[] args) {
		Scheduler sch = new Scheduler();
		CommandPrompt prt = new CommandPrompt(args[0], args[1], sch);
		sch.addSchedulable(prt);
		while (true) {
			long next = sch.decideNext();
			boolean done = sch.getSchedulable(next).runStep();
			if (done)
				sch.removeSchedulable(next);
		}
	}

}
