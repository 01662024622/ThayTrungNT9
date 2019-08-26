package vn.topica.ex2;

public class TheadWaitting {

//	method set thread sleep 
	public static void waittingThread(int ms) {
		try {
			Thread.sleep(ms);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
