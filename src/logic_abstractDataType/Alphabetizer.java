package logic_abstractDataType;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public class Alphabetizer implements Observer {
	private ArrayList<String> str;
	
	public Alphabetizer(){
		str = new ArrayList<String>();
	}
	
	public ArrayList<String> getStr(){
		return str;
	}
	
	@Override
	public void update(Observable o, Object arg) {
		if(o instanceof AlphabetizerStorage && arg instanceof ChangeEvent){
			str = ((ChangeEvent)arg).getArg();
		}
	}

}
