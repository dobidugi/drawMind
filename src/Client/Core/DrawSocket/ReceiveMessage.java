package Client.Core.DrawSocket;

import Client.Design.Brush;

import java.net.Socket;

import java.awt.Color;
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
					brush.setX(x);
					brush.setY(y);
					brush.repaint();
					brush.printAll(imgbuff.getGraphics());
				}
				else if(pars[0].equals("Color")) {
					if(pars[1].equals("BLACK")) brush.setColor(Color.BLACK);
					else if(pars[1].equals("BLUE")) brush.setColor(Color.BLUE);
					else if(pars[1].equals("RED")) brush.setColor(Color.RED);
					else if(pars[1].equals("GREEN")) brush.setColor(Color.GREEN);
					else if(pars[1].equals("YELLOW")) brush.setColor(Color.YELLOW);
					else if(pars[1].equals("WHITE")) brush.setColor(Color.WHITE);
				}
				else if(pars[0].equals("MODE")) {
					if(pars[1].equals("CLEAR")) ClearScreen();
				}
				
			} catch(IOException e) {
				
			}
		}
	}
	
	private void ClearScreen() {
		brush.setFlag(false);
		brush.repaint();
		brush.printAll(imgbuff.getGraphics());
	}
	
	public void setBrush(Brush brush) {
		this.brush = brush;
	}
	
	public void setImgbuff(BufferedImage imgbuff) {
		this.imgbuff = imgbuff;
	}
}
