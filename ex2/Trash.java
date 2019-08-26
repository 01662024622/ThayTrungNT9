package vn.topica.ex2;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Random;

/**
 * 
 * @author Hi Class Trash is singleton pattern and that used to save all Lamp
 *         have status is OFF And have list lampNewest have status OFF but that
 *         not processed yet
 */

public class Trash extends LinkedList<Lamp> {
	/**
	 * generate serial ID for all singleton pattern
	 */
	private static final long serialVersionUID = 6699116976699393657L;

	private static Random random = new Random();

	private Trash() {
	}

	private static Trash TRASH = new Trash();

	public static Trash getIntance() {
		return TRASH;
	}



/**
 * synchronized method add to ensure thread safe
 * only add element have status off and repair to trash
 */
	@Override
	public synchronized boolean add(Lamp lamp) {
		if (lamp.getStatus() == Status.OFF || lamp.getStatus() == Status.REPAIR) {
			super.add(lamp);
		}
		return false;

	}
	
	
/**
 * method processed lamp in Trash
 * 
 */
	
	public synchronized Trash rePairStatus() {
		try {
			for (Iterator<Lamp> i = TRASH.iterator(); i.hasNext();) {
//				get iterator
				Lamp lamp = i.next();
				Integer index = i.hashCode();

				if (lamp.getStatus() == Status.REPAIR) {	 // status is repair
					Store.getIntance().add(lamp); 			// add to store again
					TRASH.remove(lamp); 				// remove lamp from trash
				} else {									//status is OFF
					if (random.nextBoolean()) {				//random for processed
						TRASH.remove(lamp);			//if true will to remove lamp on trash
					} else {
						TRASH.updateElement(index, lamp);	//update element in Trash and add to Store
					}
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.fillInStackTrace();
		}
		return getIntance();
	}

	
	/**
	 * 
	 * @param index
	 * @param lamp
	 * update element to Trash
	 * add to store before change status
	 */
	public void updateElement(int index,Lamp lamp) {
		
		int indexOfTrash =TRASH.indexOf(lamp);	//get index of lamp in Trash
		lamp.setStatus(Status.REPAIR);			//set status repair for lamp
		TRASH.set(indexOfTrash, lamp);			//update lamp to Trash
		Store.getIntance().add(lamp);			//add new lamp to Store
	}
	



	@Override
	public synchronized boolean remove(Object o) {
		// TODO Auto-generated method stub
		return super.remove(o);
	}
	
	@Override
	public synchronized Lamp set(int index, Lamp element) {
		// TODO Auto-generated method stub
		return super.set(index, element);
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