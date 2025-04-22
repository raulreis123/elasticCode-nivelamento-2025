package elasticcode.solutis;

import elasticcode.solutis.entity.comissao.ComissaoGerente;
import elasticcode.solutis.entity.comissao.ComissaoSupervisor;
import elasticcode.solutis.entity.comissao.ComissaoVendedor;
import elasticcode.solutis.entity.funcionario.Funcionario;
import elasticcode.solutis.entity.funcionario.FuncionarioBase;
import elasticcode.solutis.entity.funcionario.FuncionarioMedio;
import elasticcode.solutis.entity.funcionario.FuncionarioSuperior;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Funcionario[] funcionarios =  new Funcionario[10];

        // FUNCIONARIOS BASE
        funcionarios[0] = new FuncionarioBase("Cleber", "001", new ComissaoVendedor(), "EscolaBasica");
        funcionarios[1] = new FuncionarioBase("Joao", "002", new ComissaoVendedor(), "EscolaBasica");
        funcionarios[2] = new FuncionarioBase("Gabriel", "003", new ComissaoVendedor(), "EscolaBasica");
        funcionarios[3] = new FuncionarioBase("Pedro", "004", new ComissaoVendedor(), "EscolaBasica");
        // FUNCIONARIOS MÉDIOS
        funcionarios[4] = new FuncionarioMedio("Fernando", "005", new ComissaoVendedor(), "EscolaBasica", "EscolaMedia");
        funcionarios[5] = new FuncionarioMedio("Maria", "006", new ComissaoVendedor(), "EscolaBasica", "EscolaMedia");
        funcionarios[6] = new FuncionarioMedio("Ronaldo", "007", new ComissaoVendedor(), "EscolaBasica", "EscolaMedia");
        funcionarios[7] = new FuncionarioMedio("Gustavo", "008", new ComissaoSupervisor(), "EscolaBasica", "EscolaMedia");
        // FUNCIONARIOS SUPERIOR
        funcionarios[8] = new FuncionarioSuperior("Marcelo", "009", new ComissaoSupervisor(),"EscolaBasica", "EscolaMedia", "Univerdade");
        funcionarios[9] = new FuncionarioSuperior("Renata", "010", new ComissaoGerente(),"EscolaBasica", "EscolaMedia", "Univerdade");

        // SALÁRIO TOTAL E POR SETOR
        double totalSalarios = 0.0;
        double salarioFunSup = 0.0;
        double salarioFunMed = 0.0;
        double salarioFunBase = 0.0;

        // CÁLCULO DE SALÁRIO POR SETOR E TOTAL
        for(Funcionario f : funcionarios){
            totalSalarios += f.calcularRendaTotal();

            if(f instanceof FuncionarioSuperior){
                salarioFunSup += f.calcularRendaTotal();
            } else if (f instanceof FuncionarioMedio) {
                salarioFunMed += f.calcularRendaTotal();
            } else if(f instanceof FuncionarioBase){
                salarioFunBase += f.calcularRendaTotal();
            } else{
                System.out.println("Funcionário não encontrado!");
            }

            System.out.println("\nFuncionário: " + f);
        }

        String empresaTable = """
                MODO CONSOLE:
                Salário total: %.2f
                Total salário de funcionários com ensino básico: %.2f
                Total salário de funcionários com ensino médio: %.2f
                Total salário de funcionários graduados: %.2f
                """.formatted(totalSalarios, salarioFunBase, salarioFunMed, salarioFunSup);

        System.out.println(empresaTable);
    }
}