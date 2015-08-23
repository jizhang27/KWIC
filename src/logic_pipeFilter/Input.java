package logic_pipeFilter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * This is the pump
 * 
 * @author Matthew A. Johnston
 *
 */
public class Input extends Filter {
	
	private BufferedReader reader;
	
	public Input() {
		reader = new BufferedReader(new InputStreamReader(System.in));
	}
	
	public void run() {	
		try {
			String read;
			while(true) {
				read = reader.readLine();
				if(read == null) {
					write(null);
					break;
				}
				write(read + "\n");
			}
		} catch (IOException e) {
			System.err.println("IOException caught in Filter::StandardIn");
		}
	}

}
