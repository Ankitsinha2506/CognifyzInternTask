package task1;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ChatServer {
	
	private static final int PORT = 3001;
	private static List<ClientHandler> clients = new ArrayList<>();
	
	public static void broadcastMessage(String message, ClientHandler excludeUser) {
		for(ClientHandler client : clients) {
			if(client != excludeUser) {
				client.sendMessage(message);
			}
		}
	}
	
	public static void main(String[] args) {
		System.out.println("Chat Server Started........!!!");
		try(ServerSocket serverSocket = new ServerSocket(PORT))
		{
			while(true) {
				Socket socket = serverSocket.accept();
				System.out.println("New Client Connected...!!");
				ClientHandler clientHandler = new ClientHandler(socket);
				clients.add(clientHandler);
				new Thread(clientHandler).start();	
			}
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
