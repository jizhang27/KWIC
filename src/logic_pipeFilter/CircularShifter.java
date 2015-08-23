package logic_pipeFilter;

/**
 * class CircularShifter: filter connected with a pipe to the output stream of Input filter. 
 * Thus, the lines produced by Input filter serve as input for CircularShifter filter. 
 * CircularShifter processes the input lines producing circular shifts of those lines. 
 * The produced shifts are written to the CircularShifter's output stream.
 * @author Zhang Ji
 * 
 */
public class CircularShifter extends Filter {

	public void run() {
		Debugger.print("START CIRCULAR SHIFTE FILTER");
		while (!isEmpty()) {
				String s = read();
				String tokens[] = s.split("\\s");
				
				for(int i = 0; i < tokens.length; i++) {
					StringBuilder sb = new StringBuilder();
					for(int j = 0; j < tokens.length; j++) {
						sb.append(tokens[j]);
						if(j != tokens.length -1) {
							sb.append(" ");
						}
					}
					shiftLeft(tokens);
					write(sb.toString());
					Debugger.print(sb.toString());
				}

			
		}
		Debugger.print("END CIRCULAR SHIFTER FILTER");
	}
	
	/**
	 * Shifts elements in a string array to the left
	 * @param array
	 */
	private void shiftLeft(String[] array) {
		String temp = array[0];
		int i;
		for (i = 0; i < array.length - 1; i++)
			array[i] = array[i + 1];
		array[i] = temp;
	}

}
