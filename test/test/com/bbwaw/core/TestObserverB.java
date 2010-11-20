package test.com.bbwaw.core;

import com.bbwaw.core.IWWNotification;
import com.bbwaw.core.IWWObserver;

public class TestObserverB  implements IWWObserver {

	protected  int id;
	
	protected String msg;
	
	public TestObserverB(int id) {
		this.id = id;
	}
	
	public String getMsg() {
		return msg;
	}
	
	public void update(IWWNotification notification) {
		
		msg = "TestObserverB.update: " + id;
		System.out.println("TestObserverB.update: " + id);
	}
}
