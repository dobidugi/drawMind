package Server.Core;

import java.io.IOException;
import java.io.PrintWriter;

import java.net.Socket;

public class User {
	
	private Socket Client;
	private PrintWriter send;
	private String id;
	
	public void setSocket(Socket Client) {
		this.Client = Client;
	}
	
	public void makeWriter() {
		try {
			send = new PrintWriter(Client.getOutputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void sendMessage(String msg) {
		send.println(msg);
		send.flush();
	}
	
	public Socket getClient() {
		return this.Client;
	}
	
	public void setUserID(String id) {
		this.id = id;
	}
	
	public String getUserID() {
		return this.id;
	}
}
