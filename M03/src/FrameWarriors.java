import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

public class FrameWarriors extends JFrame{
	private JButton[] weaponsArray;
	private JPanel masterPanel, panelPendejo;
	private ImageIcon miIcono;


	public FrameWarriors(ArrayList<WeaponContainer> weapons) {
		masterPanel = new JPanel();
		masterPanel.setLayout(new GridLayout(3,3));
		
		panelPendejo = new JPanel();
		panelPendejo.setLayout(new BoxLayout(panelPendejo,BoxLayout.Y_AXIS));
		
		weaponsArray = new JButton[weapons.size()]; 

		for(int i = 0; i < weaponsArray.length; i++) {
			weaponsArray[i] = new JButton();
			miIcono = new ImageIcon("./images/weapons/redimen/"+weapons.get(i).getWeaponImagePath());
			weaponsArray[i].setSize(150,150);
			
			weaponsArray[i].setIcon(miIcono);
			
			int indice = i;
			
			weaponsArray[i].addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					System.out.println(weapons.get(indice));
					
				}
			});
			

			masterPanel.add(weaponsArray[i]);
		}
	
		panelPendejo.add(masterPanel);
//		Configuraciones del JFrame
		this.add(panelPendejo);
		
		this.setTitle("Select your Warrior");
//		this.setSize(450,450);
		this.pack();
		this.setResizable(true);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);

	}
}
