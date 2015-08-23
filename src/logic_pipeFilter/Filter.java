package logic_pipeFilter;

/**
 * 
 * @author Zhang Ji
 * 
 */
public abstract class Filter{

	protected Pipe in, out;

	public void setIn(Pipe p) {
		in = p;
	}

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
	 * Reads from it's pipe
	 */
	public String read() {
		return in.read();
	}

}

