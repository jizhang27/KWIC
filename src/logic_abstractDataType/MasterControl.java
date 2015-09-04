package logic_abstractDataType;

import java.util.ArrayList;

public class MasterControl implements MainLogic{
	private int lineNum;
	private ArrayList<String> output;
	private CircularShifterStorage CSobservable;
	private CircularShifter CSobserver;
	private AlphabetizerStorage ABobservable;
	private Alphabetizer ABobserver;
	
	public MasterControl(){
		
	}
	
	private void generateEvent(int type, String input, int lineNum){
		ArrayList<String> str = new ArrayList<String>();
		str.add(input);
		ChangeEvent event = new ChangeEvent(type, str, lineNum); 
		updateLineNum(type);
		CSobservable.generateEvent(event);
	}

	private void updateLineNum(int type) {
		if(type == ChangeEvent.ADD){
			lineNum++;
		}
	}
	
	public CircularShifterStorage getCSobservable() {
		return CSobservable;
	}

	public CircularShifter getCSobserver() {
		return CSobserver;
	}

	public AlphabetizerStorage getABobservable() {
		return ABobservable;
	}

	public Alphabetizer getABobserver() {
		return ABobserver;
	}
	
	public void modifyOutput(){
		output = ABobserver.getStr();
	}
	


	// for GUI
	@Override
	public String getIgnoreWordList(){
		return CSobservable.getIgnoreWordList();
	}
	
	@Override
	public int getKey(){
		return lineNum;
	}
	
	@Override
	public void editIgnoreWord(String newWordList){
		CSobservable.editIgnoreWord(newWordList.toLowerCase());
	}

	@Override
	public void run(int type, String input, int lineNum){
		generateEvent(type, input.toLowerCase(), lineNum);
		ABobservable.generateEvent(CSobserver.getEvent());
		modifyOutput();
	}
	
	@Override
	public String getOutput(){
		int size = output.size();
		String str = new String();
		for(int i = 0; i < size; i++){
			String[] temp = output.get(i).split(" ");
			int tempSize = temp.length;
			for(int j = 0; j < tempSize - 1; j++){
				String s = temp[j];
				if(j == 0){
					s = s.toUpperCase();
				}
				str += (s + " ");
			}
			str += "\r\n";
		}
		return str;
	}
	
	@Override
	public void initialize(){
		lineNum = 0;
		output = new ArrayList<String>();;
		CSobservable = new CircularShifterStorage();
		CSobserver = new CircularShifter();
		ABobservable = new AlphabetizerStorage();
		ABobserver = new Alphabetizer();
		CSobservable.addObserver(CSobserver);
		ABobservable.addObserver(ABobserver);
	}

	@Override
	public void calculate() {
		LineStorage temp = new LineStorage(output);
		temp = CSobservable.filter(temp);
		output = temp.getLines();
	}
	
	
}
