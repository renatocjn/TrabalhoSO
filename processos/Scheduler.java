package processos;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Scheduler {

	private Set<Schedulable> SetofSchedulables = new HashSet<Schedulable>();

	public void addSchedulable(Schedulable newschd) {
		SetofSchedulables.add(newschd);
	}

	public Schedulable decideNext() {
		Schedulable[] v = (Schedulable[]) SetofSchedulables.toArray();
		return v[new Random().nextInt()%v.length];
	}

}
