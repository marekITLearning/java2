package sk.itlearning.java2.a.db;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class SimpleGui {

	public static void main(String[] args) {

		JFrame jf = new JFrame("My App");
		jf.setBounds(300, 300, 300,300);
		jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		
		JButton button = new JButton("Click me");
		
		button.addActionListener(e -> button.setText(button.getText() + "X"));
		
		panel.add(button);
		
		jf.setContentPane(panel);
		
		jf.setVisible(true);
		
		
		
	}

}
