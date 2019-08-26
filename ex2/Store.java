package vn.topica.ex2;

import java.util.Iterator;
import java.util.LinkedList;

public class Store extends LinkedList<Lamp> {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7829082799207472236L;
	private Store() {
	}

	private static Store STORE = new Store();

	public static Store getIntance() {
		return STORE;
	}

	/**
	 * 
	 * Remove lamp have status off and repair on stores
	 */
	public synchronized Store clearStatus() {
		try {
			for (Iterator<Lamp> i = STORE.iterator(); i.hasNext();) {
				Lamp lamp = i.next();
				if (lamp.getStatus()==Status.OFF||lamp.getStatus()==Status.REPAIR) {
					System.out.println("remove " + lamp.toString() + " on the Store");
					STORE.remove(lamp);
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.fillInStackTrace();
		}
		return getIntance();
	}



	@Override
	public synchronized Iterator<Lamp> iterator() {
		// TODO Auto-generated method stub
		return super.iterator();
	}

	@Override
	public synchronized boolean add(Lamp e) {
		// TODO Auto-generated method stub
		return super.add(e);
	}

	@Override
	public synchronized boolean remove(Object o) {
		// TODO Auto-generated method stub
		return super.remove(o);
	}

	@Override
	public synchronized String toString() {
		for (Iterator<Lamp> i = Store.getIntance().iterator(); i.hasNext();) {
			System.out.println(i.next().toString() + " on store");
		}
		return "";
	}
}
