public class OperacoesCadastro {

    private CRUDFuncionario crudFuncionario = new CRUDFuncionario();
    private Funcionario funcionario;

    
    public void cadastroFuncionario(String nome, String nascimento, String cpf, String cargo) {
        this.funcionario = new Funcionario(nome, nascimento, cpf, cargo, true);
        crudFuncionario.create(funcionario);
    }
}