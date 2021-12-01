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

import operacoes.OperacoesExclusao;

public class Exclusao extends JFrame {
    private JTextField txtFieldId;
    private ButtonGroup buttonGroup;
	private JRadioButton radioBtnFuncionario;
    private JRadioButton radioBtnVeiculo;
    private JRadioButton radioBtnChamado;
    private JButton button;
    private OperacoesExclusao operacoesExclusao = new OperacoesExclusao();

    public Exclusao() {
        super("Exclusão");
        setSize(350, 300);
        setLayout(null);
        formulario();
        setVisible(true);
    }

    private int getId() {
		int id = Integer.parseInt(txtFieldId.getText());

		return id;
	}

    private void enviaInformacoes() {
        if(this.radioBtnFuncionario.isSelected()) {
            operacoesExclusao.excluiFuncionario(getId());
        } else if(this.radioBtnVeiculo.isSelected()) {
            operacoesExclusao.excluiVeiculo(getId());
        } else if(this.radioBtnChamado.isSelected()){
            operacoesExclusao.excluiChamado(getId());
        }
    }

    private void adicionarComponente(JComponent componente, int x, int y, int largura) {
        componente.setBounds(x, y, largura, 20);
        add(componente);
    }

    private void adicionarJLabel(JLabel label, String titulo, int x, int y, int largura) {
        label.setText(titulo);
        adicionarComponente(label, x, y, largura);
    }

    private void adicionarJRadio(ButtonGroup buttonGroup, JRadioButton radioButton, String titulo, int x, int y, int largura) {
        radioButton.setText(titulo);
        buttonGroup.add(radioButton);
        adicionarComponente(radioButton, x, y, largura);
    }

    private void adicionaBotao(JButton button, int x, int y, int largura, String tituloBotao) {
        button.setText(tituloBotao);
        adicionarComponente(button, x, y, largura);
    }

    private void formulario() {
        JLabel label;

        label = new JLabel();
        this.txtFieldId = new JTextField();
        adicionarJLabel(label, "ID:", 80, 60, 120);
        adicionarComponente(this.txtFieldId, 100, 60, 120);

        label = new JLabel();
        adicionarJLabel(label, "Item:", 80, 120, 120);

        this.buttonGroup = new ButtonGroup();
        this.radioBtnFuncionario = new JRadioButton();
        this.radioBtnVeiculo = new JRadioButton();
        this.radioBtnChamado = new JRadioButton();
        adicionarJRadio(this.buttonGroup, this.radioBtnFuncionario, "Funcionário", 130, 100, 120);
        adicionarJRadio(this.buttonGroup, this.radioBtnVeiculo, "Veículo", 130, 120, 120);
        adicionarJRadio(this.buttonGroup, this.radioBtnChamado, "Chamado", 130, 140, 120);

        this.button = new JButton();
        this.button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                enviaInformacoes();
            }
        });
        adicionaBotao(this.button, 80, 180, 140, "Excluir");
    }
}
