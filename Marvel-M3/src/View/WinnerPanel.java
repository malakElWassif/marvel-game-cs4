package View;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class WinnerPanel extends JPanel {

	private Frame frame;
	
public WinnerPanel(Frame frame){
	this.frame=frame;
	JOptionPane.showMessageDialog(null,frame.getGame().checkGameOver().getName() + " you are the winner","winner" , JOptionPane.PLAIN_MESSAGE);
	frame.dispose();
}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
