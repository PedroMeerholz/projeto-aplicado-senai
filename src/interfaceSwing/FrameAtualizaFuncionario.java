package interfaceSwing;

import java.awt.event.ActionListener;
import java.sql.Date;
import java.awt.event.ActionEvent;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import operacoes.OperacoesAtualizacao;

public class FrameAtualizaFuncionario extends JFrame {
    private JTextField txtFieldId;
    private JTextField txtFieldNome;
	private JTextField txtFieldNascimento;
	private JTextField txtFieldCpf;
	private JTextField txtFieldCargo;
    private ButtonGroup buttonGroup;
    private JRadioButton radioBtnStatusDisponivel;
	private JRadioButton radioBtnStatusIndisponivel;
    private JButton button;
    private OperacoesAtualizacao operacoesAtualizacao = new OperacoesAtualizacao();

    public FrameAtualizaFuncionario() {
        super("Modificar Funcionário");
        setSize(400, 350);
        setLayout(null);
        criaFormulario();
        setVisible(true);
    }

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

    private void adicionarComponente(JComponent componente, int x, int y, int largura) {
        componente.setBounds(x, y, largura, 20);
        add(componente);
    }

    private void adicionarJRadio(ButtonGroup buttonGroup, JRadioButton radioButton, int x, int y, int largura) {
        adicionarComponente(radioButton, x, y, largura);
        buttonGroup.add(radioButton);
    }

    private void adicionaBotao(JButton button, int x, int y, int largura, String tituloBotao) {
        button.setText(tituloBotao);
        adicionarComponente(button, x, y, largura);
    }

    private void criaFormulario() {
        JLabel label;

        label = new JLabel("ID:");
        this.txtFieldId = new JTextField();
        adicionarComponente(label, 80, 30, 140);
        adicionarComponente(this.txtFieldId, 100, 30, 140);

        label = new JLabel("Nome:");
        this.txtFieldNome = new JTextField();
        adicionarComponente(label, 80, 70, 120);
        adicionarComponente(this.txtFieldNome, 120, 70, 120);

        label = new JLabel("Nascimento:");
        this.txtFieldNascimento = new JTextField();
        adicionarComponente(label, 80, 110, 140);
        adicionarComponente(this.txtFieldNascimento, 155, 110, 85);

        label = new JLabel("Cpf:");
        this.txtFieldCpf = new JTextField();
        adicionarComponente(label, 80, 150, 140);
        adicionarComponente(this.txtFieldCpf, 110, 150, 130);

        label = new JLabel("Cargo:");
        this.txtFieldCargo = new JTextField();
        adicionarComponente(label, 80, 190, 140);
        adicionarComponente(this.txtFieldCargo, 120, 190, 120);

        label = new JLabel("Status:");
        adicionarComponente(label, 80, 240, 140);

        this.buttonGroup = new ButtonGroup();
        this.radioBtnStatusDisponivel = new JRadioButton("Disponível");
        this.radioBtnStatusIndisponivel = new JRadioButton("Indisponível");
        adicionarJRadio(this.buttonGroup, this.radioBtnStatusDisponivel, 130, 230, 120);
        adicionarJRadio(this.buttonGroup, this.radioBtnStatusIndisponivel, 130, 250, 120);

        this.button = new JButton();
        this.button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
				operacoesAtualizacao.atualizaNomeFuncionario(getId(), getNome());
                operacoesAtualizacao.atualizaNascimentoFuncionario(getId(), getNascimento());
                operacoesAtualizacao.atualizaCpfFuncionario(getId(), getCpf());
                operacoesAtualizacao.atualizaCargoFuncionario(getId(), getCargo());
                operacoesAtualizacao.atualizaStatusFuncionario(getId(), getStatus());
            }
        });
        adicionaBotao(this.button, 80, 290, 160, "Modificar");
    }
}
