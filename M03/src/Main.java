import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Main {
	private ArrayList<WarriorContainer> warrioirs = new ArrayList<WarriorContainer>();
	private ArrayList<WeaponContainer> weapons = new ArrayList<WeaponContainer>();

	public static void main(String[] args) {
		String urlDatos = "jdbc:mysql://localhost/battle_of_races?serverTimezone=UTC";
		String usuario = "admin";
		String pass = "admin123";
		String query = "select * from WARRIORS";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection(urlDatos,usuario,pass);
			Statement stmnt = conn.createStatement();
			
			ResultSet rs = stmnt.executeQuery(query);
			
			rs.next();
			System.out.println("ID = " + rs.getInt(1) + ", Nombre = " + rs.getString(2) + ", URL = " + rs.getString(3));
			
			
			
			
			
		} catch (ClassNotFoundException e) {
			System.out.println("Driver no se ha cargado correctamente!!");		
		} catch (SQLException e) {
			System.out.println("Se ha lanzado una SQLException!!");
			e.printStackTrace();
		}

	}

}
