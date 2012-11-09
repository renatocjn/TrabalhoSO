package Interface;

import processos.SysCommand;

public class CommandParser {

	public static final String[] CMDS = {"ls", "cd", "cat", "mkdir", "rm", "write", "exec", "exit"};
	public SysCommand parse(String cmd) {
		String[] splited = cmd.split(" ");
		for( String str : CMDS )
		{
			if(str.equals(splited[0]))
			{
				return new processos.sys_cmds.uninplementedCmd(splited, splited[0]);
			}
		}
		return null;
	}

}
