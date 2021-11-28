package interfaceSwing;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import crud.Conexao;

public class ConsultaChamado extends JFrame  {
    private JPanel panel;
    private JTable table;
    private DefaultTableModel model = new DefaultTableModel();
    private Conexao conexaoBanco = new Conexao();

    public ConsultaChamado() {
        super("Consultas");
        setSize(700, 500);
        apresentacao();
        setVisible(true);
    }

    public void adicionaPainel(JPanel panel, String tituloBorda) {
        panel.setBorder(BorderFactory.createTitledBorder(tituloBorda));
        add(panel);
    }
    
    public void adicionaTabelaChamado(JPanel panel, JTable table) {
        panel.add(table);
        model.addColumn("ID");
        model.addColumn("Status");
        model.addColumn("Data");
        model.addColumn("Funcionario");
        model.addColumn("Veiculo");
        model.addColumn("Distância");
        model.addColumn("Carbono");
        model.addRow(new Object[]{"ID", "Status", "Data", "Funcionario", "Veiculo", "Distância", "Carbono"});
        preencheTabelaFuncionario(table);
    }

    public void preencheTabelaFuncionario(JTable table) {
        Connection conexao = conexaoBanco.getConexao();
        PreparedStatement execucaoSQL = conexaoBanco.getExecucaoSQL();
        String sql = "SELECT * FROM chamado";

        try {
            execucaoSQL = conexao.prepareStatement(sql);
            ResultSet resultado = execucaoSQL.executeQuery();
            while(resultado.next()) {
                model.addRow(new Object[]{resultado.getInt("id_chamado"),
                                          resultado.getBoolean("status"),
                                          resultado.getDate("data_chamado"),
                                          resultado.getString("funcionario"),
                                          resultado.getString("veiculo"),
                                          resultado.getFloat("distancia"),
                                          resultado.getFloat("carbono")});   
            }
        } catch(SQLException erro) {
            erro.printStackTrace();
        }
    }

    public void apresentacao() {
        this.panel = new JPanel();
        adicionaPainel(panel, "Chamados");

        this.table = new JTable(model);
        adicionaTabelaChamado(panel, table);
    }
}
