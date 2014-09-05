package test;

public class AccessLevel2 {

	public static void main(String[] args)	{
		AccessLevel l = new AccessLevel();
		
		l.setFormat("lol");
		String s = l.getFormat();
		
		System.out.println(s);
	}
}
