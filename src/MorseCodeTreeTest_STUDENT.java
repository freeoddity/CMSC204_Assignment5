
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


/**
 * 
 * @author Kevin Gomes
 *
 */
public class MorseCodeTreeTest_STUDENT {
	private MorseCodeTree MCTT;
	
	@BeforeEach
	void setUp() throws Exception{
		MCTT = new MorseCodeTree();
	}
	
	@AfterEach
	void tearDown() throws Exception{
		MCTT = null;
	}
	
	@Test
	void testGetRoot() {
		String root = "";
		String result = MCTT.getRoot().getData();
		assertEquals(root,result);
	}
	@Test
	void testSetRoot() {
		String root = "This is now data stored in Root";
		TreeNode<String> newRoot = new TreeNode<String>(root);
		MCTT.setRoot(newRoot);
		assertEquals(root,MCTT.getRoot().getData());
		
	}
	@Test
	void testInsert() {
		MCTT.insert(".....", "5");
		MCTT.insert("..--", "4");
		MCTT.insert(".-.-", "3");
		MCTT.insert("---.", "2");
		MCTT.insert("----", "1");
		MCTT.insert("-----", "0");
		String correctResult = "5 h s v i f u 4 e l r 3 a p w j  b d x n c k y t z g q m 2 o 1 0";
		String testResult = "";
		ArrayList<String> treeList = MCTT.toArrayList();
		for (String e: treeList) {
			testResult += e +" ";
		}
		assertEquals(correctResult, testResult.trim());
	}
	
	@Test
	void testFetch() {
		//Test 1
		String test1 = "p";
		String result = MCTT.fetch(".--.");
		assertEquals(test1, result);
		
		//Test 2
		result = MCTT.fetch("-..-");
		String test2 = "x";
		assertEquals(test2, result);
		
		//Test 3
		result = MCTT.fetch(".-.");
		String test3 = "r";
		assertEquals(test3,result);
	}
	
	@Test
	void testBuildTree() {
		String correctResult = "h s v i f u e l r a p w j  b d x n c k y t z g q m o";
		ArrayList<String> treeList = MCTT.toArrayList();
		String result = "";
		for (String e: treeList) {
			result += e +" ";
		}
		assertEquals(correctResult, result.trim());
		
	}
	
	@Test
	void testToArrayList() {
		ArrayList<String> correctList = new ArrayList<String>();
		correctList.add("h");
		correctList.add("s");
		correctList.add("v");
		correctList.add("i");
		correctList.add("f");
		correctList.add("u");
		correctList.add("e");
		correctList.add("l");
		correctList.add("r");
		correctList.add("a");
		correctList.add("p");
		correctList.add("w");
		correctList.add("j");
		correctList.add("");
		correctList.add("b");
		correctList.add("d");
		correctList.add("x");
		correctList.add("n");
		correctList.add("c");
		correctList.add("k");
		correctList.add("y");
		correctList.add("t");
		correctList.add("z");
		correctList.add("g");
		correctList.add("q");
		correctList.add("m");
		correctList.add("o");
		
		
		ArrayList<String> treeList = MCTT.toArrayList();
		for (int i = 0; i < treeList.size(); i++) {
			assertEquals(correctList.get(i), treeList.get(i));
		}
	}

}
