package test.com.bbwaw.core;

import static org.junit.Assert.*;

import org.junit.Test;

import com.bbwaw.core.*;

public class TestObservable {

	@Test
	public void testAddObserver() {

		TestObserverA testA = new TestObserverA(1);
		TestObserverB testB = new TestObserverB(2);
		
		WWNotificationCenter.addObserver(testA);
		WWNotificationCenter.addObserver(testB);
		
		assertEquals("Result", 2, WWNotificationCenter.getObserversCount() );
	}

	@Test
	public void testDeleteObserver() {

		TestObserverA testA = new TestObserverA(1);
		TestObserverB testB = new TestObserverB(2);
		
		int count = WWNotificationCenter.getObserversCount();
		int resultCount = count+1;
		
		WWNotificationCenter.addObserver(testA);
		WWNotificationCenter.addObserver(testB);
		WWNotificationCenter.addObserver(testB);
		WWNotificationCenter.deleteObserver(testA);
		
		assertEquals("Result", resultCount, WWNotificationCenter.getObserversCount() );
	}

	@Test
	public void testNotifyObservers() {
		
		TestObserverA testA = new TestObserverA(2);
		WWNotificationCenter.addObserver(testA);
		
		WWNotification notification = new WWNotification("Object", "1");
		WWNotificationCenter.notifyObservers(notification);
	
		String msg = testA.getMsg();
		assertEquals("Result", msg, "TestObserverA.update: 2" );
		
	}

}
