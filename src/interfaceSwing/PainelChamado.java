package interfaceSwing;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import crud.CRUDChamado;

import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PainelChamado extends JPanel {
    private JButton button;
    private JPanel panelButton;
    private CRUDChamado crudChamado = new CRUDChamado();

    public PainelChamado() {
        super();
        setLayout(null);
        formulario();
    }

    public void adicionaPainelBotoes() {
        this.panelButton = new JPanel();
        this.panelButton.setLayout(new GridLayout(1, 4));
        this.panelButton.setBounds(110, 40, 375, 30);
        add(this.panelButton);
    }

    public void adicionaBotao(JButton button, String tituloBotao) {
        button.setText(tituloBotao);
        panelButton.add(button);
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
                new CadastroChamado();
            }
        });
        adicionaBotao(button, "Cadastrar");
        
        this.button = new JButton();
        this.button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AtualizaChamado();
            }
        });
        adicionaBotao(button, "Modificar");

        this.button = new JButton();
        this.button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Exclusao();
            }
        });
        adicionaBotao(button, "Excluir");

        this.button = new JButton();
        this.button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ConsultaChamado();
            }
        });
        adicionaBotao(button, "Consultar");

        JLabel label;

        label = new JLabel();
        adicionarJLabel(label, "Total de Chamados: " + crudChamado.getNumeroDeChamados(), 80, 100, 150);

        label = new JLabel();
        adicionarJLabel(label, "Chamados Abertos: " + crudChamado.getChamadosDisponiveis(), 80, 140, 150);

        label = new JLabel();
        adicionarJLabel(label, "Chamados Fechados: " + crudChamado.getChamadosIndisponiveis(), 80, 180, 150);
    }
}
