package logic_eventBased;

import java.util.Observable;

public class CircularShifterStorage extends Observable{
	private LineStorage lines;
	
	public CircularShifterStorage(){
		lines = new LineStorage();
	}
	
	public void generateEvent(ChangeEvent event){
		if(event.getType() == 1 || event.getType() == 2){
			lines.setLines(event.getArg());
			int size = lines.getLine(0).length();
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
	private LineStorage filter(LineStorage lines){
		return null;
	}
}
