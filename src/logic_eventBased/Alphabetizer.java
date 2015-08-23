package logic_eventBased;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public class Alphabetizer implements Observer {
	private ArrayList<String> str;
	
	public Alphabetizer(){
		str = new ArrayList<String>();
	}
	
	@Override
	public void update(Observable o, Object arg) {
		// display
		
	}

}
