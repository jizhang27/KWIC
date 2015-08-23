package logic_pipeFilter;


/**
 * class Output: output Filter connect destination pipe as its output stream
 * @author Zhang Ji
 * 
 */
public class Output extends Filter {

	public void run() {
		
		Debugger.print("START OUTPUT FILTER");
		while(!this.isEmpty()) {
			String a = read();
			
			write(a);
			Debugger.print(a);
			

		}
		Debugger.print("END OUTPUT FILTER");
	}
}
