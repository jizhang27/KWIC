package logic_pipeFilter;

/**
 * class Master
 * The master control of main logic in the KWIC system.
 * @author Zhang Ji
 * 
 */
public class Master {
	
	private Pipeline pipeline;
	private String lines_;
	private String words_="";
	

	
	private String run() {
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
		return pipeline.getResult();
	}
	/**
	 * method changeIngoredWords: change ignored word list
	 * @param words: String of words delimited by space
	 * @returns result String 
	 */
	public String changeIngoredWords(String words) {
		words_ = words;
		return run();
	}
	/**
	 * method changeIngoredWords: change input line
	 * @param words: String of lines delimited by new line
	 * @returns result String 
	 */
	public String changeLines(String lines) {
		lines_ = lines;
		return run();
	}
	
	public static void main(String[] args) {
		Master test = new Master();
		String words = "a b c d\n1 2 3 4\n42314214 i love u";
		String ignored = "1 b b aa c";
		test.changeLines(words);
		String result = test.changeIngoredWords(ignored);
		
		System.out.println(result);
	}
	
}
