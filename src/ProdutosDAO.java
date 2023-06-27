
/**
 * @author Adm
 */
import java.sql.PreparedStatement;
import java.sql.Connection;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ProdutosDAO {

	private conectaDAO conexao;

	public ProdutosDAO(conectaDAO conexao) {

		this.conexao = conexao;

	}

	public ProdutosDAO() {

	}

	ArrayList<ProdutosDTO> listagem = new ArrayList<>();

	public boolean cadastrarProduto(ProdutosDTO produto) {

		try {

			conexao.connectDB();
			Connection conn = conexao.getConexao();
			
			PreparedStatement st = conn.prepareStatement("INSERT INTO produtos"
					  + " (nome, valor, status) VALUES (?,?,?)");

			st.setString(1, produto.getNome());
			st.setInt(2, produto.getValor());
			st.setString(3, produto.getStatus());

			int status = st.executeUpdate();
			st.close();

			conexao.desconectarDB();
			return status > 0;

		} catch (Exception e) {

			System.out.println("Erro ao conectar: " + e.getMessage());
			
			return false;
			
		}

	}

	public ArrayList<ProdutosDTO> listarProdutos() {

		return listagem;
	}

}
