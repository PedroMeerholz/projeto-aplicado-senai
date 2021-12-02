package interfaceSwing;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ConsultaFuncionario extends AdicionaComponentes {
    protected DefaultTableModel modelFuncionario = new DefaultTableModel();

    public ConsultaFuncionario() {
        super();
        setTitle("Consultar Funcionários");
        setSize(600, 600);
        formulario();
        setVisible(true);
    }

    public void adicionaTabelaFuncionario(JPanel panel, JTable table) {
        panel.add(table);
        modelFuncionario.addColumn("ID");
        modelFuncionario.addColumn("Nome");
        modelFuncionario.addColumn("Nascimento");
        modelFuncionario.addColumn("Cpf");
        modelFuncionario.addColumn("Cargo");
        modelFuncionario.addColumn("Status");
        modelFuncionario.addRow(new Object[]{"ID", "Nome", "Nascimento", "CPF", "Cargo", "Status"});
        preencheTabelaFuncionario(table);
    }

    public void preencheTabelaFuncionario(JTable table) {
        Connection conexao = conexaoBanco.getConexao();
        PreparedStatement execucaoSQL = conexaoBanco.getExecucaoSQL();
        String sql = "SELECT * FROM funcionario ORDER BY id_funcionario ASC";

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
    }

    private void formulario() {
        this.panelTable = new JPanel();
        this.table = new JTable(modelFuncionario);
        adicionaPainel(panelTable, "Funcionários");
        adicionaTabelaFuncionario(panelTable, table);
    }
}
