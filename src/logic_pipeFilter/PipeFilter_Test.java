package logic_pipeFilter;

import static org.junit.Assert.*;

import org.junit.Test;

public class PipeFilter_Test {

	@Test 
	public void test1() {
		Master test = new Master();
		test.changeLines("");
		String result = test.changeIngoredWords("");
		assertEquals(result, "\n");
		
		result = test.changeIngoredWords("a dsa asdlfkja b csa");
		assertEquals(result, "\n");
		
		test.changeIngoredWords("");
		result = test.changeLines("a b c");
		assertEquals(result, "A b c\nB c a\nC a b\n");
	}
	@Test
	public void test2() {
		Master test = new Master();
		test.changeLines("The Day after Tomorrow\nFast and Furious\nMan of Steel");
		String result = test.changeIngoredWords("is the of and as a after");
		assertEquals(result, "DAY after tomorrow the\nFAST and furious\nFURIOUS fast and\nMAN of steel\nSTEEL man of\nTOMORROW the day after\n");
		

	}

}
