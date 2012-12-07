package Interface;

public class CommandParser {

	// lista de programas do sistema
	public static final String[] CMDS = { "ls", "cd", "cat", "mkdir", "rm",
			"write", "exec", "exit" };

	public static SysCommand parse(String cmd) {
		String[] splitted = cmd.split(" ");
		for (String str : CMDS) {
			if (str.equals(splitted[0])) {
				return new processos.sys_cmds.uninplementedCmd(splitted,
						splitted[0]);// temporario até a implementacao dos
										// processos
			}
		}
		return null;
	}

}
