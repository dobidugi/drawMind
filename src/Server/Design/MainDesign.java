package Server.Design;

import javax.swing.JFrame;

import Server.Design.MainDesignComponents.*;

public class MainDesign {
	
	private JFrame frame;
	private Startbtn startbtn;
	private ChatScreen screen;
	private JoinUserField joinfield;
	private ChatInputTextField inputfield;
	
	public void makeFrame() {
		drawFrame();
		drawStartButton();
		drawJoinField();
		drawScreen();
		drawInputField();
		frame.repaint();
	}
	
	private void drawFrame() {
		frame = new JFrame();
		frame.setSize(500, 500);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(null);
		frame.setVisible(true);
		frame.addWindowListener(new java.awt.event.WindowAdapter() {
		    @Override
		    public void windowClosing(java.awt.event.WindowEvent windowEvent) {
		        System.exit(0);
		    }
		});
	}
	
	private void drawStartButton() {
		startbtn = new Startbtn();
		frame.add(startbtn);
	}
	
	private void drawJoinField() {
		joinfield = new JoinUserField();
		frame.add(joinfield);
	}
	
	private void drawScreen() {
		screen = new ChatScreen();
		frame.add(screen);
	}
	
	private void drawInputField() {
		inputfield = new ChatInputTextField();
		frame.add(inputfield);
	}
	
	public ChatScreen getScreen() {
		return this.screen;
	}
	
	public JoinUserField getJoinField() {
		return this.joinfield;
	}
}
