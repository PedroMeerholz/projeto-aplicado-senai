import java.sql.ResultSet;
import java.sql.SQLException;

public class CRUDVeiculo extends Conexao {
    public CRUDVeiculo() {
        super();
    }

    // Create
    public boolean create(Veiculo veiculo) {
        sql = "INSERT INTO veiculo (id_veiculo, modelo, placa, ano, autonomia, status) VALUES (?, ?, ?, ?, ?, ?)";
        try{
            execucaoSQL = conexao.prepareStatement(sql);
            execucaoSQL.setInt(1, veiculo.getIDVeiculo());
            execucaoSQL.setString(2, veiculo.getModeloVeiculo());
            execucaoSQL.setString(3, veiculo.getPlacaVeiculo());
            execucaoSQL.setString(4, veiculo.getAnoVeiculo());
            execucaoSQL.setDouble(5, veiculo.getAutonomia());
            execucaoSQL.setBoolean(6, veiculo.getStatus());
            execucaoSQL.execute();
            
            return true;
        } catch(SQLException e) {
            e.printStackTrace();

            return false;
        } // Fim try/catch
    } // Fim método create

    // Read
    public boolean read() {
        sql = "SELECT * FROM veiculo ORDER BY modelo ASC";
        
        try{
            execucaoSQL = conexao.prepareStatement(sql);
            ResultSet resultado = execucaoSQL.executeQuery(); // Responsável por receber os dados de uma pesquisa feita no DB
            while(resultado.next()) {
                Veiculo veiculo = new Veiculo(resultado.getString("modelo"), resultado.getString("placa"), resultado.getString("ano"), resultado.getDouble("autonomia"), resultado.getBoolean("status"));

                System.out.printf("\n\nID: %d", resultado.getInt("id_veiculo"));
                System.out.printf("\nModelo: %s", veiculo.getModeloVeiculo());
                System.out.printf("\nPlaca: %s", veiculo.getPlacaVeiculo());
                System.out.printf("\nAno: %s", veiculo.getAnoVeiculo());
                System.out.printf("\nAutonomia: %.2f", veiculo.getAutonomia());
                System.out.printf("\nStatus: %b", veiculo.getStatus());
            }

            return true;
        } catch (SQLException e) {
            e.printStackTrace();

            return false;
        } // Fim try/catch
    } // Fim método read
}
