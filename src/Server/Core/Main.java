package Server.Core;

import Server.Core.ChatSocket.chatServerController;
import Server.Core.Socket.ServerController;

public class Main {
	static public void main(String[] args) {
		ServerController drawserver = new ServerController();
		chatServerController chatserver = new chatServerController();
		drawserver.setPort(8888);
		drawserver.start();
	}
}
