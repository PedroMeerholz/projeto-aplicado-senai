import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CadastrarVeiculo implements ActionListener {

	private JFrame frameCadastrarVeiculo;
	private JTextField txtFieldModelo;
	private JTextField txtFieldPlaca;
	private JTextField txtFieldAno;
	private JTextField txtFieldAutonomia;
	private OperacoesCadastro operacoesCadastro = new OperacoesCadastro();

	public String getModelo() {
		String modelo = txtFieldModelo.getText();

		return modelo;
	}

	public String getPlaca() {
		String placa = txtFieldPlaca.getText();

		return placa;
	}

	public String getAno() {
		String ano = txtFieldAno.getText();

		return ano;
	}

	public double getAutonomia() {
		double autonomia = Double.parseDouble(txtFieldAutonomia.getText());

		return autonomia;
	}

	public void enviaInformaçoesParaCadastro(String modelo, String placa, String ano, double autonomia) {
		operacoesCadastro.cadastroVeiculo(modelo, placa, ano, autonomia);
	}

	public void actionPerformed(ActionEvent e) {
		enviaInformaçoesParaCadastro(getModelo(), getPlaca(), getAno(), getAutonomia());
	}

	// Iniciando a Aplicação
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastrarVeiculo janela = new CadastrarVeiculo();
					janela.frameCadastrarVeiculo.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	// Criando a Aplicação
	public CadastrarVeiculo() {
		initialize();
	}

	//Inicializando os componentes da janela
	private void initialize() {
		frameCadastrarVeiculo = new JFrame();
		frameCadastrarVeiculo.setTitle("Cadastrar Veículo");
		frameCadastrarVeiculo.setSize(400, 350);
		frameCadastrarVeiculo.getContentPane().setLayout(null);

		JLabel lblMensagemInicial = new JLabel("Cadastrar Veículo");
		lblMensagemInicial.setBounds(10, 10, 140, 20);
		frameCadastrarVeiculo.getContentPane().add(lblMensagemInicial);

		JLabel lblIdVeiculo = new JLabel("ID: "); // Mostra o ID que será atribuído ao funcionário, obtido consulta ao db
		lblIdVeiculo.setBounds(30, 50, 140, 20);
		frameCadastrarVeiculo.getContentPane().add(lblIdVeiculo);
		
		JLabel lblModelo = new JLabel("Modelo:");
		lblModelo.setBounds(30, 90, 140, 20);
		frameCadastrarVeiculo.getContentPane().add(lblModelo);
		
		txtFieldModelo = new JTextField();
		txtFieldModelo.setBounds(80, 90, 170, 20);
		frameCadastrarVeiculo.getContentPane().add(txtFieldModelo);
		txtFieldModelo.setColumns(10);
		
		JLabel lblPlaca = new JLabel("Placa:");
		lblPlaca.setBounds(30, 130, 150, 20);
		frameCadastrarVeiculo.getContentPane().add(lblPlaca);
		
		txtFieldPlaca = new JTextField();
		txtFieldPlaca.setBounds(70, 130, 180, 20);
		frameCadastrarVeiculo.getContentPane().add(txtFieldPlaca);
		txtFieldPlaca.setColumns(10);
		
		JLabel lblAno = new JLabel("Ano:");
		lblAno.setBounds(30, 170, 140, 20);
		frameCadastrarVeiculo.getContentPane().add(lblAno);
		
		txtFieldAno = new JTextField();
		txtFieldAno.setBounds(60, 170, 190, 20);
		frameCadastrarVeiculo.getContentPane().add(txtFieldAno);
		txtFieldAno.setColumns(10);
		
		JLabel lblAutonomia = new JLabel("Autonomia:");
		lblAutonomia.setBounds(30, 210, 140, 14);
		frameCadastrarVeiculo.getContentPane().add(lblAutonomia);
		
		txtFieldAutonomia = new JTextField();
		txtFieldAutonomia.setBounds(100, 210, 150, 20);
		frameCadastrarVeiculo.getContentPane().add(txtFieldAutonomia);
		txtFieldAutonomia.setColumns(10);
		
		JButton btnNewButton = new JButton("Cadastrar");
		btnNewButton.addActionListener(this);
		btnNewButton.setBounds(30, 250, 220, 20);
		frameCadastrarVeiculo.getContentPane().add(btnNewButton);
	}

}
