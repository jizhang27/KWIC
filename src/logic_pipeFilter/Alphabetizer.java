package logic_pipeFilter;

import java.io.EOFException;
import java.util.concurrent.ConcurrentSkipListSet;


/**
 * 
 * @author Zhang Ji
 * 
 */
public class Alphabetizer extends Filter {
	
	private ConcurrentSkipListSet<String> buffer;
	
	public Alphabetizer() {
		buffer = new ConcurrentSkipListSet<String>(String.CASE_INSENSITIVE_ORDER);
	}
	

	public void run() {
					
				String s = read();
				buffer.add(s);
			
		
		
		while(!buffer.isEmpty()) {
			write(buffer.pollFirst());
		}
		
		write(null);
	}
	
}
