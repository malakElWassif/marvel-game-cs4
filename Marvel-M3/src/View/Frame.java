package View;

import java.awt.Image;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.*;

import model.abilities.CrowdControlAbility;
import model.abilities.DamagingAbility;
import model.abilities.HealingAbility;
import model.world.AntiHero;
import model.world.Champion;
import model.world.Hero;
import model.world.Villain;
import engine.Game;
import engine.Player;

public class Frame extends JFrame {
	private String playerOneName;
	private String playerTwoName;
	private SelectChampionPanel select;
	private SelectPlayerNamePanel PlayerName;
	private SelectLeaderOnePanel LeaderOne;
	private SelectLeaderTwoPanel LeaderTwo;
	private StartGamePanel start;
	private Game game;
	private Player player1;
	private Player player2;
	private JLabel background;
	private SelectGamePanel GamePanel;
	private WinnerPanel winner;

	public Game getGame() {
		return game;
	}

	public Player getPlayer1Team() {
		return game.getFirstPlayer();

	}

	public Player getPlayer2Team() {

		return game.getSecondPlayer();
	}

	public Frame() {

		GoToStartGamePanel();
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(2000, 1000);
		this.setVisible(true);
		this.setTitle("Marvel");
		ImageIcon img = new ImageIcon("Avengers.png");
		this.setIconImage(img.getImage());

	}

	public void GoToStartGamePanel() {

		start = new StartGamePanel(this);
		// this.setSize(2000, 1000);
		this.getContentPane().add(start);
		this.validate();
		this.repaint();

	}

	public void GoToSelectPlayerPanel() {
		this.getContentPane().remove(start);
		PlayerName = new SelectPlayerNamePanel(this);
		// this.setSize(1500, 1000);
		this.getContentPane().add(PlayerName);

		this.validate();
		this.repaint();

	}

