import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class pruebas {
	public static void main(String[] args) {
		new ventana();
	}
}

class ventana extends JFrame {
	private JPanel panel,panelButtons1,panelCharacters,panelButtons2,panelTextArea;
	private JPanel panelYouStats,panelBotStats;
	private JButton buttonChooseCharacter,buttonChooseWeapon,buttonRanking,buttonFight,buttonClearConsole;
	private JTextArea textArea;
	private JLabel textPlayer,textBot;
	
	private ImageIcon imageYouCharacter,imageYouWeapon,imageBotCharacter,imageBotWeapon;
	private JLabel jlabelYouCharacter,jlabelYouWeapon,jlabelBotCharacter,jlabelBotWeapon;
	
	private JProgressBar progressBarYou,progressBarYouPower,progressBarYouAgility,progressBarYouSpeed,progressBarYouDefense;
	private JProgressBar progressBarBot,progressBarBotPower,progressBarBotAgility,progressBarBotSpeed,progressBarBotDefense;

	public ventana() {
		//Variables
			//Panels
		panel = new JPanel();
		panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));
		panelButtons1 = new JPanel();
		panelCharacters = new JPanel();
		panelButtons2 = new JPanel();
		panelTextArea = new JPanel();
		
		panelYouStats = new JPanel();
		panelBotStats = new JPanel();
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
		textBot = new JLabel("Bot");
			//ProgressBar
				//Player
		progressBarYou = new JProgressBar();
		progressBarYouPower = new JProgressBar();
		progressBarYouAgility = new JProgressBar();
		progressBarYouSpeed = new JProgressBar();
		progressBarYouDefense = new JProgressBar();
				//Bot
		progressBarBot = new JProgressBar();
		progressBarBotPower = new JProgressBar();
		progressBarBotAgility = new JProgressBar();
		progressBarBotSpeed = new JProgressBar();
		progressBarBotDefense = new JProgressBar();

				//SetValuesProgressBar
					//You HP
		progressBarYou.setMinimum(0);
		progressBarYou.setMaximum(100);
		progressBarYou.setStringPainted(true);
		
		progressBarYou.setForeground(Color.decode("#29ff3b"));
		progressBarYou.setPreferredSize(new Dimension(300, 50));
		progressBarYou.setValue(100);
					//You Power
					//You Agility
					//You Speed
					//You Defense
		
					//Bot HP
		progressBarBot.setMinimum(0);
		progressBarBot.setMaximum(100);
		progressBarBot.setStringPainted(true);
		
		progressBarBot.setForeground(Color.decode("#29ff3b"));
		progressBarBot.setPreferredSize(new Dimension(300, 50));
		progressBarBot.setValue(100);
					//Bot Power
					//Bot Agility
					//Bot Speed
					//Bot Defense
		
		//progressBar.setValue(progressBar.getValue() - 1);
		
		//panelButtons1
		panelButtons1.add(buttonChooseCharacter);
		panelButtons1.add(buttonChooseWeapon);
		panelButtons1.add(buttonRanking);
		
		//panelCharacters
		panelCharacters.add(panelYouStats,BorderLayout.WEST);
		
		panelYouStats.add(textPlayer);
		panelYouStats.add(progressBarYou);
		panelYouStats.add(jlabelYouCharacter);
		
		panelCharacters.add(panelBotStats,BorderLayout.EAST);
		panelBotStats.add(textBot);
		panelBotStats.add(progressBarBot);
		panelBotStats.add(jlabelBotCharacter);
		
		//panelButtons2
		panelButtons2.add(buttonFight);
		panelButtons2.add(buttonClearConsole);
		
		//panelTextArea
		panelTextArea.add(textArea);
		
		panel.add(panelButtons1);
		panel.add(panelCharacters);
		panel.add(panelButtons2);
		panel.add(panelTextArea);
		
		this.add(panel);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(1000,600);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
}
