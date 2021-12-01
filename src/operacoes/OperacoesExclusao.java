package operacoes;

import crud.CRUDChamado;
import crud.CRUDFuncionario;
import crud.CRUDVeiculo;

public class OperacoesExclusao {
    private CRUDFuncionario crudFuncionario = new CRUDFuncionario();
    private CRUDVeiculo crudVeiculo = new CRUDVeiculo();
    private CRUDChamado crudChamado = new CRUDChamado();

    public void excluiFuncionario(int id) {
        crudFuncionario.delete(id);
    }

    public void excluiVeiculo(int id) {
        crudVeiculo.delete(id);
    }

    public void excluiChamado(int id) {
        crudChamado.delete(id);
    }
}
