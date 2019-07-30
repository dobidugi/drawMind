package Server.Core.Socket;

import java.net.ServerSocket;
import java.net.Socket;

import java.io.IOException;
import java.io.PrintWriter;

import java.util.ArrayList;

import Server.Core.User;

import Server.Core.Socket.ServerThread;

import javax.swing.JTextField;
import javax.swing.JTextArea;

public class ServerController {
	
	private int port = 0;
	private ServerSocket Server;
	private Socket Client;
	private User user;
	public static ArrayList<User> List;
	private JTextArea screen;
	private JTextField join;
	
	public void start() {
		if (port != 0) {
			List = new ArrayList<User>();
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
				user = new User();
				user.setSocket(Client);
				user.makeWriter();
				th.setUser(user);
				th.setJoinField(join);
				th.setScreen(screen);
				List.add(user);
				th.start();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void setScreen(JTextArea screen) {
		this.screen = screen;
	}
	
	public void setJoinField(JTextField join) {
		this.join = join;
	}
}
