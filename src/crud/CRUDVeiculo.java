package crud;
import java.sql.ResultSet;
import java.sql.SQLException;

import classes.Veiculo;

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

    public float readAutonomia(int id) {
        sql = "SELECT * FROM veiculo WHERE id_veiculo=?";
        try {
            execucaoSQL = conexao.prepareStatement(sql);
            execucaoSQL.setInt(1, id);
            ResultSet resultado = execucaoSQL.executeQuery();
            float autonomia = 0;

            while(resultado.next()) {
                autonomia = resultado.getFloat("autonomia");
            }

            return autonomia;
        } catch(SQLException e) {
            e.printStackTrace();

            return -1;
        } // Fim método try/catch
    } // Fim método readOnly

    public int getNumeroDeVeiculos() {
        sql = "SELECT * FROM veiculo";
        int i = 0;
        
        try{
            execucaoSQL = conexao.prepareStatement(sql);
            ResultSet resultado = execucaoSQL.executeQuery();
            while(resultado.next()) {
                i++;
            }

            return i;
        } catch (SQLException e) {
            e.printStackTrace();

            return -1;
        }
    }

    public int getVeiculosDisponiveis() {
        sql = "SELECT * FROM veiculo WHERE status = true";
        int i = 0;
        
        try{
            execucaoSQL = conexao.prepareStatement(sql);
            ResultSet resultado = execucaoSQL.executeQuery();
            while(resultado.next()) {
                i++;
            }

            return i;
        } catch (SQLException e) {
            e.printStackTrace();

            return -1;
        }
    }

    public int getVeiculosIndisponiveis() {
        sql = "SELECT * FROM veiculo WHERE status = false";
        int i = 0;
        
        try{
            execucaoSQL = conexao.prepareStatement(sql);
            ResultSet resultado = execucaoSQL.executeQuery();
            while(resultado.next()) {
                i++;
            }

            return i;
        } catch (SQLException e) {
            e.printStackTrace();

            return -1;
        }
    }

    // Update
    public boolean updateModelo(int id, String modelo) {
        sql = "UPDATE veiculo SET modelo=? WHERE id_veiculo=?";
        try {
            execucaoSQL = conexao.prepareStatement(sql);
            execucaoSQL.setString(1, modelo);
            execucaoSQL.setInt(2, id);
            execucaoSQL.execute();
            
            return true;
        } catch(SQLException e) {
            e.printStackTrace();
            
            return false;
        } // Fim método try/catch
    } // Fim método updateModelo
    
    public boolean updatePlaca(int id, String placa) {
        sql = "UPDATE veiculo SET placa=? WHERE id_veiculo=?";
        try {
            execucaoSQL = conexao.prepareStatement(sql);
            execucaoSQL.setString(1, placa);
            execucaoSQL.setInt(2, id);
            execucaoSQL.execute();

            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            
            return false;
        } // Fim método try/catch
    } // Fim método updatePlaca
    
    public boolean updateAno(int id, String ano) {
        sql = "UPDATE veiculo SET ano=? WHERE id_veiculo=?";
        try {
            execucaoSQL = conexao.prepareStatement(sql);
            execucaoSQL.setString(1, ano);
            execucaoSQL.setInt(2, id);
            execucaoSQL.executeUpdate();

            return true;
        } catch (SQLException e) {
            e.printStackTrace();

            return false;
        } // Fim método try/catch
    } // Fim método updateAno
    
    public boolean updateAutonomia(int id, double autonomia) {
        sql = "UPDATE veiculo SET autonomia=? WHERE id_veiculo=?";
        try {
            execucaoSQL = conexao.prepareStatement(sql);
            execucaoSQL.setDouble(1, autonomia);
            execucaoSQL.setInt(2, id);
            execucaoSQL.execute();

            return true;
        } catch(SQLException e) {
            e.printStackTrace();

            return false;
        } // Fim método try/catch
    } // Fim método updateAutonomia
    
    public boolean updateStatus(int id, boolean status) {
        sql = "UPDATE veiculo SET status=? WHERE id_veiculo=?";
        try {
            execucaoSQL = conexao.prepareStatement(sql);
            execucaoSQL.setBoolean(1, status);
            execucaoSQL.setInt(2, id);
            execucaoSQL.execute();

            return true;
        } catch(SQLException e) {
            e.printStackTrace();

            return false;
        } // Fim método try/catch
    } // Fim método updateStatus

    // Delete
    public boolean delete(int id) {
        sql = "DELETE FROM veiculo WHERE id_veiculo=?"; 
        try {
            execucaoSQL = conexao.prepareStatement(sql);
            execucaoSQL.setInt(1, id);
            execucaoSQL.execute();

            return true;
        } catch(SQLException e) {
            e.printStackTrace();
            return false;
        } // Fim método try/catch
    } // Fim método delete
}
