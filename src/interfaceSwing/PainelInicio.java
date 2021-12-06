package interfaceSwing;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class PainelInicio extends JPanel {
    private Font font = new Font("SanSerif", Font.BOLD, 20);
    public PainelInicio() {
        super();
        setLayout(null);
        painel();
        setVisible(true);
    }

    public void painel() {
        JLabel label = new JLabel("Bem-Vindo");
        label.setFont(font);
        label.setBounds(400, 250, 120, 20);
        add(label);
    }
}
