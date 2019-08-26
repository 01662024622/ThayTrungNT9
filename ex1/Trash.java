package vn.topica.ex1;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;


/**
 * 
 * @author Hi
 *Class Trash is singleton pattern and that used to save all Lamp have status is OFF
 *And have list lampNewest have status OFF but that not proccessed yet
 */

public class Trash extends LinkedList<Lamp>{
	/**
	 * generate serial ID for all singleton pattern 
	 */
	private static final long serialVersionUID = -7823270442824950645L;

	private Trash() {}
	private static Trash TRASH= new Trash();
	public static Trash getIntance() {
		return TRASH;
	}
//	list lampNewest used to save lamp not processed yet. And it is synchronized collection to ensure thread safe
//	target: reduce time IO but save full lamp have status OFF
	private static List<Lamp> trashBuffer = Collections.synchronizedList(new LinkedList<Lamp>());
	

//	only add lamp have status OFF to Trash and Trash buffer
	@Override
	public synchronized boolean add(Lamp lamp) {
		if (lamp.getStatus() == Status.OFF) {
			Trash.getTrashBuffer().add(lamp);
			super.add(lamp);
		}
		return false;
		
	}
	
//	return list LampNewest ever processed
	public static List<Lamp> getTrashBuffer(){
		return trashBuffer;
	}

//	synchronized method add to ensure thread safe
	@Override
	public synchronized String toString() {
		for (Iterator<Lamp> i = Trash.getIntance().iterator(); i.hasNext();) {
			System.out.println(i.next().toString() + "on trash");
			}
		return "";
	}
	
}