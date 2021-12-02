package interfaceSwing;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ConsultaVeiculo extends AdicionaComponentes {
    private DefaultTableModel modelVeiculo = new DefaultTableModel();

    public ConsultaVeiculo() {
        super();
        setTitle("Consultar Veículo");
        setSize(600, 600);
        formulario();
        setVisible(true);
    }

    public void adicionaTabelaVeiculo(JPanel panel, JTable table) {
        panel.add(table);
        modelVeiculo.addColumn("ID");
        modelVeiculo.addColumn("Modelo");
        modelVeiculo.addColumn("Placa");
        modelVeiculo.addColumn("Ano");
        modelVeiculo.addColumn("Autonomia");
        modelVeiculo.addColumn("Status");
        modelVeiculo.addRow(new Object[]{"ID", "Modelo", "Placa", "Ano", "Autonomia", "Status"});
        preencheTabelaVeiculo(table);
    }

    public void preencheTabelaVeiculo(JTable table) {
        Connection conexao = conexaoBanco.getConexao();
        PreparedStatement execucaoSQL = conexaoBanco.getExecucaoSQL();
        String sql = "SELECT * FROM veiculo ORDER BY id_veiculo ASC";

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

    private void formulario() {
        this.panelTable = new JPanel();
        this.table = new JTable(modelVeiculo);
        adicionaPainel(panelTable, "Veículo");
        adicionaTabelaVeiculo(panelTable, table);
    }
}
