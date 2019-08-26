package vn.topica.ex1;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;


public class Store extends LinkedHashMap<Integer,Lamp>{
	/**
	 * generate serial ID for all singleton pattern 
	 */
	private static final long serialVersionUID = 2159982443571263993L;
	private Store() {}
	private static Store STORE= new Store();
	
	
	public static Store getIntance() {
		return STORE;
	}
	
	/**
	 * 
	 * remove lamp exist on Trash buffer
	 * Trash buffer is lamp have status OFF but ever processed
	 */
	public synchronized Store clearStatus() {
		try {
			for (Iterator<Lamp> i = Trash.getTrashBuffer().iterator(); i.hasNext();) {
				Lamp lamp = i.next();
				System.out.println("remove " + lamp.toString()+ " on the Store");
				STORE.remove(lamp.getIndex());					//remove to STORE
				Trash.getTrashBuffer().remove(lamp); 	//remove to Trash buffer.This lamp was processed
				}
		} catch (Exception e) {
			// TODO: handle exception
			e.fillInStackTrace();
		}
		return getIntance();
	}
	
	

	
	
	@Override
	public synchronized Lamp put(Integer index,Lamp lamp) {
		return super.put(index,lamp);
	}
	
	
	public synchronized Lamp remove(Integer index) {
		// TODO Auto-generated method stub
		return super.remove(index);
	}
	
	@Override
	public synchronized Set<java.util.Map.Entry<Integer, Lamp>> entrySet() {
		// TODO Auto-generated method stub
		return super.entrySet();
	}
	
	@Override
	public synchronized String toString() {
		for (Map.Entry<Integer, Lamp> entry : STORE.entrySet()) {
			System.out.println(entry.getValue().toString()+" on store");
			}
		return "";
	}
}
