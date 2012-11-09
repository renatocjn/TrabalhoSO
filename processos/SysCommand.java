package processos;
public abstract class SysCommand implements Schedulable {

	private String[] parameters;

	private String desc;
 
	public SysCommand(String[] param, String description)
	{
		parameters = param;
		desc = description; 
	}
	
	public abstract void runNext();

	public abstract String genLogString();
}
