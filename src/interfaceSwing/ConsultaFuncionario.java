package interfaceSwing;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import crud.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConsultaFuncionario extends JFrame {
    private JPanel panel;
    private JTable table;
    private DefaultTableModel model = new DefaultTableModel();
    private Conexao conexaoBanco = new Conexao();

    public ConsultaFuncionario() {
        super("Consultas");
        setSize(700, 500);
        apresentacao();
        setVisible(true);
    }

    public void adicionaPainel(JPanel panel, String tituloBorda) {
        panel.setBorder(BorderFactory.createTitledBorder(tituloBorda));
        add(panel);
    }
    
    public void adicionaTabelaFuncionario(JPanel panel, JTable table) {
        panel.add(table);
        model.addColumn("ID");
        model.addColumn("Nome");
        model.addColumn("Nascimento");
        model.addColumn("Cpf");
        model.addColumn("Cargo");
        model.addColumn("Status");
        model.addRow(new Object[]{"ID", "Nome", "Nascimento", "CPF", "Cargo", "Status"});
        preencheTabelaFuncionario(table);
    }

    public void preencheTabelaFuncionario(JTable table) {
        Connection conexao = conexaoBanco.getConexao();
        PreparedStatement execucaoSQL = conexaoBanco.getExecucaoSQL();
        String sql = "SELECT * FROM funcionario";

        try {
            execucaoSQL = conexao.prepareStatement(sql);
            ResultSet resultado = execucaoSQL.executeQuery();
            while(resultado.next()) {
                model.addRow(new Object[]{resultado.getInt("id_funcionario"),
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

    public void apresentacao() {
        this.panel = new JPanel();
        adicionaPainel(panel, "Funcionários");

        this.table = new JTable(model);
        adicionaTabelaFuncionario(panel, table);
    }
}
