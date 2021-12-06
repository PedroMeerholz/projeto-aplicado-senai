package crud;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import classes.Veiculo;

public class CRUDVeiculo extends Conexao {
    private DefaultTableModel modelVeiculo = new DefaultTableModel();
    
    public CRUDVeiculo() {
        super();
    }

    // Create
    public void create(Veiculo veiculo) {
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
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

    // Read
    public void adicionaTabelaVeiculo(JPanel panel, JTable table) {
        table = new JTable(modelVeiculo);
        panel.add(table);
        modelVeiculo.addColumn("ID");
        modelVeiculo.addColumn("Modelo");
        modelVeiculo.addColumn("Placa");
        modelVeiculo.addColumn("Ano");
        modelVeiculo.addColumn("Autonomia");
        modelVeiculo.addColumn("Status");
        modelVeiculo.addRow(new Object[]{"ID", "Modelo", "Placa", "Ano", "Autonomia", "Status"});
        read();
    }

    public void read() {
        sql = "SELECT * FROM veiculo ORDER BY modelo ASC";
        
        try {
            execucaoSQL = conexao.prepareStatement(sql);
            ResultSet resultado = execucaoSQL.executeQuery();
            while(resultado.next()) {
                modelVeiculo.addRow(new Object[]{resultado.getInt("id_veiculo"),
                                          resultado.getString("modelo"),
                                          resultado.getString("placa"),
                                          resultado.getString("ano"),
                                          resultado.getFloat("autonomia"),
                                          resultado.getBoolean("status")});   
            }
        } catch(SQLException erro) {
            erro.printStackTrace();
        }
    }

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
        }
    }

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
    public void updateModelo(int id, String modelo) {
        sql = "UPDATE veiculo SET modelo=? WHERE id_veiculo=?";
        try {
            execucaoSQL = conexao.prepareStatement(sql);
            execucaoSQL.setString(1, modelo);
            execucaoSQL.setInt(2, id);
            execucaoSQL.execute();
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void updatePlaca(int id, String placa) {
        sql = "UPDATE veiculo SET placa=? WHERE id_veiculo=?";
        try {
            execucaoSQL = conexao.prepareStatement(sql);
            execucaoSQL.setString(1, placa);
            execucaoSQL.setInt(2, id);
            execucaoSQL.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void updateAno(int id, String ano) {
        sql = "UPDATE veiculo SET ano=? WHERE id_veiculo=?";
        try {
            execucaoSQL = conexao.prepareStatement(sql);
            execucaoSQL.setString(1, ano);
            execucaoSQL.setInt(2, id);
            execucaoSQL.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void updateAutonomia(int id, double autonomia) {
        sql = "UPDATE veiculo SET autonomia=? WHERE id_veiculo=?";
        try {
            execucaoSQL = conexao.prepareStatement(sql);
            execucaoSQL.setDouble(1, autonomia);
            execucaoSQL.setInt(2, id);
            execucaoSQL.execute();
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void updateStatus(int id, boolean status) {
        sql = "UPDATE veiculo SET status=? WHERE id_veiculo=?";
        try {
            execucaoSQL = conexao.prepareStatement(sql);
            execucaoSQL.setBoolean(1, status);
            execucaoSQL.setInt(2, id);
            execucaoSQL.execute();
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

    // Delete
    public void delete(int id) {
        sql = "DELETE FROM veiculo WHERE id_veiculo=?"; 
        try {
            execucaoSQL = conexao.prepareStatement(sql);
            execucaoSQL.setInt(1, id);
            execucaoSQL.execute();
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }
}
