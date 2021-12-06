package interfaceSwing;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import crud.CRUDVeiculo;

import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PainelVeiculo extends JPanel {
    private JButton button;
    private JPanel panelButton;
    private JLabel labelTotalVeiculos;
    private JLabel labelVeiculosDisponiveis;
    private JLabel labelVeiculosIndisponiveis;
    private CRUDVeiculo crudVeiculo = new CRUDVeiculo();

    public PainelVeiculo() {
        super();
        setLayout(null);
        formulario();
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

    public void adicionaPainelBotoes() {
        this.panelButton = new JPanel();
        this.panelButton.setLayout(new GridLayout(1, 4));
        this.panelButton.setBounds(250, 100, 375, 30);
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
                new FrameCadastroVeiculo();
            }
        });
        adicionaBotao(button, "Cadastrar");
        
        this.button = new JButton();
        this.button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new FrameAtualizaVeiculo();
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
                new FrameConsultaVeiculo();
            }
        });
        adicionaBotao(button, "Consultar");

        this.labelTotalVeiculos = new JLabel();
        adicionarJLabel(this.labelTotalVeiculos, "Total de Veículos: " + crudVeiculo.getNumeroDeVeiculos(), 345, 240, 150);

        this.labelVeiculosDisponiveis = new JLabel();
        adicionarJLabel(this.labelVeiculosDisponiveis, "Veículos Disponíveis: " + crudVeiculo.getVeiculosDisponiveis(), 345, 280, 170);

        this.labelVeiculosIndisponiveis = new JLabel();
        adicionarJLabel(this.labelVeiculosIndisponiveis, "Veículos Indisponíveis: " + crudVeiculo.getVeiculosIndisponiveis(), 345, 320, 170);
    
        this.button = new JButton();
        this.button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                labelTotalVeiculos.setText("Total de Veículos: " + crudVeiculo.getNumeroDeVeiculos());
                labelVeiculosDisponiveis.setText("Veículos Disponíveis: " + crudVeiculo.getVeiculosDisponiveis());
                labelVeiculosIndisponiveis.setText("Veículos Indisponíveis: " + crudVeiculo.getVeiculosIndisponiveis());
            }
        });
        adicionaBotao(this.button, "Atualizar Informações", 345, 360, 170);
    }
}
