import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.awt.event.ActionEvent;

public class CadastrarFuncionario implements ActionListener {

	private JFrame frameCadastrarFuncionario;
	private JTextField txtFieldNome;
	private JTextField txtFieldNascimento;
	private JTextField txtFieldCpf;
	private JTextField txtFieldCargo;
	private OperacoesCadastro operacoesCadastro = new OperacoesCadastro();

	public String getNome() {
		String nome = txtFieldNome.getText();

		return nome;
	}
	
	public Date getNascimento() {
		String nascimento = txtFieldNascimento.getText();

		Date dataNascimento = Date.valueOf(nascimento);
		
		return dataNascimento;
	}
	
	public String getCpf() {
		String cpf = txtFieldCpf.getText();
		
		return cpf;
	}
	
	public String getCargo() {
		String cargo = txtFieldCargo.getText();
		
		return cargo;
	}

	public void enviaInformaçoesParaCadastro(String nome, Date nascimento, String cpf, String cargo) {
		operacoesCadastro.cadastroFuncionario(nome, nascimento, cpf, cargo);
	}

	public void actionPerformed(ActionEvent e) {
		enviaInformaçoesParaCadastro(getNome(), getNascimento(), getCpf(), getCargo());
	}

	//Iniciando a Aplicação
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastrarFuncionario janela = new CadastrarFuncionario();
					janela.frameCadastrarFuncionario.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	// Criando a Aplicação
	public CadastrarFuncionario() {
		initialize();
	}

	// Inicializando os elementos da janela
	private void initialize() {
		frameCadastrarFuncionario = new JFrame();
		frameCadastrarFuncionario.setTitle("Cadastrar Funcionário");
		frameCadastrarFuncionario.setSize(400, 350);
		frameCadastrarFuncionario.getContentPane().setLayout(null);

		JLabel lblMensagemInicial = new JLabel("Cadastrar Funcionário");
		lblMensagemInicial.setBounds(10, 10, 142, 20);
		frameCadastrarFuncionario.getContentPane().add(lblMensagemInicial);

		JLabel lblIdFuncionario = new JLabel("ID: "); // Mostra o ID que será atribuído ao funcionário, obtido consulta ao db
		lblIdFuncionario.setBounds(30, 50, 140, 20);
		frameCadastrarFuncionario.getContentPane().add(lblIdFuncionario);
		
		JLabel lblNomeDoFuncionrio = new JLabel("Nome:");
		lblNomeDoFuncionrio.setBounds(30, 90, 140, 14);
		frameCadastrarFuncionario.getContentPane().add(lblNomeDoFuncionrio);
		
		txtFieldNome = new JTextField();
		txtFieldNome.setBounds(70, 90, 180, 20);
		frameCadastrarFuncionario.getContentPane().add(txtFieldNome);
		txtFieldNome.setColumns(10);
		
		JLabel lblNascimento = new JLabel("Nascimento:");
		lblNascimento.setBounds(30, 130, 140, 14);
		frameCadastrarFuncionario.getContentPane().add(lblNascimento);
		
		txtFieldNascimento = new JTextField();
		txtFieldNascimento.setBounds(105, 130, 145, 20);
		frameCadastrarFuncionario.getContentPane().add(txtFieldNascimento);
		txtFieldNascimento.setColumns(10);
		
		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setBounds(30, 170, 140, 14);
		frameCadastrarFuncionario.getContentPane().add(lblCpf);
		
		txtFieldCpf = new JTextField();
		txtFieldCpf.setBounds(60, 170, 190, 20);
		frameCadastrarFuncionario.getContentPane().add(txtFieldCpf);
		txtFieldCpf.setColumns(10);

		JLabel lblCargo = new JLabel("Cargo:");
		lblCargo.setBounds(30, 210, 140, 14);
		frameCadastrarFuncionario.getContentPane().add(lblCargo);
		
		txtFieldCargo = new JTextField();
		txtFieldCargo.setBounds(70, 210, 180, 20);
		frameCadastrarFuncionario.getContentPane().add(txtFieldCargo);
		txtFieldCargo.setColumns(10);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(this);
		btnCadastrar.setBounds(30, 250, 220, 20);
		frameCadastrarFuncionario.getContentPane().add(btnCadastrar);
	}
}
