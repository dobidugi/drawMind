package Client;

import Client.core.socket.Controller;
import Client.design.MainDesign;
import Client.design.initDesign;

public class Main {
	static public void main(String[] args) {
		String id=null,ip=null;	
		Controller Socket = new Controller();
		MainDesign design = new MainDesign();
		initDesign init = new initDesign();
		init.makeFrame();
		do {
			id = init.getID();
			ip = init.getIP();
			System.out.println("");
		}while(id==null || ip==null);
		Socket.setIP(ip);
		Socket.setPort(8888);
		Socket.setId(id);
		design.makeFrame();
		Socket.start();		
		Socket.setAnswerField(design.getAnswerField());
		Socket.setScreen(design.getScreen());
		Socket.setBrush(design.getBrush());
		Socket.setImgbuff(design.getImgbuff());
	}
}
