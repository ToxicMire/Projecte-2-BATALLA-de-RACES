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

			//for(WarriorContainer i:warrioirs) {
			//	System.out.println(i);
			//}

//			for(int i = 0;i < 9; i++) {
//				System.out.println("./images/warriors/"+warrioirs.get(i).getWarriorStringPathImage());
//			}


			new FrameWarriors(warrioirs);



//System.out.println(rs.getInt(1) + " - " + rs.getInt(2) + " - " + rs.getInt(3) + " - " + rs.getInt(4) + " - "+ rs.getInt(5) + " - " + rs.getInt(6) + " - " + rs.getInt(7) + " - " + rs.getString(8) + " - " + rs.getString(9) + " - " + rs.getString(10));
		} catch (ClassNotFoundException e) {
			System.out.println("Driver no se ha cargado correctamente!!");		
		} catch (SQLException e) {
			System.out.println("Se ha lanzado una SQLException!!");
			e.printStackTrace();
		}

	}

}
