package crud;
import java.sql.ResultSet;
import java.sql.SQLException;

import classes.Chamado;

public class CRUDChamado extends Conexao {
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
    public boolean read() {
        sql = "SELECT * FROM chamado";
        try {
            execucaoSQL = conexao.prepareStatement(sql);
            ResultSet resultado = execucaoSQL.executeQuery();
            while(resultado.next()) {
                System.out.printf("ID Chamado: %d", resultado.getInt("id_chamado"));
                System.out.printf("Status: %b", resultado.getBoolean("status"));
                System.out.printf("Data do Chamado: %s", resultado.getString("data_chamado"));
                System.out.printf("Funcionario Alocado: %d", resultado.getInt("funcionario"));
                System.out.printf("Veiculo Alocado: %d", resultado.getInt("veiculo"));
                System.out.printf("Distância: %.2f", resultado.getFloat("distancia"));
                System.out.printf("Carbono Gerado: %.2f", resultado.getFloat("carbono"));
            }

            return true;
        } catch(SQLException erro) {
            erro.printStackTrace();

            return false;
        } // Fim try/catch
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
