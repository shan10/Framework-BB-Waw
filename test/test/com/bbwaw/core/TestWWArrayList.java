
package test.com.bbwaw.core;
import com.bbwaw.core.*;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestWWArrayList {

	@Test
	public void testWWArrayList() {

		WWArrayList list = new WWArrayList();
		assertEquals("Result", 0, list.size() );
	}

	@Test
	public void testWWArrayListObjectArray() {

		String[] test = new String[5];
		test[0] = "A";
		test[1] = "B";
		test[2] = "C";
		test[3] = "D";
		test[4] = null;
		
		WWArrayList list = new WWArrayList( test );
		assertEquals("Result", 4, list.size() );
	}

	@Test
	public void testWWArrayListObjectArray2() {

		String[] test = new String[5];
		test[0] = "A";
		test[1] = "B";
		test[2] = "C";
		test[3] = "D";
		test[4] = "D";
		
		WWArrayList list = new WWArrayList( test );
		assertEquals("Result", 5, list.size() );
	}
	
	@Test
	public void testWWArrayListInt() {

		WWArrayList list = new WWArrayList( 0 );
    	list.add(" 1 ");
    	list.add(" 2 ");
    	list.add(" 3 ");
    	assertEquals("Result", 3, list.size() );
		
	}

	@Test
	public void testAddIntObject() {

		WWArrayList list = new WWArrayList();
    	list.add(0, " 1 ");
    	assertEquals("Result", 1, list.size() );
	}

	@Test
	public void testAddIntObject2 () {

		WWArrayList list = new WWArrayList();
    	list.add(10, "ABC");
    	assertEquals("Result", "ABC", list.get(10) );
	}	

	@Test
	public void testAddObject() {
		
		WWArrayList list = new WWArrayList(1);
    	list.add(" 1 ");
    	list.add(" 2 ");
    	list.add(" 3 ");
    	assertEquals("Result", 3, list.size() );
	}
	
	@Test
	public void testAddObject2() {
		
		WWArrayList list2 = new WWArrayList();
    	list2.add(" 1 ");
    	list2.add(" 2 ");
    	list2.add(" 3 ");
    	list2.add(" 4 ");
    	list2.add(" 5 ");
    	list2.add(" 6 ");
    	assertEquals("Result", 6, list2.size() );
	}	

	@Test
	public void testAddObject3() {
		
		WWArrayList list2 = new WWArrayList();
    	list2.add(" 1 ");
    	list2.add(" 2 ");
    	list2.add(" 3 ");
    	list2.add(" 4 ");
    	list2.add(" 5 ");
    	list2.add(" 6 ");
    	list2.add(" 7 ");
    	list2.add(" 8 ");
    	list2.add(" 9 ");
    	list2.add(" 10 ");
    	assertEquals("Result", 10, list2.size() );
	}	
	
	@Test
	public void testClear() {
		
		WWArrayList list = new WWArrayList();
		list.clear();
		assertEquals("Result", 0, list.size() );
	}

	@Test
	public void testClone() {

		WWArrayList list = new WWArrayList();
    	list.add(" 1 ");
    	list.add(" 2 ");
    	list.add(" 3 ");
	
    	WWArrayList list2 = list.clone();
    	
    	assertEquals("Result", list.size(), list2.size() );
	}

	@Test
	public void testContains() {
		
		WWArrayList list = new WWArrayList();
    	list.add("ABC");
    	assertTrue(list.contains("ABC"));
	}

	@Test
	public void testContains2() {
		
		WWArrayList list = new WWArrayList();
    	list.add("ABC");
    	
    	boolean state = list.contains("ABCD");
    	
    	if( ! state ) {
    		assertTrue(true);	
    	}
    	else {
    		assertTrue(false);
    	}
	}
	
	@Test
	public void testGet() {

		WWArrayList list = new WWArrayList();
    	list.add("ABC");
    	
    	Object a = list.get(0);
    	assertEquals("Result", "ABC", a.toString() );
	}

	@Test
	public void testIsEmpty() {
		
		WWArrayList list = new WWArrayList();
		assertTrue(list.isEmpty());
	}

	@Test
	public void testIsEmptyNot() {
		
		WWArrayList list = new WWArrayList();
		list.add("ABC");
		
		boolean state = list.isEmpty();
			
    	if( ! state ) {
    		assertTrue(true);	
    	}
    	else {
    		assertTrue(false);
    	}
		
	}
	
	@Test
	public void testRemove() {

		WWArrayList list = new WWArrayList();
		list.add("ABC");
		list.add("DEF");
		list.add("GHI");
	
		list.remove(1);
		
		assertEquals("Result", 2, list.size() );
	}

	@Test
	public void testRemove2() {

		WWArrayList list = new WWArrayList();
		list.add("ABC");
	
		list.remove(0);
		assertEquals("Result", 0, list.size() );
	}
	
	@Test
	public void testRemove3() {

		WWArrayList list = new WWArrayList();
		list.add("ABC");
	
		list.remove(-1);
		assertEquals("Result", 1, list.size() );
	}	
	
	@Test
	public void testRemove4() {

		WWArrayList list = new WWArrayList();
		list.add("ABC");
	
		list.remove("ABC");
		assertEquals("Result", 0, list.size() );
	}		
	
	@Test
	public void testRemove5() {

		WWArrayList list = new WWArrayList();
		list.add("ABC");
	
		list.remove("ABCD");
		assertEquals("Result", 1, list.size() );
	}			
	
	@Test
	public void testSet() {
		
		WWArrayList list = new WWArrayList();
		list.set(3, "ABC");
		assertEquals("Result", 1, list.size() );
	}

	@Test
	public void testSize() {

		WWArrayList list = new WWArrayList();
		list.add("ABC");
		list.add("DEF");
		list.add("GHI");
		assertEquals("Result", 3, list.size() );
	}

	@Test
	public void testToArray() {

		WWArrayList list = new WWArrayList();
		list.add("ABC");
		list.add("DEF");
		
		Object[] result = list.toArray();
		int f = 0;
		for(int i =0; i < result.length; i++ ) {
			
			if( result[i] != null ) {
				f++;
			}
		}
		
		assertEquals("Result", 2, f );
	}

}
