import java.sql.Date;

public class Funcionario{
    //Atributos
    private int IDFuncionario;
    private String nomeFuncionario;
    private Date nascimento;
    private String cpf;
    private String cargo;
    private boolean status;

    //Construtor
    public Funcionario(String nome, Date nascimento, String cpf, String cargo, boolean status){
        setIDFuncionario();
        setNomeFuncionario(nome);
        setNascimento(nascimento);
        setCPF(cpf);
        setCargo(cargo);
        setStatus(status);
    }

    //Métodos
    public void setIDFuncionario() {
        GeraID geraID = new GeraID();
        int id = geraID.incrementaIdFuncionario();
        this.IDFuncionario = id;
    }

    public int getIDFuncionario(){
        return this.IDFuncionario;
    }

    public void setNomeFuncionario(String nome){
        this.nomeFuncionario = nome;
    }

    public String getNomeFuncionario(){
        return this.nomeFuncionario;
    }

    public void setNascimento(Date nascimento){
        this.nascimento = nascimento;
    }

    public Date getNascimento(){
        return this.nascimento;
    }

    public void setCPF(String cpf){
        this.cpf = cpf;
    }

    public String getCPF(){
        return this.cpf;
    }

    public void setCargo(String cargo){
        this.cargo = cargo;
    }

    public String getCargo(){
        return this.cargo;
    }

    public void setStatus(boolean status){
        this.status = status;
    }

    public boolean getStatus(){
        return this.status;
    }
}