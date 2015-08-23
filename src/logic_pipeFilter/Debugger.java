package logic_pipeFilter;

public class Debugger {
	
	private static boolean isEnabled = true;
	public static void print(String info) {
		if(isEnabled) {
			System.out.println(info);
		}
	}
}
