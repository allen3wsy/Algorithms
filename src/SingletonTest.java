
public class SingletonTest {
	public static void main(String[] args)
	{
		Singleton instance_1 = Singleton.getInstance();
		System.out.println(instance_1.name);
		
		/* the second time */
		Singleton instance_2 = Singleton.getInstance();
//		System.out.println(instance_2.name);		

		// check whether they are the same
		if(instance_1 == instance_2)
			System.out.println("d");
		
//		// the second time
//		Singleton i = Singleton.instance;
//		i.getName();

	}
}
