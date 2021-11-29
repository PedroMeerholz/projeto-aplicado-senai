package operacoes;
import java.sql.Date;

import crud.CRUDFuncionario;
import crud.CRUDVeiculo;

public class OperacoesAtualizacao {
    private CRUDFuncionario crudFuncionario = new CRUDFuncionario();
    private CRUDVeiculo crudVeiculo = new CRUDVeiculo();

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

    public void atualizaModeloVeiculo(int id, String modelo) {
        crudVeiculo.updateModelo(id, modelo);
    }

    public void atualizaPlacaVeiculo(int id, String placa) {
        crudVeiculo.updatePlaca(id, placa);
    }

    public void atualizaAnoVeiculo(int id, String ano) {
        crudVeiculo.updateAno(id, ano);
    }

    public void atualizaAutonomiaVeiculo(int id, float autonomia) {
        crudVeiculo.updateAutonomia(id, autonomia);
    }

    public void atualizaStatusVeiculo(int id, boolean status) {
        crudVeiculo.updateStatus(id, status);
    }
}
