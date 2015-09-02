package logic_pipeFilter;

import logic_eventBased.MainLogic;

/**
 * class Master
 * The master control of main logic in the KWIC system.
 * @author Zhang Ji
 * 
 */
public class Master implements MainLogic {
	
	private Pipeline pipeline;
	private String lines_;
	private String words_="";
	

	@Override
	public void calculate() {
		pipeline = new Pipeline(
				new Input(),
				new Output(),
				new CircularShifter(),
				new IgnoredWordRemoval(words_),
				new Alphabetizer()
				);
		pipeline.setStartPipe(lines_);
		Debugger.print("setup finished");
		pipeline.run();
		
	}
	/**
	 * method changeIngoredWords: change ignored word list
	 * @param words: String of words delimited by space
	 * @returns result String 
	 */
	public void changeIngoredWords(String words) {
		words_ = words;
		
	}
	/**
	 * method changeIngoredWords: change input line
	 * @param words: String of lines delimited by new line
	 * @returns result String 
	 */
	public void changeLines(String lines) {
		lines_ = lines;
	}
	
	
	@Override
	public void initialize() {
		
		// do nothing
	}
	@Override
	public int getKey() {
		return 0;
	}
	@Override
	public void editIgnoreWord(String newWordList) {
		changeIngoredWords(newWordList);
	}
	// type = 0; get string itself
	@Override
	public void run(int type, String input, int key) {
		if (type == 0) {
			this.lines_ = input;
		} else {
			Debugger.print("error type code");
		}
	}
	@Override
	public String getOutput() {
		return pipeline.getResult();
	}
	@Override
	public String getIgnoreWordList() {
		return words_;
	}
	
}
