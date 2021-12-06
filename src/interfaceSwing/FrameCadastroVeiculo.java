package interfaceSwing;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import operacoes.OperacoesCadastro;
import operacoes.GeraID;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrameCadastroVeiculo extends JFrame {
    private OperacoesCadastro operacoesCadastro = new OperacoesCadastro();
    private GeraID geraID = new GeraID();
    private String id;
    private JTextField txtFieldModelo;
	private JTextField txtFieldPlaca;
	private JTextField txtFieldAno;
	private JTextField txtFieldAutonomia;
    private JButton btnCadastrar;

    public FrameCadastroVeiculo() {
        super("Cadastrar Veículo");
        setSize(400, 400);

        setIdApresentacao();
        criaFormulario();

        setVisible(true);
    }

    private void setIdApresentacao() {
        this.id = String.valueOf(geraID.atualizaIDVeiculo() + 1);
    }

    private String getIdApresentacao() {
        return this.id;
    }

    private String getModelo() {
		String modelo = txtFieldModelo.getText();

		return modelo;
	}

	private String getPlaca() {
		String placa = txtFieldPlaca.getText();

		return placa;
	}

	private String getAno() {
		String ano = txtFieldAno.getText();

		return ano;
	}

	private double getAutonomia() {
		double autonomia = Double.parseDouble(txtFieldAutonomia.getText());

		return autonomia;
	}

    private void adicionarComponente(JComponent componente, int x, int y, int largura) {
        componente.setBounds(x, y, largura, 20);
        add(componente);
    }

    private void criaFormulario() {
        setLayout(null);

        JLabel label;

        label = new JLabel("ID: " + getIdApresentacao());
        adicionarComponente(label, 80, 50, 140);

        label = new JLabel("Modelo:");
        txtFieldModelo = new JTextField();
        adicionarComponente(label, 80, 90, 140);
        adicionarComponente(txtFieldModelo, 130, 90, 140);

        label = new JLabel("Placa:");
        txtFieldPlaca = new JTextField();
        adicionarComponente(label, 80, 130, 140);
        adicionarComponente(txtFieldPlaca, 120, 130, 150);

        label = new JLabel("Ano:");
        txtFieldAno = new JTextField();
        adicionarComponente(label, 80, 170, 140);
        adicionarComponente(txtFieldAno, 110, 170, 160);

        label = new JLabel("Autonomia:");
        txtFieldAutonomia = new JTextField();
        adicionarComponente(label, 80, 210, 140);
        adicionarComponente(txtFieldAutonomia, 150, 210, 120);

        btnCadastrar = new JButton("Cadastrar");
        btnCadastrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                operacoesCadastro.cadastroVeiculo(getModelo(), getPlaca(), getAno(), getAutonomia());
            }
        });
        adicionarComponente(btnCadastrar, 80, 250, 190);
    }
}
