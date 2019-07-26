package Client.Core.DrawSocket;

import Client.Design.Brush;

import java.net.Socket;

import java.awt.image.BufferedImage;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;


public class ReceiveMessage extends Thread {
	
	private Socket Server;
	private BufferedReader msgbuff;
	private String msg;
	private Brush brush;
	private BufferedImage imgbuff;
	private int x,y;
	
	public void run() {
		super.run();
		makeMsgBuff();
		getMsg();
	}

	public void setSocket(Socket Server) {
		this.Server = Server;
	}
	
	private void makeMsgBuff() {
		try {
			msgbuff = new BufferedReader(new InputStreamReader(Server.getInputStream()));
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	private void getMsg() {
		while(true) {
			try {
				msg = msgbuff.readLine();
				String[] pars = msg.split(":");
				if(pars[0].equals("Position")) {
					pars = pars[1].split(",");
					x = Integer.parseInt(pars[0]);
					y = Integer.parseInt(pars[1]);
					if(brush==null) System.out.print("null");
					brush.setX(x);
					brush.setY(y);
					brush.repaint();
					brush.printAll(imgbuff.getGraphics());
				}
			} catch(IOException e) {
				
			}
		}
	}
	
	public void setBrush(Brush brush) {
		this.brush = brush;
	}
	
	public void setImgbuff(BufferedImage imgbuff) {
		this.imgbuff = imgbuff;
	}
}
