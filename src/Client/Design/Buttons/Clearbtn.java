package Client.Design.Buttons;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import Client.Design.Brush;

public class Clearbtn extends JButton {
	
	private Brush brush;
	
	public Clearbtn(){
		super("전체 지우기");
		setBounds(660, 715, 120, 50);
		setBackground(Color.WHITE);
	}
	private void makeEvent() {
		this.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Clear");
				brush.setColor(Color.WHITE);
			}
		});
	}
	
	public void setBrush(Brush brush) {
		this.brush = brush;
		makeEvent();
	}
}