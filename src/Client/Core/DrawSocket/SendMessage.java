package Client.Core.DrawSocket;

import java.io.PrintWriter;
import java.io.IOException;

import java.net.Socket;

public class SendMessage extends Thread {
	
	private Socket Server;
	static public PrintWriter send;
	
	public void run() {
		super.run();
		makeSender();
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
	
}
