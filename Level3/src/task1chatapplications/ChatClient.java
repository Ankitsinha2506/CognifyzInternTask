package task1chatapplications;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ChatClient {
	private static Socket socket;
	private static BufferedReader in;
	private static PrintWriter out;
	
	public static void main(String[] args) {
		String serverAddress = "localhost";
		int port = 3000;
		
		try{
			socket = new Socket(serverAddress, port);
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			out = new PrintWriter(socket.getOutputStream(), true);
			new Thread(new IncommingMessageHandler()).start();
			
			BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
			String input;
			while((input = userInput.readLine()) != null) {
				out.println(input);
				if ("exit".equalsIgnoreCase(input)) {
					break;
				}
			}
		}
		catch (IOException e) {
			System.err.println("Connection Error :"+ e.getMessage());
		} finally {
			try {
				socket.close();
				
			} catch (IOException e) {
				System.err.println("Error Closing Socket : "+ e.getMessage());
			}
		}
		
	}
	static class IncommingMessageHandler implements Runnable {
		@Override
		public void run() {
			try {
				String message;
				while((message = in.readLine()) != null) {
					System.out.println(message);
				}
				
			} catch (IOException e) {
				System.err.println("Error reading Message : "+e.getMessage());
			}
			
		}
		
	}

}


