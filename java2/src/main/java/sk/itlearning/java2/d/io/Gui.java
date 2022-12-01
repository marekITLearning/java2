package sk.itlearning.java2.d.io;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class Gui {

	public static void main(String[] args) {

		JFrame w = new JFrame("Moje Gui");
		w.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		w.setSize(300, 300);

		JPanel p = new JPanel();

		JButton b = new JButton("OK");

		JLabel l = new JLabel();
		l.setText("Here comes the result");

//		b.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				double objem = 4 / 3 * 3.14 * (0.5 * 0.5 * 0.5);
//				l.setText("Objem gule s priemerom 1m = " + objem);
//			}
//		});
		
		b.addActionListener(e -> {
			double objem = 4 / 3 * 3.14 * (0.5 * 0.5 * 0.5);
			l.setText("Objem gule s priemerom 1m = " + objem);			
		});

		p.add(b);
		p.add(l);

		w.add(p);

		w.setVisible(true);
	}

}
