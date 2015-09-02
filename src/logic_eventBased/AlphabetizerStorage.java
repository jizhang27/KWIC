package logic_eventBased;

import java.util.ArrayList;
import java.util.Observable;

public class AlphabetizerStorage extends Observable{
	private LineStorage lines;
	
	public AlphabetizerStorage(){
		lines = new LineStorage();
	}
	
	public void generateEvent(ChangeEvent event){		
		if(event.getType() == 2 || event.getType() == 3){
			int size = lines.size();
			int index = event.getIndex();
			for(int i = 0; i < size; i++){
				String[] str = lines.getLine(i).split(" ");
				if(Integer.parseInt(str[str.length - 1].trim()) == index){
					lines.deleteLine(i);
					i--;
					size--;
				}
			}
		}
		// sort (insert)
		if(event.getType() == 1 || event.getType() == 2){
			ArrayList<String> inputstr = event.getArg();
			int size = inputstr.size();
			for(int i = 0; i < size; i++){
				insert(inputstr.get(i) + " " + event.getIndex());
			}
		}
		event.setArg(lines.getLines());
		this.setChanged();
		this.notifyObservers(event);
	}
	
	private void insert(String input){

		System.out.println(input);
		int size = lines.size();
		for(int i = 0; i< size; i++){
			if(input.compareToIgnoreCase(lines.getLine(i)) < 0){
				lines.insertLine(input, i);
				return;
			}
		}
		lines.addLine(input);
	}
}
