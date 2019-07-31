package Server.Core.Socket;

import java.net.Socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.swing.JTextArea;
import javax.swing.JTextField;

import Server.Core.User;
import Server.Core.Game.GameController;

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
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void waitMsg() {
		while (true) {
			try {
				msg = userin.readLine();
				if (msg == null) {
					msg = "CHAT:" + ID + " out the room.";
					allUserSendMsg();
					Client.close();
					ServerController.List.remove(user);
					JoinFieldUpdate();
					break;
				}
				if (msg.contains("CHAT:")) {
					msg += " "; // 아무것도 입력하지않고 엔터눌렀을시 멈춤방지
					String[] pars = msg.split(":");
					System.out.println(pars[1]);
					if(pars[1].equals(GameController.answer+" ") && GameController.answerflag == false && (!(this.ID).equals(GameController.ID))) {
						GameController.answerflag = true;
						GameController.rightAnswer(ID);
					}
					if (pars[0].equals("CHAT")) {
						pars[1] += " ";
						msg = "CHAT:" + "[" + ID + "] " + pars[1];
					}
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
			screen.append(ID + " join the room\n");
		} catch (IOException e) {

		}
		for (int i = 0; i < ServerController.List.size(); i++) {
			ServerController.List.get(i).sendMessage("JOIN:" + ID);
		}
	}

	private void allUserSendMsg() {
		for (int i = 0; i < ServerController.List.size(); i++) {
			ServerController.List.get(i).sendMessage(msg);
		}
		if (msg.contains("CHAT:")) {
			String pars[] = msg.split(":");
			screen.append(pars[1] + "\n");
			screen.setCaretPosition(screen.getDocument().getLength());
		}
	}

	private void JoinFieldUpdate() {
		String str = new String();
		str = "접속유저 : ";
		for (int i = 0; i < ServerController.List.size(); i++) {
			str += ServerController.List.get(i).getUserID() + " ";
		}
		join.setText(str);
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
