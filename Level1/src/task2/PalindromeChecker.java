package task2;

import java.util.Scanner;

public class PalindromeChecker {
	
	private static boolean isPalindrome(String str) {
		// Remove non-alphaNumeric characters and convert into lowercase.
		String cleanString = str.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
		
		// Use two pointer techniques to check if the cleaned string is palindrome or not.
		int left = 0;
		int right = cleanString.length()-1;
		
		while(left<right) {
			if (cleanString.charAt(left) != cleanString.charAt(right)) {
				return false;
			}
			left++;
			right--;
		}
		
		return true;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("-----Palindrome Checker------");
		System.out.println("Enter any Word or Sentences : ");
		String wordOrSentence = sc.nextLine();
		
		if(isPalindrome(wordOrSentence)) {
			System.out.println(wordOrSentence + " : is Palindrome.");
		}
		else {
			System.out.println(wordOrSentence + " : is not Palindrome");
		}
		
		sc.close();
	}

	

}
