package interfaceSwing;

import javax.swing.JFrame;

import java.awt.GridLayout;

public class TelaPrincipal extends JFrame {    
    public TelaPrincipal() {
        super();
        setTitle("Projeto Aplicado - 2° Semestre");
        setSize(1200, 900);
        setLayout(new GridLayout(2, 2));
        tela();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void tela() {
        PainelFuncionario painelFuncionario = new PainelFuncionario();
        add(painelFuncionario);

        PainelVeiculo painelVeiculo = new PainelVeiculo();
        add(painelVeiculo);

        PainelChamado painelChamado = new PainelChamado();
        add(painelChamado);

        PainelCarbono painelCarbono = new PainelCarbono();
        add(painelCarbono);
    }
}
