package Server.Core.DrawSocket;

import java.net.ServerSocket;
import java.net.Socket;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import Server.Core.DrawSocket.ServerThread;

public class ServerController {
	
	private int port = 0;
	private ServerSocket Server;
	private Socket Client;
	public static ArrayList<PrintWriter> List;
	
	public void start() {
		if (port != 0) {
			List = new ArrayList<PrintWriter>();
			makeServerSocket();
			makeClientSocket();
			acceptClient();
		} else
			System.out.println("set server port");
	}

	public void setPort(int port) {
		this.port = port;
	}

	private void makeServerSocket() {
		try {
			Server = new ServerSocket(port);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void makeClientSocket() {
		Client = new Socket();
	}

	private void acceptClient() {
		while (true) {
			try {
				Client = Server.accept();
				ServerThread th = new ServerThread();
				th.setSocket(Client);
				List.add(new PrintWriter(Client.getOutputStream()));
				th.start();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
