package processos.sys_cmds;

import processos.SysCommand;

public class uninplementedCmd extends SysCommand {

	public uninplementedCmd(String[] param, String description) {
		super(param, description);
	}

	@Override
	public String genLogString() {
		return this.getClass().toString();
	}

	@Override
	public boolean runStep() {
		System.out.println("comando " + parameters[0]
				+ " nao foi implementado ainda");
		return true;
	}
}
