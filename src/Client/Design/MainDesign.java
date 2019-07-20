package Client.Design;

import java.awt.image.BufferedImage;
import java.awt.Color;

import javax.swing.border.Border;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MainDesign {
	private JFrame frame;
	private BufferedImage imgbuff;
	private JLabel img;
	private Border imgborder;
	
	public void makeFrame() {
		drawFrame();
		drawImgSection();
	}
	
	private void drawFrame() {
		frame = new JFrame();
		frame.setSize(1200, 800);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(null);
		frame.setVisible(true);
	}
	
	private void drawImgSection() {
		imgbuff = new BufferedImage(850,700,BufferedImage.TYPE_INT_ARGB);
		img = new JLabel(new ImageIcon(imgbuff));
		imgborder = BorderFactory.createLineBorder(Color.BLACK,3);
		img.setBounds(10,10,850,700);
		img.setBorder(imgborder);
		frame.add(img);
	}
}
