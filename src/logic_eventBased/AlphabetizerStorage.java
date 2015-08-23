package logic_eventBased;

import java.util.Observable;

public class AlphabetizerStorage  extends Observable{
	private LineStorage lines;
	
	public AlphabetizerStorage(){
		lines = new LineStorage();
	}
	
	public void generateEvent(ChangeEvent event){
		// sort
		
		event.setArg(lines.getLines());
		
		this.setChanged();
		this.notifyObservers(event);
	}
}
