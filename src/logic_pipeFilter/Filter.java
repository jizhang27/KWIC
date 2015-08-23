package logic_pipeFilter;

/**
 * Abstract class Filter: component reads streams of data on its input streams, processes the data and writes the resulting data on its output streams.
 * @author Zhang Ji
 * 
 */
public abstract class Filter implements Runnable{

	protected Pipe in, out;
	/**
	 * set input filter 
	 * @param p
	 */
	public void setIn(Pipe p) {
		in = p;
	}
	
	/**
	 * set output filter 
	 * @param p
	 */
	public void setOut(Pipe p) {
		out = p;
	}

	/**
	 * Writes to it's pipe
	 * 
	 * @param s
	 */
	public void write(String s) {
		
		out.write(s);
	}
	/**
	 * tell if input pipe is empty
	 * @return
	 */
	public boolean isEmpty() {
		return in.isEmpty();
	}
	/**
	 * Reads from it's pipe
	 */
	public String read() {
		return in.read();
	}

}

