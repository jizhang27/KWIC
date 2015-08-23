package logic_pipeFilter;

import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * class IgnoredWordRemoval: remove those line starts with words in ignoredWorldList.
 * The result after removal are written to its output stream
 * @author Zhang Ji
 * 
 */
public class IgnoredWordRemoval extends Filter {

	
	private  ArrayList<String> noise;

	public IgnoredWordRemoval(String words) {
		noise = new ArrayList<String>();
		StringTokenizer st = new StringTokenizer(words);
		while (st.hasMoreTokens()) {
			noise.add(st.nextToken().toLowerCase());
		}
	}
	public void run() {
		Debugger.print("START IGNORED WORLD FILTER");
		while (!isEmpty()) {
				String s = read();
				String tokens[] = s.split("\\s");

				// Don't write it if it does contain the noise word
				if (!noise.contains(tokens[0].toLowerCase())) {
					write(s);
				}
				
			
		}
		Debugger.print("END IGNORED WORLD FILTER");
	}

}
