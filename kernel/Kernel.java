package kernel;

import processos.Schedulable;
import processos.Scheduler;
import Interface.CommandPrompt;

public class Kernel {
	public static void main(String[] args) {
		Scheduler sch = new Scheduler();
		CommandPrompt prt = new CommandPrompt(args[0], args[1], sch);
		sch.addSchedulable(prt);
		while(true)
		{
			Schedulable next = sch.decideNext();
			next.runNext();
		}
	}

}
