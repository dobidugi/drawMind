package Client.Design;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JLabel;

class Brush extends JLabel {

	private int x;
	private int y;
	public Color color = Color.black;

	@Override
	public void paint(Graphics g) {
		System.out.print("d");
		Graphics2D g2 = (Graphics2D) g;
		g2.setBackground(Color.BLACK);
		g2.setColor(color);
		g2.fillOval(x - 10, y - 10, 10, 20);

	}
	
	public void setX(int x) {
		this.x = x;
	}
	
	public void setY(int y) {
		this.y = y;
	}
	
	public void setColor(Color color) {
		this.color = color;
	}
}