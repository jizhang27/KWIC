package logic_pipeFilter;

/**
 * class Input: Input filter that connect start pipe as its input stream.
 * @author Zhang Ji
 */
public class Input extends Filter {

	@Override
	public void run() {
		Debugger.print("START INPUT FILTER");
		while(!this.isEmpty()) {
			String a = read();
			write(a);
//			write(read());
			Debugger.print(a);
		}
		Debugger.print("END INPUT FILTER");
	}
	
}
