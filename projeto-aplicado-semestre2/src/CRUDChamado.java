import java.sql.SQLException;

public class CRUDChamado extends Conexao {
    public CRUDChamado() {
        super();
    }

    // Create
    public boolean create(Chamado chamado) {
        sql = "INSERT INTO chamado (status, data_chamado, funcionario, veiculo, distancia, carbono) VALUES (?, ?, ?, ?, ?, ?)";
        try {
            execucaoSQL = conexao.prepareStatement(sql);
            execucaoSQL.setBoolean(1, chamado.getStatus());
            execucaoSQL.setString(2, chamado.getDataChamado());
            execucaoSQL.setInt(3, chamado.getFuncionario().getIDFuncionario());
            execucaoSQL.setInt(4, chamado.getVeiculoAlocado().getIDVeiculo());
            execucaoSQL.setDouble(5, chamado.getDistancia());
            execucaoSQL.setDouble(6, chamado.getCarbonoEmitido());
            execucaoSQL.execute();

            return true;
        } catch(SQLException e) {
            e.printStackTrace();

            return false;
        } // Fim try/catch
    } // Fim método create  
} // Fim classe CRUDChamado
