import java.awt.EventQueue;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.awt.event.ActionEvent;

public class AtualizarFuncionario {

	private JFrame frameAtualizarFuncionario;
	private JTextField txtFieldId;
	private JTextField txtFieldNome;
	private JButton btnAtualizarNome;
	private JTextField txtFieldNascimento;
	private JButton btnAtualizarNascimento;
	private JTextField txtFieldCpf;
	private JButton btnAtualizarCpf;
	private JTextField txtFieldCargo;
	private JButton btnAtualizarCargo;
	private ButtonGroup buttonGroup;
	private JRadioButton radioBtnStatusDisponivel;
	private JRadioButton radioButtonIndisponivel;
	private JButton btnAtualizaStatus;
	private OperacoesAtualizacao operacoesAtualizacao = new OperacoesAtualizacao();

	public int getId() {
		int id = Integer.parseInt(txtFieldId.getText());

		return id;
	}

	public String getNome() {
		String nome = txtFieldNome.getText();

		return nome;
	}
	
	public Date getNascimento() {
		String nascimentoString = txtFieldNascimento.getText();

		Date nascimento = Date.valueOf(nascimentoString);
		
		return nascimento;
	}
	
	public String getCpf() {
		String cpf = txtFieldCpf.getText();
		
		return cpf;
	}
	
	public String getCargo() {
		String cargo = txtFieldCargo.getText();
		
		return cargo;
	}

	public boolean getStatus() {
		boolean status = true;
		if(radioBtnStatusDisponivel.isSelected()) {
			status = true;
		} else {
			status = false;
		}

		return status;
	}

	//Iniciando a Aplicação
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AtualizarFuncionario janela = new AtualizarFuncionario();
					janela.frameAtualizarFuncionario.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	// Criando a Aplicação
	public AtualizarFuncionario() {
		initialize();
	}

	// Inicializando os elementos da janela
	private void initialize() {
		frameAtualizarFuncionario = new JFrame();
		frameAtualizarFuncionario.setTitle("Atualizar Funcionário");
		frameAtualizarFuncionario.setSize(400, 350);
		frameAtualizarFuncionario.getContentPane().setLayout(null);

		JLabel lblMensagemInicial = new JLabel("Atualizar Funcionário");
		lblMensagemInicial.setBounds(10, 10, 140, 20);
		frameAtualizarFuncionario.getContentPane().add(lblMensagemInicial);

		JLabel lblIdFuncionario = new JLabel("ID: "); // Mostra o ID que será atribuído ao funcionário, obtido consulta ao db
		lblIdFuncionario.setBounds(30, 50, 140, 20);
		frameAtualizarFuncionario.getContentPane().add(lblIdFuncionario);

		txtFieldId = new JTextField();
		txtFieldId.setBounds(50, 50, 200, 20);
		frameAtualizarFuncionario.getContentPane().add(txtFieldId);
		
		JLabel lblNomeDoFuncionrio = new JLabel("Nome:");
		lblNomeDoFuncionrio.setBounds(30, 90, 140, 14);
		frameAtualizarFuncionario.getContentPane().add(lblNomeDoFuncionrio);
		
		txtFieldNome = new JTextField();
		txtFieldNome.setBounds(70, 90, 180, 20);
		frameAtualizarFuncionario.getContentPane().add(txtFieldNome);
		txtFieldNome.setColumns(10);
		
		btnAtualizarNome = new JButton("Atualizar");
		btnAtualizarNome.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				operacoesAtualizacao.atualizaNomeFuncionario(getId(), getNome());
			}
		});
		btnAtualizarNome.setBounds(260, 90, 100, 20);
		frameAtualizarFuncionario.getContentPane().add(btnAtualizarNome);
		
		JLabel lblNascimento = new JLabel("Nascimento:");
		lblNascimento.setBounds(30, 130, 140, 20);
		frameAtualizarFuncionario.getContentPane().add(lblNascimento);
		
		txtFieldNascimento = new JTextField();
		txtFieldNascimento.setBounds(105, 130, 145, 20);
		frameAtualizarFuncionario.getContentPane().add(txtFieldNascimento);
		txtFieldNascimento.setColumns(10);

		btnAtualizarNascimento = new JButton("Atualizar");
		btnAtualizarNascimento.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				operacoesAtualizacao.atualizaNascimentoFuncionario(getId(), getNascimento());
			}
		});
		btnAtualizarNascimento.setBounds(260, 130, 100, 20);
		frameAtualizarFuncionario.getContentPane().add(btnAtualizarNascimento);
		
		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setBounds(30, 170, 140, 20);
		frameAtualizarFuncionario.getContentPane().add(lblCpf);
		
		txtFieldCpf = new JTextField();
		txtFieldCpf.setBounds(60, 170, 190, 20);
		frameAtualizarFuncionario.getContentPane().add(txtFieldCpf);
		txtFieldCpf.setColumns(10);

		btnAtualizarCpf = new JButton("Atualizar");
		btnAtualizarCpf.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				operacoesAtualizacao.atualizaCpfFuncionario(getId(), getCpf());
			}
		});
		btnAtualizarCpf.setBounds(260, 170, 100, 20);
		frameAtualizarFuncionario.getContentPane().add(btnAtualizarCpf);
		
		JLabel lblCargo = new JLabel("Cargo:");
		lblCargo.setBounds(30, 210, 140, 20);
		frameAtualizarFuncionario.getContentPane().add(lblCargo);
		
		txtFieldCargo = new JTextField();
		txtFieldCargo.setBounds(70, 210, 180, 20);
		frameAtualizarFuncionario.getContentPane().add(txtFieldCargo);
		txtFieldCargo.setColumns(10);
		
		btnAtualizarCargo = new JButton("Atualizar");
		btnAtualizarCargo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				operacoesAtualizacao.atualizaCargoFuncionario(getId(), getCargo());
			}
		});
		btnAtualizarCargo.setBounds(260, 210, 100, 20);
		frameAtualizarFuncionario.getContentPane().add(btnAtualizarCargo);

		JLabel lblStatus = new JLabel("Status:");
		lblStatus.setBounds(30, 250, 140, 20);
		frameAtualizarFuncionario.getContentPane().add(lblStatus);

		buttonGroup = new ButtonGroup();

		radioBtnStatusDisponivel = new JRadioButton("Disponível", true);
		radioBtnStatusDisponivel.setBounds(70, 250, 90, 20);
		buttonGroup.add(radioBtnStatusDisponivel);
		frameAtualizarFuncionario.getContentPane().add(radioBtnStatusDisponivel);

		radioButtonIndisponivel = new JRadioButton("Indiponível");
		radioButtonIndisponivel.setBounds(160, 250, 90, 20);
		buttonGroup.add(radioButtonIndisponivel);
		frameAtualizarFuncionario.getContentPane().add(radioButtonIndisponivel);

		btnAtualizaStatus = new JButton("Atualizar");
		btnAtualizaStatus.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				operacoesAtualizacao.atualizaStatusFuncionario(getId(), getStatus());
			}
		});
		btnAtualizaStatus.setBounds(260, 250, 100, 20);
		frameAtualizarFuncionario.getContentPane().add(btnAtualizaStatus);
	}
}
