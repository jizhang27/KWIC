package logic_eventBased;

public class MasterControl {
	private int lineNum;
	private static CircularShifterStorage CSobservable;
	private static CircularShifter CSobserver;
	private static AlphabetizerStorage ABobservable;
	private static Alphabetizer ABobserver;
	
	public void initialize(){
		lineNum = 0;
		CSobservable = new CircularShifterStorage();
		CSobserver = new CircularShifter();
		ABobservable = new AlphabetizerStorage();
		ABobserver = new Alphabetizer();
		CSobservable.addObserver(CSobserver);
		ABobservable.addObserver(ABobserver);
	}
	
	// require arguments
	public void generateEvent(){
		ChangeEvent event = new ChangeEvent(0, null); 
		updateLineNum(event.getType());
		CSobservable.generateEvent(event);
	}

	private void updateLineNum(int type) {
		if(type == ChangeEvent.ADD){
			lineNum++;
		} else if (type == ChangeEvent.DELETE){
			lineNum--;
		}
	}
	
	public static CircularShifterStorage getCSobservable() {
		return CSobservable;
	}

	public static CircularShifter getCSobserver() {
		return CSobserver;
	}

	public static AlphabetizerStorage getABobservable() {
		return ABobservable;
	}

	public static Alphabetizer getABobserver() {
		return ABobserver;
	}
	
	// for GUI
	public int getKey(){
		return lineNum;
	}
}
