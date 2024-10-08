package Task3;

import java.util.Scanner;

public class StudentGradeCalculator {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Entet the Number of Grades to be Enteted : ");
		int numGrades = sc.nextInt();
		
		// Create an array to store the Grades.
		double[] grades = new double[numGrades];
		
		// Prompt the user to enter grades.
		for(int i=0; i<numGrades; i++)
		{
			System.out.println("Enter Grade " + (i+1) + " : ");
			grades[i] = sc.nextDouble();
		}
		
		// Calculate the Average Grade .
		double sum = 0;
		for(double grade : grades)
		{
			sum += grade;
		}
		
		double average = sum / numGrades;
		
		// Display the Average Grades.
		System.out.println("The Average Grade is : "+average);
		
		sc.close();
	}

}
