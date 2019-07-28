package Client.Design.Buttons;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import Client.Core.sSocket.SendMessage;
import Client.Design.Brush;

public class Eraserbtn extends JButton {
	
	private Brush brush;
	
	public Eraserbtn(){
		super("지우개");
		setBounds(660, 715, 120, 50);
		setBackground(Color.WHITE);
	}
	private void makeEvent() {
		this.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SendMessage.send.println("Color:WHITE");
				SendMessage.send.flush();
				brush.setColor(Color.WHITE);
			}
		});
	}
	
	public void setBrush(Brush brush) {
		this.brush = brush;
		makeEvent();
	}
}