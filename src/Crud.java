import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Crud {

    // CREATE
    public void adicionar(Clientes cliente) {
        String sql = "INSERT INTO clientes (nome, cpf, endereco, telefone) VALUES (?, ?, ?, ?)";
        try (Connection conn = conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getCpf());
            stmt.setString(3, cliente.getEndereco());
            stmt.setString(4, cliente.getTelefone());
            stmt.executeUpdate();

            System.out.println("✅ Cliente adicionado com sucesso ao banco!");
        } catch (SQLException e) {
            System.out.println("❌ Erro ao adicionar: " + e.getMessage());
        }
    }

    // READ
    public void listar() {
        String sql = "SELECT * FROM clientes";
        try (Connection conn = conexao.conectar();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            System.out.println("\n--- Lista de Clientes ---");
            boolean vazio = true;
            while (rs.next()) {
                vazio = false;
                System.out.println("ID: " + rs.getInt("id") +
                        " | Nome: " + rs.getString("nome") +
                        " | CPF: " + rs.getString("cpf") +
                        " | Endereço: " + rs.getString("endereco") +
                        " | Telefone: " + rs.getString("telefone"));
            }
            if (vazio) {
                System.out.println("Nenhum cliente cadastrado.");
            }
        } catch (SQLException e) {
            System.out.println("❌ Erro ao listar: " + e.getMessage());
        }
    }

    // UPDATE
    public void atualizar(Clientes cliente) {
        String sql = "UPDATE clientes SET nome=?, cpf=?, endereco=?, telefone=? WHERE id=?";
        try (Connection conn = conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getCpf());
            stmt.setString(3, cliente.getEndereco());
            stmt.setString(4, cliente.getTelefone());
            stmt.setInt(5, cliente.getId());

            int linhas = stmt.executeUpdate();
            if (linhas > 0) {
                System.out.println("✏️ Cliente atualizado com sucesso no banco!");
            } else {
                System.out.println("❌ Cliente não encontrado!");
            }
        } catch (SQLException e) {
            System.out.println("❌ Erro ao atualizar: " + e.getMessage());
        }
    }

    // DELETE
    public void remover(int id) {
        String sql = "DELETE FROM clientes WHERE id=?";
        try (Connection conn = conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            int linhas = stmt.executeUpdate();

            if (linhas > 0) {
                System.out.println("🗑️ Cliente removido com sucesso!");
            } else {
                System.out.println("❌ Cliente não encontrado!");
            }
        } catch (SQLException e) {
            System.out.println("❌ Erro ao remover: " + e.getMessage());
        }
    }

    public int tamanho() {
        String sql = "SELECT COUNT(*) FROM clientes";
        try (Connection conn = conexao.conectar();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException e) {
            System.out.println("❌ Erro ao contar: " + e.getMessage());
        }
        return 0;
    }
}
