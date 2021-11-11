public class Testes {
    public static void main(String[] args) {
        CRUDFuncionario crudFuncionario = new CRUDFuncionario();
        Funcionario funcionario = new Funcionario("Pedro", "2003-11-13", "12306632901", "Diretor", true);

        CRUDVeiculo crudVeiculo = new CRUDVeiculo();
        Veiculo veiculo = new Veiculo("Strada", "AAAAA", "2013", 8.1, true);

        CRUDChamado crudChamado = new CRUDChamado();
        Chamado chamado = new Chamado("2021-11-11", funcionario, veiculo, true);

        // System.out.println(crudFuncionario.create(funcionario));
        // System.out.println(funcionario.getIDFuncionario());

        // System.out.println(crudVeiculo.create(veiculo));
        // System.out.println(veiculo.getIDVeiculo());

        // System.out.println(crudChamado.create(chamado));
        // System.out.println(crudChamado.read());
    }
}
