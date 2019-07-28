package Client.Core.sSocket;

import java.io.PrintWriter;
import java.io.IOException;

import java.net.Socket;

public class SendMessage extends Thread {
	
	private Socket Server;
	static public PrintWriter send;
	private String id;
	
	public void run() {
		super.run();
		makeSender();
		sendID();
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public void setSocket(Socket Server) {
		this.Server = Server;
	}
	
	private void makeSender() {
		try {
			send = new PrintWriter(Server.getOutputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void sendID() {
		send.println(id);
		send.flush();
	}
}
