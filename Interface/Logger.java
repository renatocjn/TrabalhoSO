package Interface;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

import processos.SysCommand;

public class Logger {

	private String logFolderPath;
	
	public Logger(String logFolder)
	{
		logFolderPath = logFolder;
	}
	
	public void log(String tag, String message) {
		File f = new File(logFolderPath+"/"+tag+".log");
		try {
			f.createNewFile();
			OutputStream os = new FileOutputStream(f);
			BufferedWriter output = new BufferedWriter(new OutputStreamWriter(os));
			
			output.append(message);
			output.close();
		} catch (IOException ioe) {
			System.out.println(ioe);
		}
	}

	public void logCommand(String tag, SysCommand cmd) {
		log(tag, cmd.genLogString());
	}
}
