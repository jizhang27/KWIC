package logic_abstractDataType;

import java.util.ArrayList;

public class LineStorage {
	private ArrayList<String> lines;
	
	public LineStorage(){
		this.lines = new ArrayList<String>();
	}
	
	public LineStorage(ArrayList<String> lines){
		this.lines = lines;
	}
	
	public int size(){
		return lines.size();
	}
	
	public ArrayList<String> getLines(){
		return lines;
	}
	
	public String getLine(int index){
		try{
			return lines.get(index);
		} catch(IndexOutOfBoundsException e) {
			return null;
		}
	}
	
	public boolean setLines(ArrayList<String> newLines){
		try{
			lines = newLines;
			return true;
		} catch(IndexOutOfBoundsException e) {
			return false;
		}
	}
	
	public boolean setLine(int index, String newLine){
		try{
			lines.set(index, newLine);
			return true;
		} catch(IndexOutOfBoundsException e) {
			return false;
		}
	}
	
	public int addLine(String newLine){
		lines.add(newLine);
		return lines.size() - 1;
	}
	
	public int insertLine(String newLine, int index){
		if(index > lines.size()){
			return -1;
		}
		lines.add(index, newLine);
		return index;
	}
	
	public boolean deleteLine(int index){
		try{
			lines.remove(index);
			return true;
		} catch(IndexOutOfBoundsException e) {
			return false;
		}
	}
}
