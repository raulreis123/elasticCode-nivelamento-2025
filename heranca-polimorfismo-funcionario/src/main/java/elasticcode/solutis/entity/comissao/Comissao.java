package elasticcode.solutis.entity.comissao;

public abstract class Comissao {
    protected Double comissao;

    public Comissao(){
        this.comissao = setarComissao();
    }

    public abstract Double setarComissao();
    public abstract double getComissao();
    public abstract String toString();
}
