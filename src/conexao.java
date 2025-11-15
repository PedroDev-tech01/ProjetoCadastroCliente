import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

 public class conexao {

    // 🔹 Dados de conexão com o MySQL
    private static final String URL = "jdbc:mysql://localhost:3306/sistema";
    private static final String USUARIO = "root";
    private static final String SENHA = "1234";

    public static Connection conectar() {
        try {
            Connection conexao = DriverManager.getConnection(URL, USUARIO, SENHA);
            return conexao;
        } catch (SQLException e) {
            System.out.println("❌ Erro ao conectar: " + e.getMessage());
            return null;
        }
    }
    public static void main(String[] args) {
        conectar();
    }
}

