import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.*;

public class pruebas {

	void saveBattle(String playerName,int playerWarriorId,int playerWeaponId,int botWarriorId,int botWeaponId,int injuriesCaused,int injuriesSuffred, int battlePoints) {
		String urlDatos = "jdbc:mysql://localhost/battle_of_races?serverTimezone=UTC";
		String usuario = "admin";
		String pass = "P@ssw0rd!";

		String query = "select 	w.WARRIOR_ID,r.RACE_HP,r.RACE_STRENGTH,r.RACE_DEFENSE,r.RACE_AGILITY,r.RACE_SPEED,r.RACE_POINTS,w.WARRIOR_NAME,w.WARRIOR_IMAGE_PATH,r.RACE_NAME from WARRIORS w inner join RACES r on w.WARRIORS_RACE_ID=RACE_ID;";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection(urlDatos,usuario,pass);

			String update = "INSERT INTO BATTLE (PLAYER_ID,WARRIOR_ID,WARRIOR_WEAPON_ID,OPPONENT_ID,OPPONENT_WEAPON_ID,INJURIES_CAUSED,INJURIES_SUFFERED,BATTLE_POINTS) "
					+ "VALUES ((SELECT PLAYER_ID FROM PLAYERS WHERE PLAYER_NAME = ?),?,?,?,?,?,?,?)";

			PreparedStatement ps = conn.prepareStatement(update);

			ps.setString(1, playerName);
			ps.setInt(2, playerWarriorId);
			ps.setInt(3, playerWeaponId);
			ps.setInt(4, botWarriorId);
			ps.setInt(5, botWeaponId);
			ps.setInt(6, injuriesCaused);
			ps.setInt(7, injuriesSuffred);
			ps.setInt(8, battlePoints);
			ps.executeUpdate();



		} catch (ClassNotFoundException e1) {
			System.out.println("Driver no se ha cargado correctamente!!");		
		} catch (SQLException e1) {
			System.out.println("Se ha lanzado una SQLException!!");
			e1.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new FrameMain("Pepe");
	}
}

class FrameMain extends JFrame {
	//Swing
	private JPanel panel,panelMain,panelWarriors,panelWeapons,panelButtons1,panelCharacters,panelButtons2,panelTextArea;
	private JPanel panelPlayer,panelPlayerProgressBar,panelPlayerCharacter,panelPlayerGeneralStats,panelPlayerWeapon,panelPlayerStats,panelPlayerStatsText,panelPlayerStatsBars,
	panelBot,panelBotProgressBar,panelBotCharacter,panelBotGeneralStats,panelBotWeapon,panelBotStats,panelBotStatsText,panelBotStatsBars;

	private JButton buttonChooseCharacter,buttonChooseWeapon,buttonRanking,buttonFight,buttonClearConsole,buttonNext;
	private JTextArea textArea;
	JScrollPane scrollPane;
	private JLabel textPlayer,textPlayerPower,textPlayerAgility,textPlayerSpeed,textPlayerDefense,
	textBot,textBotPower,textBotAgility,textBotSpeed,textBotDefense;

	private ImageIcon imagePlayerCharacter,imageYouWeapon,imageBotCharacter,imageBotWeapon;
	private JLabel jlabelYouCharacter,jlabelYouWeapon,jlabelBotCharacter,jlabelBotWeapon;

	private JProgressBar progressBarPlayer,progressBarPlayerPower,progressBarPlayerAgility,progressBarPlayerSpeed,progressBarPlayerDefense;
	private JProgressBar progressBarBot,progressBarBotPower,progressBarBotAgility,progressBarBotSpeed,progressBarBotDefense;

	//Programa
	private JButton[] warriorsArray,weaponsArray;
	private WarriorContainer warriorPlayer,warriorBot;
	private WeaponContainer weaponPlayer,weaponBot;
	private WarriorContainer[] warriorPlayerAndBotList = new WarriorContainer[2];
	private WeaponContainer[] weaponPlayerAndBotList = new WeaponContainer[2];
	private int actualWarriorToAttack = 0,actualWarriorToDefend = 1;
	private int battlePoints = 0,injuriesCaused = 0, injuriesSuffred = 0;
	private boolean playerWin = false;

	private Random random = new Random();
	private boolean warriorSelected = false,weaponSelected = false, botNotRandomized = true;

	private pruebas functions = new pruebas();

	//Connections BBDD
	String urlDatos = "jdbc:mysql://localhost/battle_of_races?serverTimezone=UTC";
	String usuario = "admin";
	String pass = "P@ssw0rd!";

