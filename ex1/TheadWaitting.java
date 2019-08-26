package vn.topica.ex1;

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
