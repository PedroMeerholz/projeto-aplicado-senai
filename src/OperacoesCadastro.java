import java.sql.Date;

public class OperacoesCadastro {

    public void cadastroFuncionario(String nome, Date nascimento, String cpf, String cargo) {
        CRUDFuncionario crudFuncionario = new CRUDFuncionario();
        Funcionario funcionario = new Funcionario(nome, nascimento, cpf, cargo, true);
        crudFuncionario.create(funcionario);
    }
    
    public void cadastroVeiculo(String modelo, String placa, String ano, double autonomia) {
        CRUDVeiculo crudVeiculo = new CRUDVeiculo();
        Veiculo veiculo = new Veiculo(modelo, placa, ano, autonomia, true);
        crudVeiculo.create(veiculo);
    }
    
    public void cadastroChamado(int idFuncionario, int idVeiculo) {
        CRUDChamado crudChamado = new CRUDChamado();
        Chamado chamado = new Chamado(idFuncionario, idVeiculo);
        crudChamado.create(chamado);
    }
}