import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CadastrarChamado implements ActionListener {

	private JFrame frameCadastrarChamado;
	private JTextField txtFieldIdFuncionario;
	private JTextField txtFieldIdVeiculo;
	private OperacoesCadastro operacoesCadastro = new OperacoesCadastro();

	public int getIdFuncionario() {
		int id = Integer.parseInt(txtFieldIdFuncionario.getText());

		return id;
	}

	public int getIdVeiculo() {
		int id = Integer.parseInt(txtFieldIdVeiculo.getText());

		return id;
	}

	public void enviaInformaçoesParaCadastro(int idFuncionario, int idVeiculo) {
		operacoesCadastro.cadastroChamado(idFuncionario, idVeiculo);
	}

	public void actionPerformed(ActionEvent e) {
		enviaInformaçoesParaCadastro(getIdFuncionario(), getIdVeiculo());
	}

	// Iniciando a Aplicação
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastrarChamado janela = new CadastrarChamado();
					janela.frameCadastrarChamado.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	// Criando a Aplicação
	public CadastrarChamado() {
		initialize();
	}

	// Inicializando os componentes da janela
	private void initialize() {
		frameCadastrarChamado = new JFrame();
		frameCadastrarChamado.setTitle("Cadastrar Chamado");
		frameCadastrarChamado.setSize(400, 350);
		frameCadastrarChamado.getContentPane().setLayout(null);

		JLabel lblMensagemInicial = new JLabel("Cadastrar Chamado");
		lblMensagemInicial.setBounds(10, 10, 140, 20);
		frameCadastrarChamado.getContentPane().add(lblMensagemInicial);

		JLabel lblIdChamado = new JLabel("ID:");
		lblIdChamado.setBounds(30, 50, 140, 20);
		frameCadastrarChamado.getContentPane().add(lblIdChamado);

		JLabel lblDataChamado = new JLabel("Data:");
		lblDataChamado.setBounds(30, 90, 140, 20);
		frameCadastrarChamado.getContentPane().add(lblDataChamado);
		
		JLabel lblIdDoFuncionario = new JLabel("ID do Funcionario:");
		lblIdDoFuncionario.setBounds(30, 130, 140, 20);
		frameCadastrarChamado.getContentPane().add(lblIdDoFuncionario);
		
		txtFieldIdFuncionario = new JTextField();
		txtFieldIdFuncionario.setBounds(135, 130, 50, 20);
		frameCadastrarChamado.getContentPane().add(txtFieldIdFuncionario);
		txtFieldIdFuncionario.setColumns(10);
		
		JLabel lblIdDoVeculo = new JLabel("ID do Veículo:");
		lblIdDoVeculo.setBounds(30, 170, 142, 20);
		frameCadastrarChamado.getContentPane().add(lblIdDoVeculo);
		
		txtFieldIdVeiculo = new JTextField();
		txtFieldIdVeiculo.setBounds(110, 170, 75, 20);
		frameCadastrarChamado.getContentPane().add(txtFieldIdVeiculo);
		txtFieldIdVeiculo.setColumns(10);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(this);
		btnCadastrar.setBounds(30, 210, 155, 20);
		frameCadastrarChamado.getContentPane().add(btnCadastrar);
	}
}
