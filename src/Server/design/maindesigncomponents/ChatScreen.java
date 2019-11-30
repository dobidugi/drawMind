package Server.design.maindesigncomponents;

import javax.swing.JTextArea;
import javax.swing.border.Border;
import javax.swing.BorderFactory;

import java.awt.Color;

public class ChatScreen extends JTextArea {
	
	public ChatScreen(){
		setBounds(10,110,480,250);
		setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
		setEnabled(false);
		this.setDisabledTextColor(Color.BLACK);
	}
}
