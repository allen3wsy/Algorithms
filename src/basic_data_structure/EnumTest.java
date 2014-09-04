package basic_data_structure;

public class EnumTest {

	public enum Color	{
		Red, Yellow, Green;
	}
	
	public static void main(String[] args)	{
		
		for(Color c : Color.values())	{
			System.out.println(c);
		}
		
	}
}
