import java.sql.ResultSet;
import java.sql.SQLException;

public class GeraID extends Conexao {
    private int idFuncionario = 0;
    private int idVeiculo = 0;

    public GeraID() {

    }

    public int atualizaIDFuncionario() {
        sql = "SELECT id_funcionario FROM funcionario ORDER BY id_funcionario DESC LIMIT 1";
        try {
            execucaoSQL = conexao.prepareStatement(sql);
            ResultSet resultado = execucaoSQL.executeQuery();
            while(resultado.next()) {
                this.idFuncionario = resultado.getInt("id_funcionario");
            }

            return this.idFuncionario;
        } catch(SQLException e) {
            e.printStackTrace();

            return -1;
        }
    }

    public int incrementaIdFuncionario() {
        int id = atualizaIDFuncionario();
        this.idFuncionario = id + 1;

        return this.idFuncionario;
    }

    public int atualizaIDVeiculo() {
        sql = "SELECT id_veiculo FROM veiculo ORDER BY id_veiculo DESC LIMIT 1";
        try {
            execucaoSQL = conexao.prepareStatement(sql);
            ResultSet resultado = execucaoSQL.executeQuery();
            while(resultado.next()) {
                this.idVeiculo = resultado.getInt("id_veiculo");
            }
            
            return this.idVeiculo;
        } catch (SQLException e) {
            e.printStackTrace();

            return -1;
        }
    }

    public int incrementaIdVeiculo() {
        int id = atualizaIDVeiculo();
        this.idVeiculo = id + 1;

        return this.idVeiculo;
    }
}
