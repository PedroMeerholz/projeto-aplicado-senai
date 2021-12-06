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
    private JLabel labelTotalChamados;
    private JLabel labelChamadosAbertos;
    private JLabel labelChamadosFechados;
    private CRUDChamado crudChamado = new CRUDChamado();

    public PainelChamado() {
        super();
        setLayout(null);
        formulario();
    }

    public void adicionaPainelBotoes() {
        this.panelButton = new JPanel();
        this.panelButton.setLayout(new GridLayout(1, 4));
        this.panelButton.setBounds(250, 100, 375, 30);
        add(this.panelButton);
    }

    public void adicionaBotao(JButton button, String tituloBotao) {
        button.setText(tituloBotao);
        panelButton.add(button);
    }

    public void adicionaBotao(JButton button, String tituloBotao, int x, int y, int largura) {
        button.setText(tituloBotao);
        button.setBounds(x, y, largura, 30);
        add(button);
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
                new FrameCadastroChamado();
            }
        });
        adicionaBotao(button, "Cadastrar");
        
        this.button = new JButton();
        this.button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new FrameAtualizaChamado();
            }
        });
        adicionaBotao(button, "Modificar");

        this.button = new JButton();
        this.button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new FrameExclusao();
            }
        });
        adicionaBotao(button, "Excluir");

        this.button = new JButton();
        this.button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new FrameConsultaChamado();
            }
        });
        adicionaBotao(button, "Consultar");

        this.labelTotalChamados = new JLabel();
        adicionarJLabel(this.labelTotalChamados, "Total de Chamados: " + crudChamado.getNumeroDeChamados(), 345, 240, 150);

        this.labelChamadosAbertos = new JLabel();
        adicionarJLabel(this.labelChamadosAbertos, "Chamados Abertos: " + crudChamado.getChamadosDisponiveis(), 345, 280, 170);

        this.labelChamadosFechados = new JLabel();
        adicionarJLabel(this.labelChamadosFechados, "Chamados Fechados: " + crudChamado.getChamadosIndisponiveis(), 345, 320, 170);
    
        this.button = new JButton();
        this.button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                labelTotalChamados.setText("Total de Chamados: " + crudChamado.getNumeroDeChamados());
                labelChamadosAbertos.setText("Chamados Abertos: " + crudChamado.getChamadosDisponiveis());
                labelChamadosFechados.setText("Chamados Fechados: " + crudChamado.getChamadosIndisponiveis());
            }
        });
        adicionaBotao(this.button, "Atualizar Informações", 345, 360, 170);
    }
}
