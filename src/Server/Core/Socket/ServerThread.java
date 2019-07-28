package Server.Core.Socket;

import java.net.Socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.IOException;

public class ServerThread extends Thread {
	
	private Socket Client;
	private BufferedReader userin;
	private String msg;
	
	public void run() {
		super.run();
		makeUserInBuffer();
		waitMsg();
	}
	
	public void setSocket(Socket Client) {
		this.Client = Client;
	}
	
	private void makeUserInBuffer() {
		try {
			userin = new BufferedReader(new InputStreamReader(Client.getInputStream()));
		}	catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void waitMsg() {
		while(true) {
			try {
				msg = userin.readLine();
				System.out.print(msg);
				if(msg==null) {
					Client.close();
					break;
				}
				allUserSendMsg();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	private void allUserSendMsg() {
		for(int i=0;i<ServerController.List.size();i++){
			ServerController.List.get(i).println(msg);
			ServerController.List.get(i).flush();
		}
	}
}
