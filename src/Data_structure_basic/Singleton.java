package Data_structure_basic;
public class Singleton	{
	/* 2nd!!! the static Singleton field */
	static Singleton s;
	String name;
	
	/* 1st!!! the most important thing! private constructor */
	private Singleton(String name)	{
		this.name = name;
	}
	
	/* 3rd!!!  this method must be static because Singleton class has not been 
	 * created */
	public static Singleton getInstance()	{
	
		if(s == null)	{
			s = new Singleton("aaa");		
			return s;
		}
		return s;
	}
	
//	public void getName()
//	{
//		System.out.println(name);
//	}
	
}