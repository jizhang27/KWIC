package logic_eventBased;

import java.util.ArrayList;

public class ChangeEvent {
	public static int ADD = 1;
	public static int MODIFY = 2;
	public static int DELETE = 3;
	
	private int type;
	private ArrayList<String> arg;
	private int index;
	
	public ChangeEvent(int type, ArrayList<String> arg){
		this.type = type;
		this.arg = arg;
		this.index = -1;
	}
	
	public ChangeEvent(int type, ArrayList<String> arg, int index){
		this.type = type;
		this.arg = arg;
		this.index = index;
	}
	
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public ArrayList<String> getArg() {
		return arg;
	}
	public void setArg(ArrayList<String> arg) {
		this.arg = arg;
	}
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
}
