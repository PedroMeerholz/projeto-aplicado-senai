package crud;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import classes.Funcionario;

public class CRUDFuncionario extends Conexao {
    private DefaultTableModel modelFuncionario = new DefaultTableModel();

    public CRUDFuncionario() {
        super();
    }

    public boolean create(Funcionario funcionario) {
        sql = "INSERT INTO funcionario (id_funcionario, nome, nascimento, cpf, cargo, status) VALUES (?, ?, ?, ?, ?, ?)";
        try {
            execucaoSQL = conexao.prepareStatement(sql); // Responsável por gerenciar e executar o código SQL
            execucaoSQL.setInt(1, funcionario.getIDFuncionario());
            execucaoSQL.setString(2, funcionario.getNomeFuncionario());
            execucaoSQL.setDate(3, funcionario.getNascimento());
            execucaoSQL.setString(4, funcionario.getCPF());
            execucaoSQL.setString(5, funcionario.getCargo());
            execucaoSQL.setBoolean(6, funcionario.getStatus());
            execucaoSQL.execute();

            return true;
        } catch (SQLException erro) {
            erro.printStackTrace();

            return false;
        }// Fim try/catch
    } // Fim método create

    public void adicionaTabelaFuncionario(JPanel panel, JTable table) {
        table = new JTable(modelFuncionario);
        panel.add(table);
        modelFuncionario.addColumn("ID");
        modelFuncionario.addColumn("Nome");
        modelFuncionario.addColumn("Nascimento");
        modelFuncionario.addColumn("Cpf");
        modelFuncionario.addColumn("Cargo");
        modelFuncionario.addColumn("Status");
        modelFuncionario.addRow(new Object[]{"ID", "Nome", "Nascimento", "CPF", "Cargo", "Status"});
        read(table);
    }

    public void read(JTable table) {
        sql = "SELECT * FROM funcionario ORDER BY nome ASC";
        
        try {
            execucaoSQL = conexao.prepareStatement(sql);
            ResultSet resultado = execucaoSQL.executeQuery();
            while(resultado.next()) {
                modelFuncionario.addRow(new Object[]{resultado.getInt("id_funcionario"),
                                          resultado.getString("nome"),
                                          resultado.getDate("nascimento"),
                                          resultado.getString("cpf"),
                                          resultado.getString("cargo"),
                                          resultado.getBoolean("status")});   
            }
        } catch(SQLException erro) {
            erro.printStackTrace();
        }
    } // Fim método read

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
        sql = "SELECT * FROM funcionario WHERE status = true";
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
        sql = "SELECT * FROM funcionario WHERE status = false";
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

    public boolean updateNome(int id, String nome) {
        sql = "UPDATE funcionario SET nome=? WHERE id_funcionario=?";
        try {
            execucaoSQL = conexao.prepareStatement(sql);
            execucaoSQL.setString(1, nome);
            execucaoSQL.setInt(2, id);
            execucaoSQL.execute();
            
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } // Fim try/catch
    } // Fim método updateNome

    public boolean updateNascimento(int id, Date nascimento) {
        sql = "UPDATE funcionario SET nascimento=? WHERE id_funcionario=?";
        try {
            execucaoSQL = conexao.prepareStatement(sql);
            execucaoSQL.setDate(1, nascimento);
            execucaoSQL.setInt(2, id);
            execucaoSQL.execute();

            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } // Fim try/catch
    } // Fim método updateNascimento

    public boolean updateCpf(int id, String cpf) {
        sql = "UPDATE funcionario SET cpf=? WHERE id_funcionario=?";
        try {
            execucaoSQL = conexao.prepareStatement(sql);
            execucaoSQL.setString(1, cpf);
            execucaoSQL.setInt(2, id);
            execucaoSQL.execute();

            return true;
        } catch (SQLException e) {
            e.printStackTrace();

            return false;
        } // Fim try/catch
    } // Fim método updateCpf

    public boolean updateCargo(int id, String cargo) {
        sql = "UPDATE funcionario SET cargo=? WHERE id_funcionario=?";
        try {
            execucaoSQL = conexao.prepareStatement(sql);
            execucaoSQL.setString(1, cargo);
            execucaoSQL.setInt(2, id);
            execucaoSQL.execute();

            return true;
        } catch (SQLException e) {
            e.printStackTrace();

            return false;
        } // Fim try/catch
    } // Fim método updateCargo

    public boolean updateStatus(int id, boolean status) {
        sql = "UPDATE funcionario SET status=? WHERE id_funcionario=?";

        try {
            execucaoSQL = conexao.prepareStatement(sql);
            execucaoSQL.setBoolean(1, status);
            execucaoSQL.setInt(2, id);
            execucaoSQL.execute();

            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } // Fim try/catch
    } // Fim método updateStatus

    public boolean delete(int id) {
        sql = "DELETE FROM funcionario WHERE id_funcionario=?";
        try {
            execucaoSQL = conexao.prepareStatement(sql);
            execucaoSQL.setInt(1, id);
            execucaoSQL.execute();

            return true;
        } catch (SQLException e) {
            return false;
        } // Fim try/catch
    } // Fim método delete
}
