package vn.topica.ex1;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		threadOne to create new lamp and add it to list
		Thread threadOne = new ThreadOne();
		threadOne.start();
//		thread to will processed data
		Thread threadTwo = new ThreadTwo();
		threadTwo.start();
	}

}
