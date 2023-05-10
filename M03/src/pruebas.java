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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.*;

public class pruebas {
	public static void main(String[] args) {
		new FrameMain();
	}
}

class FrameMain extends JFrame {
	//Swing
	private JPanel panel,panelMain,panelWarriors,panelWeapons,panelButtons1,panelCharacters,panelButtons2,panelTextArea;
	private JPanel panelPlayer,panelPlayerProgressBar,panelPlayerCharacter,panelPlayerGeneralStats,panelPlayerWeapon,panelPlayerStats,panelPlayerStatsText,panelPlayerStatsBars,
				   panelBot,panelBotProgressBar,panelBotCharacter,panelBotGeneralStats,panelBotWeapon,panelBotStats,panelBotStatsText,panelBotStatsBars;
	
	private JButton buttonChooseCharacter,buttonChooseWeapon,buttonRanking,buttonFight,buttonClearConsole;
	private JTextArea textArea;
	private JLabel textPlayer,textPlayerPower,textPlayerAgility,textPlayerSpeed,textPlayerDefense,
				   textBot,textBotPower,textBotAgility,textBotSpeed,textBotDefense;
	
	private ImageIcon imageYouCharacter,imageYouWeapon,imageBotCharacter,imageBotWeapon;
	private JLabel jlabelYouCharacter,jlabelYouWeapon,jlabelBotCharacter,jlabelBotWeapon;
	
	private JProgressBar progressBarPlayer,progressBarPlayerPower,progressBarPlayerAgility,progressBarPlayerSpeed,progressBarPlayerDefense;
	private JProgressBar progressBarBot,progressBarBotPower,progressBarBotAgility,progressBarBotSpeed,progressBarBotDefense;
	
	//Variables
	private JButton[] warriorsArray;
	
	private boolean warriorSelected = false,weaponSelected = false;
	
	

	public FrameMain() {
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
			//TextArea
		textArea = new JTextArea(5,100);
			//ImageIcon
		imageYouCharacter = new ImageIcon("./images/X.png");
		imageYouWeapon = new ImageIcon("./images/XSmall.png");
		imageBotCharacter = new ImageIcon("./images/X.png");
		imageBotWeapon = new ImageIcon("./images/XSmall.png");
			//JLabel
		jlabelYouCharacter = new JLabel(imageYouCharacter);
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
		progressBarPlayerPower.setMaximum(100);
		progressBarPlayerPower.setStringPainted(false);
		
		progressBarPlayerPower.setForeground(Color.red);
		progressBarPlayerPower.setPreferredSize(new Dimension(100, 50));
		progressBarPlayerPower.setValue(100);
					//Player Agility
		progressBarPlayerAgility.setMinimum(0);
		progressBarPlayerAgility.setMaximum(100);
		progressBarPlayerAgility.setStringPainted(false);
		
		progressBarPlayerAgility.setForeground(Color.PINK);
		progressBarPlayerAgility.setPreferredSize(new Dimension(100, 50));
		progressBarPlayerAgility.setValue(100);
					//Player Speed
		progressBarPlayerSpeed.setMinimum(0);
		progressBarPlayerSpeed.setMaximum(100);
		progressBarPlayerSpeed.setStringPainted(false);
		
		progressBarPlayerSpeed.setForeground(Color.YELLOW);
		progressBarPlayerSpeed.setPreferredSize(new Dimension(100, 50));
		progressBarPlayerSpeed.setValue(100);
					//Player Defense
		progressBarPlayerDefense.setMinimum(0);
		progressBarPlayerDefense.setMaximum(100);
		progressBarPlayerDefense.setStringPainted(false);
		
		progressBarPlayerDefense.setForeground(Color.BLUE);
		progressBarPlayerDefense.setPreferredSize(new Dimension(100, 50));
		progressBarPlayerDefense.setValue(100);
					//Bot HP
		progressBarBot.setMinimum(0);
		progressBarBot.setMaximum(100);
		progressBarBot.setStringPainted(true);
		
		progressBarBot.setForeground(Color.decode("#29ff3b"));
		progressBarBot.setPreferredSize(new Dimension(500, 50));
		progressBarBot.setValue(100);
					//Bot Power
		progressBarBotPower.setMinimum(0);
		progressBarBotPower.setMaximum(100);
		progressBarBotPower.setStringPainted(false);
		
		progressBarBotPower.setForeground(Color.red);
		progressBarBotPower.setPreferredSize(new Dimension(100, 50));
		progressBarBotPower.setValue(100);
					//Bot Agility
		progressBarBotAgility.setMinimum(0);
		progressBarBotAgility.setMaximum(100);
		progressBarBotAgility.setStringPainted(false);
		
		progressBarBotAgility.setForeground(Color.PINK);
		progressBarBotAgility.setPreferredSize(new Dimension(100, 50));
		progressBarBotAgility.setValue(100);
					//Bot Speed
		progressBarBotSpeed.setMinimum(0);
		progressBarBotSpeed.setMaximum(100);
		progressBarBotSpeed.setStringPainted(false);
		
		progressBarBotSpeed.setForeground(Color.YELLOW);
		progressBarBotSpeed.setPreferredSize(new Dimension(100, 50));
		progressBarBotSpeed.setValue(100);
					//Bot Defense
		progressBarBotDefense.setMinimum(0);
		progressBarBotDefense.setMaximum(100);
		progressBarBotDefense.setStringPainted(false);
		
		progressBarBotDefense.setForeground(Color.BLUE);
		progressBarBotDefense.setPreferredSize(new Dimension(100, 50));
		progressBarBotDefense.setValue(100);
		
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
		panelButtons2.add(buttonFight);
		panelButtons2.add(buttonClearConsole);
		
		//panelTextArea
		panelTextArea.add(textArea);
		
		
		//Events
		buttonChooseCharacter.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				panelMain.setVisible(false);
				
				ImageIcon miIcono;
				
				ArrayList<WarriorContainer> warrioirs = new ArrayList<WarriorContainer>();
				ArrayList<WeaponContainer> weapons = new ArrayList<WeaponContainer>();
				int indexWarriorSelected;
				
				
				//Conexiones BBDD
				String urlDatos = "jdbc:mysql://localhost/battle_of_races?serverTimezone=UTC";
				String usuario = "admin";
				String pass = "admin123";
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
							panelMain.setVisible(true);
							panelWarriors.setVisible(false);
							panelWarriors.removeAll();
							System.out.println(indice);
							
							System.out.println(warriorsArray.length + " - " + warrioirs.size());
							
						}
					});
					

					panelWarriors.add(warriorsArray[i]);
				}
				
				
				
				panelWarriors.setVisible(true);
				
			}
		});
		
		
		panelMain.add(panelButtons1);
		panelMain.add(panelCharacters);
		panelMain.add(panelButtons2);
		panelMain.add(panelTextArea);
		
		panel.add(panelMain);
		panel.add(panelWarriors);
		
		this.add(panel);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		this.setSize(1000,600);
		this.pack();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
}
