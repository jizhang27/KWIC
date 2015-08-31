package logic_eventBased;

public interface EvnetBasedAPI {
	public static void initialize(){}
	
	public static int getKey(){
		return 0;
	}
	
	public static void editIgnoreWord(String newWordList){}
	
	public static void run(int type, String input, int lineNum){}
	
	public static String getOutput(){
		return null;
	}
	
	public static String getIgnoreWordList(){
		return null;
	}
}
