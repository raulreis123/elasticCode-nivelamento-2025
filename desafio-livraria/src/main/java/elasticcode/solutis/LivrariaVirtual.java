package elasticcode.solutis;

import elasticcode.solutis.entity.Eletronico;
import elasticcode.solutis.entity.Impresso;
import elasticcode.solutis.entity.Livro;
import elasticcode.solutis.entity.Venda;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LivrariaVirtual {

    private final Integer MAX_IMPRESSOS = 100;
    private final Integer MAX_ELETRONICOS = 100;
    private final Integer MAX_VENDAS = 100;

    // LISTA DE LIVROS
    private List<Impresso> impressos = new ArrayList<>();
    private List<Eletronico> eletronicos = new ArrayList<>();
    private List<Venda> vendas = new ArrayList<>();

    // NUMERO DE LIVROS
    private Integer numImpressos = 0;
    private Integer numEletronicos = 0;
    private Integer numVendas = 0;

    public static Scanner lt = new Scanner(System.in);

    public static void main(String[] args) {
        LivrariaVirtual loja = new LivrariaVirtual();

        int option;

        do {
            String menu = """
                \n
                Digite uma opção:
                    1 - Cadastrar livro
                    2 - Realizar uma venda
                    3 - Lista livros
                    4 - Listar vendas
                    5 - sair do programa
                """;

            System.out.println(menu);
            option = lt.nextInt();

            switch (option){
                case 1:
                    loja.cadastrarLivro();
                    break;
                case 2:
                    loja.realizarVenda();
                    break;
                case 3:
                    loja.listarLivros();
                    break;
                case 4:
                    loja.listarVendas();
                    break;
                case 5:
                    System.out.println("Até mais!");
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        } while (option != 5);

    }


    public void cadastrarLivro(){
        boolean valido = false;

        // SETANDO ATRIBUTOS DO LIVRO
        lt.nextLine();
        System.out.print("Escreva o titulo do livro: ");
        String titulo = lt.nextLine();

        System.out.print("Escreva o autor do livro: ");
        String autor = lt.nextLine();

        System.out.print("Escreva a editora do livro: ");
        String editora = lt.nextLine();

        System.out.print("Escreva o preço do livro: ");
        Float preco = lt.nextFloat();

        System.out.print("\n1 Impresso --- 2 Eletrônico --- 3 ambos: ");
        int tipo = lt.nextInt();

        if((tipo == 1 || tipo == 3) && impressos.size() < MAX_IMPRESSOS) {
            System.out.println("Cadastrando livro impresso: ");

            System.out.println("Valor do frete: ");
            Float frete = lt.nextFloat();

            System.out.println("Quantidade no estoque: ");
            Integer qtdEstoque = lt.nextInt();

            Impresso impresso = new Impresso(titulo, autor, editora, preco, frete, qtdEstoque);
            impressos.add(impresso);
            valido = true;
        }

        if((tipo == 2 || tipo == 3) && eletronicos.size() < MAX_ELETRONICOS){
            System.out.println("Cadastrando livro virtual: ");

            System.out.println("Tamanho do livro: ");
            Integer tmLivro = lt.nextInt();

            Eletronico eletronico = new Eletronico(titulo, autor, editora, preco, tmLivro);
            eletronicos.add(eletronico);
            valido = true;

        }

        if(!valido){
            System.out.println("Opção inválida!!!");
        }
    }

    public void realizarVenda(){
        lt.nextLine();
        System.out.print("Escreva o nome do cliente: ");
        String nomeCliente = lt.nextLine();

        System.out.println("Insira a quantidade de livros para venda: ");
        int qtdLivro = lt.nextInt();
        lt.nextLine();

        Venda venda = new Venda(nomeCliente, qtdLivro);

        int i = 0;

        while(i < qtdLivro){
            System.out.println("\nTipo de livro: \n 1 impresso --- 2 eletronico");
            int tipo = lt.nextInt();
            int indexLivro;
            int indexVenda;

            if(tipo == 1){
                listarLivrosImpressos();

                System.out.println("\n Digite o índice do livro desejado: ");
                indexLivro = lt.nextInt();
                System.out.println("\n Digite o índice onde deseja inserir o livro: ");
                indexVenda = lt.nextInt();

                venda.addLivro(impressos.get(indexLivro), indexVenda);
                i++;

            } else if(tipo == 2) {
                listarLivrosEletronicos();

                System.out.println("\n Digite o índice do livro desejado: ");
                indexLivro = lt.nextInt();
                System.out.println("\n Digite o índice onde deseja inserir o livro: ");
                indexVenda = lt.nextInt();

                venda.addLivro(eletronicos.get(indexLivro), indexVenda);
                i++;

            } else System.out.println("Opção inválida!");
        }
        vendas.add(venda);
        this.numVendas++;
    }

    public void listarLivrosImpressos(){
        if(impressos.isEmpty()){
            System.out.println("Nenhum livro impresso cadastrado!");
        } else{
            StringBuilder tblIMpressos = new StringBuilder("""
                Índice de livros impressos:
                """);

            int cont = 0;

            for (Impresso impresso : impressos) {
                tblIMpressos.append("\n%d - %s".formatted(cont++, impresso.toString()));
            }

            System.out.println(tblIMpressos);
        }
    }

    public void listarLivrosEletronicos(){
        if (eletronicos.isEmpty()){
            System.out.println("Nenhum livro eletrônico cadastrado!");
        } else{
            StringBuilder tblEletronicos = new StringBuilder("""
                Índice de livros eletrônicos:
                """);

            int cont = 0;

            for (Eletronico eletronico : eletronicos) {
                tblEletronicos.append("\n%d - %s".formatted(cont++, eletronico.toString()));
            }

            System.out.println(tblEletronicos);
        }
    }

    public void listarLivros(){
        System.out.println("\n - Índice de todos os livros");

        listarLivrosImpressos();
        listarLivrosEletronicos();

    }

    public void livros(){

    }

    public void listarVendas(){
        for (Venda venda : vendas){
            System.out.println(venda.toString());
        }
    }
}