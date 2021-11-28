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

public class ConsultaVeiculo extends JFrame {
    private JPanel panel;
    private JTable table;
    private DefaultTableModel model = new DefaultTableModel();
    private Conexao conexaoBanco = new Conexao();

    public ConsultaVeiculo() {
        super("Consultas");
        setSize(700, 500);
        apresentacao();
        setVisible(true);
    }
    
    public void adicionaPainel(JPanel panel, String tituloBorda) {
        panel.setBorder(BorderFactory.createTitledBorder(tituloBorda));
        add(panel);
    }

    public void adicionaTabelaVeiculo(JPanel panel, JTable table) {
        panel.add(table);
        model.addColumn("ID");
        model.addColumn("Modelo");
        model.addColumn("Placa");
        model.addColumn("Ano");
        model.addColumn("Autonomia");
        model.addColumn("Status");
        model.addRow(new Object[]{"ID", "Modelo", "Placa", "Ano", "Autonomia", "Status"});
        preencheTabelaVeiculo(table);
    }

    public void preencheTabelaVeiculo(JTable table) {
        Connection conexao = conexaoBanco.getConexao();
        PreparedStatement execucaoSQL = conexaoBanco.getExecucaoSQL();
        String sql = "SELECT * FROM veiculo";

        try {
            execucaoSQL = conexao.prepareStatement(sql);
            ResultSet resultado = execucaoSQL.executeQuery();
            while(resultado.next()) {
                model.addRow(new Object[]{resultado.getInt("id_veiculo"),
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
    
    public void apresentacao() {
        this.panel = new JPanel();
        adicionaPainel(panel, "Veículo");

        this.table = new JTable(model);
        adicionaTabelaVeiculo(panel, table);
    }
}
