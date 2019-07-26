package Server.Core;

import Server.Core.DrawSocket.ServerController;

public class Main {
	static public void main(String[] args) {
		ServerController server = new ServerController();
		server.setPort(8888);
		server.start();
	}
}
