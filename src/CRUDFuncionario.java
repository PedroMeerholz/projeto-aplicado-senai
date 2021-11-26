import java.sql.Date;
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
            execucaoSQL.setDate(3, funcionario.getNascimento());
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
                Funcionario funcionario = new Funcionario(resultado.getString("nome"), resultado.getDate("nascimento"), resultado.getString("cpf"), resultado.getString("cargo"), resultado.getBoolean("status"));

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
    } // Fim método readOnly

    public boolean updateNome(int id, String nome) {
        sql = "UPDATE funcionario SET nome=? WHERE id_funcionario=?";
        try {
            execucaoSQL = conexao.prepareStatement(sql);
            execucaoSQL.setString(1, nome);
            execucaoSQL.setInt(2, id);
            execucaoSQL.execute();
            
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } // Fim try/catch
    } // Fim método updateNome

    public boolean updateNascimento(int id, Date nascimento) {
        sql = "UPDATE funcionario SET nascimento=? WHERE id_funcionario=?";
        try {
            execucaoSQL = conexao.prepareStatement(sql);
            execucaoSQL.setDate(1, nascimento);
            execucaoSQL.setInt(2, id);
            execucaoSQL.execute();

            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } // Fim try/catch
    } // Fim método updateNascimento

    public boolean updateCpf(int id, String cpf) {
        sql = "UPDATE funcionario SET cpf=? WHERE id_funcionario=?";
        try {
            execucaoSQL = conexao.prepareStatement(sql);
            execucaoSQL.setString(1, cpf);
            execucaoSQL.setInt(2, id);
            execucaoSQL.execute();

            return true;
        } catch (SQLException e) {
            e.printStackTrace();

            return false;
        } // Fim try/catch
    } // Fim método updateCpf

    public boolean updateCargo(int id, String cargo) {
        sql = "UPDATE funcionario SET cargo=? WHERE id_funcionario=?";
        try {
            execucaoSQL = conexao.prepareStatement(sql);
            execucaoSQL.setString(1, cargo);
            execucaoSQL.setInt(2, id);
            execucaoSQL.execute();

            return true;
        } catch (SQLException e) {
            e.printStackTrace();

            return false;
        } // Fim try/catch
    } // Fim método updateCargo

    public boolean updateStatus(int id, boolean status) {
        sql = "UPDATE funcionario SET status=? WHERE id_funcionario=?";

        try {
            execucaoSQL = conexao.prepareStatement(sql);
            execucaoSQL.setBoolean(1, status);
            execucaoSQL.setInt(2, id);
            execucaoSQL.execute();

            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } // Fim try/catch
    } // Fim método updateStatus

    public boolean delete(int id) {
        sql = "DELETE FROM funcionario WHERE id_funcionario=?";
        try {
            execucaoSQL = conexao.prepareStatement(sql);
            execucaoSQL.setInt(1, id);
            execucaoSQL.execute();

            return true;
        } catch (SQLException e) {
            return false;
        } // Fim try/catch
    } // Fim método delete
}
