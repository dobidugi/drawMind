package Client.Design.Buttons;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import Client.Design.Brush;

public class Blackbtn extends JButton{
	private Brush brush;
	public Blackbtn(){
		setBounds(10, 715, 120, 50);
		setBackground(Color.BLACK);
	}
	private void makeEvent() {
		this.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("te");
				brush.setColor(Color.BLACK);
			}
		});
	}
	
	public void setBrush(Brush brush) {
		this.brush = brush;
		makeEvent();
	}
}
