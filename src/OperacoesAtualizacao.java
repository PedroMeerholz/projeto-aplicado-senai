import java.sql.Date;

public class OperacoesAtualizacao {
    Funcionario funcionario;
    CRUDFuncionario crudFuncionario = new CRUDFuncionario();

    public void atualizaNomeFuncionario(int id, String nome) {
        crudFuncionario.updateNome(id, nome);
    }

    public void atualizaNascimentoFuncionario(int id, Date nascimento) {
        crudFuncionario.updateNascimento(id, nascimento);
    }

    public void atualizaCpfFuncionario(int id, String cpf) {
        crudFuncionario.updateCpf(id, cpf);
    }

    public void atualizaCargoFuncionario(int id, String cargo) {
        crudFuncionario.updateCargo(id, cargo);
    }

    public void atualizaStatusFuncionario(int id, boolean status) {
        crudFuncionario.updateStatus(id, status);
    }
}
