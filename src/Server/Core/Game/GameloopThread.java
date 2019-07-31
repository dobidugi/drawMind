package Server.Core.Game;

import Server.Core.Socket.ServerController;

import javax.swing.JTextArea;

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
			GameController.allUserMsg("CHAT:[알림] " + GameController.ID +"님의 차례입니다.");
			screen.append("CHAT:[알림] " + GameController.ID +"님의 차례입니다.\n");
			ServerController.List.get(index).sendMessage("SET:TRUE");
			ServerController.List.get(index).sendMessage("CHAT:[알림] " + "당신차례입니다.");
			ServerController.List.get(index).sendMessage("CHAT:[알림] " + "정답은 " +  answer +" 입니다.");
			ServerController.List.get(index).sendMessage("CHAT:[알림] " + "정답을 잘 설명해보세요!!!");
			while(true) {
				if(GameController.answerflag == true) break;
				else {
					try {
						Thread.sleep(3000);
					} catch(InterruptedException e) {
						
					}
				}
			}
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
