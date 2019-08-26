package vn.topica.ex1;


public class ThreadTwo extends Thread{

	@Override
	public void run() {
		// TODO Auto-generated method stub

//		Thread always will running
		while (true) {
//			clear status define
			Store.getIntance().clearStatus();
//			print list lamp after processed
			Store.getIntance().toString();
//			Waiting thread with "ms" unit
			TheadWaitting.waittingThread(200);
		}
	}
}
