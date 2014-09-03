package test;


public class LoggingTry {

	public static void main(String[] args) {
		Logging loggingObject =	Logging.getSingleton();
		Logging loggingObject2 = Logging.getSingleton();
		
		loggingObject.log("hihi");
		
		if(loggingObject == loggingObject2)
			System.out.println("LoggingTry.main()");
		
	}
}
