package interfaceSwing;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;

import crud.Conexao;

import java.awt.GridLayout;

public class AdicionaComponentes extends JFrame {
    protected JPanel panelTable;
    protected JPanel panelButton;
    protected JTable table;
    protected JButton button;
    protected Conexao conexaoBanco = new Conexao();

    public void adicionarComponente(JComponent componente, int x, int y, int largura) {
        componente.setBounds(x, y, largura, 20);
        add(componente);
    }
    
    public void adicionaPainel(JPanel panel, String tituloBorda) {
        panel.setBorder(BorderFactory.createTitledBorder(tituloBorda));
        add(panel);
    }

    public void adionaPainelBotoes(JPanel panelPai) {
        this.panelButton.setLayout(new GridLayout(1, 4));
        panelPai.add(this.panelButton);
    }

    public void adicionaBotao(JPanel panel, JButton button, String tituloBotao) {
        button.setText(tituloBotao);
        panel.add(button);
    }

    public void adicionaBotao(JButton button, int x, int y, int largura, String tituloBotao) {
        button.setText(tituloBotao);
        adicionarComponente(button, x, y, largura);
    }

    public void adicionarJLabel(JPanel panel, JLabel label, String titulo, int x, int y, int largura) {
        label.setText(titulo);
        label.setBounds(x, y, largura, 20);
        panel.add(label);
    }
}
