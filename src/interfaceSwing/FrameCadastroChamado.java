package interfaceSwing;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComponent;

import operacoes.OperacoesCadastro;
import operacoes.GeraID;

import java.time.LocalDate;


import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrameCadastroChamado extends JFrame {
    private String id;
    private LocalDate data = LocalDate.now();
	private JTextField txtFieldIdFuncionario;
	private JTextField txtFieldIdVeiculo;
    private JButton btnCadastrar;
	private OperacoesCadastro operacoesCadastro = new OperacoesCadastro();
    private GeraID geraID = new GeraID();

    public FrameCadastroChamado() {
        super("Cadastro de Chamados");
        setSize(400, 400);

        setIdApresentacao();
        criaFormulario();

        setVisible(true);
    }

    private void setIdApresentacao() {
        this.id = String.valueOf(geraID.atualizaIDChamado() + 1);
    }

    private String getIdApresentacao() {
        return this.id;
    }

    private LocalDate getDataApresentacao() {
        return this.data;
    }
    
    private int getIdFuncionario() {
		int id = Integer.parseInt(txtFieldIdFuncionario.getText());

		return id;
	}

	private int getIdVeiculo() {
		int id = Integer.parseInt(txtFieldIdVeiculo.getText());

		return id;
	}

    private void adicionarComponente(JComponent componente, int x, int y, int largura) {
        add(componente);
        componente.setBounds(x, y, largura, 20);
    }

	public void enviaInformaçoesParaCadastro(int idFuncionario, int idVeiculo) {
		operacoesCadastro.cadastroChamado(idFuncionario, idVeiculo);
	}

    private void criaFormulario() {
        setLayout(null);

        JLabel label;

        label = new JLabel("ID Chamado: " + getIdApresentacao());
        adicionarComponente(label, 100, 70, 140);

        label = new JLabel("Data: " + getDataApresentacao());
        adicionarComponente(label, 100, 110, 140);

        label = new JLabel("ID do Funcionário: ");
        txtFieldIdFuncionario = new JTextField();
        adicionarComponente(label, 100, 150, 140);
        adicionarComponente(txtFieldIdFuncionario, 205, 150, 50);

        label = new JLabel("ID do Veículo: ");
        txtFieldIdVeiculo = new JTextField();
        adicionarComponente(label, 100, 190, 140);
        adicionarComponente(txtFieldIdVeiculo, 180, 190, 75);

        btnCadastrar = new JButton("Cadastrar");
        btnCadastrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                enviaInformaçoesParaCadastro(getIdFuncionario(), getIdVeiculo());
            }
        });
        adicionarComponente(btnCadastrar, 100, 230, 155);
    }
}
