package task1;

import java.util.Scanner;

public class TempConverter {
	// Method to convert Celsius to Fahrenheit.
	private static double celsiusToFarheneit(double celsius) {
		// TODO Auto-generated method stub
		
		return (celsius * 9/5) + 32;
	}
	
	// Method to Convert Fahrenheit to Celsius .
	private static double fahrenheitToCelsius(double fahrenheit) {
		// TODO Auto-generated method stub
		return (fahrenheit - 32) * 5/9;
	}

	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Temperature Converter");
		System.out.println("1. Celsius to Fahrenheit");
		System.out.println("2. Fahrenheit to Celsius");
		System.out.println("Choose any Options : (1 or 2)");
		int option = sc.nextInt();
		double inputTemp, convertedTemp;
		
		switch(option) {
		case 1:
			System.out.println("Enter Temperature in Celsius : ");
			inputTemp = sc.nextDouble();
			convertedTemp = celsiusToFarheneit(inputTemp);
			System.out.printf("%.2f Celsius is %.2f is Fahrenheit\n", inputTemp, convertedTemp);
			break;
			
		case 2:
			System.out.println("Enter Temperature in Fahrenheit : ");
			inputTemp = sc.nextDouble();
			convertedTemp = fahrenheitToCelsius(inputTemp);
			System.out.printf("%.2f is Fahrenheit %.2f Celsius is \n", inputTemp, convertedTemp);
			break;
			
		default:
			System.out.println("Invalid Options !!, Please choose correct Options !!");
		}
		
		sc.close();
	}

	
	

}
