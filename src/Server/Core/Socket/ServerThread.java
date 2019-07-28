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
	private String ID;
	public void run() {
		super.run();
		makeUserInBuffer();
		joinchat();
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
				String[] pars = msg.split(":");
				if(pars[0].equals("CHAT")) {
					msg = "CHAT:"+ "["+ID+"] "+pars[1];
				}
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
	
	private void joinchat() {
		try {
			ID = userin.readLine();
		} catch(IOException e) {
			
		}
		for(int i=0;i<ServerController.List.size();i++){
			
			ServerController.List.get(i).println("JOIN:"+ID);
			ServerController.List.get(i).flush();
		}
	}
	private void allUserSendMsg() {
		System.out.println(msg);
		System.out.println(ServerController.List.size());
		for(int i=0;i<ServerController.List.size();i++){
			ServerController.List.get(i).println(msg);
			ServerController.List.get(i).flush();
		}
	}
}
