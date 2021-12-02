package interfaceSwing;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaPrincipal extends AdicionaComponentes {
    private JPanel panelCarbono;
    
    public TelaPrincipal() {
        super();
        setTitle("Projeto Aplicado - 2° Semestre");
        setSize(1200, 900);
        setLayout(new GridLayout(2, 2));
        tela();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void tela() {
        // Painel de Funcionários
        this.panelTable = new JPanel();
        this.panelButton = new JPanel();
        this.button = new JButton();
        this.button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CadastroFuncionario cadastroFuncionario = new CadastroFuncionario();
            }
        });
        adicionaBotao(panelButton, button, "Cadastrar");
        
        this.button = new JButton();
        this.button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AtualizaFuncionario atualizaFuncionario = new AtualizaFuncionario();
            }
        });
        adicionaBotao(panelButton, button, "Modificar");

        this.button = new JButton();
        this.button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Exclusao exclusao = new Exclusao();
            }
        });
        adicionaBotao(panelButton, button, "Excluir");

        this.button = new JButton();
        this.button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ConsultaFuncionario consultaFuncionario = new ConsultaFuncionario();
            }
        });
        adicionaBotao(panelButton, button, "Consultar");
        adionaPainelBotoes(panelTable);
        adicionaPainel(panelTable, "Funcionários");
        // Fim painel de Funcionários

        // Painel de Veículos
        this.panelTable = new JPanel();
        
        this.panelButton = new JPanel();
        this.button = new JButton();
        this.button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CadastroVeiculo cadastroVeiculo = new CadastroVeiculo();
            }
        });
        adicionaBotao(panelButton, button, "Cadastrar");
        
        this.button = new JButton();
        this.button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AtualizaVeiculo atualizaVeiculo = new AtualizaVeiculo();
            }
        });
        adicionaBotao(panelButton, button, "Modificar");

        this.button = new JButton();
        this.button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Exclusao exclusao = new Exclusao();
            }
        });
        adicionaBotao(panelButton, button, "Excluir");

        this.button = new JButton();
        this.button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ConsultaVeiculo consultaVeiculo = new ConsultaVeiculo();
            }
        });
        adicionaBotao(panelButton, button, "Consultar");
        adionaPainelBotoes(panelTable);
        adicionaPainel(panelTable, "Veículo");
        // Fim painel de Veículos

        // Painel de Chamados
        this.panelTable = new JPanel();
        
        this.panelButton = new JPanel();
        this.button = new JButton();
        this.button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CadastroChamado cadastroChamado = new CadastroChamado();
            }
        });
        adicionaBotao(panelButton, button, "Cadastrar");
        
        this.button = new JButton();
        this.button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AtualizaChamado atualizaChamado = new AtualizaChamado();
            }
        });
        adicionaBotao(panelButton, button, "Modificar");

        this.button = new JButton();
        this.button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Exclusao exclusao = new Exclusao();
            }
        });
        adicionaBotao(panelButton, button, "Excluir");

        this.button = new JButton();
        this.button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ConsultaChamado consultaChamado = new ConsultaChamado();
            }
        });
        adicionaBotao(panelButton, button, "Consultar");
        adionaPainelBotoes(panelTable);
        adicionaPainel(panelTable, "Chamados");
        // Fim painel de Chamados

        // Painel de Informações de Carbono
        this.panelCarbono = new JPanel();
        this.panelCarbono.setLayout(null);
        adicionaPainel(this.panelCarbono, "Informações Carbono");

        JLabel label;

        label = new JLabel();
        adicionarJLabel(this.panelCarbono, label, "Total de Carbono Emitido:", 80, 60, 150);

        label = new JLabel();
        adicionarJLabel(this.panelCarbono, label, "Veículo que Mais Emitiu:", 80, 100, 150);

        label = new JLabel();
        adicionarJLabel(this.panelCarbono, label, "Veículo que Menos Emitiu:", 80, 140, 150);

        label = new JLabel();
        adicionarJLabel(this.panelCarbono, label, "Carbono por KM:", 80, 180, 120);
        // Fim painel de Informações de Carbono
    }
}
