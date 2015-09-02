package logic_eventBased;

public interface MainLogic {
	public void initialize();
	
	public int getKey();
	
	public void editIgnoreWord(String newWordList);
	
	public void run(int type, String input, int key);
	
	
	public String getOutput();
	
	public String getIgnoreWordList();
	
	public void calculate();
}
