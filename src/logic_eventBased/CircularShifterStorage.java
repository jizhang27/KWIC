package logic_eventBased;

import java.util.ArrayList;
import java.util.Observable;

public class CircularShifterStorage extends Observable{
	private LineStorage lines;
	private ArrayList<String> IgnoreWord;
	
	public CircularShifterStorage(){
		lines = new LineStorage();
		IgnoreWord = new ArrayList<String>();
	}
	
	public void generateEvent(ChangeEvent event){
		if(event.getType() == 1 || event.getType() == 2){
			lines.setLines(event.getArg());
			int size = lines.getLine(0).split(" ").length;
			for(int i = 1; i < size; i++){
				lines.addLine(shift(lines.getLine(i - 1)));
			}
			lines = filter(lines);
			event.setArg(lines.getLines());
		}
		this.setChanged();
		this.notifyObservers(event);
	}
	
	private String shift(String str){
		String head = getFirstWord(str);
		String tail = removeFirstWord(str);
		return tail + " " + head;
	}
	
	private String getFirstWord(String str){
		return str.trim().split(" ")[0];
	}
	
	private String removeFirstWord(String str){
		return str.replaceFirst(getFirstWord(str), "").trim();
	}
	

	// tools
	public boolean ignoreFilter(String firstword){
		return IgnoreWord.contains(firstword.toLowerCase());
	}
	
	public String getIgnoreWordList(){
		String str = new String();
		int size = IgnoreWord.size();
		for(int i = 0; i< size; i++){
			str += (IgnoreWord.get(i) + " ");
		}
		return str.trim();
	}
	
	public void editIgnoreWord(String newWordList){
		String[] words = newWordList.trim().split(" ");
		int size = words.length;
		for(int i = 0; i < size; i++){
			IgnoreWord.add(words[i]);
		}
	}
	
	public LineStorage filter(LineStorage lines){
		int size = lines.size();
		for(int i = 0; i < size; i++){
			if(ignoreFilter(getFirstWord(lines.getLine(i)))){
				lines.deleteLine(i);
				i--;
				size--;
			}
		}
		return lines;
	}
}
