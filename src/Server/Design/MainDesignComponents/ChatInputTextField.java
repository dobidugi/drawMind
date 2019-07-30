package Server.Design.MainDesignComponents;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JTextField;

public class ChatInputTextField extends JTextField {
	public ChatInputTextField() {
		setBounds(10,360,480,30);
		setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
	}
}
