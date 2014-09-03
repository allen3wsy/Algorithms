package test;

import java.io.IOException;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class ScannerTest {

	public static void main(String args[]) throws IOException {

		// Java Exmaple to get input from user from command prompt
		System.out.println("Please enter input from command prompt: ");
		Scanner scanner = new Scanner(System.in);
		
		// Getting input in String format
		String name = scanner.nextLine();
		int a = scanner.nextInt();
		System.out.println("This is: " + name);
		System.out.println("This are: " + a);
		
		// Getting number as input from command line in Java
		System.out.println("Please enter a number from command line? ");
		int number = scanner.nextInt();
		System.out.println("You have entered : " + number);

		// Getting floating point as input from command line in Java
		System.out.println("Please enter a floating point number from command line? ");
		float decimal = scanner.nextFloat();
		System.out.println("You have entered : " + decimal);
		
		// Java Example to get input from user using GUI
		String input = JOptionPane.showInputDialog("Enter any number of your choice");
		System.out.println("User has entered: " + input);
	}
}
