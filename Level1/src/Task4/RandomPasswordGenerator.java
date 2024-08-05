package Task4;

import java.util.Random;
import java.util.Scanner;

public class RandomPasswordGenerator {
	
	private static final String LOWERCASE = "abcdefghijklmnopqrstuvwxyz";
	private static final String UPPERCASE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	private static final String DIGITS = "0123456789";
	private static final String SPECIAL_CHARS = "!@#$%^&*()-_+=<>?";
	
	private static String generatePassword(int length, boolean useLowerCase, boolean useUpperCase, boolean useDigits, boolean useSpecialChars) {
		StringBuilder charPool = new StringBuilder();
		Random random = new Random();
		StringBuilder password = new StringBuilder();
		
		if(useLowerCase)	{
			charPool.append(LOWERCASE);
		}
		if(useUpperCase) {
			charPool.append(UPPERCASE);
		}
		if (useDigits) {
			charPool.append(DIGITS);
		}
		if(useSpecialChars) {
			charPool.append(SPECIAL_CHARS);
		}
		
		if(charPool.length() == 0) {
			throw new IllegalArgumentException("Atleast one character set must be selected");
		}
		 
		for(int i=0; i<length; i++) {
			int index = random.nextInt(charPool.length());
			password.append(charPool.charAt(index));
		}
		
		return password.toString();

	}
	
	public static void main(String[] args) 
	{
		try(Scanner sc = new Scanner(System.in)) 
		{
			System.out.print("Enter the Desired length of the password : ");
			int length = sc.nextInt();
			System.out.println("Include Lowercase letters ? (yes/no) :");
			boolean useLowerCase = sc.next().equalsIgnoreCase("yes");
			System.out.println("Include Uppercase letters ? (yes/no) : ");
			boolean useUpperCase = sc.next().equalsIgnoreCase("yes");
			System.out.println("Include Digits ? (yes/no) :");
			boolean useDigits = sc.next().equalsIgnoreCase("yes");
			System.out.println("Include Special Character ? (yes/no) : ");
			boolean useSpecialChars = sc.next().equalsIgnoreCase("yes");
			
			String password = generatePassword(length, useLowerCase, useUpperCase, useDigits, useSpecialChars);
			System.out.println("Generated Password : "+ password);
		} 
		catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
		
	}

}
