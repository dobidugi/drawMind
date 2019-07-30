package Server.Design;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JScrollPane;
import javax.swing.JFrame;

import Server.Core.Socket.ServerController;

import Server.Design.MainDesignComponents.*;

public class MainDesign {
	
	private JFrame frame;
	private Startbtn startbtn;
	private ChatScreen screen;
	private JoinUserField joinfield;
	private ChatInputTextField inputfield;
	private JScrollPane scroll;
	
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
		scroll = new JScrollPane(screen, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scroll.setBounds(10,110,480,250);
		screen.setCaretPosition(screen.getDocument().getLength());
		frame.add(scroll);
	}
	
	private void drawInputField() {
		inputfield = new ChatInputTextField();
		frame.add(inputfield);
		inputfield.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					screen.append("[SERVER] "+inputfield.getText()+"\n");
					screen.setCaretPosition(screen.getDocument().getLength());
					for(int i=0;i<ServerController.List.size();i++) {
						ServerController.List.get(i).sendMessage("CHAT:[SERVER] "+inputfield.getText());
					}
					inputfield.setText("");
				}
			}

		});	
	}
	
	public ChatScreen getScreen() {
		return this.screen;
	}
	
	public JoinUserField getJoinField() {
		return this.joinfield;
	}
}
