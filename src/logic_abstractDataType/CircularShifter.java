package logic_abstractDataType;

import java.util.Observable;
import java.util.Observer;

public class CircularShifter implements Observer{
	private ChangeEvent event;
	
	public ChangeEvent getEvent(){
		return event;
	}
	public CircularShifter(){
	}
	@Override
	public void update(Observable o, Object arg) {
		if(o instanceof CircularShifterStorage && arg instanceof ChangeEvent){
			event = ((ChangeEvent)arg);
		}
	}
}
