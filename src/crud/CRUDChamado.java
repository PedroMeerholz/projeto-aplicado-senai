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
        sql = "INSERT INTO chamado (id_chamado, status, data_chamado, funcionario, veiculo, distancia, carbono) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try {
            execucaoSQL = conexao.prepareStatement(sql);
            execucaoSQL.setInt(1, chamado.getIDChamado());
            execucaoSQL.setBoolean(2, chamado.getStatus());
            execucaoSQL.setDate(3, chamado.getDataChamado());
            execucaoSQL.setInt(4, chamado.getIdFuncionarioAlocado());
            execucaoSQL.setInt(5, chamado.getIdVeiculoAlocado());
            execucaoSQL.setDouble(6, chamado.getDistancia());
            execucaoSQL.setDouble(7, chamado.getCarbonoEmitido());
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

    public boolean readOnly(int id) {
        sql = "SELECT FROM chamado WHERE id_chamado='"+id+"'";
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
        } // Fim método try/catch
    } // Fim método readOnly

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
