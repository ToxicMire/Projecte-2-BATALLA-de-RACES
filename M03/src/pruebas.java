//import java.awt.BorderLayout;
//import java.awt.Color;
//import java.awt.Dimension;
//import java.awt.Graphics;
//import java.awt.Image;
//
//import javax.swing.*;
//
//public class pruebas {
//    public static void main(String[] args) {
//        new ventana();
//    }
//}
//
//class ventana extends JFrame {
//	private FondoPanel panel = new FondoPanel("imagen.jpeg");
//	private JPanel panel1,panel2,panel3;
//	private JButton b1;
//	
//	public ventana() {
//		panel1 = new JPanel();
//		panel2 = new JPanel();
//		panel3 = new JPanel();
//
//		b1 = new JButton("hola");
//		
//		panel1.setBounds(0, 0, 200, 300);
//		panel1.add(b1);
//		
//		panel1.setBorder(BorderFactory.createLineBorder(Color.BLACK));
//		
//		panel1.setPreferredSize(new Dimension(200, 200));
//        panel1.setBackground(new Color(0, 0, 0, 0));
//		panel.add(panel1);
//		
//		this.add(panel);
//		
//		
//		this.getContentPane().add(panel, BorderLayout.CENTER);
//		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		this.setSize(201,300);
//		this.setLocationRelativeTo(null);
//		this.setVisible(true);
//	}
//}
//
//
//class FondoPanel extends JPanel {
//    private Image imagenFondo;
//
//    public FondoPanel(String rutaImagen) {
//        this(new ImageIcon(rutaImagen).getImage());
//    }
//
//    public FondoPanel(Image imagen) {
//        imagenFondo = imagen;
//        Dimension size = new Dimension(imagenFondo.getWidth(null), imagenFondo.getHeight(null));
//        setPreferredSize(size);
//        setMinimumSize(size);
//        setMaximumSize(size);
//        setSize(size);
//        setLayout(null);
//    }
//
//    @Override
//    protected void paintComponent(Graphics g) {
//        super.paintComponent(g);
//        g.drawImage(imagenFondo, 0, 0, null);
//    }
//}
