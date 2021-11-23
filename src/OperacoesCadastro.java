public class OperacoesCadastro {

    private CRUDFuncionario crudFuncionario = new CRUDFuncionario();
    private CRUDVeiculo crudVeiculo = new CRUDVeiculo();
    private Funcionario funcionario;
    private Veiculo veiculo;
    
    public void cadastroFuncionario(String nome, String nascimento, String cpf, String cargo) {
        this.funcionario = new Funcionario(nome, nascimento, cpf, cargo, true);
        crudFuncionario.create(funcionario);
    }

    public void cadastroVeiculo(String modelo, String placa, String ano, double autonomia) {
        this.veiculo = new Veiculo(modelo, placa, ano, autonomia, true);
        crudVeiculo.create(veiculo);
    }
}