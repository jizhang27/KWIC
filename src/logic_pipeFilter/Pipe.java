package logic_pipeFilter;

import java.util.LinkedList;

/**
 * 
 * Class Pipe: The connectors of filters to merge the streams together
 * @author Zhang Ji
 * 
 * 
 */
public class Pipe {
	private LinkedList<String> buffer;

	public Pipe() {
		buffer = new LinkedList<String>();
		
	}

	/**
	 * Write a string to the pipe
	 * @param s
	 */
	public void write(String s) {
		buffer.add(s);
	}
	/**
	 * tell whether pipe is empty 
	 */
	public boolean isEmpty() {
		return buffer.isEmpty();
	}
	
	/**
	 * Read from the Pipe. 
	 * @return String
	 */
	public String read() {
		return buffer.pop();
	}

	
}
