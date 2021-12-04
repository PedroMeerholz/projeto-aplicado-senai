package interfaceSwing;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import crud.CRUDChamado;

public class PainelCarbono extends JPanel {
    private JLabel labelTotalCarbono;
    private JLabel labelMaiorEmissor;
    private JLabel labelMenorEmissor;
    private JButton button;
    private CRUDChamado crudChamado = new CRUDChamado();

    public PainelCarbono() {
        super();
        setLayout(null);
        informacoes();
    }

    public void adicionarJLabel(JLabel label, String titulo, int x, int y, int largura) {
        label.setText(titulo);
        label.setBounds(x, y, largura, 20);
        add(label);
    }

    public void adicionaBotao(JButton button, String tituloBotao, int x, int y, int largura) {
        button.setText(tituloBotao);
        button.setBounds(x, y, largura, 30);
        add(button);
    }

    public void informacoes() {
        this.labelTotalCarbono = new JLabel();
        adicionarJLabel(this.labelTotalCarbono, "Total de Carbono Emitido(Kg): " + crudChamado.getCarbonoEmitido(), 345, 240, 200);

        this.labelMaiorEmissor = new JLabel();
        adicionarJLabel(this.labelMaiorEmissor, "Veículo(ID) que Mais Emitiu Carbono: " + crudChamado.getMaiorEmissor(), 345, 280, 250);

        this.labelMenorEmissor = new JLabel();
        adicionarJLabel(this.labelMenorEmissor, "Veículo(ID) que Menos Emitiu Carbono: " + crudChamado.getMenorEmissor(), 345, 320, 250);
    
        this.button = new JButton();
        this.button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                labelTotalCarbono.setText("Total de Carbono Emitido: " + crudChamado.getCarbonoEmitido());
                labelMaiorEmissor.setText("Veículo(ID) que Mais Emitiu Carbono: " + crudChamado.getMaiorEmissor());
                labelMenorEmissor.setText("Veículo(ID) que Menos Emitiu Carbono: " + crudChamado.getMenorEmissor());
            }
        });
        adicionaBotao(this.button, "Atualiza Informações", 345, 360, 170);
    }
}
