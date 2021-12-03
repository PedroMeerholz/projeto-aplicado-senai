package interfaceSwing;

import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class PainelInicio extends JPanel {
    public PainelInicio() {
        super();
        setLayout(new BorderLayout());
        setVisible(true);
    }

    public void painel() {
        JLabel label = new JLabel("Bem-Vindo");
        add(label, BorderLayout.CENTER);
    }
}
