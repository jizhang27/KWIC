package logic_pipeFilter;

import java.util.concurrent.ConcurrentSkipListSet;

/**
 * class Alphabetizer: filter connected with a pipe to the output stream of
 * CircularShifter filter. Thus, circular shifts produced by CircularShifter
 * serve as input for Alphabetizer. Alphabetizer sorts these shifts
 * alphabetically and writes them to its output stream.
 * 
 * @author Zhang Ji
 * 
 */
public class Alphabetizer extends Filter {

	private ConcurrentSkipListSet<String> buffer;

	public Alphabetizer() {
		buffer = new ConcurrentSkipListSet<String>(
				String.CASE_INSENSITIVE_ORDER);
	}

	public void run() {
		Debugger.print("START Alphabetizer FILTER");
		while(!isEmpty()) {
			String s = read();
			int firstSpacePos = s.indexOf(" ");
			String transform;
			if (firstSpacePos != -1) {
				transform = s.substring(0, firstSpacePos).toUpperCase()
						+ s.substring(firstSpacePos).toLowerCase();
			} else {
				transform = s;
			}

			buffer.add(transform);

		}
		
		while (!buffer.isEmpty()) {
			String c = buffer.pollFirst();
			Debugger.print(c);
			write(c);
			// write(buffer.pollFirst());
		}

		Debugger.print("END Alphabetizer FILTER");
	}

}
