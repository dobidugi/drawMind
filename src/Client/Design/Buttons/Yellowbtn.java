package Client.Design.Buttons;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import Client.Core.Socket.SendMessage;
import Client.Design.Brush;

public class Yellowbtn extends JButton {
	
	private Brush brush;
	
	public Yellowbtn(){
		setBounds(530, 715, 120, 50);
		setBackground(Color.YELLOW);
	}
	private void makeEvent() {
		this.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SendMessage.send.println("Color:YELLOW");
				SendMessage.send.flush();
				brush.setColor(Color.YELLOW);
			}
		});
	}
	
	public void setBrush(Brush brush) {
		this.brush = brush;
		makeEvent();
	}
}