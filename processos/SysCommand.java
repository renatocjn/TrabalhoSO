package processos;

public abstract class SysCommand implements Schedulable {

	protected String[] parameters;

	protected String desc;

	public SysCommand(String[] param, String description) {
		parameters = param;
		desc = description;
	}

	@Override
	public abstract String genLogString();

	@Override
	public abstract boolean runStep();
}
