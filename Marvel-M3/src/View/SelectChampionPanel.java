package View;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import model.world.Champion;
import engine.Game;

public class SelectChampionPanel extends JPanel implements ActionListener {
	private Frame frame;
	private ArrayList<JButton> buttons;


	public SelectChampionPanel(Frame frame) {
		
		this.frame = frame;
		
		this.setLayout(new GridLayout(3, 3));
		buttons = new ArrayList<JButton>();
		JOptionPane.showMessageDialog(this, frame.getPlayerOneName()
				+ " please select your three Champions", "Choose",
				JOptionPane.PLAIN_MESSAGE);
		for (int i = 0; i < frame.getChampions().size(); i++) {
			JButton c = new JButton(new ImageIcon(frame.getChampions().get(i).getName()+".jpg"));
			c.setBackground(Color.WHITE);
			
			c.setFocusable(false);
			this.add(c);
			buttons.add(c);
			c.addActionListener(this);

		}

	}

	int k = 6;

	public void actionPerformed(ActionEvent e) {

		for (int i = 0; i < buttons.size(); i++) {

			Champion c = frame.getChampions().get(i);
			if (e.getSource() == buttons.get(i)) {
				int answer = JOptionPane.showConfirmDialog(null,
						frame.getChampionStats(i), c.getName() + "'s stats",
						JOptionPane.YES_NO_OPTION);

				if (answer == JOptionPane.YES_OPTION) {

					if (k > 0) {
						buttons.get(i).setEnabled(false);
						if (k > 3) {
							frame.getPlayer1Team().getTeam().add(c);

						}
						if (k == 4) {
							JOptionPane
									.showMessageDialog(
											this,
											frame.getPlayerTwoName()
													+ " please select your three Champions",
											"Choose", JOptionPane.PLAIN_MESSAGE);
							
						} else if (k <= 3){
							frame.getPlayer2Team().getTeam().add(c);
						}
						k--;
						 
					}
					if (k == 0){
						   frame.GoToSelectLeaderOnePanel(frame.getPlayer1Team());
						}
				
				} 
				
					
			}
		
		}
		}
}
