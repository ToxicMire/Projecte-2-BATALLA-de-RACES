import javax.swing.*; import java.awt.*;

public class Frame2 extends JFrame {

    // BUTTONS —————————————————————————————————————————————————————————————————————————————————————————————————————————
    // First of all, we create the buttons that we will use in "Frame2". It should ask the player which character they
    // will play, then we will do the same but with the weapon. Finally, we will need a button that shows the ranking.
    private JButton chooseCharacter;
    private JButton chooseWeapon;
    private JButton showRanking;

    // CONFIGURATION OF THE GAME ———————————————————————————————————————————————————————————————————————————————————————
    // We have to configure the functionality and aesthetic of "Frame2".
    public Frame2(String username) {

        // First, we have to set a title, and we have chosen "BATTLE OF RACES: Game", because is the frame where
        // the game will take place.
        super("BATTLE OF RACES: Game" + username);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 600);

        // MIDDLE SCREEN ———————————————————————————————————————————————————————————————————————————————————————————————
        // Here we configure the game to start up in the middle of the screen.
        // First, with "Toolkit.getDefaultToolkit().getScreenSize()" we can get the screen's dimension of the computer
        // that the user's is playing from. We save the dimension in a variable named "dim" and then we have to divide
        // "dim" (the dimensions) by 2 to let the game start up from the middle.
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (dim.width - getWidth()) / 2;
        int y = (dim.height - getHeight()) / 2;
        setLocation(x, y);

        JPanel panel = new JPanel();

        // USER'S SETTINGS —————————————————————————————————————————————————————————————————————————————————————————————
        // Now that we have the window of the panel configured, we need to ask the player what character will they
        // choose. The "setFont" method is only to make a medieval aesthetic to the game. We chose that font because it
        // matches with the desired aesthetic.
        chooseCharacter = new JButton("Choose Character");
        chooseCharacter.setBorderPainted(false);
        chooseCharacter.setContentAreaFilled(false);
        chooseCharacter.setFocusPainted(false);
        chooseCharacter.setOpaque(false);
        chooseCharacter.setFont(new Font("C059", Font.PLAIN, 18));
        chooseCharacter.setMargin(new Insets(30, 30, 30, 30));

        // WEAPON'S BUTTON —————————————————————————————————————————————————————————————————————————————————————————————
        // We need to ask the player what weapon will they choose. The "setFont" method is only to make a medieval
        // aesthetic to the game. We chose that font because it matches with the desired aesthetic.
        chooseWeapon = new JButton("Choose Weapon");
        chooseWeapon.setBorderPainted(false);
        chooseWeapon.setContentAreaFilled(false);
        chooseWeapon.setFocusPainted(false);
        chooseWeapon.setOpaque(false);
        chooseWeapon.setFont(new Font("C059", Font.PLAIN, 18));
        chooseWeapon.setMargin(new Insets(30, 30, 30, 30));

        // RANKING BUTTON ——————————————————————————————————————————————————————————————————————————————————————————————
        // Here we will make a button that will show the ranking. The "setFont" method is only to make a medieval
        // aesthetic to the game. We chose that font because it matches with the desired aesthetic.
        showRanking = new JButton("Ranking");
        showRanking.setBorderPainted(false);
        showRanking.setContentAreaFilled(false);
        showRanking.setFocusPainted(false);
        showRanking.setOpaque(false);
        showRanking.setFont(new Font("Arial", Font.PLAIN, 18));
        showRanking.setMargin(new Insets(30, 30, 30, 30));

        panel.add(chooseCharacter);
        panel.add(chooseWeapon);
        panel.add(showRanking);

        getContentPane().add(panel, BorderLayout.NORTH);

        // TODO | % of life. It should show two panels showing the character's life, but it only shows one panel that
        //  merges Panel1 and Panel2.
        JPanel lifePanel1 = new JPanel();
        lifePanel1.setPreferredSize(new Dimension(150, 30));
        lifePanel1.setBackground(Color.BLACK);
        lifePanel1.setLayout(new BorderLayout());

        // The system of % of life works. If you change the value of "width", the green color changes correctly.
        JPanel lifeBar1 = new JPanel();
        lifeBar1.setBackground(Color.GREEN);
        lifeBar1.setPreferredSize(new Dimension(100, 30));
        lifePanel1.add(lifeBar1, BorderLayout.WEST);

        // TODO | % of life. It should show two panels showing the character's life, but it only shows one panel that
        //  merges Panel1 and Panel2.
        JPanel lifePanel2 = new JPanel();
        lifePanel2.setPreferredSize(new Dimension(510, 30));
        lifePanel2.setBackground(Color.BLACK);
        lifePanel2.setLayout(new BorderLayout());

        // The system of % of life barely works. If you change the value of "width", the green color changes correctly,
        // but it should delete the green color in the opposite way.
        JPanel lifeBar2 = new JPanel();
        lifeBar2.setBackground(Color.GREEN);
        lifeBar2.setPreferredSize(new Dimension(510, 30));
        lifePanel2.add(lifeBar2, BorderLayout.EAST);

        // ADDING THE LIFE'S BOXES TO THE WINDOW.
        JPanel lifePanels = new JPanel(new GridLayout(1, 2));
        lifePanels.add(lifePanel1);
        lifePanels.add(lifePanel2);

        getContentPane().add(lifePanels, BorderLayout.SOUTH);

        setVisible(true);
    }
}