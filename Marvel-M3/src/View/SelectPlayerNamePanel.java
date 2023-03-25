package View;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SelectPlayerNamePanel extends JPanel implements ActionListener {
	private Frame frame;
	private JButton button;
	private JLabel label1;
	private JLabel label2;
	private JTextField field1;
	private JTextField field2;
	private JLabel background;

	public SelectPlayerNamePanel(Frame frame) {
		this.frame = frame;
		this.setLayout(null);

		button = new JButton("Next");
		button.setBounds(500, 500, 300, 50);
		button.setForeground(Color.DARK_GRAY);
		button.setBackground(Color.WHITE);
		button.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 30));
		this.add(button);
		button.addActionListener(this);

		label1 = new JLabel("Player's 1 name");
		label1.setBounds(100, 100, 500, 100);
		label1.setForeground(Color.darkGray);
		label1.setBackground(Color.WHITE);
		label1.setFont(new Font("Dialog", Font.BOLD| Font.ROMAN_BASELINE, 30));
		this.add(label1);

		label2 = new JLabel("Player's 2 name");
		label2.setBounds(100, 200, 500, 100);
		label2.setForeground(Color.darkGray);
		label2.setBackground(Color.WHITE);
		label2.setFont(new Font("Dialog", Font.BOLD | Font.ROMAN_BASELINE, 30));
		this.add(label2);

		field1 = new JTextField();
		field1.setBounds(350, 120, 300, 50);
		this.add(field1);

		field2 = new JTextField();
		field2.setBounds(350, 240, 300, 50);
		this.add(field2);
		ImageIcon image = new ImageIcon("mmm.jpg");
		background = new JLabel("", image, JLabel.CENTER);
		background.setBounds(0, 0, 1400, 800);
		this.add(background);

	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == button) {
			if (field1.getText().equals("")) {
				JOptionPane.showMessageDialog(this,
						"Player 1 please eneter your name", "error",
						JOptionPane.ERROR_MESSAGE);
			}

			else if (field2.getText().equals("")) {
				JOptionPane.showMessageDialog(this,
						"Player 2 please eneter your name", "error",
						JOptionPane.ERROR_MESSAGE);
			} else {
				frame.GoToSelectChampionPanel(field1.getText(),
						field2.getText());
			}

		}
	}
}
