package classes;

import java.sql.Date;
import java.time.LocalDate;

import operacoes.GeraID;

public class Chamado {
    //Atributos
    private int IDChamado;
    private Date dataChamado;
    private int idFuncionarioAlocado;
    private int idVeiculoAlocado;
    private double distancia;
    private boolean status;

    public Chamado(int idFuncionarioAlocado, int idVeiculoAlocado) {
        setIDChamado();
        setDataChamado();
        setIdFuncionarioAlocado(idFuncionarioAlocado);
        setIdVeiculoAlocado(idVeiculoAlocado);
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

    public void setIdFuncionarioAlocado(int idFuncionarioAlocado) {
        this.idFuncionarioAlocado = idFuncionarioAlocado;
    }

    public int getIdFuncionarioAlocado() {
        return this.idFuncionarioAlocado;
    }

    public void setIdVeiculoAlocado(int id) {
        this.idVeiculoAlocado = id;
    }

    public int getIdVeiculoAlocado() {
        return this.idVeiculoAlocado;
    }

    public void setDistancia(double distancia){
        this.distancia = distancia;
    }

    public double getDistancia(){
        return this.distancia;
    }

}
