package elasticcode.solutis.entity.funcionario;

import elasticcode.solutis.entity.comissao.Comissao;

public class FuncionarioSuperior extends FuncionarioMedio{
    protected String universidade;

    public FuncionarioSuperior(String nome, String codFuncional, Comissao comissao, String escolaFundamental, String escolaMedio, String universidade){
        super(nome, codFuncional, comissao,escolaFundamental, escolaMedio);
        this.universidade = universidade;
    }

    @Override
    public Double calcularRendaTotal(){
        double salario = super.calcularRendaTotal();
        return salario + salario + comissao.getComissao();
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("FuncionarioSuperior{");
        sb.append("universidade='").append(universidade).append('\'');
        sb.append(", escolaMedio='").append(escolaMedio).append('\'');
        sb.append(", escolaFundamental='").append(escolaFundamental).append('\'');
        sb.append(", nome='").append(nome).append('\'');
        sb.append(", codFuncional='").append(codFuncional).append('\'');
        sb.append(", salarioBase=").append(salarioBase);
        sb.append(", comissao=").append(comissao);
        sb.append(", salario total=").append(calcularRendaTotal());
        sb.append('}');
        return sb.toString();
    }
}
