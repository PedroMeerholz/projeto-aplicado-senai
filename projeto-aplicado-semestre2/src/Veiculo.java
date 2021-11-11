public class Veiculo {
    //Atributos
    private int IDVeiculo;
    private String modeloVeiculo;
    private String placaVeiculo;
    private String anoVeiculo;
    private double autonomia;
    private boolean status;

    //Métodos
    public int getIDVeiculo(){
        return this.IDVeiculo;
    }

    public void setModeloVeiculo(String modeloVeiculo){
        this.modeloVeiculo = modeloVeiculo;
    }

    public String getModeloVeiculo(){
        return this.modeloVeiculo;
    }

    public void setPlacaVeiculo(String placaVeiculo){
        this.placaVeiculo = placaVeiculo;
    }

    public String getPlacaVeiculo(){
        return this.placaVeiculo;
    }

    public void setAnoVeiculo(String anoVeiculo){
        this.anoVeiculo = anoVeiculo;
    }

    public String getAnoVeiculo(){
        return this.anoVeiculo;
    }

    public void setAutonomia(double autonomia){
        this.autonomia = autonomia;
    }

    public double getAutonomia(){
        return this.autonomia;
    }

    public void setStatus(boolean status){
        this.status = status;
    }

    public boolean getStatus(){
        return this.status;
    }
}
