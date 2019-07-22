package Client.Design.Buttons;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import Client.Design.Brush;

public class Greenbtn extends JButton {
	
	private Brush brush;
	
	public Greenbtn(){
		setBounds(400, 715, 120, 50);
		setBackground(Color.GREEN);
	}
	private void makeEvent() {
		this.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("GREEN");
				brush.setColor(Color.GREEN);
			}
		});
	}
	
	public void setBrush(Brush brush) {
		this.brush = brush;
		makeEvent();
	}
}

