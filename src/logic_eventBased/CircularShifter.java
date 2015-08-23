package logic_eventBased;

import java.util.Observable;
import java.util.Observer;

public class CircularShifter implements Observer{
	
	public CircularShifter(){
	}
	@Override
	public void update(Observable o, Object arg) {
		if(o instanceof CircularShifterStorage && arg instanceof ChangeEvent){
			MasterControl.getABobservable().generateEvent((ChangeEvent)arg);
		}
	}
}
