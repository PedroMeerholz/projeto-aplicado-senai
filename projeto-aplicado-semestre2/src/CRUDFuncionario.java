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
        }
    }
}
