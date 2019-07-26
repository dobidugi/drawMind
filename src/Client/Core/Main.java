package Client.Core;

import Client.Design.MainDesign;
import Client.Core.DrawSocket.Controller;

public class Main {
	static public void main(String[] args) {
		Controller drawSocket = new Controller();
		drawSocket.setIP("127.0.0.1");
		drawSocket.setPort(8888);
		drawSocket.start();
		MainDesign design = new MainDesign();
		design.makeFrame();
		drawSocket.setBrush(design.getBrush());
		drawSocket.setImgbuff(design.getImgbuff());
	}
}
