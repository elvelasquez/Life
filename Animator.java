package edu.amherst.cs112.lab9;

public class Animator implements Runnable {

	MenuComponent comp;
	boolean ok = true;
	
	public Animator(MenuComponent c) {
		comp = c;
	}
	
	public void run() {
		try {
			while (ok) {
				Thread.sleep(100);
				comp.widgetPanel.widgetComponent.run();
			}
		} catch (InterruptedException e) {
			return;	
		}
		
	}
	

}