	public void GoToSelectChampionPanel(String Playername1, String Playername2) {
		playerOneName = Playername1;
		playerTwoName = Playername2;
		game = new Game(new Player((String) Playername1), new Player(
				(String) Playername2));

		try {
			Game.loadAbilities("Abilities.csv");
			Game.loadChampions("Champions.csv");
			this.getContentPane().remove(PlayerName);

			select = new SelectChampionPanel(this);
			// this.setSize(2000, 1000);
			this.getContentPane().add(select);
			this.validate();
			this.repaint();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public ArrayList<Champion> getChampions() {
		return Game.getAvailableChampions();

	}

	public String getPlayerOneName() {
		return playerOneName;
	}

	public String getPlayerTwoName() {
		return playerTwoName;
	}

	public String getChampionStats(int i) {
		Champion c = getChampions().get(i);
		String s = "Champion's name: " + c.getName() + "\n"
				+ "Champion's current health points: " + c.getCurrentHP()
				+ "\n" + "Champion's Mana:" + c.getMana() + "\n"
				+ "Champion's max Action points per turn: "
				+ c.getMaxActionPointsPerTurn() + "\n"
				+ "Champion's current Action Points:"
				+ c.getCurrentActionPoints() + "\n" + "Champion's attack range"
				+ c.getAttackRange() + "\n" + "Champion's attack Damage:"
				+ c.getAttackDamage() + "\n" + "Champion's speed:"
				+ c.getSpeed() + "\n" + c.getName() + "'s abilities: " + "\n";
		for (int j = 0; j < c.getAbilities().size(); j++) {
			s = s + c.getAbilities().get(j).getName() + "\n";
		}
		s = s + "\n" + "\n";
		s = s + "Would you like to choose " + c.getName() + " ?";
		return s;
	}

	public void GoToSelectLeaderOnePanel(Player player1) {
		this.player1 = player1;

		this.getContentPane().remove(select);
		LeaderOne = new SelectLeaderOnePanel(this);
		// this.setSize(2000, 1000);
		this.getContentPane().add(LeaderOne);

		this.validate();
		this.repaint();

	}

	public void GoToSelectLeaderTwoPanel(Player player2) {
		this.player2 = player2;
		this.getContentPane().remove(LeaderOne);
		LeaderTwo = new SelectLeaderTwoPanel(this);
		// this.setSize(2000, 1000);
		this.getContentPane().add(LeaderTwo);

		this.validate();
		this.repaint();

	}

	public String GetChampionLeaderOneStats(int i) {
		for (int k = 0; k < getChampions().size(); k++) {

			Champion c = getChampions().get(k);
			Champion cplayer = getPlayer1Team().getTeam().get(i);
			if (c == cplayer) {

				String s = "Champion's name: " + c.getName() + "\n"
						+ "Champion's current health points: "
						+ c.getCurrentHP() + "\n" + "Champion's Mana:"
						+ c.getMana() + "\n"
						+ "Champion's max Action points per turn: "
						+ c.getMaxActionPointsPerTurn() + "\n"
						+ "Champion's current Action Points:"
						+ c.getCurrentActionPoints() + "\n"
						+ "Champion's attack range" + c.getAttackRange() + "\n"
						+ "Champion's attack Damage:" + c.getAttackDamage()
						+ "\n" + "Champion's speed:" + c.getSpeed() + "\n"
						+ c.getName() + "'s abilities: " + "\n";
				for (int j = 0; j < c.getAbilities().size(); j++) {
					s = s + c.getAbilities().get(j).getName() + "\n";
				}
				s = s + "\n" + "\n";
				s = s + "Would you like to choose " + c.getName() + " ?";

				return s;
			}

		}
		return "";
	}

	public String GetChampionLeaderTwoStats(int i) {
		for (int k = 0; k < getChampions().size(); k++) {

			Champion c = getChampions().get(k);
			Champion cplayer = getPlayer2Team().getTeam().get(i);
			if (c == cplayer) {

				String s = "Champion's name: " + c.getName() + "\n"
						+ "Champion's current health points: "
						+ c.getCurrentHP() + "\n" + "Champion's Mana:"
						+ c.getMana() + "\n"
						+ "Champion's max Action points per turn: "
						+ c.getMaxActionPointsPerTurn() + "\n"
						+ "Champion's current Action Points:"
						+ c.getCurrentActionPoints() + "\n"
						+ "Champion's attack range" + c.getAttackRange() + "\n"
						+ "Champion's attack Damage:" + c.getAttackDamage()
						+ "\n" + "Champion's speed:" + c.getSpeed() + "\n"
						+ c.getName() + "'s abilities: " + "\n";
				for (int j = 0; j < c.getAbilities().size(); j++) {
					s = s + c.getAbilities().get(j).getName() + "\n";
				}
				s = s + "\n" + "\n";
				s = s + "Would you like to choose " + c.getName() + " ?";

				return s;
			}

		}
		return "";
	}

	public void GoToGamePanel() {
		game = new Game(game.getFirstPlayer(), game.getSecondPlayer());

		this.getContentPane().remove(LeaderTwo);
		GamePanel = new SelectGamePanel(this);
		this.setSize(2000, 1000);
		this.getContentPane().add(GamePanel);

		this.validate();
		this.repaint();
	}

	public String getAllChampionStats(Champion c) {
		String s = "";
		if (game.getFirstPlayer().getTeam().contains(c)) {
			s = "<html>" + getPlayerOneName() + "'s champion" + "<br>";
		}
		if (game.getSecondPlayer().getTeam().contains(c)) {
			s = "<html>" + getPlayerTwoName() + "'s champion" + "<br>";
		}

		if (c instanceof Hero) {
			s = s+"<br>" + "Champion's Type: Hero" + "<br>";
		} else if (c instanceof Villain) {
			s =s+ "<br>" + "Champion's Type: Villain" + "<br>";
		} else if (c instanceof AntiHero) {
			s =s+ "<br>" + "Champion's Type: AntiHero" + "<br>";
		}
		if (game.getFirstPlayer().getTeam().contains(c)) {
			if (game.getFirstPlayer().getLeader() == c) {
				s = s + "<br>" + "Is the champion leader: Yes" + "<br>";
			} else {
				s = s + "<br>" + "Is the champion leader: No" + "<br>";
			}

		} else if (game.getSecondPlayer().getTeam().contains(c)) {
			if (game.getSecondPlayer().getLeader() == c) {
				s = s + "<br>" + "Is the champion leader: Yes" + "<br>";
			} else {
				s = s + "<br>" + "Is the champion leader: No" + "<br>";
			}

		}
		s = s + "Champion's name: " + c.getName() + "<br>"
				+ "Champion's current health points: " + c.getCurrentHP()
				+ "<br>" + "Champion's Mana:" + c.getMana() + "<br>"
				+ "Champion's max Action points per turn: "
				+ c.getMaxActionPointsPerTurn() + "<br>"
				+ "Champion's current Action Points: "
				+ c.getCurrentActionPoints() + "<br>"
				+ "Champion's attack range: " + c.getAttackRange() + "<br>"
				+ "Champion's attack Damage: " + c.getAttackDamage() + "<br>"
				+ "Champion's speed: " + c.getSpeed() + "<br>" + "<br>";

		s = s + "<br>" + " Applied Effects:";
		for (int k = 0; k < c.getAppliedEffects().size(); k++) {
			s = s + "Name: " + c.getAppliedEffects().get(k).getName() + "<br>";
			s = s + "Type: " + c.getAppliedEffects().get(k).getType() + "<br>";
			s = s + "Duration: " + c.getAppliedEffects().get(k).getDuration()
					+ "<br>";

		}

		return s;
	}


	public String CurrentChampStats(Champion c){
		
		
			String s = "";
			if (c instanceof Hero) {
				s = "<html>" + "Champion's Type: Hero"+"<br>" ;
			} else if (c instanceof Villain) {
				s = "<html>" + "Champion's Type: Villain"+"<br>" ;
			} else if (c instanceof AntiHero) {
				s = "<html>" + "Champion's Type: AntiHero"+"<br>";
			}
			if (game.getFirstPlayer().getTeam().contains(c)) 
			{
				if(game.getFirstPlayer().getLeader()==c)
				{
					s=s+"<br>"+"Is the champion leader: Yes"+"<br>";
				}
				else
				{
					s=s+"<br>"+"Is the champion leader: No"+"<br>";
				}

			}
			else if(game.getSecondPlayer().getTeam().contains(c)) 
			{
				if(game.getSecondPlayer().getLeader()==c)
				{
					s=s+"<br>"+"Is the champion leader: Yes"+"<br>";
				}
				else
				{
					s=s+"<br>"+"Is the champion leader: No"+"<br>";
				}

			}
			s = s + "Champion's name: " + c.getName() + "<br>"
					+ "Champion's current health points: " + c.getCurrentHP()
					+ "<br>" + "Champion's Mana:" + c.getMana() + "<br>"
					+ "Champion's max Action points per turn: "
					+ c.getMaxActionPointsPerTurn() + "<br>"
					+ "Champion's current Action Points: "
					+ c.getCurrentActionPoints() + "<br>"
					+ "Champion's attack range: " + c.getAttackRange() + "<br>"
					+ "Champion's attack Damage: " + c.getAttackDamage() + "<br>"
					+ "Champion's speed: " + c.getSpeed() + "<br>" +"<br>"+ c.getName()
					+ "'s abilities: " + "<br>";
			for (int j = 0; j < c.getAbilities().size(); j++) {
				if (c.getAbilities().get(j) instanceof DamagingAbility)
					s = s + "<br>" + "Ability type: Damaging Ability " + "<br>";
				else if (c.getAbilities().get(j) instanceof HealingAbility)
					s = s + "<br>" + " Ability Type: Healing Ability" + "<br>";
				    
				else if (c.getAbilities().get(j) instanceof CrowdControlAbility)
					s = s + "<br>" + " Ability Type: Crowd Control Ability"
							+ "<br>";
				
				s = s +"Ability name : "+ c.getAbilities().get(j).getName() + "<br>";
				s = s + "Mana Cost:" + c.getAbilities().get(j).getManaCost()
						+ "<br>";
				s = s + "Base CoolDown: "
						+ c.getAbilities().get(j).getBaseCooldown() + "<br>";
				s = s + "Current CoolDown: "
						+ c.getAbilities().get(j).getCurrentCooldown() + "<br>";
				s = s + "Cast Range: " + c.getAbilities().get(j).getCastRange()
						+ "<br>";
				s = s + "Cast Area: " + c.getAbilities().get(j).getCastArea()
						+ "<br>";
				s = s + "Required Action Points: "
						+ c.getAbilities().get(j).getRequiredActionPoints()
						+ "<br>";
				

			}
			s = s + "<br>" + " Applied Effects:";
			for (int k = 0; k < c.getAppliedEffects().size(); k++) {
				s = s + "Name: " + c.getAppliedEffects().get(k).getName() + "<br>";
				s = s + "Type: " + c.getAppliedEffects().get(k).getType() + "<br>";
				s = s + "Duration: " + c.getAppliedEffects().get(k).getDuration()
						+ "<br>";

			}

			return s;
		}
		
		
		
	
	
	
	
	
	
	
	
	public void GoToWinnerPanel() {

		this.getContentPane().remove(GamePanel);
		winner = new WinnerPanel(this);
		this.setSize(2000, 1000);
		this.getContentPane().add(winner);

		this.validate();
		this.repaint();

	}

	

	public static void main(String[] args) {
		Frame f = new Frame();
		String path = "Avengers.wav";
		Music music = new Music();
		music.PlayMusic(path);


	}

}
