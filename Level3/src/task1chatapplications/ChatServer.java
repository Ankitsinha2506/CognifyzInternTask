package task1chatapplications;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashSet;
import java.util.Set;

public class ChatServer {
	private static Set<Socket> clientSockets = new HashSet<>();
	static Set<String> clientNames = new HashSet<>();
	
	public static void main(String[] args) {
		int port = 3000;
		try(ServerSocket serverSocket =  new ServerSocket(port)){
			System.out.println("Chat Server Started on Port : "+ port);
			
			while(true) {
				Socket clientSocket = serverSocket.accept();
				synchronized (clientSockets) {
					clientSockets.add(clientSocket);
				}
				new ClientHandler(clientSocket).start();
			}
			
		} catch (IOException e) {
			System.err.println("Error Starting Server : "+ e.getMessage());
		}
	}
	
	static void broadcastMessage(String message, Socket senderSocket) {
		synchronized (clientSockets) {
			for (Socket socket : clientSockets) {
				if(socket != senderSocket) {
					try {
						PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
						out.print(message);
					} catch (IOException e) {
						System.err.println("Error Sending Message : "+ e.getMessage());
					}
				}
			}
		}
	}
	
	static void removeClient(Socket clienSocket) {
		synchronized (clientSockets) {
			clientSockets.remove(clienSocket);
		}
	}
}

class ClientHandler extends Thread{
	private Socket clientSocket;
	private String clientName;

	public ClientHandler(Socket socket) {
		this.clientSocket = socket;
	}
	@Override
	public void run() {
		try(BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
		PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true)) {
			out.println("Enter Your Name: ");
			clientName = in.readLine();
			synchronized (ChatServer.clientNames) {
				if(clientName != null && !ChatServer.clientNames.contains(clientName)) {
					ChatServer.clientNames.add(clientName);
					ChatServer.broadcastMessage(clientName + " has Join the Chats", clientSocket);
				} else {
					out.println("Name is Already taken or invalid. Try Again..!!");
					clientSocket.close();
					return;
				}
				
			}
			
			String message;
			while((message=in.readLine()) != null) {
				if("exit".equalsIgnoreCase(message)) {
					ChatServer.broadcastMessage(clientName + " has left the chat", clientSocket);
					break;
				}
				ChatServer.broadcastMessage(clientName+ " : " + message , clientSocket);
			}
			
		} catch (IOException e) {
			System.err.println("Client Connection Error: "+ e.getMessage());
		} finally {
			try {
				clientSocket.close();
			} catch (Exception e) {
				System.err.println("Error closing Socket: "+ e.getMessage());
			}
			ChatServer.removeClient(clientSocket);
		}
	}
	
}
