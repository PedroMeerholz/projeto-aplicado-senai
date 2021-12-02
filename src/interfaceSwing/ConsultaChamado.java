package interfaceSwing;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ConsultaChamado extends AdicionaComponentes {
    protected DefaultTableModel modelChamado = new DefaultTableModel();

    public ConsultaChamado() {
        super();
        setTitle("Consultar Chamados");
        setSize(600, 600);
        formulario();
        setVisible(true);
    }

    public void adicionaTabelaChamado(JPanel panel, JTable table) {
        panel.add(table);
        modelChamado.addColumn("ID");
        modelChamado.addColumn("Status");
        modelChamado.addColumn("Data");
        modelChamado.addColumn("Funcionario");
        modelChamado.addColumn("Veiculo");
        modelChamado.addColumn("Distância");
        modelChamado.addColumn("Carbono");
        modelChamado.addRow(new Object[]{"ID", "Status", "Data", "Funcionario", "Veiculo", "Distância", "Carbono"});
        preencheTabelaChamado(table);
    }

    public void preencheTabelaChamado(JTable table) {
        Connection conexao = conexaoBanco.getConexao();
        PreparedStatement execucaoSQL = conexaoBanco.getExecucaoSQL();
        String sql = "SELECT * FROM chamado ORDER BY id_chamado ASC";

        try {
            execucaoSQL = conexao.prepareStatement(sql);
            ResultSet resultado = execucaoSQL.executeQuery();
            while(resultado.next()) {
                modelChamado.addRow(new Object[]{resultado.getInt("id_chamado"),
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

    public void formulario() {
        this.panelTable = new JPanel();
        this.table = new JTable(modelChamado);
        adicionaPainel(panelTable, "Chamados");
        adicionaTabelaChamado(panelTable, table);
    }
}