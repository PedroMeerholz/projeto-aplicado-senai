package interfaceSwing;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import operacoes.OperacoesAtualizacao;

public class FrameAtualizaChamado extends JFrame {
    private JTextField txtFieldId;
	private JTextField txtFieldDistancia;
    private JButton button;
    private OperacoesAtualizacao operacoesAtualizacao = new OperacoesAtualizacao();

    public FrameAtualizaChamado() {
        super("Modificar Chamado");
        setSize(400, 350);
        setLayout(null);
        criaFormulario();
        setVisible(true);
    }

    private int getId() {
		int id = Integer.parseInt(txtFieldId.getText());

		return id;
	}

    private float getDistancia() {
        float distancia = Float.parseFloat(txtFieldDistancia.getText());

        return distancia;
    }

    private void adicionarComponente(JComponent componente, int x, int y, int largura) {
        componente.setBounds(x, y, largura, 20);
        add(componente);
    }

    private void adicionaBotao(JButton button, int x, int y, int largura, String tituloBotao) {
        button.setText(tituloBotao);
        adicionarComponente(button, x, y, largura);
    }

    private void criaFormulario() {
        JLabel label;

        label = new JLabel("ID:");
        this.txtFieldId = new JTextField();
        adicionarComponente(label, 120, 60, 140);
        adicionarComponente(this.txtFieldId, 140, 60, 120);

        label = new JLabel("Status: Concluído");
        adicionarComponente(label, 120, 100, 140);

        label = new JLabel("Distância:");
        this.txtFieldDistancia = new JTextField();
        adicionarComponente(label, 120, 140, 120);
        adicionarComponente(this.txtFieldDistancia, 180, 140, 80);

        this.button = new JButton();
        this.button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                operacoesAtualizacao.atualizaStatusChamado(getId(), false);
                operacoesAtualizacao.atualizaDistanciaChamado(getId(), getDistancia());
            }
        });
        adicionaBotao(this.button, 120, 200, 140, "Modificar");
    }
}