package Server.Core.Socket;

import java.net.Socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.IOException;

import javax.swing.JTextArea;
import javax.swing.JTextField;

import Server.Core.User;

public class ServerThread extends Thread {
	
	private User user;
	private Socket Client;
	private BufferedReader userin;
	private String msg;
	private String ID;
	private JTextArea screen;
	private JTextField join;
	
	public void run() {
		super.run();
		setClient();
		makeUserInBuffer();
		joinchat();
		waitMsg();
	}
	
	public void setUser(User user) {
		this.user = user;
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
				if(msg==null) {
					msg ="CHAT:"+ID+" out the room.";
					allUserSendMsg();
					Client.close();
					ServerController.List.remove(user);
					JoinFieldUpdate();
					break;
				}
				String[] pars = msg.split(":");
				if(pars[0].equals("CHAT")) {
					msg = "CHAT:"+ "["+ID+"] "+pars[1];
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
			user.setUserID(ID);
			JoinFieldUpdate();
			screen.append(ID+" join the room\n");
		} catch(IOException e) {
			
		}
		for(int i=0;i<ServerController.List.size();i++){
			ServerController.List.get(i).sendMessage("JOIN:"+ID);
		}
	}
	private void allUserSendMsg() {
		for(int i=0;i<ServerController.List.size();i++){
			ServerController.List.get(i).sendMessage(msg);
		}
		String pars[] = msg.split(":");
		screen.append(pars[1]+"\n");
	}
	
	
	private void JoinFieldUpdate() {
		String str = new String();
		str = "접속유저 : ";
		for(int i=0;i<ServerController.List.size();i++) {
			str+= ServerController.List.get(i).getUserID()+" ";
		}
		join.setText(str);;
	}
	
	private void setClient() {
		this.Client = user.getClient();
	}
	
	public void setScreen(JTextArea screen) {
		this.screen = screen;
	}
	
	public void setJoinField(JTextField join) {
		this.join = join;
	}
}
