package logic_pipeFilter;

/**
 * This is the launcher
 * 
 * @author Zhang Ji
 * 
 */
public class Master {
	public static void main(String[] args) {
	/*
     
     */
    (new Pipeline(
			new Input(),
			new CircularShifter(),
			new NoiseWordRemoval(),
			new Alphabetizer(),
			new Output()
		)).run();
	}
}
