package Server.core.game;

import Server.core.socket.ServerController;

public class GameController {
	static public String answer;
	static public boolean answerflag = false;
	static public boolean gameflag = false;
	static public String ID;
	static public void firstStart() {
		for (int i = 0; i < ServerController.List.size(); i++) {
			ServerController.List.get(i).sendMessage("CHAT:[SERVER] " + "게임을 시작합니다.");
			ServerController.List.get(i).sendMessage("SET:FALSE");
			ServerController.List.get(i).sendMessage("MODE:CLEAR");
			
		}
	}
	
	static public void allUserPermissionFalse() {
		for (int i = 0; i < ServerController.List.size(); i++) {
			ServerController.List.get(i).sendMessage("SET:FALSE");
			ServerController.List.get(i).sendMessage("MODE:CLEAR");
		}
	}
	
	static public void rightAnswer(String id) {
		answerflag = true;
		answer = "aaaaaaaaaaa";
		for (int i = 0; i < ServerController.List.size(); i++) {
			ServerController.List.get(i).sendMessage("CHAT:[알림] " + id +" 님이 맞추셨습니다.");
		}
	}
	
	static public void allUserMsg(String msg) {
		for (int i = 0; i < ServerController.List.size(); i++) {
			ServerController.List.get(i).sendMessage(msg);
		}
	}
}
