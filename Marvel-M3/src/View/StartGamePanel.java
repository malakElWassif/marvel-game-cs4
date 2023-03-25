package View;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;





import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class StartGamePanel extends JPanel implements ActionListener {
	private Frame frame;
	private JButton button;
	private JLabel background;
public StartGamePanel(Frame frame)
{
	this.setLayout(null);
	this.frame=frame;
	
	
	button=new JButton(" Avengers Assemble!");
	button.setFocusable(false);
	button.setForeground(Color.DARK_GRAY);
	button.setBackground(Color.WHITE);
	
	button.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 20));
	button.setBounds(500, 580, 300, 60);
	this.add(button);
	button.addActionListener(this);
	ImageIcon image=  new ImageIcon("wall.jpg");
    background= new JLabel("",image,JLabel.CENTER);
    background.setBounds(0, 0, 1400, 900);
    this.add(background);
}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==button)
		{
			frame.GoToSelectPlayerPanel();
		}
		
	}

}
