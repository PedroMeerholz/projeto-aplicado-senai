import java.sql.Date;
import java.time.LocalDate;

public class Chamado {
    //Atributos
    private int IDChamado;
    private Date dataChamado;
    private Funcionario funcionarioAlocado;
    private Veiculo veiculoAlocado;
    private double distancia;
    private double carbonoEmitido;
    private boolean status;

    //Contrutor
    public Chamado(String dataChamado, Funcionario funcionarioAlocado, Veiculo veiculoAlocado, boolean status){
        setIDChamado();
        setDataChamado();
        setFuncionarioAlocado(funcionarioAlocado);
        setVeiculoAlocado(veiculoAlocado);
        setStatus(true);
    }

    // Métodos
    public void setIDChamado() {
        GeraID geraID = new GeraID();
        int id = geraID.incrementaIdChamado();

        this.IDChamado = id;
    }

    public int getIDChamado(){
        return this.IDChamado;
    }

    public void setStatus(boolean status){
        this.status = status;
    }

    public boolean getStatus(){
        return this.status;
    }

    public void setDataChamado(){
        LocalDate data = LocalDate.now();
        this.dataChamado = Date.valueOf(data);
    }

    public Date getDataChamado(){
        return this.dataChamado;
    }

    public void setFuncionarioAlocado(Funcionario funcionarioAlocado){
        this.funcionarioAlocado = funcionarioAlocado;
    }

    public Funcionario getFuncionario(){
        return this.funcionarioAlocado;
    }

    public void setVeiculoAlocado(Veiculo veiculoAlocado){
        this.veiculoAlocado = veiculoAlocado;
    }

    public Veiculo getVeiculoAlocado(){
        return this.veiculoAlocado;
    }

    public void setDistancia(double distancia){
        this.distancia = distancia;
    }

    public double getDistancia(){
        return this.distancia;
    }

    public void setCarbonoEmitido(double distancia, double autonomia){
        //Fórmula para calcular a emissão de carbono
            //CG * 0.73 * 0.75 * 3.7 = CO2(kg)
        //Consumo de Gasolina
           //Distância dividivo por autonomia

        double consumoGasolina = distancia / autonomia;
        double emissao = consumoGasolina * 0.73 * 0.75 * 3.7;
        this.carbonoEmitido = emissao;
    }

    public double getCarbonoEmitido(){
        return this.carbonoEmitido;
    }
}
