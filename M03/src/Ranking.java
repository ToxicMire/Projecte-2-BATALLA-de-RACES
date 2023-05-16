import javax.swing.*; import javax.swing.table.*; import java.awt.*; import java.awt.event.*; import java.sql.*;


class Ranking extends JFrame{
    // RANKING
    JPanel p1 = new JPanel();
    private JTable table;
    private JScrollPane scroll;

    public Ranking() {
        String[] nomCol = {"POSITION", "USERNAME", "BATTLE POINTS", "INJURIES TAKEN", "INJURIES SUFFRED"};
        int position = 1;
        int index = 0;
        String[][] data = new String[10][5];

        // BBDD connections.
        String urlDatos = "jdbc:mysql://localhost/battle_of_races?serverTimezone=UTC";
        String usuario = "admin";
        String pass = "P@ssw0rd!";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(urlDatos,usuario,pass);
            Statement stmnt = conn.createStatement();
            String query = "select p.PLAYER_NAME,sum(BATTLE_POINTS),sum(INJURIES_CAUSED),sum(INJURIES_SUFFERED) \n" +
            "from BATTLE b\n" +  "inner join PLAYERS p on p.PLAYER_ID=b.PLAYER_ID\n" +
            "GROUP BY PLAYER_NAME\n" +  "order by sum(BATTLE_POINTS) DESC\n" +  "LIMIT 10;";
            ResultSet rs = stmnt.executeQuery(query);

            while(rs.next()){
                data[index] = new String[]{"" + (index+1), rs.getString(1), "" + rs.getInt(2),
                        "" + rs.getInt(3), "" + rs.getInt(4)};

                table = new JTable(data, nomCol);
                table.setEnabled(false);
                table.setRowHeight(50);
                table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
                scroll = new JScrollPane(table);
                index++;
            }
        } catch (ClassNotFoundException e1) {
            System.out.println("Driver no se ha cargado correctamente!!");
        } catch (SQLException e1) {
            System.out.println("Se ha lanzado una SQLException!!");
            e1.printStackTrace();
        }

        MyTableCellRenderer renderer = new MyTableCellRenderer();

        // Configura la tabla para utilizar el renderizador para todas las columnas
        for(int i = 0; i < nomCol.length; i++) {
            table.getColumnModel().getColumn(i).setCellRenderer(renderer);
        }


        TableColumnModel columnModel = table.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(80);
        columnModel.getColumn(1).setPreferredWidth(150);
        columnModel.getColumn(2).setPreferredWidth(150);
        columnModel.getColumn(3).setPreferredWidth(150);
        columnModel.getColumn(4).setPreferredWidth(150);

        this.add(scroll, BorderLayout.CENTER);
        this.setTitle("Ranking");
        this.setSize(700, 500);
        this.setResizable(false);
        this.setVisible(true);

        // MIDDLE SCREEN ———————————————————————————————————————————————————————————————————————————————————————————————
        // Here we configure the game to start up in the middle of the screen.
        // First, with "Toolkit.getDefaultToolkit().getScreenSize()" we can get the screen's dimension of the computer
        // that the user's is playing from. We save the dimension in a variable named "dim" and then we have to divide
        // "dim" (the dimensions) by 2 to let the game start up from the middle.
        this.setLocationRelativeTo(null);
    }
    
    public class MyTableCellRenderer extends DefaultTableCellRenderer {

        // Constructor.
        public MyTableCellRenderer() {
            super();
        }

        // Sobrescribe el método getTableCellRendererComponent para configurar el fondo de cada celda.
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
                                                       int row, int column) {

            // Llama al método padre para configurar la apariencia básica de la celda.
            Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

            // Configura el fondo de la celda según el número de fila.
            if(row == 0) {
                cell.setBackground(Color.decode("#FFD700"));
            } else if(row == 1) {
                cell.setBackground(Color.decode("#C0C0C0"));
            } else if(row == 2) {
                cell.setBackground(Color.decode("#CD7F32"));
            } else {
                cell.setBackground(table.getBackground());
            }
            return cell;
        }
    }
}