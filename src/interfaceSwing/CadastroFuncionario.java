package interfaceSwing;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import operacoes.OperacoesCadastro;
import operacoes.GeraID;

import java.sql.Date;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CadastroFuncionario extends JFrame {
    private OperacoesCadastro operacoesCadastro = new OperacoesCadastro();
    private GeraID geraID = new GeraID();
    private String id;
    private JTextField txtFieldNome;
	private JTextField txtFieldNascimento;
	private JTextField txtFieldCpf;
	private JTextField txtFieldCargo;
    private JButton btnCadastrar;

    
    public CadastroFuncionario() {
        super("Home");
        setSize(700, 500);
        
        setIdApresentacao();
        criaFormulario();
        
        setVisible(true);
    }

    private void setIdApresentacao() {
        this.id = String.valueOf(geraID.atualizaIDFuncionario() + 1);
    }

    private String getIdApresentacao() {
        return this.id;
    }
    
    private String getNome() {
        String nome = txtFieldNome.getText();

		return nome;
	}
	
	private Date getNascimento() {
		String nascimento = txtFieldNascimento.getText();

		Date dataNascimento = Date.valueOf(nascimento);
		
		return dataNascimento;
	}
	
	private String getCpf() {
		String cpf = txtFieldCpf.getText();
		
		return cpf;
	}
	
	private String getCargo() {
		String cargo = txtFieldCargo.getText();
		
		return cargo;
	}
    
    private void adicionarComponente(JComponent componente, int x, int y, int largura) {
        add(componente);
        componente.setBounds(x, y, largura, 20);
    }

    private void enviaInformaçoesParaCadastro(String nome, Date nascimento, String cpf, String cargo) {
		operacoesCadastro.cadastroFuncionario(nome, nascimento, cpf, cargo);
	}
   
    private void criaFormulario() {
        setLayout(null);
        
        JLabel label;
        
        label = new JLabel("Cadastrar Funcionário");
        adicionarComponente(label, 300, 15, 140);

        label = new JLabel("ID: " + getIdApresentacao());
        adicionarComponente(label, 30, 50, 140);

        label = new JLabel("Nome:");
        txtFieldNome = new JTextField();
        adicionarComponente(label, 30, 90, 140);
        adicionarComponente(txtFieldNome, 70, 90, 180);

        label = new JLabel("Nascimento:");
        txtFieldNascimento = new JTextField();
        adicionarComponente(label, 30, 130, 140);
        adicionarComponente(txtFieldNascimento, 105, 130, 145);

        label = new JLabel("CPF:");
        txtFieldCpf = new JTextField();
        adicionarComponente(label, 30, 170, 140);
        adicionarComponente(txtFieldCpf, 60, 170, 190);

        label = new JLabel("Cargo:");
        txtFieldCargo = new JTextField();
        adicionarComponente(label, 30, 210, 140);
        adicionarComponente(txtFieldCargo, 70, 210, 180);

        btnCadastrar = new JButton("Cadastrar");
        btnCadastrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                enviaInformaçoesParaCadastro(getNome(), getNascimento(), getCpf(), getCargo());
            }
        });
        adicionarComponente(btnCadastrar, 30, 250, 220);
    }
}
