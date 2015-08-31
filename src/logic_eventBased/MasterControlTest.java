package logic_eventBased;

import static org.junit.Assert.*;

import org.junit.Test;

public class MasterControlTest {

	@Test
	public void test1() {
		MasterControl .initialize();
		int result = MasterControl.getKey();
		assertEquals(result, 0);
	}

	@Test
	public void test2() {
		MasterControl .initialize();
		String ig = "a an the";
		MasterControl.editIgnoreWord(ig);
		String result = MasterControl.getIgnoreWordList();
		assertEquals(result, ig);
	}
	
	@Test
	public void test3() {
		MasterControl.initialize();
		String ig = "a an the";
		MasterControl.editIgnoreWord(ig);
		MasterControl.run(1, "the Lion King", MasterControl.getKey());
		String result = MasterControl.getOutput();
		int resultIndex = MasterControl.getKey();
		assertEquals(result, "King the Lion \r\nLion King the \r\n");
		assertEquals(resultIndex, 1);
	}
	
	@Test
	public void test4() {
		MasterControl.initialize();
		String ig = "a an the";
		MasterControl.editIgnoreWord(ig);
		MasterControl.run(1, "the Lion King", MasterControl.getKey());
		MasterControl.run(2, "the Tiger King", 0);
		String result = MasterControl.getOutput();
		int resultIndex = MasterControl.getKey();
		assertEquals(result, "King the Tiger \r\nTiger King the \r\n");
		assertEquals(resultIndex, 1);
	}
	
	@Test
	public void test5() {
		MasterControl.initialize();
		String ig = "a an the";
		MasterControl.editIgnoreWord(ig);
		MasterControl.run(1, "the Lion King", MasterControl.getKey());
		MasterControl.run(3, null, 0);
		String result = MasterControl.getOutput();
		int resultIndex = MasterControl.getKey();
		assertEquals(result, "");
		assertEquals(resultIndex, 0);
	}
}
