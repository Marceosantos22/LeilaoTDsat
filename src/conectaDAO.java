
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 * @author Adm
 */
public class conectaDAO {

	Connection conn;
	PreparedStatement st;
	ResultSet rs;

	public Connection getConexao() {
		return conn;
	}

	public Boolean connectDB() {

		try {

			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/uc11",
					  "root", "F17101818@");

			return true;

		} catch (SQLException erro) {
			JOptionPane.showMessageDialog(null, "Erro ConectaDAO" + erro.getMessage());
			return false;
		}

	}

	public void desconectarDB() {

		try {

			conn.close();

		} catch (Exception e) {
		}

	}

}
