package logic_eventBased;

import static org.junit.Assert.*;

import org.junit.Test;

public class MasterControlTest {

	@Test
	public void test1() {
		MasterControl test = new MasterControl();
		test.initialize();
		int result = test.getKey();
		assertEquals(result, 0);
	}

	@Test
	public void test2() {
		MasterControl test = new MasterControl();
		test.initialize();
		String ig = "a an the";
		test.editIgnoreWord(ig);
		String result = test.getIgnoreWordList();
		assertEquals(result, ig);
	}
	
	@Test
	public void test3() {
		MasterControl test = new MasterControl();
		test.initialize();
		String ig = "a an the";
		test.editIgnoreWord(ig);
		test.run(1, "the Lion King", test.getKey());
		String result = test.getOutput();
		int resultIndex = test.getKey();
		assertEquals(result, "KING the lion \r\nLION king the \r\n");
		assertEquals(resultIndex, 1);
	}
	
	@Test
	public void test4() {
		MasterControl test = new MasterControl();
		test.initialize();
		String ig = "a an the";
		test.editIgnoreWord(ig);
		test.run(1, "the Lion King", test.getKey());
		test.run(2, "the Tiger King", 0);
		String result = test.getOutput();
		int resultIndex = test.getKey();
		assertEquals(result, "KING the tiger \r\nTIGER king the \r\n");
		assertEquals(resultIndex, 1);
	}
	
	@Test
	public void test5() {
		MasterControl test = new MasterControl();
		test.initialize();
		String ig = "a an the";
		test.editIgnoreWord(ig);
		test.run(1, "the Lion King", test.getKey());
		test.run(3, "", 0);
		String result = test.getOutput();
		int resultIndex = test.getKey();
		assertEquals(result, "");
		assertEquals(resultIndex, 1);
	}
}
