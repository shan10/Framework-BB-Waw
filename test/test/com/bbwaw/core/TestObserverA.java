package test.com.bbwaw.core;

import com.bbwaw.core.IWWNotification;
import com.bbwaw.core.IWWObserver;

public class TestObserverA  implements IWWObserver {

	protected  int id;
	
	protected String msg;
	
	public TestObserverA(int id) {
		this.id = id;
	}
	
	public String getMsg() {
		return msg;
	}
	
	public void update(IWWNotification notification) {
		
		msg = "TestObserverA.update: " + id;
		System.out.println("TestObserverA.update: " + id);
	}
}