	public FrameMain(String playerName) {
		//Variables
		//Panels
		panel = new JPanel();

		panelMain = new JPanel();
		panelMain.setLayout(new BoxLayout(panelMain,BoxLayout.Y_AXIS));

		panelWarriors = new JPanel();
		panelWarriors.setLayout(new GridLayout(3,3));
		panelWarriors.setSize(450,450);
		panelWarriors.setVisible(false);

		panelWeapons = new JPanel();
		panelWeapons.setLayout(new GridLayout(3,3));
		panelWeapons.setSize(450,450);
		panelWeapons.setVisible(false);

		panelButtons1 = new JPanel();
		panelCharacters = new JPanel();
		panelCharacters.setLayout(new BorderLayout(100,10));

		panelButtons2 = new JPanel();
		panelTextArea = new JPanel();

		panelPlayer = new JPanel();
		panelPlayerProgressBar = new JPanel();
		panelPlayerCharacter = new JPanel();
		panelPlayerGeneralStats = new JPanel();
		panelPlayerWeapon = new JPanel();
		panelPlayerStats = new JPanel();
		panelPlayerStats.setLayout(new BorderLayout(20,10));
		panelPlayerStatsText = new JPanel();
		panelPlayerStatsText.setLayout(new BoxLayout(panelPlayerStatsText,BoxLayout.Y_AXIS));
		panelPlayerStatsBars = new JPanel();
		panelPlayerStatsBars.setLayout(new BoxLayout(panelPlayerStatsBars,BoxLayout.Y_AXIS));

		panelBot = new JPanel();
		panelBotProgressBar = new JPanel();
		panelBotCharacter = new JPanel();
		panelBotGeneralStats = new JPanel();
		panelBotWeapon = new JPanel();
		panelBotStats = new JPanel();
		panelBotStats.setLayout(new BorderLayout(20,10));
		panelBotStatsText = new JPanel();
		panelBotStatsText.setLayout(new BoxLayout(panelBotStatsText,BoxLayout.Y_AXIS));
		panelBotStatsBars = new JPanel();
		panelBotStatsBars.setLayout(new BoxLayout(panelBotStatsBars,BoxLayout.Y_AXIS));
		//Buttons
		buttonChooseCharacter = new JButton("Choose Character");
		buttonChooseWeapon = new JButton("Choose Weapon");
		buttonRanking = new JButton("Ranking");
		buttonFight= new JButton("Fight");
		buttonClearConsole = new JButton("Clear Console");
		buttonNext = new JButton("Next Round");
		buttonNext.setVisible(false);
		//TextArea
		textArea = new JTextArea(5,100);
		//Scroll
		scrollPane = new JScrollPane(textArea);
		//ImageIcon
		imagePlayerCharacter = new ImageIcon("./images/X.png");
		imageYouWeapon = new ImageIcon("./images/XSmall.png");
		imageBotCharacter = new ImageIcon("./images/X.png");
		imageBotWeapon = new ImageIcon("./images/XSmall.png");
		//JLabel
		jlabelYouCharacter = new JLabel(imagePlayerCharacter);
		jlabelYouWeapon = new JLabel(imageYouWeapon);
		jlabelBotCharacter = new JLabel(imageBotCharacter);
		jlabelBotWeapon = new JLabel(imageBotWeapon);

		textPlayer = new JLabel("Player");
		textPlayerPower = new JLabel("Power");
		textPlayerAgility = new JLabel("Agility");
		textPlayerSpeed = new JLabel("Speed");
		textPlayerDefense = new JLabel("Defense");


		textBot = new JLabel("Bot");
		textBotPower = new JLabel("Power");
		textBotAgility = new JLabel("Agility");
		textBotSpeed = new JLabel("Speed");
		textBotDefense = new JLabel("Defense");
		//ProgressBar
		//Player
		progressBarPlayer = new JProgressBar();
		progressBarPlayerPower = new JProgressBar();
		progressBarPlayerAgility = new JProgressBar();
		progressBarPlayerSpeed = new JProgressBar();
		progressBarPlayerDefense = new JProgressBar();
		//Bot
		progressBarBot = new JProgressBar();
		progressBarBotPower = new JProgressBar();
		progressBarBotAgility = new JProgressBar();
		progressBarBotSpeed = new JProgressBar();
		progressBarBotDefense = new JProgressBar();

		//SetValuesProgressBar
		//Player HP
		progressBarPlayer.setMinimum(0);
		progressBarPlayer.setMaximum(100);
		progressBarPlayer.setStringPainted(true);

		progressBarPlayer.setForeground(Color.decode("#29ff3b"));
		progressBarPlayer.setPreferredSize(new Dimension(500, 50));
		progressBarPlayer.setValue(100);
		//Player Power
		progressBarPlayerPower.setMinimum(0);
		progressBarPlayerPower.setMaximum(11);
		progressBarPlayerPower.setStringPainted(false);

		progressBarPlayerPower.setForeground(Color.red);
		progressBarPlayerPower.setPreferredSize(new Dimension(100, 50));
		progressBarPlayerPower.setValue(0);
		//Player Agility
		progressBarPlayerAgility.setMinimum(0);
		progressBarPlayerAgility.setMaximum(7);
		progressBarPlayerAgility.setStringPainted(false);

		progressBarPlayerAgility.setForeground(Color.PINK);
		progressBarPlayerAgility.setPreferredSize(new Dimension(100, 50));
		progressBarPlayerAgility.setValue(0);
		//Player Speed
		progressBarPlayerSpeed.setMinimum(0);
		progressBarPlayerSpeed.setMaximum(12);
		progressBarPlayerSpeed.setStringPainted(false);

		progressBarPlayerSpeed.setForeground(Color.YELLOW);
		progressBarPlayerSpeed.setPreferredSize(new Dimension(100, 50));
		progressBarPlayerSpeed.setValue(0);
		//Player Defense
		progressBarPlayerDefense.setMinimum(0);
		progressBarPlayerDefense.setMaximum(4);
		progressBarPlayerDefense.setStringPainted(false);

		progressBarPlayerDefense.setForeground(Color.BLUE);
		progressBarPlayerDefense.setPreferredSize(new Dimension(100, 50));
		progressBarPlayerDefense.setValue(0);
		//Bot HP
		progressBarBot.setMinimum(0);
		progressBarBot.setMaximum(100);
		progressBarBot.setStringPainted(true);

		progressBarBot.setForeground(Color.decode("#29ff3b"));
		progressBarBot.setPreferredSize(new Dimension(500, 50));
		progressBarBot.setValue(100);
		//Bot Power
		progressBarBotPower.setMinimum(0);
		progressBarBotPower.setMaximum(11);
		progressBarBotPower.setStringPainted(false);

		progressBarBotPower.setForeground(Color.red);
		progressBarBotPower.setPreferredSize(new Dimension(100, 50));
		progressBarBotPower.setValue(0);
		//Bot Agility
		progressBarBotAgility.setMinimum(0);
		progressBarBotAgility.setMaximum(7);
		progressBarBotAgility.setStringPainted(false);

		progressBarBotAgility.setForeground(Color.PINK);
		progressBarBotAgility.setPreferredSize(new Dimension(100, 50));
		progressBarBotAgility.setValue(0);
		//Bot Speed
		progressBarBotSpeed.setMinimum(0);
		progressBarBotSpeed.setMaximum(12);
		progressBarBotSpeed.setStringPainted(false);

		progressBarBotSpeed.setForeground(Color.YELLOW);
		progressBarBotSpeed.setPreferredSize(new Dimension(100, 50));
		progressBarBotSpeed.setValue(0);
		//Bot Defense
		progressBarBotDefense.setMinimum(0);
		progressBarBotDefense.setMaximum(4);
		progressBarBotDefense.setStringPainted(false);

		progressBarBotDefense.setForeground(Color.BLUE);
		progressBarBotDefense.setPreferredSize(new Dimension(100, 50));
		progressBarBotDefense.setValue(0);

		//progressBar.setValue(progressBar.getValue() - 1);

		//panelButtons1
		panelButtons1.add(buttonChooseCharacter);
		panelButtons1.add(buttonChooseWeapon);
		panelButtons1.add(buttonRanking);

		//panelCharacters
		panelCharacters.add(panelPlayer,BorderLayout.WEST);
		panelPlayer.setLayout(new BoxLayout(panelPlayer,BoxLayout.Y_AXIS));
		panelPlayer.add(textPlayer);
		panelPlayer.add(panelPlayerProgressBar);
		panelPlayerProgressBar.add(progressBarPlayer);
		panelPlayer.add(panelPlayerCharacter);
		panelPlayerCharacter.add(jlabelYouCharacter);
		panelPlayer.add(panelPlayerGeneralStats);
		panelPlayerGeneralStats.add(panelPlayerWeapon);
		panelPlayerWeapon.add(jlabelYouWeapon);
		panelPlayerGeneralStats.add(panelPlayerStats);

		panelPlayerStats.add(panelPlayerStatsText,BorderLayout.WEST);
		panelPlayerStatsText.add(textPlayerPower);
		panelPlayerStatsText.add(textPlayerAgility);
		panelPlayerStatsText.add(textPlayerSpeed);
		panelPlayerStatsText.add(textPlayerDefense);

		panelPlayerStats.add(panelPlayerStatsBars,BorderLayout.EAST);
		panelPlayerStatsBars.add(progressBarPlayerPower);
		panelPlayerStatsBars.add(progressBarPlayerAgility);
		panelPlayerStatsBars.add(progressBarPlayerSpeed);
		panelPlayerStatsBars.add(progressBarPlayerDefense);

		panelCharacters.add(panelBot,BorderLayout.EAST);
		panelBot.setLayout(new BoxLayout(panelBot,BoxLayout.Y_AXIS));
		panelBot.add(textBot);
		panelBot.add(panelBotProgressBar);
		panelBotProgressBar.add(progressBarBot);
		panelBot.add(panelBotCharacter);
		panelBotCharacter.add(jlabelBotCharacter);
		panelBot.add(panelBotGeneralStats);

		panelBotGeneralStats.add(panelBotWeapon);
		panelBotWeapon.add(jlabelBotWeapon);
		panelBotGeneralStats.add(panelBotStats);
		panelBotStats.add(panelBotStatsText,BorderLayout.WEST);
		panelBotStatsText.add(textBotPower);
		panelBotStatsText.add(textBotAgility);
		panelBotStatsText.add(textBotSpeed);
		panelBotStatsText.add(textBotDefense);

		panelBotStats.add(panelBotStatsBars,BorderLayout.EAST);
		panelBotStatsBars.add(progressBarBotPower);
		panelBotStatsBars.add(progressBarBotAgility);
		panelBotStatsBars.add(progressBarBotSpeed);
		panelBotStatsBars.add(progressBarBotDefense);

		//panelButtons2
		panelButtons2.add(buttonNext);
		panelButtons2.add(buttonFight);
		panelButtons2.add(buttonClearConsole);

		//panelTextArea
		panelTextArea.add(scrollPane);


		//Events
		buttonChooseCharacter.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				panelMain.setVisible(false);

				ImageIcon miIcono;

				ArrayList<WarriorContainer> warrioirs = new ArrayList<WarriorContainer>();	

				String query = "select 	w.WARRIOR_ID,r.RACE_HP,r.RACE_STRENGTH,r.RACE_DEFENSE,r.RACE_AGILITY,r.RACE_SPEED,r.RACE_POINTS,w.WARRIOR_NAME,w.WARRIOR_IMAGE_PATH,r.RACE_NAME from WARRIORS w inner join RACES r on w.WARRIORS_RACE_ID=RACE_ID;";

				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection conn = DriverManager.getConnection(urlDatos,usuario,pass);
					Statement stmnt = conn.createStatement();

					ResultSet rs = stmnt.executeQuery(query);

					while(rs.next()) {
						warrioirs.add(new WarriorContainer(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getInt(5)
								, rs.getInt(6), rs.getInt(7), rs.getString(8), rs.getString(9), rs.getString(10)));
					}

				} catch (ClassNotFoundException e1) {
					System.out.println("Driver no se ha cargado correctamente!!");		
				} catch (SQLException e1) {
					System.out.println("Se ha lanzado una SQLException!!");
					e1.printStackTrace();
				}

