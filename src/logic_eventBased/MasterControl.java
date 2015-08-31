package logic_eventBased;

import java.util.ArrayList;

public class MasterControl {
	private static int lineNum;
	private static ArrayList<String> output;
	private static CircularShifterStorage CSobservable;
	private static CircularShifter CSobserver;
	private static AlphabetizerStorage ABobservable;
	private static Alphabetizer ABobserver;
	private static ArrayList<String> IgnoreWord;
	
	private static void generateEvent(int type, String input, int lineNum){
		ArrayList<String> str = new ArrayList<String>();
		str.add(input);
		ChangeEvent event = new ChangeEvent(type, str, lineNum); 
		updateLineNum(type);
		CSobservable.generateEvent(event);
	}

	private static void updateLineNum(int type) {
		if(type == ChangeEvent.ADD){
			lineNum++;
		} else if (type == ChangeEvent.DELETE){
			lineNum--;
		}
	}
	
	public static CircularShifterStorage getCSobservable() {
		return CSobservable;
	}

	public static CircularShifter getCSobserver() {
		return CSobserver;
	}

	public static AlphabetizerStorage getABobservable() {
		return ABobservable;
	}

	public static Alphabetizer getABobserver() {
		return ABobserver;
	}
	
	public static void modifyOutput(ArrayList<String> newStr){
		output = newStr;
	}
	
	public static boolean ignoreFilter(String firstword){
		return IgnoreWord.contains(firstword.toLowerCase());
	}
	
	public static String getIgnoreWordList(){
		String str = new String();
		int size = IgnoreWord.size();
		for(int i = 0; i< size; i++){
			str += (IgnoreWord.get(i) + " ");
		}
		return str.trim();
	}
	
	// for GUI
	public static int getKey(){
		return lineNum;
	}
	
	public static void editIgnoreWord(String newWordList){
		String[] words = newWordList.trim().split(" ");
		int size = words.length;
		for(int i = 0; i < size; i++){
			IgnoreWord.add(words[i]);
		}
	}

	public static void run(int type, String input, int lineNum){
		generateEvent(type, input, lineNum);
	}
	
	public static String getOutput(){
		int size = output.size();
		String str = new String();
		for(int i = 0; i < size; i++){
			String[] temp = output.get(i).split(" ");
			int tempSize = temp.length;
			for(int j = 0; j < tempSize - 1; j++){
				str += (temp[j] + " ");
			}
			str += "\r\n";
		}
		return str;
	}
	
	public static void initialize(){
		lineNum = 0;
		output = new ArrayList<String>();;
		CSobservable = new CircularShifterStorage();
		CSobserver = new CircularShifter();
		ABobservable = new AlphabetizerStorage();
		ABobserver = new Alphabetizer();
		CSobservable.addObserver(CSobserver);
		ABobservable.addObserver(ABobserver);
		IgnoreWord = new ArrayList<String>();
	}
}
