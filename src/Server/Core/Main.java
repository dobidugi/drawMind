package Server.Core;

import Server.Core.Socket.ServerController;

public class Main {
	static public void main(String[] args) {
		ServerController drawserver = new ServerController();
		drawserver.setPort(8888);
		drawserver.start();
	}
}
