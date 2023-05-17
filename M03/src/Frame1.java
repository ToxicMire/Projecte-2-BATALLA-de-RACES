                                //  ————————————————————————————————————————————
                                // |                 IMPORTS                    |
                                //  ————————————————————————————————————————————

import javax.swing.*; import java.awt.*; import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Frame1 extends JFrame {

    private JPanel panel1 = new JPanel();
    private JPanel separationPanel1 = new JPanel();
    private JPanel separationPanel2 = new JPanel();
    

    // BUTTONS —————————————————————————————————————————————————————————————————————————————————————————————————————————
    // First of all, we create the buttons that we will use in "Frame1". It should ask the user their name
    // ("usernameField") and let them play ("startButton") or exit the game ("exitButton").
    private FondoPanel panel = new FondoPanel("./medieval.jpeg");
    private JTextField usernameField;
    private JButton startButton;
    private JButton exitButton;
    

    // CONFIGURATION OF THE GAME ———————————————————————————————————————————————————————————————————————————————————————
    // We have to configure the functionality and aesthetic of "Frame1".
    public Frame1() {

        panel1.setBounds(0, 0, 800, 400);

        panel1.setPreferredSize(new Dimension(800, 480));
        panel1.setBackground(new Color(0, 0, 0, 0));
        //panel1.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        panel1.setLayout((new BoxLayout(panel1, BoxLayout.Y_AXIS)));
        panel1.setBorder(BorderFactory.createEmptyBorder(150,0,0,0));
        
        separationPanel1.setSize(100,100);
        separationPanel1.setOpaque(false);
        
        separationPanel2.setSize(50,50);
        separationPanel2.setOpaque(false);
        
        



        // First, we have to set a title, and we have chosen "BATTLE OF RACES: Welcome!", because is the frame where
        // we will ask the player their name and what they want to do: play or exit the game.
        setTitle("BATTLE OF RACES: Welcome!");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        // MIDDLE SCREEN ———————————————————————————————————————————————————————————————————————————————————————————————
        // Here we configure the game to start up in the middle of the screen.
        // First, with "Toolkit.getDefaultToolkit().getScreenSize()" we can get the screen's dimension of the computer
        // that the user's is playing from. We save the dimension in a variable named "dim" and then we have to divide
        // "dim" (the dimensions) by 2 to let the game start up from the middle.
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (dim.width - getWidth()) / 2;
        int y = (dim.height - getHeight()) / 2;
        setLocation(x, y);

        // USER'S SETTINGS —————————————————————————————————————————————————————————————————————————————————————————————
        // Now that we have the window of the panel configured, we need to ask the player what will their username be.
        // The "setFont" method is only to make a medieval aesthetic to the game. We chose that font because it matches
        // with the desired aesthetic.
        JLabel usernameLabel = new JLabel("Write your username:");
        usernameLabel.setFont(new Font("C059", Font.PLAIN, 20));
        usernameLabel.setHorizontalAlignment(JLabel.CENTER);
        usernameLabel.setVerticalAlignment(JLabel.CENTER);
        usernameField = new JTextField(1);
        usernameField.setMaximumSize(new Dimension(200, 20));
        
        
        
        // START BUTTON ————————————————————————————————————————————————————————————————————————————————————————————————
        // The "setFont" method is only to make a medieval aesthetic to the game. We chose that font because it matches
        // with the desired aesthetic.
        startButton = new JButton("Start game");
        startButton.setFont(new Font("C059", Font.PLAIN, 14));
        startButton.setMargin(new Insets(10, 20, 10, 20));
        
     

        // EXIT BUTTON —————————————————————————————————————————————————————————————————————————————————————————————————
        // The "setFont" method is only to make a medieval aesthetic to the game. We chose that font because it matches
        // with the desired aesthetic.
        exitButton = new JButton("Exit game");
        exitButton.setFont(new Font("C059", Font.PLAIN, 14));
        exitButton.setMargin(new Insets(10, 10, 10, 10));

//        JPanel usernamePanel = new JPanel();
//        usernamePanel.setLayout(new BoxLayout(usernamePanel, BoxLayout.Y_AXIS));
        panel1.add(usernameLabel);
        panel1.add(usernameField);
        
        panel1.add(separationPanel1);
//        JPanel buttonPanel = new JPanel();
//        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));
        panel1.add(startButton);
        
        panel1.add(separationPanel2);
//        JPanel exitButtonPanel = new JPanel();
//        exitButtonPanel.setLayout(new BoxLayout(exitButtonPanel, BoxLayout.Y_AXIS));
        panel1.add(exitButton);

//        panel1.add(usernameLabel);
//        panel1.add(usernameField);
//        panel1.add(startButton);
//        panel1.add(exitButton);

        panel.add(panel1);
        panel1.setAlignmentX(panel1.CENTER_ALIGNMENT);
        usernameLabel.setAlignmentX(usernameLabel.CENTER_ALIGNMENT);
        usernameField.setAlignmentX(usernameField.CENTER_ALIGNMENT);
        startButton.setAlignmentX(startButton.CENTER_ALIGNMENT);
        exitButton.setAlignmentX(exitButton.CENTER_ALIGNMENT);
        
        this.add(panel);

        // ADDING ALL TO THE WINDOW ————————————————————————————————————————————————————————————————————————————————————
        panel1.add(Box.createVerticalGlue());
//        panel1.add(usernamePanel);
//        panel1.add(buttonPanel);
//        panel1.add(exitButtonPanel);
        panel1.add(Box.createVerticalGlue());
        // add(mainPanel);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);

        // START BUTTON ————————————————————————————————————————————————————————————————————————————————————————————————
        // What we do here is add a new "ActionListener()" to indicate the button that his action is execute "Frame".
        // First, we have to make the window invisible with the command "setVisible(false)" so it doesn't open until
        // it has to. Then we [...]. Finally, we make the window visible with the command "setVisible(true)" so the
        // user can interact with "Frame2".
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {                
                String text = usernameField.getText();
                
                //If the username is a space or is empty, an error message will appear.
                if (text.equals("")) {
                	JOptionPane.showMessageDialog(usernameLabel, "Enter a username", "", JOptionPane.ERROR_MESSAGE);
                }
                else {
                	String urlDatos = "jdbc:mysql://localhost/battle_of_races?serverTimezone=UTC";
            		String usuario = "admin";
            		String pass = "P@ssw0rd!";
            		
            		//We check if the username does not exist, we insert it into the database and we execute the Game Frame (Frame 2)
            		String query = "SELECT IF(COUNT(*) > 0, 1, 0) AS existe FROM PLAYERS WHERE PLAYER_NAME = '" + text + "'";
            		
            		try {
            			Class.forName("com.mysql.cj.jdbc.Driver");
    					Connection conn = DriverManager.getConnection(urlDatos,usuario,pass);
    					Statement stmnt = conn.createStatement();

    					ResultSet rs = stmnt.executeQuery(query);	
    					
    					rs.next();
    					
    					if(rs.getInt(1) == 0) {
        					String update = "INSERT INTO PLAYERS (PLAYER_NAME) VALUES('" + text + "')";
    						
	            			PreparedStatement ps = conn.prepareStatement(update);
	            			ps.executeUpdate();
    					}



            		} catch (ClassNotFoundException e1) {
            			System.out.println("Driver no se ha cargado correctamente!!");		
            		} catch (SQLException e1) {
            			System.out.println("Se ha lanzado una SQLException!!");
            			e1.printStackTrace();
            		}
            		
                	
                	//Make Frame 1 invisible and run Frame 2 (game)
                	setVisible(false);
                	new Frame2(text);
                }
                
            }
        });

        // EXIT BUTTON —————————————————————————————————————————————————————————————————————————————————————————————————
        // What we do here is add a new "ActionListener()" to indicate the button that his action is closing the game
        // with the command "System.exit(0)".
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        
        
}


    // PROGRAM —————————————————————————————————————————————————————————————————————————————————————————————————————————
    // Here we make the program executable! :)
    public static void main(String[] args) {
        Frame1 frame1 = new Frame1();
        frame1.setVisible(true);
    }

    class FondoPanel extends JPanel {
        private Image imagenFondo;

        public FondoPanel(String rutaImagen) {
            this(new ImageIcon(rutaImagen).getImage());
        }

        public FondoPanel(Image imagen) {
            imagenFondo = imagen;
            Dimension size = new Dimension(imagenFondo.getWidth(null), imagenFondo.getHeight(null));
            setPreferredSize(size);
            setMinimumSize(size);
            setMaximumSize(size);
            setSize(size);
            setLayout(null);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(imagenFondo, 0, 0, null);
        }
    }
}