package task1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientHandler implements Runnable {
	
	private Socket socket;
	private PrintWriter out;
	private BufferedReader in;

	public ClientHandler(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {
		try {
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			out = new PrintWriter(socket.getOutputStream(), true);
			
			String message;
			while((message = in.readLine()) != null) {
				System.out.println("Received : "+ message);
				ChatServer.broadcastMessage(message, this);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				socket.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}	
	}

	public void sendMessage(String message) {
		
		out.print(message);
		
	}

}
