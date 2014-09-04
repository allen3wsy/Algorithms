package basic_data_structure;

public class Logger2 {

	public static void main(String[] args)	{
		Logger l = new Logger();
		
		l.setFormat("lol");
		String s = l.getFormat();
		
		System.out.println(s);
	}
}
