package logic_pipeFilter;

import java.util.LinkedList;

/**
 * 
 * Class: Pipe
 * @author Zhang Ji
 * The connectors of filters to merge the streams together
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
	 * Read from the Pipe. 
	 * @return String
	 */
	public String read() {
		return buffer.pop();
	}

	
}
