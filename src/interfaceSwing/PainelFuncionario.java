package interfaceSwing;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import crud.CRUDFuncionario;

public class PainelFuncionario extends JPanel {
    private JButton button;
    private JPanel panelButton;
    private JLabel labelTotalFuncionarios;
    private JLabel labelFuncionariosDisponiveis;
    private JLabel labelFuncionariosIndisponiveis;
    private CRUDFuncionario crudFuncionario= new CRUDFuncionario();


    public PainelFuncionario() {
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
                new FrameCadastroFuncionario();
            }
        });
        adicionaBotao(button, "Cadastrar");

        this.button = new JButton();
        this.button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new FrameAtualizaFuncionario();
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
                new FrameConsultaFuncionario();
            }
        });
        adicionaBotao(button, "Consultar");
        
        this.labelTotalFuncionarios = new JLabel();
        adicionarJLabel(this.labelTotalFuncionarios, "Total de Funcionários: " + crudFuncionario.getNumeroDeFuncionarios(), 345, 240, 150);

        this.labelFuncionariosDisponiveis = new JLabel();
        adicionarJLabel(this.labelFuncionariosDisponiveis, "Funcionários Disponíveis: " + crudFuncionario.getFuncionariosDisponiveis(), 345, 280, 170);

        this.labelFuncionariosIndisponiveis = new JLabel();
        adicionarJLabel(this.labelFuncionariosIndisponiveis, "Funcionários Indisponíveis: " + crudFuncionario.getFuncionarioIndisponiveis(), 345, 320, 170);

        this.button = new JButton();
        this.button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                labelTotalFuncionarios.setText("Total de Funcionários: " + crudFuncionario.getNumeroDeFuncionarios());
                labelFuncionariosDisponiveis.setText("Funcionários Disponíveis: " + crudFuncionario.getFuncionariosDisponiveis());
                labelFuncionariosIndisponiveis.setText("Funcionários Indisponíveis: " + crudFuncionario.getFuncionarioIndisponiveis());
            }
        });
        adicionaBotao(this.button, "Atualizar Informações", 345, 360, 170);
    }   
}
