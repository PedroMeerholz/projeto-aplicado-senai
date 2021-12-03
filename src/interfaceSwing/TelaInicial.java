package interfaceSwing;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;

public class TelaInicial extends JFrame {
    private JTabbedPane tabbedPane;

    public TelaInicial() {
        super();
        setTitle("Início");
        setSize(400, 400);
        menu();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void adicionaMenu(JTabbedPane tabbedPane) {
        add(tabbedPane);
    }

    public void menu() {
        this.tabbedPane = new JTabbedPane();
        adicionaMenu(this.tabbedPane);

        this.tabbedPane.addTab("Início", new PainelInicio());
        this.tabbedPane.addTab("Funcionário", new PainelFuncionario());
        this.tabbedPane.addTab("Veículo", new PainelVeiculo());
        this.tabbedPane.addTab("Chamado", new PainelChamado());
        this.tabbedPane.add("Carbono", new PainelCarbono());
    }

    public static void main(String[] args) {
        new TelaInicial();
    }
}
