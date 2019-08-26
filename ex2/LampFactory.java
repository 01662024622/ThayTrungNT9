package vn.topica.ex2;
/**
 * 
 * @author Hi
 *LampFactory is flyweight pattern.
 *support when create new so many object same class
 */
public class LampFactory {
	public static Lamp newLamp() {
		return new Lamp();
	}
}
