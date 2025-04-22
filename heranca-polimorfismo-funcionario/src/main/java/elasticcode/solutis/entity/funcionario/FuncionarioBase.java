package elasticcode.solutis.entity.funcionario;

import elasticcode.solutis.entity.comissao.Comissao;

public class FuncionarioBase extends Funcionario{
    protected String escolaFundamental;

    public FuncionarioBase(String nome, String codFuncional, Comissao comissao, String escolaFundamental){
        super(nome, codFuncional, comissao);
        this.escolaFundamental = escolaFundamental;
    }

    @Override
    public Double calcularRendaTotal(){
        return salarioBase * 1.1 + comissao.getComissao();
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("FuncionarioBase{");
        sb.append("nome='").append(nome).append('\'');
        sb.append(", codFuncional='").append(codFuncional).append('\'');
        sb.append(", salarioBase=").append(salarioBase);
        sb.append(", comissao=").append(comissao.toString());
        sb.append(", salario total=").append(calcularRendaTotal());
        sb.append('}');
        return sb.toString();
    }
}
