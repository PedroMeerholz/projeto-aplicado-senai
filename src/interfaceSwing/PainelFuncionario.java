package interfaceSwing;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PainelFuncionario extends JPanel {
    private JButton button;
    private JPanel panelButton;

    public PainelFuncionario() {
        super();
        setBorder(BorderFactory.createTitledBorder("Funcionário"));
        setLayout(null);
        formulario();
    }

    public void adicionaBotao(JButton button, String tituloBotao) {
        button.setText(tituloBotao);
        panelButton.add(button);
    }

    public void adicionaPainelBotoes() {
        this.panelButton = new JPanel();
        this.panelButton.setLayout(new GridLayout(1, 4));
        this.panelButton.setBounds(110, 40, 375, 30);
        add(this.panelButton);
    }

    public void adicionarJLabel(JLabel label, String titulo, int x, int y, int largura) {
        label.setText(titulo);
        label.setBounds(x, y, largura, 20);
        add(label);
    }

    public void formulario() {
        adicionaPainelBotoes();
        this.button = new JButton();
        this.button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CadastroFuncionario cadastroFuncionario = new CadastroFuncionario();
            }
        });
        adicionaBotao(button, "Cadastrar");

        this.button = new JButton();
        this.button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AtualizaFuncionario atualizaFuncionario = new AtualizaFuncionario();
            }
        });
        adicionaBotao(button, "Modificar");

        this.button = new JButton();
        this.button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Exclusao exclusao = new Exclusao();
            }
        });
        adicionaBotao(button, "Excluir");

        this.button = new JButton();
        this.button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ConsultaFuncionario consultaFuncionario = new ConsultaFuncionario();
            }
        });
        adicionaBotao(button, "Consultar");

        JLabel label;
        
        label = new JLabel();
        adicionarJLabel(label, "Total de Veículos:", 80, 100, 150);

        label = new JLabel();
        adicionarJLabel(label, "Veículos Disponíveis:", 80, 140, 150);

        label = new JLabel();
        adicionarJLabel(label, "Veículos Indisponíveis:", 80, 180, 150);
    }   
}
