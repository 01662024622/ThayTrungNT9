package vn.topica.ex2;

import java.util.Random;

/**
 * 
 * @author Hi
 *Class Lamp auto create index
 *Can initialization with field status random
 */
public class Lamp 
{
	private static int cout=0;
	private Status status;
	private int index;
	private static Random random = new Random();
   
//	Constructor method if initialization have status
	public Lamp(Status status) {
		this.index=++cout;
		this.status=status;
	}

//	Constructor method if initialization do not have status
	public Lamp() {
		this.index=++cout;
	    this.status= this.randomStatus();
	}
	
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	
	
//	method create random status
	public Status randomStatus() {
		return Status.values()[random.nextInt(Status.values().length)];
	}
	
	@Override
		public String toString() {
			// TODO Auto-generated method stub
			return "Lamp :"+ this.getIndex() + " have been status : "+ this.getStatus();
		}
}
