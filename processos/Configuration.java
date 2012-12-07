package processos;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Configuration {
	public static class QueueDescription {
		public final int mqid, pid;
		public final String algorithm;
		
		public QueueDescription(int mqid, int pid, String algorithm) {
			super();
			this.mqid = mqid;
			this.pid = pid;
			this.algorithm = algorithm;
		}
		
		@Override
		public String toString() {
			return "mqid: "+mqid+", pid: "+pid+", algorithm: "+algorithm;
		}
	}
	
	Map<String, Object> conf = new HashMap<String, Object>();

	public Object getConf(String key) {
		return conf.get(key);
	}

	public void setConf(String key, Object val) {
		conf.put(key, val);
	}
	
	public static Configuration parseConfig(File fp) throws FileNotFoundException {
		Configuration configuration = new Configuration();
		Scanner input = new Scanner(fp);
		int processorNumber = input.nextInt();
		configuration.setConf("processorNumber", processorNumber);
		int multLevelQueueNumber = input.nextInt();
		configuration.setConf("multLevelQueueNumber", multLevelQueueNumber);
		int queueNumber = input.nextInt();
		List<Configuration.QueueDescription> descriptions = new LinkedList<Configuration.QueueDescription>();
		for(int i=0;i<queueNumber;i++)
		{
			int mqid = input.nextInt();
			int pid = input.nextInt();
			String alg = input.nextLine();
			descriptions.add(new QueueDescription(mqid, pid, alg));
		}
		configuration.setConf("queueDescriptions", descriptions);
		input.close();
		return null;
	}
	
	public static Configuration parseConfig(String pathname) throws FileNotFoundException {
		return parseConfig(new File(pathname));
	}
}
