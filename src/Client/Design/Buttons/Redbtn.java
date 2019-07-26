package Client.Design.Buttons;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import Client.Core.DrawSocket.SendMessage;
import Client.Design.Brush;

public class Redbtn extends JButton{
	private Brush brush;
	public Redbtn(){
		setBounds(140, 715, 120, 50);
		setBackground(Color.RED);
	}
	private void makeEvent() {
		this.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SendMessage.send.println("Color:RED");
				SendMessage.send.flush();
				brush.setColor(Color.RED);
			}
		});
	}
	
	public void setBrush(Brush brush) {
		this.brush = brush;
		makeEvent();
	}

}
