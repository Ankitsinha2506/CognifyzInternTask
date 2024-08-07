package task1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ChatClient 
{
	private static final String SERVER_ADDRESS = "localhost";
	private static final int SERVER_PORT = 3001;
	
	
	public static void main(String[] args) 
	{
		try (Socket socket = new Socket(SERVER_ADDRESS, SERVER_PORT);
	             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
	             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
	             BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in)))
		{
			System.out.println("Connected to chat server");
			Thread readThread = new Thread(() -> {
                String message;
                try {
                    while ((message = in.readLine()) != null) {
                        System.out.println("Server: " + message);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
			 readThread.start();
			 
			 String userInput;
	            while ((userInput = stdIn.readLine()) != null) 
	            {
	                out.println(userInput);
	            }
		} 
		catch (Exception e) {
            e.printStackTrace();
        }	
				
	}

}
