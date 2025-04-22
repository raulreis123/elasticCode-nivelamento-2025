package elasticcode.solutis.entity.funcionario;

import elasticcode.solutis.entity.comissao.Comissao;

public abstract class Funcionario {
    protected String nome;
    protected String codFuncional;
    protected Double salarioBase = 1000.0;
    protected Comissao comissao;

    public Funcionario(String nome, String codFuncional, Comissao comissao) {
        this.nome = nome;
        this.codFuncional = codFuncional;
        this.comissao = comissao;
    }

    public abstract Double calcularRendaTotal();
}
