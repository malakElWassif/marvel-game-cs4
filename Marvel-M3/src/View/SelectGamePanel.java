package View;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.abilities.Ability;
import model.abilities.AreaOfEffect;
import model.abilities.CrowdControlAbility;
import model.abilities.DamagingAbility;
import model.abilities.HealingAbility;
import model.world.Champion;
import model.world.Cover;
import model.world.Damageable;
import model.world.Direction;
import engine.Player;
import engine.PriorityQueue;
import exceptions.AbilityUseException;
import exceptions.ChampionDisarmedException;
import exceptions.InvalidTargetException;
import exceptions.LeaderAbilityAlreadyUsedException;
import exceptions.LeaderNotCurrentException;
import exceptions.NotEnoughResourcesException;
import exceptions.UnallowedMovementException;

public class SelectGamePanel extends JPanel implements ActionListener {
	private Frame frame;
	private JTextField field;
	private JButton[][] board;
	private JPanel boardpanel;
	private JPanel Abilitiespanel;
	private Player player1;
	private Player player2;
	private JButton leaderUseAbility1;
	private JButton  leaderUseAbility2;
	private JButton endTurn;
	private JPanel restOfButtons;
	private JButton Up;
	private JButton Down;
	private JButton Left;
	private JButton Right;
	private JPanel ActionsPanel;
	private JButton Move;
	private JButton Attack;
	private JPanel currentchampionpanel;
	private JButton currentchampion;
	private JLabel currentchampionlabel;
	private JPanel TakeActionPanel;
	private JPanel NamePanel;
	private Direction directiontarget;
	private JLabel Player1name;
	private JLabel Player2name;
	private ArrayList<JButton> buttons;
	private ArrayList<JButton> turnOrderButtons;
	private JLabel background;
	private JLabel Turn0rder;

