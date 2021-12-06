package interfaceSwing;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;

import crud.CRUDVeiculo;

public class FrameConsultaVeiculo extends JFrame {
    private JPanel panelTable;
    private JTable table;
    private CRUDVeiculo crudVeiculo = new CRUDVeiculo();

    public FrameConsultaVeiculo() {
        super();
        setTitle("Consultar Veículo");
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
        adicionaPainel(panelTable, "Veículo");
        crudVeiculo.adicionaTabelaVeiculo(panelTable, table);
    }
}
