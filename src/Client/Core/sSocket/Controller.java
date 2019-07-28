package Client.Core.sSocket;

import javax.swing.JTextArea;

import java.awt.image.BufferedImage;

import java.net.Socket;

import Client.Core.sSocket.SendMessage;
import Client.Design.Brush;

public class Controller {
	
	private Socket Server;
	private String ip=null;
	private int port=0;
	private SendMessage SendThread;
	private ReceiveMessage ReceiveThread;
	private Brush brush;
	private BufferedImage imgbuff;
	private JTextArea screen;
	
	public void start() {
		if(ip!=null && port!=0) {
			connectServer();
			//	makeThread();
		}
	}
	
	public void setIP(String ip) {
		this.ip = ip;
	}
	
	public void setPort(int port) {
		this.port = port;
	}
	
	private void connectServer() {
		try {
			Server = new Socket(ip,port);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void makeThread() {
		SendThread = new SendMessage();
		ReceiveThread = new ReceiveMessage();
		SendThread.setSocket(Server);
		ReceiveThread.setSocket(Server);
		ReceiveThread.setBrush(brush);
		ReceiveThread.setScreen(screen);
		ReceiveThread.setImgbuff(imgbuff);
		SendThread.start();
		ReceiveThread.start();
	}

	public void setScreen(JTextArea screen) {
		this.screen = screen;
	}
	
	public void setBrush(Brush brush) {
		this.brush = brush;
	}
	
	public void setImgbuff(BufferedImage imgbuff) {
		this.imgbuff = imgbuff;
		makeThread();
	}
}
