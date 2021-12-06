package interfaceSwing;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;

import crud.CRUDChamado;

public class FrameConsultaChamado extends JFrame {
    private JPanel panelTable;
    private JTable table;
    private CRUDChamado crudChamado = new CRUDChamado();

    public FrameConsultaChamado() {
        super();
        setTitle("Consultar Chamados");
        setSize(600, 600);
        apresentaTabela();
        setVisible(true);
    }

    public void adicionaPainel(JPanel panel, String tituloBorda) {
        panel.setBorder(BorderFactory.createTitledBorder(tituloBorda));
        add(panel);
    }
    
    public void apresentaTabela() {
        this.panelTable = new JPanel();
        adicionaPainel(panelTable, "Chamados");
        crudChamado.adicionaTabelaChamado(panelTable, table);
    }
}