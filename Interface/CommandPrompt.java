package Interface;
import processos.Schedulable;
import processos.SysCommand;
import processos.Process;
import processos.Scheduler;
import java.util.Scanner;

public class CommandPrompt implements Schedulable{ 
	private String user;
	private String machine;
	private Enviroment enviroment = new Enviroment();
	private Scheduler scheduler;
	private Scanner input = new Scanner(System.in);
	private Logger log = new Logger(System.getenv("PWD")); //Temporary
	public CommandPrompt(String usr, String mach, Scheduler sch)
	{
		user = usr;
		machine = mach;
		scheduler = sch;
		enviroment.addVariable("pwd", "/");
	}

	public String ReadInput() {
		return input.next();
	}

	public SysCommand parsecmd(String cmd) {
		return null;
	}

	public void promptLoop() 
	{
		System.out.print(user+"@"+machine+":"+enviroment.getvar("pwd")+"$");
		String cmdStr = ReadInput();
		SysCommand cmd = parsecmd(cmdStr);
		if (cmd == null)
		{
			log.log("Prompt", "cnf: "+cmdStr);
		}
		else
		{
			scheduler.addSchedulable(cmd);
			log.logCommand("Prompt", cmd);
		}
	}

	public Process genNewProcess(SysCommand cmd) {
		return null;
	}

	@Override
	public void runNext() {
		promptLoop();
		
	}

	@Override
	public String genLogString() {
		return null;
	}

}
