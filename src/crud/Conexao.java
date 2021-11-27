package crud;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Conexao {
    protected Connection conexao; // Responsável por manter a conexão com o DB aberta
    protected PreparedStatement execucaoSQL; // Responsável por gerenciar e executar o código SQL
    protected String sql;

    public Conexao() {
        try {
            Class.forName("org.postgresql.Driver"); // Realização do registro do Driver
            String url = "jdbc:postgresql://localhost:5432/projeto_aplicado";
            String usuario = "postgres";
            String senha = "89601311";
            this.conexao = DriverManager.getConnection(url, usuario, senha); // Cria a conexão com o DB
        } catch (ClassNotFoundException e) {
            // Erro relacionado ao Driver
            e.printStackTrace();
        } catch (SQLException e) {
            // Erro relacionado a conexão com o DB
            e.printStackTrace();
        } // Fim try/catch
    }
}
