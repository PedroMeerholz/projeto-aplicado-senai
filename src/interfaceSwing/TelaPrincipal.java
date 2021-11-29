package interfaceSwing;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import crud.Conexao;

import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TelaPrincipal extends JFrame {
    private JPanel panelTable;
    private JTable table;
    private JPanel panelButton;
    private JButton button;
    private DefaultTableModel modelFuncionario = new DefaultTableModel();
    private DefaultTableModel modelVeiculo = new DefaultTableModel();
    private DefaultTableModel modelChamado = new DefaultTableModel();
    private Conexao conexaoBanco = new Conexao();
    
    public TelaPrincipal() {
        super("Projeto Aplicado - 2° Semestre");
        setSize(1850, 500);
        setLayout(new GridLayout(1, 3));
        tela();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void adicionaPainel(JPanel panel, String tituloBorda) {
        panel.setBorder(BorderFactory.createTitledBorder(tituloBorda));
        add(panel);
    }

    private void adionaPainelBotoes(JPanel panelPai) {
        this.panelButton.setLayout(new GridLayout(1, 4));
        panelPai.add(this.panelButton);
    }

    private void adicionaBotao(JPanel panel, JButton button, String tituloBotao) {
        button.setText(tituloBotao);
        panel.add(button);
    }

    private void adicionaTabelaFuncionario(JPanel panel, JTable table) {
        panel.add(table);
        modelFuncionario.addColumn("ID");
        modelFuncionario.addColumn("Nome");
        modelFuncionario.addColumn("Nascimento");
        modelFuncionario.addColumn("Cpf");
        modelFuncionario.addColumn("Cargo");
        modelFuncionario.addColumn("Status");
        modelFuncionario.addRow(new Object[]{"ID", "Nome", "Nascimento", "CPF", "Cargo", "Status"});
        preencheTabelaFuncionario(table);
    }

    private void preencheTabelaFuncionario(JTable table) {
        Connection conexao = conexaoBanco.getConexao();
        PreparedStatement execucaoSQL = conexaoBanco.getExecucaoSQL();
        String sql = "SELECT * FROM funcionario";

        try {
            execucaoSQL = conexao.prepareStatement(sql);
            ResultSet resultado = execucaoSQL.executeQuery();
            while(resultado.next()) {
                modelFuncionario.addRow(new Object[]{resultado.getInt("id_funcionario"),
                                          resultado.getString("nome"),
                                          resultado.getDate("nascimento"),
                                          resultado.getString("cpf"),
                                          resultado.getString("cargo"),
                                          resultado.getBoolean("status")});   
            }
        } catch(SQLException erro) {
            erro.printStackTrace();
        }
    }

    private void adicionaTabelaVeiculo(JPanel panel, JTable table) {
        panel.add(table);
        modelVeiculo.addColumn("ID");
        modelVeiculo.addColumn("Modelo");
        modelVeiculo.addColumn("Placa");
        modelVeiculo.addColumn("Ano");
        modelVeiculo.addColumn("Autonomia");
        modelVeiculo.addColumn("Status");
        modelVeiculo.addRow(new Object[]{"ID", "Modelo", "Placa", "Ano", "Autonomia", "Status"});
        preencheTabelaVeiculo(table);
    }

    public void preencheTabelaVeiculo(JTable table) {
        Connection conexao = conexaoBanco.getConexao();
        PreparedStatement execucaoSQL = conexaoBanco.getExecucaoSQL();
        String sql = "SELECT * FROM veiculo";

        try {
            execucaoSQL = conexao.prepareStatement(sql);
            ResultSet resultado = execucaoSQL.executeQuery();
            while(resultado.next()) {
                modelVeiculo.addRow(new Object[]{resultado.getInt("id_veiculo"),
                                          resultado.getString("modelo"),
                                          resultado.getString("placa"),
                                          resultado.getString("ano"),
                                          resultado.getFloat("autonomia"),
                                          resultado.getBoolean("status")});   
            }
        } catch(SQLException erro) {
            erro.printStackTrace();
        }
    }

    private void adicionaTabelaChamado(JPanel panel, JTable table) {
        panel.add(table);
        modelChamado.addColumn("ID");
        modelChamado.addColumn("Status");
        modelChamado.addColumn("Data");
        modelChamado.addColumn("Funcionario");
        modelChamado.addColumn("Veiculo");
        modelChamado.addColumn("Distância");
        modelChamado.addColumn("Carbono");
        modelChamado.addRow(new Object[]{"ID", "Status", "Data", "Funcionario", "Veiculo", "Distância", "Carbono"});
        preencheTabelaChamado(table);
    }

    private void preencheTabelaChamado(JTable table) {
        Connection conexao = conexaoBanco.getConexao();
        PreparedStatement execucaoSQL = conexaoBanco.getExecucaoSQL();
        String sql = "SELECT * FROM chamado";

        try {
            execucaoSQL = conexao.prepareStatement(sql);
            ResultSet resultado = execucaoSQL.executeQuery();
            while(resultado.next()) {
                modelChamado.addRow(new Object[]{resultado.getInt("id_chamado"),
                                          resultado.getBoolean("status"),
                                          resultado.getDate("data_chamado"),
                                          resultado.getString("funcionario"),
                                          resultado.getString("veiculo"),
                                          resultado.getFloat("distancia"),
                                          resultado.getFloat("carbono")});   
            }
        } catch(SQLException erro) {
            erro.printStackTrace();
        }
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
        adicionaBotao(panelButton, button, "Excluir");
        adionaPainelBotoes(panelTable);

        this.button = new JButton();
        adicionaBotao(panelButton, button, "Atualizar Tabela");
        adionaPainelBotoes(panelTable);

        this.table = new JTable(modelFuncionario);
        adicionaPainel(panelTable, "Funcionários");
        adicionaTabelaFuncionario(panelTable, table);
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
        adicionaBotao(panelButton, button, "Excluir");
        adionaPainelBotoes(panelTable);

        this.button = new JButton();
        adicionaBotao(panelButton, button, "Atualizar Tabela");
        adionaPainelBotoes(panelTable);

        this.table = new JTable(modelVeiculo);
        adicionaPainel(panelTable, "Veículo");
        adicionaTabelaVeiculo(panelTable, table);
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
        adicionaBotao(panelButton, button, "Modificar");

        this.button = new JButton();
        adicionaBotao(panelButton, button, "Excluir");
        adionaPainelBotoes(panelTable);

        this.button = new JButton();
        adicionaBotao(panelButton, button, "Atualizar Tabela");
        adionaPainelBotoes(panelTable);

        this.table = new JTable(modelChamado);
        adicionaPainel(panelTable, "Chamados");
        adicionaTabelaChamado(panelTable, table);
        // Fim painel de Chamados
    }
}
