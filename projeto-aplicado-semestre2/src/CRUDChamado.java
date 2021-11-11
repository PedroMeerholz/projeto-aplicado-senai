import java.sql.SQLException;

public class CRUDChamado extends Conexao {
    public CRUDChamado() {
        super();
    }

    // Create
    public boolean create(Chamado chamado) {
        sql = "INSERT INTO chamado (id_chamado, status, data_chamado, funcionario, veiculo, distancia, carbono) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try {
            execucaoSQL = conexao.prepareStatement(sql);
            execucaoSQL.setInt(1, chamado.getIDChamado());
            execucaoSQL.setBoolean(2, chamado.getStatus());
            execucaoSQL.setDate(3, chamado.getDataChamado());
            execucaoSQL.setInt(4, chamado.getFuncionario().getIDFuncionario());
            execucaoSQL.setInt(5, chamado.getVeiculoAlocado().getIDVeiculo());
            execucaoSQL.setDouble(6, chamado.getDistancia());
            execucaoSQL.setDouble(7, chamado.getCarbonoEmitido());
            execucaoSQL.execute();

            return true;
        } catch(SQLException e) {
            e.printStackTrace();

            return false;
        } // Fim try/catch
    } // Fim método create  
} // Fim classe CRUDChamado
