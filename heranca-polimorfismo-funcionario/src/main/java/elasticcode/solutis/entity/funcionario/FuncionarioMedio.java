package elasticcode.solutis.entity.funcionario;

import elasticcode.solutis.entity.comissao.Comissao;

public class FuncionarioMedio extends FuncionarioBase{
    protected String escolaMedio;

    public FuncionarioMedio(String nome, String codFuncional, Comissao comissao, String escolaBasico, String escolaMedio){
        super(nome, codFuncional, comissao,escolaBasico);
        this.escolaMedio = escolaMedio;
    }

    @Override
    public Double calcularRendaTotal(){
        double salario = super.calcularRendaTotal();
        return salario * 1.5 + comissao.getComissao();
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("FuncionarioMedio{");
        sb.append("escolaMedio='").append(escolaMedio).append('\'');
        sb.append(", escolaFundamental='").append(escolaFundamental).append('\'');
        sb.append(", nome='").append(nome).append('\'');
        sb.append(", codFuncional='").append(codFuncional).append('\'');
        sb.append(", salarioBase=").append(salarioBase);
        sb.append(", comissao=").append(comissao.toString());
        sb.append(", salario total=").append(calcularRendaTotal());
        sb.append('}');
        return sb.toString();
    }
}
