package elasticcode.solutis.entity.funcionario;

import elasticcode.solutis.entity.comissao.Comissao;

public class FuncionarioSemEnsino extends Funcionario {
    public FuncionarioSemEnsino(String nome, String codFuncional, Comissao comissao){
        super(nome, codFuncional, comissao);
    }

    @Override
    public Double calcularRendaTotal(){
        return salarioBase;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("FuncionarioSemEnsino{");
        sb.append("nome='").append(nome).append('\'');
        sb.append(", codFuncional='").append(codFuncional).append('\'');
        sb.append(", salarioBase=").append(salarioBase);
        sb.append(", comissao=").append(comissao.toString());
        sb.append(", salario total=").append(calcularRendaTotal());
        sb.append('}');
        return sb.toString();
    }
}
