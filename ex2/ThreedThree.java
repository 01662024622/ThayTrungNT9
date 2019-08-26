package vn.topica.ex2;

public class ThreedThree extends Thread{

	@Override
	public void run() {
		// TODO Auto-generated method stub

//		Thread always will running
		while (true) {
//			processed lamp in Trash
			Trash.getIntance().rePairStatus();
//			waitting thread with ms unit
			TheadWaitting.waittingThread(200);
		}
	}
}
