package interfaceSwing;

import javax.swing.JLabel;
import javax.swing.JPanel;

import crud.*;

public class PainelCarbono extends JPanel {

    private CRUDChamado crudChamado = new CRUDChamado();

    public PainelCarbono() {
        super();
        setLayout(null);
        informacoes();
    }

    public void adicionarJLabel(JLabel label, String titulo, int x, int y, int largura) {
        label.setText(titulo);
        label.setBounds(x, y, largura, 20);
        add(label);
    }

    public void informacoes() {
        JLabel label;

        label = new JLabel();
        adicionarJLabel(label, "Total de Carbono Emitido: " + crudChamado.getCarbonoEmitido(), 80, 100, 180);

        label = new JLabel();
        adicionarJLabel(label, "Veículo(ID) que Mais Emitiu Carbono: " + crudChamado.getMaiorEmissor(), 80, 140, 220);

        label = new JLabel();
        adicionarJLabel(label, "Veículo(ID) que Menos Emitiu Carbono: " + crudChamado.getMenorEmissor(), 80, 180, 240);
    }
}
