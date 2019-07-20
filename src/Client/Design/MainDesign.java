package Client.Design;

import java.awt.image.BufferedImage;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.border.Border;
import javax.swing.BorderFactory;
import javax.swing.DefaultBoundedRangeModel;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JList;

import Client.Design.Brush;

public class MainDesign {
	private final int panelWidth = 900;  // 그림판 너비
	private final int panelHeight = 700; // 그림판 높이
	private JFrame frame;
	private BufferedImage imgbuff;
	private JLabel imgpanel;
	private Border imgborder;
	private Brush brush;
	private JButton blackbtn;
	private JButton redbtn;
	private JButton bluebtn;
	private JButton greenbtn;
	private JButton yellowbtn;
	private JButton eraserbtn;
	private JButton clearbtn;
	private JList Jlist;
	private DefaultListModel userlist; 
	
	public void makeFrame() {
		drawFrame();
		drawImgSection();
		makeBrush();
		makeMouseEvent();
		drawButtons();
		drawUserList();
		frame.repaint();
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
		imgbuff = new BufferedImage(panelWidth, panelHeight, BufferedImage.TYPE_INT_ARGB);
		imgpanel = new JLabel(new ImageIcon(imgbuff));
		imgborder = BorderFactory.createLineBorder(Color.BLACK, 3);
		imgpanel.setBounds(10, 10, panelWidth, panelHeight);
		imgpanel.setBorder(imgborder);
		frame.add(imgpanel);
	}

	private void makeBrush() {
		brush = new Brush();
		brush.setBounds(10, 10, panelWidth, panelHeight);
		frame.add(brush);
	}

	private void makeMouseEvent() {
		imgpanel.addMouseMotionListener(new MouseMotionListener() {
			@Override
			public void mouseDragged(MouseEvent e) {
				brush.setX(e.getX());
				brush.setY(e.getY());
				brush.repaint();
				brush.printAll(imgbuff.getGraphics());
			}

			public void mouseMoved(MouseEvent e) {

			}
		});
	}

	private void drawButtons() {
		makeBlackButton();
		makeRedButton();
		makeBlueButton();
		makeGreenButton();
		makeYellowButton();
		makeEraserButton();
		makeClearButton();
	}

	private void makeBlackButton() {
		drawBlackButton();
		BlackButtonEvent();
	}

	private void drawBlackButton() {
		blackbtn = new JButton();
		blackbtn.setBackground(Color.BLACK);
		blackbtn.setBounds(10, 715, 120, 50);
		frame.add(blackbtn);
	}

	private void BlackButtonEvent() {
		blackbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				brush.setColor(Color.BLACK);
			}
		});
	}

	private void makeRedButton() {
		drawRedButton();
		RedButtonEvent();
	}

	private void drawRedButton() {
		redbtn = new JButton();
		redbtn.setBackground(Color.red);
		redbtn.setBounds(140, 715, 120, 50);
		frame.add(redbtn);
	}

	private void RedButtonEvent() {
		redbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				brush.setColor(Color.RED);
			}
		});
	}

	private void makeBlueButton() {
		drawBlueButton();
		BlueButtonEvent();
	}

	private void drawBlueButton() {
		bluebtn = new JButton();
		bluebtn.setBackground(Color.BLUE);
		bluebtn.setBounds(270, 715, 120, 50);
		frame.add(bluebtn);
	}

	private void BlueButtonEvent() {
		bluebtn.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				brush.setColor(Color.blue);
			}
		});
	}

	private void makeGreenButton() {
		drawGreenButton();
		GreenButtonEvent();
	}

	private void drawGreenButton() {
		greenbtn = new JButton();
		greenbtn.setBackground(Color.GREEN);
		greenbtn.setBounds(400, 715, 120, 50);
		frame.add(greenbtn);
	}

	private void GreenButtonEvent() {
		greenbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				brush.setColor(Color.GREEN);
			}
		});
	}

	private void makeYellowButton() {
		drawYellowButton();
		YellowButtonEvent();
	}

	private void drawYellowButton() {
		yellowbtn = new JButton();
		yellowbtn.setBackground(Color.YELLOW);
		yellowbtn.setBounds(530, 715, 120, 50);
		frame.add(yellowbtn);
	}

	private void YellowButtonEvent() {
		yellowbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				brush.setColor(Color.YELLOW);
			}
		});
	}

	private void makeEraserButton() {
		drawEraserButton();
		EraserButtonEvent();
	}

	private void drawEraserButton() {
		eraserbtn = new JButton("지우개");
		eraserbtn.setBackground(Color.WHITE);
		eraserbtn.setBounds(660, 715, 120, 50);
		frame.add(eraserbtn);

	}

	private void EraserButtonEvent() {
		eraserbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				brush.setColor(Color.WHITE);
			}
		});
	}

	private void makeClearButton() {
		drawClearButton();
		ClearButtonEvent();
	}

	private void drawClearButton() {
		clearbtn = new JButton("전체 지우기");
		clearbtn.setBackground(Color.WHITE);
		clearbtn.setBounds(790, 715, 120, 50);
		frame.add(clearbtn);
	}

	private void ClearButtonEvent() {
		clearbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.remove(imgpanel);
				frame.remove(brush);
				drawImgSection();
				makeBrush();
				makeMouseEvent();
				frame.repaint();
			}
		});
	}
	
	private void drawUserList() {
		userlist = new DefaultListModel();
		Jlist= new JList(userlist);
		Jlist.setBounds(930,10,170,90);
		frame.add(Jlist);
	}
}
