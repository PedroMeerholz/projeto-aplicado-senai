package operacoes;
import java.sql.Date;

import crud.*;
import classes.*;

public class OperacoesCadastro {
    private CRUDFuncionario crudFuncionario = new CRUDFuncionario();
    private CRUDVeiculo crudVeiculo = new CRUDVeiculo();
    private CRUDChamado crudChamado = new CRUDChamado();

    public void cadastroFuncionario(String nome, Date nascimento, String cpf, String cargo) {
        Funcionario funcionario = new Funcionario(nome, nascimento, cpf, cargo, true);
        crudFuncionario.create(funcionario);
    }
    
    public void cadastroVeiculo(String modelo, String placa, String ano, double autonomia) {
        Veiculo veiculo = new Veiculo(modelo, placa, ano, autonomia, true);
        crudVeiculo.create(veiculo);
    }
    
    public void cadastroChamado(int idFuncionario, int idVeiculo) {
        Chamado chamado = new Chamado(idFuncionario, idVeiculo);
        crudChamado.create(chamado);
        crudVeiculo.updateStatus(chamado.getIdVeiculoAlocado(), false);
        crudFuncionario.updateStatus(chamado.getIdFuncionarioAlocado(), false);
    }
}