package interfaceSwing;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import operacoes.OperacoesAtualizacao;

public class AtualizaVeiculo extends JFrame {
    private JTextField txtFieldId;
    private JTextField txtFieldModelo;
    private JTextField txtFieldPlaca;
    private JTextField txtFieldAno;
    private JTextField txtFieldAutonomia;
    private ButtonGroup buttonGroup;
    private JRadioButton radioBtnStatusDisponivel;
	private JRadioButton radioBtnStatusIndisponivel;
    private JButton button;
    private OperacoesAtualizacao operacoesAtualizacao = new OperacoesAtualizacao();

    public AtualizaVeiculo() {
        super("Modificar Funcionário");
        setSize(400, 350);
        setLayout(null);
        criaFormulario();
        setVisible(true);
    }

    private int getId() {
        int id = Integer.parseInt(txtFieldId.getText());

        return id;
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

    private float getAutonomia() {
        float autonomia = Float.parseFloat(txtFieldAutonomia.getText());

        return autonomia;
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
   
    private void adicionarJRadio(ButtonGroup buttonGroup, JRadioButton radioButton, String titulo, int x, int y, int largura) {
        radioButton.setText(titulo);
        adicionarComponente(radioButton, x, y, largura);
        buttonGroup.add(radioButton);
    }

    private void adicionaBotao(JButton button, int x, int y, int largura, String tituloBotao) {
        button.setText(tituloBotao);
        adicionarComponente(button, x, y, largura);
    }

    private void adicionarJLabel(JLabel label, String titulo, int x, int y, int largura) {
        label.setText(titulo);
        adicionarComponente(label, x, y, largura);
    }

    private void criaFormulario() {
        JLabel label;

        label = new JLabel();
        this.txtFieldId = new JTextField();
        adicionarJLabel(label, "ID:", 80, 30, 140);
        adicionarComponente(txtFieldId, 100, 30, 140);

        label = new JLabel();
        this.txtFieldModelo = new JTextField();
        adicionarJLabel(label, "Modelo:", 80, 70, 140);
        adicionarComponente(txtFieldModelo, 130, 70, 110);

        label = new JLabel();
        this.txtFieldPlaca = new JTextField();
        adicionarJLabel(label, "Placa:", 80, 110, 140);
        adicionarComponente(txtFieldPlaca, 120, 110, 120);

        label = new JLabel();
        this.txtFieldAno = new JTextField();
        adicionarJLabel(label, "Ano:", 80, 150, 140);
        adicionarComponente(txtFieldAno, 110, 150, 130);

        label = new JLabel();
        this.txtFieldAutonomia = new JTextField();
        adicionarJLabel(label, "Autonomia:", 80, 190, 140);
        adicionarComponente(this.txtFieldAutonomia, 150, 190, 90);

        label = new JLabel();
        adicionarJLabel(label, "Status", 80, 240, 80);

        this.buttonGroup = new ButtonGroup();
        this.radioBtnStatusDisponivel = new JRadioButton();
        this.radioBtnStatusIndisponivel = new JRadioButton();
        adicionarJRadio(buttonGroup, radioBtnStatusDisponivel, "Disponível", 130, 230, 120);
        adicionarJRadio(buttonGroup, radioBtnStatusIndisponivel, "Indiponível", 130, 250, 120);

        this.button = new JButton();
        this.button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                operacoesAtualizacao.atualizaModeloVeiculo(getId(), getModelo());
                operacoesAtualizacao.atualizaPlacaVeiculo(getId(), getPlaca());
                operacoesAtualizacao.atualizaAnoVeiculo(getId(), getAno());
                operacoesAtualizacao.atualizaAutonomiaVeiculo(getId(), getAutonomia());
                operacoesAtualizacao.atualizaStatusVeiculo(getId(), getStatus());
            }
        });
        adicionaBotao(this.button, 80, 290, 160, "Modificar");
    }

    public static void main(String[] args) {
        AtualizaVeiculo atualizaVeiculo = new AtualizaVeiculo();
    }
}
