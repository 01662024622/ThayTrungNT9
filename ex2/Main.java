package vn.topica.ex2;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		threadOne to create new lamp and add it to list
		Thread threadOne = new ThreadOne();
		threadOne.start();
//		thread to will processed data
		Thread threadTwo = new ThreadTwo();
		threadTwo.start();
//		thread to will processed data in Trash
		Thread threadThree = new ThreedThree();
		threadThree.start();
	}

}
