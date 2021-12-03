package operacoes;

import java.sql.ResultSet;
import java.sql.SQLException;

import crud.Conexao;

public class OperacoesVisualizacao extends Conexao {
    public int getNumeroDeFuncionarios() {
        sql = "SELECT * FROM funcionario ORDER BY nome ASC";
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

    public int getFuncionariosDisponiveis() {
        sql = "SELECT * FROM funcionario WHERE status = true ORDER BY nome ASC";
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

    public int getFuncionarioIndisponiveis() {
        sql = "SELECT * FROM funcionario WHERE status = false ORDER BY nome ASC";
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

    public static void main(String[] args) {
        System.out.println(new OperacoesVisualizacao().getFuncionarioIndisponiveis());
    }
}
