package Interface;

import java.util.Scanner;

import processos.Schedulable;
import processos.Scheduler;
import processos.SysCommand;

public class CommandPrompt implements Schedulable {

	private String user;
	private String machine;
	private Enviroment enviroment = new Enviroment();
	private Scheduler scheduler;
	private Scanner input = new Scanner(System.in);

	public CommandPrompt(String usr, String mach, Scheduler sch) {
		user = usr;
		machine = mach;
		scheduler = sch;
		enviroment.addVariable("pwd", "/"); // temporario enquanto o modulo de
											// armazenamento não funciona
	}

	@Override
	public String genLogString() {
		return null;
	}

	public boolean promptLoop() {
		System.out.print(user + "@" + machine + ":" + enviroment.getvar("pwd")
				+ "$");
		String cmdStr = input.next();
		SysCommand cmd = CommandParser.parse(cmdStr);
		if (cmd == null) {
			Logger.log("prompt", "cnf: " + cmdStr);
			System.out.println("   cnf: " + cmdStr);
		} else {
			scheduler.addSchedulable(cmd);
			Logger.logCommand("prompt", cmd);
		}
		return false;
	}

	@Override
	public boolean runStep() {
		return promptLoop();

	}
}