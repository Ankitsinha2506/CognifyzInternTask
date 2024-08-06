package Task3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class EncryptionDecryption {
	
	private static final int SHIFT = 3;
	
	private static void processFile(String inputFilePath, String outputFilePath, boolean encrypt) throws IOException {
		File inputFile = new File(inputFilePath);
		if(!inputFile.exists()) {
			System.out.println("Error :  Input file does not exists..!!");
			return;
		}else 
		{
			try(
				BufferedReader reader = new BufferedReader(new FileReader(new File(inputFilePath)));
				BufferedWriter writer = new BufferedWriter(new FileWriter(new File(	outputFilePath)));
			)
			{
				String line;
				while ((line = reader.readLine()) != null) {
					String processedLine = encrypt ? encryptLine(line) : decryptLine(line);
					writer.write(processedLine);
					writer.newLine();
				}
			}
		}
		
		
	}
	
	private static String encryptLine(String line) {
		StringBuilder encrypted = new StringBuilder();
		for(char c : line.toCharArray()) {
			if(Character.isLetter(c)) {
				char shifted = (char) (c + SHIFT);
				if(Character.isLowerCase(c) && shifted > 'z' || Character.isUpperCase(c) && shifted > 'Z') {
					shifted -= 26;
				}
				encrypted.append(shifted);
			}
			else {
				encrypted.append(c);
			}
		}
		return encrypted.toString();
	}
	
	
	private static String decryptLine(String line) {
		StringBuilder decrypted = new StringBuilder();
		for(char c : line.toCharArray()) {
			if(Character.isLetter(c)) {
				char shifted = (char) (c - SHIFT);
				if(Character.isLowerCase(c) && shifted < 'a' || Character.isUpperCase(c) && shifted < 'A') {
					shifted += 26;
				}
				decrypted.append(shifted);
			}
			else {
				decrypted.append(c);
			}
		}
		
		return decrypted.toString();
	}
	
	
	public static void main(String[] args) {
		try(Scanner sc = new Scanner(System.in)){
			System.out.println("Do you Want to encrypt or decrypt the file ? (enter 'encrypt' or 'decrypt'): ");
			String choice = sc.nextLine().trim().toLowerCase();
			
			System.out.println("Enter the input file path :");
			String inputFilePath = sc.nextLine().trim();
			
			System.out.println("Enter the Output file path : ");
			String outputFilePath = sc.nextLine().trim();
			
			if (choice.equals("encrypt")) {
				processFile(inputFilePath, outputFilePath, true);
				System.out.println("File Encrypted Successfully..!!");
			}
			else if(choice.equals("decrypt")) {
				processFile(inputFilePath, outputFilePath, 	false);
				System.out.println("File Decrypted Successfully...!!");
			}
			else {
				System.out.println("Invalid Choice, Please enter 'encrypt' or 'decrypt') :");
			}
		}
		catch (IOException e) {
			System.out.println("An Error Occurred : " + e.getMessage());
		}
		
	}

	

}
