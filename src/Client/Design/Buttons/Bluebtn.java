package Client.Design.Buttons;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import Client.Core.DrawSocket.SendMessage;
import Client.Design.Brush;

public class Bluebtn extends JButton {
	
	private Brush brush;
	
	public Bluebtn(){
		setBounds(270, 715, 120, 50);
		setBackground(Color.BLUE);
	}
	private void makeEvent() {
		this.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SendMessage.send.println("Color:BLUE");
				SendMessage.send.flush();
				brush.setColor(Color.BLUE);
			}
		});
	}
	
	public void setBrush(Brush brush) {
		this.brush = brush;
		makeEvent();
	}

}
