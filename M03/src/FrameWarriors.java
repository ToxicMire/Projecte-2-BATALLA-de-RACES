import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

public class FrameWarriors extends JFrame{
	private JButton[] warriorsArray = new JButton[9]; 
	private JPanel masterPanel;
	private ImageIcon miIcono;


	public FrameWarriors(ArrayList<WarriorContainer> warrioirs) {
		masterPanel = new JPanel();
		masterPanel.setLayout(new GridLayout(3,3));

		for(int i = 0; i < warriorsArray.length; i++) {
			warriorsArray[i] = new JButton();
			warriorsArray[i].setSize(150,150);
			
			miIcono = new ImageIcon("./images/warriors/"+warrioirs.get(i).getWarriorStringPathImage());
			warriorsArray[i].setIcon(miIcono);
			
			int indice = i;
			
			warriorsArray[i].addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					System.out.println(indice);
					
				}
			});
			

			masterPanel.add(warriorsArray[i]);
		}
	
//		Configuraciones del JFrame
		this.add(masterPanel);
		
		this.setTitle("Select your Warrior");
		this.setSize(450,450);
//		this.pack();
		this.setResizable(true);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);

	}
}
