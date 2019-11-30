package Server.core.game;

import javax.swing.JTextArea;

import Server.core.socket.ServerController;

public class GameloopThread extends Thread {

	private JTextArea screen;
	
	@Override
	public void run() {
		super.run();
		Game game = new Game();
		String answer;
		int index = 0;
		game.start();
		GameController.firstStart();
		while(game.hasMoreAnswer()) {
			answer = game.getAnswer();
			GameController.answer = answer;
			System.out.println(answer);
			GameController.gameflag = true;
			GameController.answerflag = false;
			GameController.ID = ServerController.List.get(index).getUserID();
			GameController.allUserMsg("CHAT:[알림] " + GameController.ID +"user turn.");
			screen.append("[알림�] " + GameController.ID +"user turn.\n");
			ServerController.List.get(index).sendMessage("SET:TRUE");
			ServerController.List.get(index).sendMessage("CHAT:[알림] " + "당신차례입니다.");
			ServerController.List.get(index).sendMessage("CHAT:[알림] " + "정답은  " +  answer +" 입니다.");
			ServerController.List.get(index).sendMessage("CHAT:[알림] " + "정답을 잘 설명해보세요!!!");
			ServerController.List.get(index).sendMessage("ANSWER:"+answer);
			while(true) {
				if(GameController.answerflag == true) break;
				else {
					try {
						Thread.sleep(3000);
					} catch(InterruptedException e) {
						
					}
				}
			}
			ServerController.List.get(index).sendMessage("ANSWER:"+" ");
			GameController.allUserPermissionFalse();
			++index;
			if(index == ServerController.List.size()) {
				index = 0;
			}
		}
	}
	
	public void setScreen(JTextArea screen) {
		this.screen = screen;
	}
}
