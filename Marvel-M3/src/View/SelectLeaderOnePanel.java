 package View;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

import model.world.Champion;

public class SelectLeaderOnePanel extends JPanel implements ActionListener {
	
	
	private Frame frame;
	private ArrayList<JButton> buttons1;
	
	public SelectLeaderOnePanel(Frame frame){
		this.frame=frame;
		this.setLayout(new GridLayout(3,1));
		
		
		
		JOptionPane.showMessageDialog(this, frame.getPlayerOneName()
				+ " please select your Leader", "Choose",
				JOptionPane.PLAIN_MESSAGE);
		
		buttons1 = new ArrayList<JButton>();
		
		for(int i=0;i<frame.getPlayer1Team().getTeam().size();i++){
			JButton c1 =  new JButton(new ImageIcon(frame.getPlayer1Team().getTeam().get(i).getName()+".jpg"));
			c1.setBackground(Color.WHITE);
			c1.setFocusable(false);
			this.add(c1);
			buttons1.add(c1);
			c1.addActionListener(this);
			
		
		}
		


		
		
	}
	public void actionPerformed(ActionEvent e) {
		for(int j=0; j<buttons1.size();j++){
			Champion c = frame.getPlayer1Team().getTeam().get(j);
			if (e.getSource() == buttons1.get(j)) {
				int answer = JOptionPane.showConfirmDialog(null,
						frame.GetChampionLeaderOneStats(j), c.getName() + "'s stats",
						JOptionPane.YES_NO_OPTION);
				if (answer == JOptionPane.YES_OPTION) {
					frame.getPlayer1Team().setLeader(c);
					frame.GoToSelectLeaderTwoPanel(frame.getPlayer2Team());
					
				}

			
			}
			
		}
	
	}

}
