import java.sql.ResultSet;
import java.sql.SQLException;

public class CRUDFuncionario extends Conexao {
    public CRUDFuncionario() {
        super();
    }

    public boolean create(Funcionario funcionario) {
        sql = "INSERT INTO funcionario (id_funcionario, nome, nascimento, cpf, cargo, status) VALUES (?, ?, ?, ?, ?, ?)";
        try {
            execucaoSQL = conexao.prepareStatement(sql); // Responsável por gerenciar e executar o código SQL
            execucaoSQL.setInt(1, funcionario.getIDFuncionario());
            execucaoSQL.setString(2, funcionario.getNomeFuncionario());
            execucaoSQL.setString(3, funcionario.getNascimento());
            execucaoSQL.setString(4, funcionario.getCPF());
            execucaoSQL.setString(5, funcionario.getCargo());
            execucaoSQL.setBoolean(6, funcionario.getStatus());
            execucaoSQL.execute();

            return true;
        } catch (SQLException erro) {
            erro.printStackTrace();

            return false;
        }// Fim try/catch
    } // Fim método create

    public boolean read() {
        sql = "SELECT * FROM funcionario ORDER BY nome ASC";
        
        try{
            execucaoSQL = conexao.prepareStatement(sql);
            ResultSet resultado = execucaoSQL.executeQuery(); // Responsável por receber os dados de uma pesquisa feita no DB
            while(resultado.next()) {
                Funcionario funcionario = new Funcionario(resultado.getString("nome"), resultado.getString("nascimento"), resultado.getString("cpf"), resultado.getString("cargo"), resultado.getBoolean("status"));

                System.out.printf("\n\nID: %d", resultado.getInt("id_funcionario"));
                System.out.printf("\nNome: %s", funcionario.getNomeFuncionario());
                System.out.printf("\nNascimento: %s", funcionario.getNascimento());
                System.out.printf("\nCPF: %s", funcionario.getCPF());
                System.out.printf("\nCargo: %s", funcionario.getCargo());
                System.out.printf("\nStatus: %b", funcionario.getStatus());
            }

            return true;
        } catch (SQLException e) {
            // Erro caso haja problemas para se conectar ao banco de dados
            e.printStackTrace();

            return false;
        } // Fim try/catch
    } // Fim método read

    public boolean readOnly(int id) {
        sql = "SELECT * FROM funcionario WHERE id_funcionario='"+id+"'";
        try {
            execucaoSQL = conexao.prepareStatement(sql);
            ResultSet resultado = execucaoSQL.executeQuery();

            while(resultado.next()) {
                System.out.println(resultado.getInt("id_funcionario"));
                System.out.println(resultado.getString("nome"));
                System.out.println(resultado.getString("nascimento"));
                System.out.println(resultado.getString("cpf"));
                System.out.println(resultado.getString("cargo"));
                System.out.println(resultado.getBoolean("status"));
            }
            
            return true;
        } catch (SQLException erro) {
            erro.printStackTrace();
            
            return false;
        } // Fim try/catch
    } // Fim método read
}