	public SelectGamePanel(Frame frame) {

		this.frame = frame;
		this.setLayout(null);
		this.setBackground(Color.WHITE);
		boardpanel = new JPanel();
		boardpanel.setLayout(new GridLayout(5, 5));
		boardpanel.setBounds(280, 50, 780, 650);
		this.add(boardpanel);

		board = new JButton[5][5];
		for (int i = board.length - 1; i >= 0; i--) {
			for (int j = 0; j < board.length; j++) {
				board[i][j] = new JButton();
				board[i][j].addActionListener(this);
				boardpanel.add(board[i][j]);
			}
		}

		Abilitiespanel = new JPanel();
		Abilitiespanel.setLayout(new GridLayout(3, 1));
		Abilitiespanel.setBackground(Color.WHITE);
		Abilitiespanel.setBounds(10, 490, 220, 100);
		this.add(Abilitiespanel);

		restOfButtons = new JPanel();
		restOfButtons.setLayout(new GridLayout(6, 1));
		restOfButtons.setBounds(10, 50, 220, 350);
		this.add(restOfButtons);

		leaderUseAbility1 = new JButton(frame.getPlayerOneName()+"'s  Leader Ability");
		leaderUseAbility1.setBackground(Color.WHITE);
		leaderUseAbility1.setBounds(10, 630, 240, 30);
		leaderUseAbility1.setForeground(Color.DARK_GRAY);
		leaderUseAbility1
				.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 17));
		leaderUseAbility1.addActionListener(this);
		
		leaderUseAbility2 = new JButton(frame.getPlayerTwoName()+"'s Leader Ability");
		leaderUseAbility2.setBackground(Color.WHITE);
		leaderUseAbility2.setBounds(10, 660, 240, 30);
		leaderUseAbility2.setForeground(Color.DARK_GRAY);
		leaderUseAbility2
				.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 17));
		leaderUseAbility2.addActionListener(this);
		
		
		
		
		

		endTurn = new JButton(" end turn");
		endTurn.setBounds(50, 420, 120, 30);
		endTurn.setBackground(Color.WHITE);
		endTurn.setForeground(Color.DARK_GRAY);
		endTurn.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 20));
		endTurn.addActionListener(this);
		this.add(leaderUseAbility1);
		this.add(leaderUseAbility2);
		this.add(endTurn);
		ActionsPanel = new JPanel();
		ActionsPanel.setLayout(null);
		// ActionsPanel.setBackground(Color.WHITE);
		// ActionsPanel.setBounds(1100, 500, 230, 250);
		// this.add(ActionsPanel);

		Up = new JButton("Up");
		Up.setBounds(1180, 450, 80, 40);
		Up.setBackground(Color.DARK_GRAY);
		Up.setForeground(Color.white);
		Up.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 20));
		Up.addActionListener(this);
		this.add(Up);

		Left = new JButton("Left");
		Left.setBounds(1130, 500, 80, 40);
		Left.setBackground(Color.DARK_GRAY);
	    Left.setForeground(Color.white);
		Left.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 20));
		Left.addActionListener(this);
		this.add(Left);

		Right = new JButton("Right");
		Right.setBounds(1230, 500, 100, 40);
		Right.setBackground(Color.DARK_GRAY);
		Right.setForeground(Color.white);
		Right.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 20));
		Right.addActionListener(this);
		this.add(Right);

		Down = new JButton("Down");
		Down.setBounds(1180, 550, 90, 40);
		Down.setBackground(Color.DARK_GRAY);
		Down.setForeground(Color.white);
		Down.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 20));
		Down.addActionListener(this);
		this.add(Down);

		Move = new JButton("Move");
		Move.setBounds(230, 100, 100, 25);
		Move.setBackground(Color.WHITE);
		Move.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 20));
		Move.addActionListener(this);
		// ActionsPanel.add(Move);

		Attack = new JButton("Attack");
		Attack.setBounds(230, 120, 100, 25);
		Attack.setBackground(Color.WHITE);
		Attack.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 20));
		Attack.addActionListener(this);
		// ActionsPanel.add(Attack);

		TakeActionPanel = new JPanel();
		TakeActionPanel.setLayout(new GridLayout(2, 1));
		TakeActionPanel.setBounds(1130, 615, 200, 50);
		this.add(TakeActionPanel);
		TakeActionPanel.add(Attack);
		TakeActionPanel.add(Move);

		currentchampionpanel = new JPanel();

		currentchampionpanel.setBackground(Color.WHITE);
		currentchampionpanel.setBounds(1100, 350, 250, 50);
		this.add(currentchampionpanel);

		Champion c = frame.getGame().getCurrentChampion();
		currentchampion = new JButton();
		// currentchampion.setText(c.getName());
		currentchampion.setIcon(new ImageIcon(c.getName() + ".jpg"));
		currentchampion.setBounds(1100, 50, 250, 300);
		currentchampion.setBackground(Color.WHITE);
		// currentchampion.setBackground(Color.white);
		currentchampion.setForeground(Color.black);
		currentchampion.addActionListener(this);
		this.add(currentchampion);

		currentchampionlabel = new JLabel("Current Champion");
		currentchampionlabel.setForeground(Color.DARK_GRAY);
		currentchampionlabel.setBounds(1180, 220, 200, 320);
		currentchampionlabel.setFont(new Font("Dialog",
				Font.BOLD | Font.ITALIC, 25));
		currentchampionpanel.add(currentchampionlabel);

		NamePanel = new JPanel();
		NamePanel.setBounds(0, 0, 1400, 30);
		NamePanel.setLayout(null);
		NamePanel.setBackground(Color.DARK_GRAY);
		this.add(NamePanel);

		Turn0rder = new JLabel("Turn Order");
		Turn0rder.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 25));
		Turn0rder.setForeground(Color.WHITE);
		Turn0rder.setBounds(50, 0, 200, 30);
		NamePanel.add(Turn0rder);

		Player1name = new JLabel("First player: " + frame.getPlayerOneName());
		Player1name.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 25));
		Player1name.setForeground(Color.WHITE);
		Player1name.setBounds(450, 0, 400, 30);
		NamePanel.add(Player1name);

		Player2name = new JLabel("Second player: " + frame.getPlayerTwoName());
		Player2name.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 25));
		Player2name.setForeground(Color.white);
		Player2name.setBounds(730, 0, 400, 30);
		NamePanel.add(Player2name);
		directiontarget = null;

		ImageIcon image = new ImageIcon("7478001.jpg");
		background = new JLabel("", image, JLabel.CENTER);
		background.setBounds(0, 0, 1400, 900);
		this.add(background);

		turnOrder();
		getAbilities();
		UpdateBoard();
		this.validate();
		this.repaint();

	}

	public void turnOrder() {
		PriorityQueue temp = new PriorityQueue(6);
		turnOrderButtons = new ArrayList<JButton>();
		while (!frame.getGame().getTurnOrder().isEmpty()) {
			String s = "";

			Champion c = (Champion) frame.getGame().getTurnOrder().peekMin();
			//s = c.getName() + "  ";
			JButton b = new JButton(new ImageIcon(c.getName()+"3.jpg"));
		   // b.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 20));
		  
			b.setBackground(Color.WHITE);
			restOfButtons.add(b);
			turnOrderButtons.add(b);
			temp.insert(frame.getGame().getTurnOrder().remove());

		}
		while (!temp.isEmpty()) {
			frame.getGame().getTurnOrder().insert(temp.remove());
		}

	}

	public void UpdateTurnOrder() {
		PriorityQueue temp = new PriorityQueue(6);
		ArrayList<String> array = new ArrayList<String>();
		while (!frame.getGame().getTurnOrder().isEmpty()) {

			Champion c = (Champion) frame.getGame().getTurnOrder().peekMin();

			array.add(c.getName());
			temp.insert(frame.getGame().getTurnOrder().remove());

		}
		while (!temp.isEmpty()) {
			frame.getGame().getTurnOrder().insert(temp.remove());
		}

		int j = 0;
		for (int i = 0; i < array.size(); i++) {
			turnOrderButtons.get(i).setIcon(new ImageIcon(array.get(i)+"3.jpg"));
			j = i;
		}
        if(j+1<turnOrderButtons.size())
		turnOrderButtons.get(j + 1).setIcon(new ImageIcon("white.jpg"));

	}

	public void UpdateBoard() {
		int k=1;
		for (int i = board.length - 1; i >= 0; i--) {
			for (int j = 0; j <= board.length - 1; j++) {
				Damageable d = (Damageable) frame.getGame().getBoard()[i][j];
				if (d instanceof Champion) {
					Champion c = (Champion) d;

					if (c == frame.getGame().getCurrentChampion()) {
						board[i][j].setBackground(Color.WHITE);
						board[i][j].setForeground(Color.GREEN);
						// board[i][j].setText(c.getName());
						board[i][j]
								.setIcon(new ImageIcon(c.getName() + "1.jpg"));
						board[i][j].setToolTipText(frame.getAllChampionStats(c)
								+ ""+"<br>"+"location:"+"(" + i + "" + "," + j
								+ "" + ")"); // to be edited
						// board[i][j].setText(c.getCurrentHP() + "");

					} else {
						board[i][j].setBackground(Color.WHITE);
						board[i][j].setForeground(Color.GREEN);
						// board[i][j].setText(c.getName());
						board[i][j]
								.setIcon(new ImageIcon(c.getName() + "1.jpg"));
						board[i][j].setToolTipText(frame.getAllChampionStats(c)
								+ ""+"<br>"+"location:"+"(" + i + "" + "," + j
								+ "" + ")"); // to be edited
						// board[i][j].setText(c.getCurrentHP() + "");

					}
					
                 
				} else if (d instanceof Cover) {
					Cover c = (Cover) d;
				
					// board[i][j].setIcon(new ImageIcon("rock.jpg"));
					// board[i][j].setText(c.getCurrentHP() + "");
					board[i][j].setToolTipText("<html>"+"cover's currentHP"
							+ c.getCurrentHP() + ""+"<br>"+"location:"+"(" + i + "" + "," + j
							+ "" + ")");
					board[i][j].setIcon(new ImageIcon("infinityStone"+k+""+".jpg"));
					k++;
					board[i][j].setBackground(Color.WHITE);
					
				} else {
					board[i][j].setIcon(new ImageIcon("white.jpg"));
					//board[i][j].setBackground(Color.WHITE);
					board[i][j].setText("");
					board[i][j].setToolTipText("");

				}

			}
		}

	}

	public void getAbilities() {
		Champion c = frame.getGame().getCurrentChampion();
		buttons = new ArrayList<JButton>();
		for (int i = 0; i < c.getAbilities().size(); i++) {
			Ability a = c.getAbilities().get(i);
			String s = "";
			s = "<html>" + "Mana Cost:" + a.getManaCost() + "<br>";
			s = s + "Base CoolDown:" + a.getBaseCooldown() + "<br>";
			s = s + "Current CoolDown:" + a.getCurrentCooldown() + "<br>";
			s = s + "Cast Range:" + a.getCastRange() + "<br>";
			s = s + "Cast Area:" + a.getCastArea() + "<br>";
			s = s + "Required Action Points:" + a.getRequiredActionPoints()
					+ "<br>";
			if(a instanceof DamagingAbility)
			{
				DamagingAbility DA=(DamagingAbility)a;
				s= s +"Type: Damaging Ability"+"<br>";
				s=s+"Damage amount: "+DA.getDamageAmount()+"<br>";
			}
			else if(a instanceof HealingAbility)
			{
				HealingAbility HA=(HealingAbility)a;
				s= s + "Type: Healing Ability"+"<br>";
				s=s+"Heal amount: "+HA.getHealAmount()+"<br>";
			}
			else
			{
				CrowdControlAbility CCA=(CrowdControlAbility)a;
				s = s + "Type: Crowd Control Abilty"+"<br>";
				s=s+"Effect name: "+CCA.getEffect().getName()+"<br>"
				+"Effect Type: "+CCA.getEffect().getType()+"<br>"+"Effect duration : "+CCA.getEffect().getDuration();
			}

			JButton button = new JButton();
			button.setText(a.getName() + "");
			button.setToolTipText(s);
			button.setBackground(Color.DARK_GRAY);
			button.setForeground(Color.WHITE);
			button.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 20));
			button.addActionListener(this);
			Abilitiespanel.add(button);
			buttons.add(button);

		}

	}

	public void UpdateAbilities() {
		Champion c = frame.getGame().getCurrentChampion();
		for (int j = 0; j < buttons.size(); j++) {
			Ability a = c.getAbilities().get(j);
			buttons.get(j).setText(a.getName() + "");
			String s = "";
			s = "<html>" + "Mana Cost:" + a.getManaCost() + "<br>";
			s = s + "Base CoolDown:" + a.getBaseCooldown() + "<br>";
			s = s + "Current CoolDown:" + a.getCurrentCooldown() + "<br>";
			s = s + "Cast Range:" + a.getCastRange() + "<br>";
			s = s + "Cast Area:" + a.getCastArea() + "<br>";
			s = s + "Required Action Points:" + a.getRequiredActionPoints()
					+ "<br>";
					if(a instanceof DamagingAbility)
			{
				DamagingAbility DA=(DamagingAbility)a;
				s= s +"Type: Damaging Ability"+"<br>";
				s=s+"Damage amount: "+DA.getDamageAmount()+"<br>";
			}
			else if(a instanceof HealingAbility)
			{
				HealingAbility HA=(HealingAbility)a;
				s= s + "Type: Healing Ability"+"<br>";
				s=s+"Heal amount: "+HA.getHealAmount()+"<br>";
			}
			else
			{
				CrowdControlAbility CCA=(CrowdControlAbility)a;
				s = s + "Type: Crowd Control Abilty"+"<br>";
				s=s+"Effect name: "+CCA.getEffect().getName()+"<br>"
				+"Effect Type: "+CCA.getEffect().getType()+"<br>"+"Effect duration : "+CCA.getEffect().getDuration();
			}
			buttons.get(j).setToolTipText(s);

		}

	}

	public void UpdateCurrentChampion() {
		Champion c = frame.getGame().getCurrentChampion();
		currentchampion.setIcon(new ImageIcon(c.getName() + ".jpg"));
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		Champion c = frame.getGame().getCurrentChampion();

		if (e.getSource() == currentchampion) {
			JOptionPane.showMessageDialog(null, frame.CurrentChampStats(c),
					"Champion stats", JOptionPane.PLAIN_MESSAGE);
		}
		String[] directions = new String[] { "UP", "DOWN", "LEFT", "RIGHT" };

		for (int i = 0; i < buttons.size(); i++) {

			if (e.getSource() == buttons.get(i)) {
				Ability a = c.getAbilities().get(i);
				if (a.getCastArea() == AreaOfEffect.DIRECTIONAL) {

					String res = (String) JOptionPane.showInputDialog(null,
							"please choose a direction",
							"cast ability directional",
							JOptionPane.PLAIN_MESSAGE, null, directions,
							directions[0]);

					if (res == "UP") {

						directiontarget = Direction.UP;
					}

					if (res == "DOWN") {
						directiontarget = Direction.DOWN;
					}
					if (res == "RIGHT") {
						directiontarget = Direction.RIGHT;
					}
					if (res == "LEFT") {
						directiontarget = Direction.LEFT;
					}

					try {
						frame.getGame().castAbility(a, directiontarget);
						UpdateBoard();
						UpdateAbilities();
						UpdateCurrentChampion();

					} catch (NotEnoughResourcesException | AbilityUseException
							| CloneNotSupportedException e1) {
						JOptionPane.showMessageDialog(null, e1.getMessage(),
								"error", JOptionPane.ERROR_MESSAGE);
						e1.printStackTrace();
					}

				} else if (a.getCastArea() == AreaOfEffect.TEAMTARGET
						|| a.getCastArea() == AreaOfEffect.SURROUND
						|| a.getCastArea() == AreaOfEffect.SELFTARGET) {
					try {
						frame.getGame().castAbility(a);
						UpdateBoard();
						UpdateAbilities();
						UpdateCurrentChampion();
					} catch (NotEnoughResourcesException | AbilityUseException
							| CloneNotSupportedException e1) {
						JOptionPane.showMessageDialog(null, e1.getMessage(),
								"error", JOptionPane.ERROR_MESSAGE);
						e1.printStackTrace();
					}

				} else if (a.getCastArea() == AreaOfEffect.SINGLETARGET) {
					JTextField x = new JTextField();
					JTextField y = new JTextField();
					Object[] inputFields = { "Enter x coordinate", x,
							"Enter y coordinate", y };
					int option = JOptionPane.showConfirmDialog(this,
							inputFields, "Multiple Inputs",
							JOptionPane.OK_CANCEL_OPTION,
							JOptionPane.INFORMATION_MESSAGE);

					if (option == JOptionPane.OK_OPTION) {
						try {
							frame.getGame().castAbility(a,
									Integer.parseInt(x.getText()),
									Integer.parseInt(y.getText()));
							UpdateBoard();
							UpdateAbilities();
							UpdateCurrentChampion();

						} catch (NumberFormatException
								| NotEnoughResourcesException
								| AbilityUseException | InvalidTargetException
								| CloneNotSupportedException e1) {
							JOptionPane.showMessageDialog(null,
									e1.getMessage(), "error",
									JOptionPane.ERROR_MESSAGE);
							e1.printStackTrace();
						}
					}

				}

			}

		}
		if (e.getSource() == Attack) {
			if (directiontarget == null) {
				JOptionPane.showMessageDialog(TakeActionPanel,
						"please choose a direction to attack", "error",
						JOptionPane.ERROR_MESSAGE);
			} else {
				try {
					frame.getGame().attack(directiontarget);
					UpdateBoard();
					UpdateCurrentChampion();
					UpdateAbilities();

				} catch (NotEnoughResourcesException
						| ChampionDisarmedException | InvalidTargetException e1) {
					JOptionPane.showMessageDialog(this, e1.getMessage(),
							"error", JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				}
			}
		}

		if (e.getSource() == Up) {
			directiontarget = Direction.UP;
		}
		if (e.getSource() == Down) {
			directiontarget = Direction.DOWN;
		}
		if (e.getSource() == Right) {
			directiontarget = Direction.RIGHT;
		}
		if (e.getSource() == Left) {
			directiontarget = Direction.LEFT;
		}
		
		if (e.getSource() == Move) {
			if (directiontarget == null) {
				JOptionPane.showMessageDialog(this,
						"please choose a direction to move", "error",
						JOptionPane.ERROR_MESSAGE);
			} else {
				try {
					frame.getGame().move(directiontarget);
					UpdateBoard();
					UpdateCurrentChampion();
					UpdateAbilities();
					

				} catch (NotEnoughResourcesException
						| UnallowedMovementException e1) {
					JOptionPane.showMessageDialog(this, e1.getMessage(),
							"error", JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				}
			}

		}
		if (e.getSource() == endTurn) {
			frame.getGame().endTurn();
			UpdateBoard();
			UpdateCurrentChampion();
			UpdateAbilities();
			directiontarget = null;
			UpdateTurnOrder();
			Champion ch = frame.getGame().getCurrentChampion();
			currentchampionlabel.setText("Current Champion ");
		}

		if (e.getSource() == leaderUseAbility1) {

			try {
				frame.getGame().useLeaderAbility();
				leaderUseAbility1.setEnabled(false);
			} catch (LeaderNotCurrentException
					| LeaderAbilityAlreadyUsedException e1) {
				JOptionPane.showMessageDialog(this, e1.getMessage(), "error",
						JOptionPane.ERROR_MESSAGE);
				e1.printStackTrace();
			}
			UpdateBoard();
			UpdateCurrentChampion();
			UpdateAbilities();

		}
		if (e.getSource() == leaderUseAbility2) {

			try {
				frame.getGame().useLeaderAbility();
				leaderUseAbility2.setEnabled(false);
			} catch (LeaderNotCurrentException
					| LeaderAbilityAlreadyUsedException e1) {
				JOptionPane.showMessageDialog(this, e1.getMessage(), "error",
						JOptionPane.ERROR_MESSAGE);
				e1.printStackTrace();
			}
			UpdateBoard();
			UpdateCurrentChampion();
			UpdateAbilities();

		}

		if (frame.getGame().checkGameOver() != null) {
			frame.GoToWinnerPanel();

		}

	}

}