package interfaceSwing;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.GridLayout;

public class PainelCarbono extends JPanel {
    public PainelCarbono() {
        super();
        setBorder(BorderFactory.createTitledBorder("Chamados"));
        setLayout(null);
        formulario();
    }

    public void adicionarJLabel(JLabel label, String titulo, int x, int y, int largura) {
        label.setText(titulo);
        label.setBounds(x, y, largura, 20);
        add(label);
    }

    public void formulario() {
        JLabel label;

        label = new JLabel();
        adicionarJLabel(label, "Total de Carbono Emitido:", 80, 100, 150);

        label = new JLabel();
        adicionarJLabel(label, "Veículo que Mais Emitiu:", 80, 140, 150);

        label = new JLabel();
        adicionarJLabel(label, "Veículo que Menos Emitiu:", 80, 180, 150);

        label = new JLabel();
        adicionarJLabel(label, "Carbono por KM:", 80, 220, 120);
    }
}
