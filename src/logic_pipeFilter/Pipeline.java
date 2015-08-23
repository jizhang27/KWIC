package logic_pipeFilter;

import java.util.ArrayList;

/**
 * class Pipeline: models the process of pipe and filter
 * The designed data flow is from start Pipe to Input Filter, followed by a number of intermediate filter.
 * Then Data comes to Output filter, finally received by destination Pipe
 *   
 * @author Zhang Ji
 *
 */

public class Pipeline {
	
	private final static int START_INDEX = 0;
	private ArrayList<Filter> filters;
	private Pipe startPipe;
	private Pipe destinationPipe;
	
	public Pipeline(Input input, Output output, Filter ... multiFilters) {
		
		filters = new ArrayList<Filter>();
		for(int i = 0; i < multiFilters.length; i++) {
			filters.add(multiFilters[i]);
		}
		filters.add(output);
		filters.add(START_INDEX, input);
		
			
		for(int i = 0; i < filters.size()-1; i++) {
			Pipe p = new Pipe();
			filters.get(i).setOut(p);
			filters.get(i+1).setIn(p);
		}
		
		
		destinationPipe = new Pipe();
		filters.get(filters.size()-1).setOut(destinationPipe);;
	}
	
	public void setStartPipe(String lines) {
			startPipe = new Pipe();
			String lineArray[] = lines.split("\\r?\\n");
			for(int i = 0; i<lineArray.length; i++) {
				startPipe.write(lineArray[i]);
			}
			Filter input = filters.get(START_INDEX);
			input.setIn(startPipe);
	}
	
	
	public String getResult() {
	
		String result = "";
		while (!destinationPipe.isEmpty()) {
			result += destinationPipe.read() +"\n";
		}
		return result;
	}
	
	public void run() {
		for(Filter f : filters) {
			f.run();
			
		}
	}
}
