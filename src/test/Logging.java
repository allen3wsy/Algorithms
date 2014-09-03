package test;

//Implements a simple logging class using a singleton.
public class Logging {

	// this creates the actual Singleton instance
	private static Logging singletonInstance = null;

	/*
	 * Private constructor prevents others from instantiating this class:
	 */
	private Logging() {
	}

	// this method returns the singleton instance (THREAD-SAFE now !!!)
	public synchronized static Logging getSingleton() {
		if(singletonInstance == null) {
			singletonInstance = new Logging();
		}
		return singletonInstance;
	}

	/*
	 * This will print a message to the screen: sample call:
	 * Logging.getSingleton().log("testing message");
	 */

	public void log(String message) {
		System.out.println(System.currentTimeMillis() + ": " + message);
	}
}