				warriorsArray = new JButton[warrioirs.size()];

				for(int i = 0; i < warriorsArray.length; i++) {
					warriorsArray[i] = new JButton();
					warriorsArray[i].setSize(150,150);

					miIcono = new ImageIcon("./images/warriors/redimen/"+warrioirs.get(i).getWarriorStringPathImage());
					warriorsArray[i].setIcon(miIcono);

					int indice = i;

					warriorsArray[i].addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							warriorPlayer = warrioirs.get(indice);						
							warriorSelected = true;

							ImageIcon warriorImage = new ImageIcon("./images/warriors/big/"+warriorPlayer.getWarriorStringPathImage());

							jlabelYouCharacter.setIcon(warriorImage);

							weaponSelected = false;
							ImageIcon withoutWeapon = new ImageIcon("./images/XSmall.png");
							jlabelYouWeapon.setIcon(withoutWeapon);

							progressBarPlayerPower.setValue(0);
							progressBarPlayerAgility.setValue(0);
							progressBarPlayerSpeed.setValue(0);
							progressBarPlayerDefense.setValue(0);

							panelMain.setVisible(true);
							panelWarriors.setVisible(false);
							panelWarriors.removeAll();
						}
					});
					panelWarriors.add(warriorsArray[i]);
				}

				panelWarriors.setVisible(true);

			}
		});

		buttonChooseWeapon.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				if(warriorSelected) {

					panelMain.setVisible(false);

					ImageIcon miIcono;

					ArrayList<WeaponContainer> weapons = new ArrayList<WeaponContainer>();

					String query = "select w.WEAPON_ID,w.WEAPON_POINTS,w.WEAPON_STRENGTH,w.WEAPON_SPEED,w.WEAPON_NAME,w.WEAPON_IMAGE_PATH from WEAPONS w inner join WEAPONS_AVAILABLE wa on wa.WEAPON_ID=w.WEAPON_ID \n"
							+ "where wa.RACE_ID = (select RACE_ID from RACES where RACE_NAME = '"+warriorPlayer.getWarriorRace()+"');";

					try {
						Class.forName("com.mysql.cj.jdbc.Driver");
						Connection conn = DriverManager.getConnection(urlDatos,usuario,pass);
						Statement stmnt = conn.createStatement();

						ResultSet rs = stmnt.executeQuery(query);

						while(rs.next()) {
							weapons.add(new WeaponContainer(rs.getInt(1),rs.getInt(2),rs.getInt(3),rs.getInt(4),rs.getString(5),rs.getString(6)));
						}

					} catch (ClassNotFoundException e1) {
						System.out.println("Driver no se ha cargado correctamente!!");		
					} catch (SQLException e1) {
						System.out.println("Se ha lanzado una SQLException!!");
						e1.printStackTrace();
					}

					weaponsArray = new JButton[weapons.size()];

					for(int i = 0; i < weaponsArray.length; i++) {
						weaponsArray[i] = new JButton();
						weaponsArray[i].setSize(150,150);

						miIcono = new ImageIcon("./images/weapons/redimen/"+weapons.get(i).getWeaponImagePath());
						weaponsArray[i].setIcon(miIcono);

						int indice = i;

						weaponsArray[i].addActionListener(new ActionListener() {
							@Override
							public void actionPerformed(ActionEvent e) {
								weaponPlayer = weapons.get(indice);						
								weaponSelected = true;

								ImageIcon weaponImage = new ImageIcon("./images/weapons/redimen/"+weaponPlayer.getWeaponImagePath());

								jlabelYouWeapon.setIcon(weaponImage);

								int power = warriorPlayer.getWarriorStrength() + weaponPlayer.getWeaponStrength();
								int agility = warriorPlayer.getWarriorAgility();
								int speed = warriorPlayer.getWarrioirSpeed() + weaponPlayer.getWeaponSpeed();
								int defense = warriorPlayer.getWarriorDefense();

								progressBarPlayerPower.setValue(power);
								progressBarPlayerAgility.setValue(agility);
								progressBarPlayerSpeed.setValue(speed);
								progressBarPlayerDefense.setValue(defense);

								panelMain.setVisible(true);
								panelWeapons.setVisible(false);
								panelWeapons.removeAll();
							}
						});
						panelWeapons.add(weaponsArray[i]);
					}

					panelWeapons.setVisible(true);

				}else {
					JOptionPane.showMessageDialog(panelMain, "You cannot choose a weapon without having chosen a warrior.","",JOptionPane.ERROR_MESSAGE);
				}

			}
		});

		buttonRanking.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new Ranking();
			}
		});

		buttonFight.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(warriorSelected && weaponSelected) {

					if(botNotRandomized) {
						//Query select random warrior for a bot
						String query = "select 	w.WARRIOR_ID,r.RACE_HP,r.RACE_STRENGTH,r.RACE_DEFENSE,r.RACE_AGILITY,r.RACE_SPEED,r.RACE_POINTS,w.WARRIOR_NAME,w.WARRIOR_IMAGE_PATH,r.RACE_NAME \n"
								+ "from WARRIORS w \n"
								+ "inner join RACES r on w.WARRIORS_RACE_ID=RACE_ID\n"
								+ "order by rand()\n"
								+ "limit 1;";

						try {
							Class.forName("com.mysql.cj.jdbc.Driver");
							Connection conn = DriverManager.getConnection(urlDatos,usuario,pass);
							Statement stmnt = conn.createStatement();

							ResultSet rs = stmnt.executeQuery(query);

							rs.next();

							warriorBot = new WarriorContainer(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getInt(5)
									, rs.getInt(6), rs.getInt(7), rs.getString(8), rs.getString(9), rs.getString(10));


							//Select random weapon for a bot
							query = "select w.WEAPON_ID,w.WEAPON_POINTS,w.WEAPON_STRENGTH,w.WEAPON_SPEED,w.WEAPON_NAME,w.WEAPON_IMAGE_PATH \n"
									+ "from WEAPONS w \n"
									+ "inner join WEAPONS_AVAILABLE wa on wa.WEAPON_ID=w.WEAPON_ID\n"
									+ "where wa.RACE_ID = (select RACE_ID from RACES where RACE_NAME = '"+warriorBot.getWarriorRace()+"')\n"
									+ "order by rand()\n"
									+ "limit 1;";

							rs = stmnt.executeQuery(query);

							rs.next();

							weaponBot = new WeaponContainer(rs.getInt(1),rs.getInt(2),rs.getInt(3),rs.getInt(4),rs.getString(5),rs.getString(6));

							//Set bot images
							ImageIcon warrioirImage = new ImageIcon("./images/warriors/big/"+warriorBot.getWarriorStringPathImage());
							ImageIcon weaponImage = new ImageIcon("./images/weapons/redimen/"+weaponBot.getWeaponImagePath());

							jlabelBotCharacter.setIcon(warrioirImage);
							jlabelBotWeapon.setIcon(weaponImage);

							//Set bot stats
							int power = warriorBot.getWarriorStrength() + weaponBot.getWeaponStrength();
							int agility = warriorBot.getWarriorAgility();
							int speed = warriorBot.getWarrioirSpeed() + weaponBot.getWeaponSpeed();
							int defense = warriorBot.getWarriorDefense();

							progressBarBotPower.setValue(power);
							progressBarBotAgility.setValue(agility);
							progressBarBotSpeed.setValue(speed);
							progressBarBotDefense.setValue(defense);
							
							botNotRandomized = false;

						} catch (ClassNotFoundException e1) {
							System.out.println("Driver no se ha cargado correctamente!!");		
						} catch (SQLException e1) {
							System.out.println("Se ha lanzado una SQLException!!");
							e1.printStackTrace();
						}
					}

					//Hide buttonn
					panelButtons1.setVisible(false);
					buttonFight.setVisible(false);

					buttonNext.setVisible(true);


					//Chose the first warrior to attack
					warriorPlayerAndBotList[0] = warriorPlayer;
					warriorPlayerAndBotList[1] = warriorBot;

					weaponPlayerAndBotList[0] = weaponPlayer;
					weaponPlayerAndBotList[1] = weaponBot;

					int playerSpeed = warriorPlayer.getWarrioirSpeed() + weaponPlayer.getWeaponSpeed(),botSpeed = warriorBot.getWarrioirSpeed() + weaponBot.getWeaponSpeed();
					int playerAgility = warriorPlayer.getWarriorAgility(),botAgility = warriorBot.getWarriorAgility();

					if(playerSpeed > botSpeed){
						actualWarriorToAttack = 0;
					}else if(playerSpeed < botSpeed){
						actualWarriorToAttack = 1;
					}else{
						if(playerAgility > botAgility){
							actualWarriorToAttack = 0;
						}else if(playerAgility < botAgility){
							actualWarriorToAttack = 1;
						}else{
							actualWarriorToAttack = random.nextInt(2);
						}
					}

					if(actualWarriorToAttack == 0){
						actualWarriorToDefend = 1;
					}else{
						actualWarriorToDefend = 0;
					}

					String text = textArea.getText()+"\nThe first attacker is " + (actualWarriorToAttack == 0 ? playerName:"Bot") + "\n";
					textArea.setText(text);
				}else {
					JOptionPane.showMessageDialog(panelMain, "You cannot fight without having chosen a fighter and a weapon.","",JOptionPane.ERROR_MESSAGE);
				}



			}
		});

		buttonNext.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String text = textArea.getText();

				int tryAtacRandom = random.nextInt(101) + 1;
				int tryDefendRandom;

				if(warriorPlayerAndBotList[actualWarriorToAttack].getWarriorAgility() * 10 < tryAtacRandom){
					text = text + (actualWarriorToAttack == 0 ? playerName:"Bot") +" missed.\n";
					textArea.setText(text);
				}else{
					text = text + (actualWarriorToAttack == 0 ? playerName:"Bot") +" attacks the defender.\n";
					textArea.setText(text);

					tryDefendRandom = random.nextInt(51) + 1;
					if(warriorPlayerAndBotList[actualWarriorToDefend].getWarriorAgility() < tryDefendRandom){
						int attackerStrength = warriorPlayerAndBotList[actualWarriorToAttack].getWarriorStrength();
						int attackerWeaponStrength = + weaponPlayerAndBotList[actualWarriorToAttack].getWeaponStrength();
						int defenderStrength = warriorPlayerAndBotList[actualWarriorToDefend].getWarriorDefense();
						int damage = attackerStrength + attackerWeaponStrength - defenderStrength;

						text = text + (actualWarriorToDefend == 0 ? playerName:"Bot") +" has taken " + damage + " points of damage.\n";
						textArea.setText(text);

						warriorPlayerAndBotList[actualWarriorToDefend].subtractLife(damage);

						if(actualWarriorToDefend == 0){
							int maxHP = warriorPlayerAndBotList[actualWarriorToDefend].getMaxHP();
							int actualHP = warriorPlayerAndBotList[actualWarriorToDefend].getWarriorHP();
							int percentage = actualHP * 100 / maxHP;
							progressBarPlayer.setValue(percentage);

							injuriesSuffred += damage;
						}else{
							int maxHP = warriorPlayerAndBotList[actualWarriorToDefend].getMaxHP();
							int actualHP = warriorPlayerAndBotList[actualWarriorToDefend].getWarriorHP();
							int percentage = actualHP * 100 / maxHP;
							progressBarBot.setValue(percentage);

							injuriesCaused += damage;
						}

					}else{
						text = text + (actualWarriorToDefend == 0 ? playerName:"Bot") +" defends.\n";
						textArea.setText(text);
					}
				}



				if(warriorPlayerAndBotList[actualWarriorToDefend].getWarriorHP() <= 0){
					battlePoints += warriorBot.getWarriorPoints() + weaponBot.getWeaponPoints();

					if (actualWarriorToDefend == 1) {
						playerWin = true;
					}else {
						playerWin = false;
					}
					
					int playerOption = JOptionPane.showConfirmDialog(panelMain, "Do you want to keep playing?","Game over",JOptionPane.YES_NO_OPTION);

					
					if(playerOption == JOptionPane.YES_OPTION && !playerWin) {
						//When player loses and checks YES
						//Part 1
						functions.saveBattle(playerName, warriorPlayer.getWarriorId(), weaponPlayer.getWeaponId(), warriorBot.getWarriorId(), weaponBot.getWeaponId(), injuriesCaused, injuriesSuffred, battlePoints);
						injuriesCaused = 0;
						injuriesSuffred = 0;
						battlePoints = 0;

						//Part 2
						warriorBot.setMaxHP();
						progressBarBot.setValue(100);

						warriorSelected = false;
						weaponSelected = false;
						
						jlabelYouCharacter.setIcon(imagePlayerCharacter);
						jlabelYouWeapon.setIcon(imageYouWeapon);
						
						progressBarPlayer.setValue(100);
						progressBarPlayerPower.setValue(0);
						progressBarPlayerAgility.setValue(0);
						progressBarPlayerSpeed.setValue(0);
						progressBarPlayerDefense.setValue(0);
						
						panelButtons1.setVisible(true);
						buttonFight.setVisible(true);

						buttonNext.setVisible(false);
						
						


					}else if(playerOption == JOptionPane.YES_OPTION && playerWin) {
						//When player wins and checks YES

						//Select other bot
						//Query select random warrior for a bot
						String query = "select 	w.WARRIOR_ID,r.RACE_HP,r.RACE_STRENGTH,r.RACE_DEFENSE,r.RACE_AGILITY,r.RACE_SPEED,r.RACE_POINTS,w.WARRIOR_NAME,w.WARRIOR_IMAGE_PATH,r.RACE_NAME \n"
								+ "from WARRIORS w \n"
								+ "inner join RACES r on w.WARRIORS_RACE_ID=RACE_ID\n"
								+ "order by rand()\n"
								+ "limit 1;";

						try {
							Class.forName("com.mysql.cj.jdbc.Driver");
							Connection conn = DriverManager.getConnection(urlDatos,usuario,pass);
							Statement stmnt = conn.createStatement();

							ResultSet rs = stmnt.executeQuery(query);

							rs.next();



							warriorBot = new WarriorContainer(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getInt(5)
									, rs.getInt(6), rs.getInt(7), rs.getString(8), rs.getString(9), rs.getString(10));


							//Select random weapon for a bot
							query = "select w.WEAPON_ID,w.WEAPON_POINTS,w.WEAPON_STRENGTH,w.WEAPON_SPEED,w.WEAPON_NAME,w.WEAPON_IMAGE_PATH \n"
									+ "from WEAPONS w \n"
									+ "inner join WEAPONS_AVAILABLE wa on wa.WEAPON_ID=w.WEAPON_ID\n"
									+ "where wa.RACE_ID = (select RACE_ID from RACES where RACE_NAME = '"+warriorBot.getWarriorRace()+"')\n"
									+ "order by rand()\n"
									+ "limit 1;";

							rs = stmnt.executeQuery(query);

							rs.next();

							weaponBot = new WeaponContainer(rs.getInt(1),rs.getInt(2),rs.getInt(3),rs.getInt(4),rs.getString(5),rs.getString(6));

							//Set bot images
							ImageIcon warrioirImage = new ImageIcon("./images/warriors/big/"+warriorBot.getWarriorStringPathImage());
							ImageIcon weaponImage = new ImageIcon("./images/weapons/redimen/"+weaponBot.getWeaponImagePath());

							jlabelBotCharacter.setIcon(warrioirImage);
							jlabelBotWeapon.setIcon(weaponImage);

							//Set bot stats
							int power = warriorBot.getWarriorStrength() + weaponBot.getWeaponStrength();
							int agility = warriorBot.getWarriorAgility();
							int speed = warriorBot.getWarrioirSpeed() + weaponBot.getWeaponSpeed();
							int defense = warriorBot.getWarriorDefense();

							progressBarBot.setValue(100);

							progressBarBotPower.setValue(power);
							progressBarBotAgility.setValue(agility);
							progressBarBotSpeed.setValue(speed);
							progressBarBotDefense.setValue(defense);

							progressBarPlayer.setValue(100);
							warriorPlayer.setMaxHP();

							//Chose the first warrior to attack
							warriorPlayerAndBotList[0] = warriorPlayer;
							warriorPlayerAndBotList[1] = warriorBot;

							weaponPlayerAndBotList[0] = weaponPlayer;
							weaponPlayerAndBotList[1] = weaponBot;

							int playerSpeed = warriorPlayer.getWarrioirSpeed() + weaponPlayer.getWeaponSpeed(),botSpeed = warriorBot.getWarrioirSpeed() + weaponBot.getWeaponSpeed();
							int playerAgility = warriorPlayer.getWarriorAgility(),botAgility = warriorBot.getWarriorAgility();

							if(playerSpeed > botSpeed){
								actualWarriorToAttack = 0;
							}else if(playerSpeed < botSpeed){
								actualWarriorToAttack = 1;
							}else{
								if(playerAgility > botAgility){
									actualWarriorToAttack = 0;
								}else if(playerAgility < botAgility){
									actualWarriorToAttack = 1;
								}else{
									actualWarriorToAttack = random.nextInt(2);
								}
							}

							if(actualWarriorToAttack == 0){
								actualWarriorToDefend = 1;
							}else{
								actualWarriorToDefend = 0;
							}

							text = textArea.getText()+"\nThe first attacker is " + (actualWarriorToAttack == 0 ? playerName:"Bot") + "\n";
							textArea.setText(text);

						} catch (ClassNotFoundException e1) {
							System.out.println("Driver no se ha cargado correctamente!!");		
						} catch (SQLException e1) {
							System.out.println("Se ha lanzado una SQLException!!");
							e1.printStackTrace();
						}


					}else {
						//When player loses and checks YES

						//When player checks NO
						dispose();
						functions.saveBattle(playerName, warriorPlayer.getWarriorId(), weaponPlayer.getWeaponId(), warriorBot.getWarriorId(), weaponBot.getWeaponId(), injuriesCaused, injuriesSuffred, battlePoints);

					}
				}


				int attackerSpeed = warriorPlayerAndBotList[actualWarriorToAttack].getWarrioirSpeed() + weaponPlayerAndBotList[actualWarriorToAttack].getWeaponSpeed();
				int defensorSpeed =  warriorPlayerAndBotList[actualWarriorToDefend].getWarrioirSpeed() + weaponPlayerAndBotList[actualWarriorToDefend].getWeaponSpeed();


				if(attackerSpeed <= defensorSpeed){
					if(actualWarriorToAttack == 0){actualWarriorToAttack = 1; actualWarriorToDefend = 0;}
					else{actualWarriorToAttack = 0; actualWarriorToDefend = 1;}
				}else{
					int randomNumber = random.nextInt(101) + 1;
					if((attackerSpeed - defensorSpeed) * 10 < randomNumber){
						if(actualWarriorToAttack == 0){actualWarriorToAttack = 1; actualWarriorToDefend = 0;}
						else{actualWarriorToAttack = 0; actualWarriorToDefend = 1;}
					}
				}
			}
		});
		
		buttonClearConsole.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				textArea.setText("");
				
			}
		});

		//AddPanels
		panelMain.add(panelButtons1);
		panelMain.add(panelCharacters);
		panelMain.add(panelButtons2);
		panelMain.add(panelTextArea);

		panel.add(panelMain);
		panel.add(panelWarriors);
		panel.add(panelWeapons);

		this.add(panel);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//		this.setSize(1000,600);
		this.pack();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
}
