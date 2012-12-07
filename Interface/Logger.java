package Interface;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

public class Logger {

	private static String logFolderPath = "."; // temporario até modulo de
												// armazenamento

	public static void log(String tag, String message) {
		try {
			String filename = logFolderPath + "/" + tag + ".log";
			BufferedWriter output = new BufferedWriter(new FileWriter(filename,
					true));
			output.append(new Date().toString() + " # " + message);
			output.newLine();
			output.close();
		} catch (IOException ioe) {
			System.out.println(ioe);
		}
	}

	public static void logCommand(String tag, SysCommand cmd) {
		log(tag, cmd.genLogString());
	}
}
