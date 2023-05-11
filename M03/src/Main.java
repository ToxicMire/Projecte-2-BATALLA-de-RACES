import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		//Variables
		ArrayList<WarriorContainer> warrioirs = new ArrayList<WarriorContainer>();
		ArrayList<WeaponContainer> weapons = new ArrayList<WeaponContainer>();
		int indexWarriorSelected;

		//Conexiones BBDD
		String urlDatos = "jdbc:mysql://localhost/battle_of_races?serverTimezone=UTC";
		String usuario = "admin";
		String pass = "admin123";
		String query = "select w.WEAPON_ID,w.WEAPON_POINTS,w.WEAPON_STRENGTH,w.WEAPON_SPEED,w.WEAPON_NAME,w.WEAPON_IMAGE_PATH from WEAPONS w inner join WEAPONS_AVAILABLE wa on wa.WEAPON_ID=w.WEAPON_ID where wa.RACE_ID = 2;";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection(urlDatos,usuario,pass);
			Statement stmnt = conn.createStatement();

			ResultSet rs = stmnt.executeQuery(query);

			while(rs.next()) {
				
				weapons.add(new WeaponContainer(rs.getInt(1),rs.getInt(2),rs.getInt(3),rs.getInt(4),rs.getString(5),rs.getString(6)));
			}

			new FrameWarriors(weapons);



//System.out.println(rs.getInt(1) + " - " + rs.getInt(2) + " - " + rs.getInt(3) + " - " + rs.getInt(4) + " - "+ rs.getInt(5) + " - " + rs.getInt(6) + " - " + rs.getInt(7) + " - " + rs.getString(8) + " - " + rs.getString(9) + " - " + rs.getString(10));
		} catch (ClassNotFoundException e) {
			System.out.println("Driver no se ha cargado correctamente!!");		
		} catch (SQLException e) {
			System.out.println("Se ha lanzado una SQLException!!");
			e.printStackTrace();
		}

	}

}
