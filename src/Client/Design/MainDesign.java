package Client.Design;

import java.awt.image.BufferedImage;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
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
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import Client.Core.GameController;
import Client.Core.Socket.SendMessage;
import Client.Design.MainDesignComponents.Brush;
import Client.Design.MainDesignComponents.Colorbtns;

public class MainDesign {

	private final int panelWidth = 900; // 그림판 너비
	private final int panelHeight = 700; // 그림판 높이
	private JFrame frame;
	private BufferedImage imgbuff;
	private JLabel imgpanel;
	private Brush brush;
	private JButton clearbtn;
	private JTextField answerfield;
	private JTextArea screen;
	private JTextField input;
	private Colorbtns btns;

	public void makeFrame() {
		drawFrame();
		drawImgSection();
		makeBrush();
		makeMouseEvent();
		drawButtons();
		drawAnswerField();
		drawChat();
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
		imgpanel.setBounds(10, 10, panelWidth, panelHeight);
		imgpanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
		frame.add(imgpanel);
	}

	private void makeBrush() {
		brush = new Brush();
		brush.setBounds(10, 10, panelWidth, panelHeight);
		brush.repaint();
		brush.printAll(imgbuff.getGraphics());
		frame.add(brush);
	}

	private void makeMouseEvent() {
		imgpanel.addMouseMotionListener(new MouseMotionListener() {
			@Override
			public void mouseDragged(MouseEvent e) {
				if(GameController.turnflag==true) {
					SendMessage.send.println("Position:" + e.getX() + "," + e.getY());
					SendMessage.send.flush();
				}
			}

			public void mouseMoved(MouseEvent e) {

			}
		});
	}

	private void drawButtons() {
		btns = new Colorbtns();
		btns.setBrush(brush);
		btns.makeButtons();
		frame.add(btns.blackbtn());
		frame.add(btns.redbtn());
		frame.add(btns.bluebtn());
		frame.add(btns.greenbtn());
		frame.add(btns.yellowbtn());
		frame.add(btns.eraserbtn());
		makeClearButton();
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
				if(GameController.turnflag==true) {
					SendMessage.send.println("MODE:CLEAR");
					SendMessage.send.flush();
				}
			}
		});
	}

	private void drawAnswerField() {
		answerfield = new JTextField();
		Border listBorder = BorderFactory.createLineBorder(Color.BLACK, 3);
		answerfield.setBorder(listBorder);
		answerfield.setBounds(930, 10, 250, 90);
		frame.add(answerfield);
	}

	private void drawChat() {
		drawScreen();
		drawInputText();
	}

	private void drawScreen() {
		screen = new JTextArea();
		JScrollPane scroll = new JScrollPane(screen);
		scroll.setBounds(930, 150, 250, 560);
		Border screenborder = BorderFactory.createLineBorder(Color.BLACK, 3);
		screen.setEnabled(false);
		screen.setDisabledTextColor(Color.BLACK);
		screen.setFont(screen.getFont().deriveFont(16f));
		screen.setBorder(screenborder);
		screen.setCaretPosition(screen.getDocument().getLength());
		frame.add(scroll);
	}

	private void drawInputText() {
		input = new JTextField();
		input.setBounds(930, 710, 250, 30);
		Border inputborder = BorderFactory.createLineBorder(Color.BLACK, 3);
		input.setBorder(inputborder);
		input.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					SendMessage.send.println("CHAT:" + input.getText());
					SendMessage.send.flush();
					input.setText("");
				}
			}

		});	
		frame.add(input);
	}

	public Brush getBrush() {
		return this.brush;
	}

	public BufferedImage getImgbuff() {
		return this.imgbuff;
	}

	public JTextArea getScreen() {
		return this.screen;
	}
}