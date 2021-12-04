package interfaceSwing;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;

import crud.CRUDFuncionario;

public class ConsultaFuncionario extends JFrame {
    private JPanel panelTable;
    private JTable table;
    private CRUDFuncionario crudFuncionario = new CRUDFuncionario();

    public ConsultaFuncionario() {
        super();
        setTitle("Consultar Funcionários");
        setSize(600, 600);
        apresentaTabela();
        setVisible(true);
    }

    public void adicionaPainel(JPanel panel, String tituloBorda) {
        panel.setBorder(BorderFactory.createTitledBorder(tituloBorda));
        add(panel);
    }

    private void apresentaTabela() {
        this.panelTable = new JPanel();
        adicionaPainel(panelTable, "Funcionários");
        crudFuncionario.adicionaTabelaFuncionario(panelTable, table);
    }
}
