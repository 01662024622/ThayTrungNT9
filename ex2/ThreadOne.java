package vn.topica.ex2;

import java.util.Random;

public class ThreadOne extends Thread {

	@Override
	public void run() {
		// TODO Auto-generated method stub
//		Thread always will running
		while (true) {
//			random for get number lamp will initialization
			for (int i = 0; i < new Random().nextInt(20) + 1; i++) {
//				call method for add to corresponding list
				addToAllList(LampFactory.newLamp());
			}
		}
	}

//	add  new lamp to all corresponding list 
	public void addToAllList(Lamp lamp) {
//		add to store list
		Store.getIntance().add(lamp);
//		call to add method of Trash but will validate and be processed
		Trash.getIntance().add(lamp);
		System.out.println("create " + lamp.toString());
//		waitting thread with ms unit
		TheadWaitting.waittingThread(100);
	}
	
	

}


