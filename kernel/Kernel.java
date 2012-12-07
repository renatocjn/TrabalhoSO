package kernel;

import java.io.File;
import java.io.FileNotFoundException;

import processos.Configuration;
import processos.Process;
import processos.Scheduler;


public class Kernel {
	public static void main(String[] args) {
		File config_file = new File("teste.config");
		try {
			Configuration config = Configuration.parseConfig(config_file);
			Scheduler sch = new Scheduler(config);
			Process p1 = new Process(1);
			Process p2 = new Process(2);
			Process p3 = new Process(3);
			Process p4 = new Process(5);
			Process p5 = new Process(3);
			sch.loadProcess(p1, 0, 0);
			sch.loadProcess(p2, 0, 0);
			sch.loadProcess(p3, 0, 0);
			sch.loadProcess(p4, 0, 0);
			sch.loadProcess(p5, 0, 0);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
