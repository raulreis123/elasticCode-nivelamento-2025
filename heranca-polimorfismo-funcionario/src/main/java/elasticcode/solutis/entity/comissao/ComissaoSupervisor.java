package elasticcode.solutis.entity.comissao;

public class ComissaoSupervisor extends Comissao{
    @Override
    public Double setarComissao(){
        return 600.0;
    }

    @Override
    public double getComissao(){
        return comissao;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ComissaoGerente{");
        sb.append("comissao=").append(comissao);
        sb.append('}');
        return sb.toString();
    }
}
