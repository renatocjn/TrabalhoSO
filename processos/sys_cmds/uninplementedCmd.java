package processos.sys_cmds;

import processos.SysCommand;

public class uninplementedCmd extends SysCommand {

	public uninplementedCmd(String[] param, String description) {
		super(param, description);
	}

	@Override
	public void runNext() {
		System.out.println("processos nao foram implementados!");
	}

	@Override
	public String genLogString() {
		return this.getClass().toString();
	}

}
