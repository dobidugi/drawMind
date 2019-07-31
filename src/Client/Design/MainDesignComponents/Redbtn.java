package Client.Design.MainDesignComponents;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import Client.Core.GameController;
import Client.Core.Socket.SendMessage;

public class Redbtn extends JButton{
	private Brush brush;
	public Redbtn(){
		setBounds(80, 415, 60, 40);
		setBackground(Color.RED);
	}
	private void makeEvent() {
		this.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(GameController.turnflag==true) {
					SendMessage.send.println("Color:RED");
					SendMessage.send.flush();
					brush.setColor(Color.RED);
				}
			}
		});
	}
	
	public void setBrush(Brush brush) {
		this.brush = brush;
		makeEvent();
	}

}
