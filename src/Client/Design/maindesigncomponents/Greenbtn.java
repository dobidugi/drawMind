package Client.design.maindesigncomponents;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import Client.core.socket.SendMessage;
import Client.core.GameController;

public class Greenbtn extends JButton {
	
	private Brush brush;
	
	public Greenbtn(){
		setBounds(220, 415, 60, 40);
		setBackground(Color.GREEN);
	}
	private void makeEvent() {
		this.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(GameController.turnflag==true) {
					SendMessage.send.println("Color:GREEN");
					SendMessage.send.flush();
					brush.setColor(Color.GREEN);
				}
			}
		});
	}
	
	public void setBrush(Brush brush) {
		this.brush = brush;
		makeEvent();
	}
}

