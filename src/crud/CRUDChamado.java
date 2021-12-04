package crud;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import classes.Chamado;

public class CRUDChamado extends Conexao {
    private DefaultTableModel modelChamado = new DefaultTableModel();
    
    public CRUDChamado() {
        super();
    }

    // Create
    public boolean create(Chamado chamado) {
        sql = "INSERT INTO chamado (id_chamado, status, data_chamado, funcionario, veiculo, distancia) VALUES (?, ?, ?, ?, ?, ?)";
        try {
            execucaoSQL = conexao.prepareStatement(sql);
            execucaoSQL.setInt(1, chamado.getIDChamado());
            execucaoSQL.setBoolean(2, chamado.getStatus());
            execucaoSQL.setDate(3, chamado.getDataChamado());
            execucaoSQL.setInt(4, chamado.getIdFuncionarioAlocado());
            execucaoSQL.setInt(5, chamado.getIdVeiculoAlocado());
            execucaoSQL.setDouble(6, chamado.getDistancia());
            execucaoSQL.execute();

            return true;
        } catch(SQLException e) {
            e.printStackTrace();

            return false;
        } // Fim try/catch
    } // Fim método create
    
    // Read
    public void adicionaTabelaChamado(JPanel panel, JTable table) {
        table = new JTable(modelChamado);
        panel.add(table);
        modelChamado.addColumn("ID");
        modelChamado.addColumn("Status");
        modelChamado.addColumn("Data");
        modelChamado.addColumn("Funcionario");
        modelChamado.addColumn("Veiculo");
        modelChamado.addColumn("Distância");
        modelChamado.addColumn("Carbono");
        modelChamado.addRow(new Object[]{"ID", "Data", "Funcionario", "Placa Veiculo", "Distância", "Carbono", "Status"});
        read(table);
    }

    public void read(JTable table) {
        sql = "SELECT id_chamado, data_chamado, nome, placa, distancia, carbono, chamado.status FROM funcionario JOIN chamado ON chamado.funcionario = funcionario.id_funcionario JOIN veiculo ON veiculo.id_veiculo = chamado.veiculo";
        try {
            execucaoSQL = conexao.prepareStatement(sql);
            ResultSet resultado = execucaoSQL.executeQuery();
            while(resultado.next()) {
                modelChamado.addRow(new Object[]{resultado.getInt("id_chamado"),
                                                 resultado.getDate("data_chamado"),
                                                 resultado.getString("nome"),
                                                 resultado.getString("placa"),
                                                 resultado.getFloat("distancia"),
                                                 resultado.getFloat("carbono"),
                                                 resultado.getBoolean("status")});
            }
        } catch(SQLException erro) {
            erro.printStackTrace();
        }
    } // Fim método read

    public int getNumeroDeChamados() {
        sql = "SELECT * FROM chamado";
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

    public int getChamadosDisponiveis() {
        sql = "SELECT * FROM chamado WHERE status = true";
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

    public int getChamadosIndisponiveis() {
        sql = "SELECT * FROM chamado WHERE status = false";
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

    public float getCarbonoEmitido() {
        sql = "SELECT SUM(carbono) FROM chamado";
        float carbonoTotal = 0;

        try{
            execucaoSQL = conexao.prepareStatement(sql);
            ResultSet resultado = execucaoSQL.executeQuery();
            while(resultado.next()) {
                carbonoTotal = resultado.getFloat("sum");
            }

            return carbonoTotal;
        } catch (SQLException e) {
            e.printStackTrace();

            return -1;
        }
    }

    public int getMaiorEmissor() {
        sql = "SELECT veiculo, MAX(carbono) AS emissoes FROM chamado GROUP BY veiculo ORDER BY emissoes DESC LIMIT 1";
        int veiculo = -1;

        try{
            execucaoSQL = conexao.prepareStatement(sql);
            ResultSet resultado = execucaoSQL.executeQuery();
            while(resultado.next()) {
                veiculo = resultado.getInt("veiculo");
                
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }

        return veiculo;
    }

    public int getMenorEmissor() {
        sql = "SELECT veiculo, MAX(carbono) AS emissoes FROM chamado GROUP BY veiculo ORDER BY emissoes ASC LIMIT 1";
        int veiculo = -1;

        try{
            execucaoSQL = conexao.prepareStatement(sql);
            ResultSet resultado = execucaoSQL.executeQuery();
            while(resultado.next()) {
                veiculo = resultado.getInt("veiculo");
                
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }

        return veiculo;
    }

    public float getDistanciaTotal() {
        sql = "SELECT SUM(distancia) FROM chamado;";
        int veiculo = -1;

        try{
            execucaoSQL = conexao.prepareStatement(sql);
            ResultSet resultado = execucaoSQL.executeQuery();
            while(resultado.next()) {
                veiculo = resultado.getInt("veiculo");
                
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }

        return veiculo;
    }


    // Update
    public boolean updateStatus(int id, boolean status){
        sql = "UPDATE chamado SET status='"+status+"' WHERE id_chamado='"+id+"'";
        try {
            execucaoSQL = conexao.prepareStatement(sql);
            execucaoSQL.execute();

            return true;
        } catch(SQLException erro) {
            erro.printStackTrace();

            return false;
        } // Fim método try/catch
    } 

    public boolean updateFuncionarioAlocado(int idChamado, int idFuncionario) {
        sql = "UPDATE chamado SET funcionario='"+idFuncionario+"' WHERE id_chamado='"+idChamado+"'";
        try {
            execucaoSQL = conexao.prepareStatement(sql);
            execucaoSQL.execute();

            return true;
        } catch(SQLException erro) {
            erro.printStackTrace();

            return false;
        } // Fim método try/catch
    } // Fim método updateFuncionarioAlocado

    public boolean updateVeiculoAlocado(int idChamado, int idVeiculo) {
        sql = "UPDATE chamado SET veiculo='"+idVeiculo+"' WHERE id_chamado='"+idChamado+"'";
        try {
            execucaoSQL = conexao.prepareStatement(sql);
            execucaoSQL.execute();

            return true;
        } catch(SQLException erro) {
            erro.printStackTrace();

            return false;
        } // Fim método try/catch
    } // Fim método updateVeiculoAlocado

    public boolean updateDistancia(int id, float distancia) {
        sql = "UPDATE chamado SET distancia='"+distancia+"' WHERE id_chamado='"+id+"'";
        try {
            execucaoSQL = conexao.prepareStatement(sql);
            execucaoSQL.execute();

            return true;
        } catch(SQLException erro) {
            erro.printStackTrace();

            return false;
        } // Fim método try/catch
    } // Fim método updateDistancia

    public void updateCarbono(int id, double distancia, float autonomia) {
        double consumoGasolina = distancia / autonomia;
        double emissao = consumoGasolina * 0.73 * 0.75 * 3.7;
        sql = "UPDATE chamado SET carbono='"+emissao+"' WHERE id_chamado='"+id+"'";
        try {
            execucaoSQL = conexao.prepareStatement(sql);
            execucaoSQL.execute();
        } catch(SQLException erro) {
            erro.printStackTrace();
        }
    }

    // Delete
    public boolean delete(int id) {
        sql = "DELETE FROM chamado WHERE id_chamado='"+id+"'";
        try {
            execucaoSQL = conexao.prepareStatement(sql);
            execucaoSQL.execute();

            return false;
        } catch(SQLException erro) {
            erro.printStackTrace();

            return false;
        }
    }
} // Fim classe CRUDChamado
