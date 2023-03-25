package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import model.world.Champion;

public class SelectLeaderTwoPanel extends JPanel implements ActionListener{
	private Frame frame;
	private ArrayList <JButton> buttons2 ;
	
	
	public SelectLeaderTwoPanel(Frame frame){
		this.frame=frame;
		this.setLayout(new GridLayout(3,1));
		JOptionPane.showMessageDialog(this, frame.getPlayerTwoName()
				+ " please select your Leader", "Choose",
				JOptionPane.PLAIN_MESSAGE);
		
		buttons2 = new ArrayList<JButton>();
		for(int i=0;i<frame.getPlayer2Team().getTeam().size();i++){
			JButton c1 =  new JButton(new ImageIcon(frame.getPlayer2Team().getTeam().get(i).getName()+".jpg"));
			c1.setBackground(Color.WHITE);
			c1.setFocusable(false);
			this.add(c1);
			buttons2.add(c1);
			c1.addActionListener(this);
			
		
		}
		
		
		
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		for(int j=0; j<buttons2.size();j++){
			Champion c = frame.getPlayer2Team().getTeam().get(j);
			if (e.getSource() == buttons2.get(j)) {
				int answer = JOptionPane.showConfirmDialog(null,
						frame.GetChampionLeaderTwoStats(j), c.getName() + "'s stats",
						JOptionPane.YES_NO_OPTION);
				if (answer == JOptionPane.YES_OPTION) {
					frame.getPlayer2Team().setLeader(c);
					frame.GoToGamePanel();
					
					
				}

			
			}
			
		}
		
	}	
		
		
	
	
	
	
}
