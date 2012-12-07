package processos;

import java.util.LinkedList;
import java.util.List;

public class ProcessorCollection {
	List<Processor> processors = new LinkedList<Processor>();

	public ProcessorCollection(int n) {
		for (int i = 0; i < n; i++) {
			processors.add(new Processor());
		}
	}

	public Processor getProcessor(int index) {
		return processors.get(index);
	}
}
