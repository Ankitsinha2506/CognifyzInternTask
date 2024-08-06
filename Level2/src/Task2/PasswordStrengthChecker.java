package Task2;

import java.util.Scanner;

public class PasswordStrengthChecker {
	
	
	
	private static String checkPasswordStrength(String password) {
		int lengthScore = checkLength(password);
		int upperScore = checkUpperCase(password);
		int lowerScore = checkLowerCase(password);
		int digitsScore = checkDigits(password);
		int SpecialCharScore = checkSpecialChar(password);
		
		int totalScore = lengthScore + upperScore + lowerScore + digitsScore + SpecialCharScore;
		
		 if (totalScore == 5) {
	            return "Very Strong";
	        } else if (totalScore >= 4) {
	            return "Strong";
	        } else if (totalScore >= 3) {
	            return "Moderate";
	        } else {
	            return "Weak";	
	        }
	}
	
	private static int checkSpecialChar(String password) {
		String specialChars = "@#$%^&*()-_+=<>?";
		
		for(char c : password.toCharArray()) {
			if(specialChars.indexOf(c)>=0) {
				return 1;
			}
		}
		return 0;
	}

	private static int checkDigits(String password) {
		for(char c : password.toCharArray()) {
			if(Character.isDigit(c)) {
				return 1;
			}
		}
		return 0;
	}

	private static int checkLowerCase(String password) {
		for(char c : password.toCharArray()) {
			if(Character.isLowerCase(c)) {
				return 1;
			}
		}
		return 0;
	}

	private static int checkUpperCase(String password) {
		for(char c : password.toCharArray()) {
			if(Character.isUpperCase(c)) {
				return 1;
			}
		}
		return 0;
	}

	private static int checkLength(String password) {
		// TODO Auto-generated method stub
		return password.length() >= 8 ? 1 : 0;
	}

	public static void main(String[] args) {
		try(Scanner sc = new Scanner(System.in)){
			System.out.println("Enter Your Password : ");
			String password = sc.nextLine();
			
			String strength = checkPasswordStrength(password);
			System.out.println("Password Strength : "+strength);
		}
	}

	

}
