package estoqueProdutoPreco;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class EstoqueProdutos {
    private Map<Long, Produto> estoqueProdutosMap;

    public EstoqueProdutos() {
        this.estoqueProdutosMap = new HashMap<>();
    }

    public void adicionarProduto (Long cod, String nome, int quantidade, double preco){
        estoqueProdutosMap.put(cod, new Produto(nome, preco, quantidade));
    }

    public void exibirProdutos(){
        System.out.println(estoqueProdutosMap);
    }

    public double calculaValorTotalEstoque(){
        double valorTotalEstoque = 0;
        if (!estoqueProdutosMap.isEmpty()){

            for (Produto p : estoqueProdutosMap.values()){
                valorTotalEstoque += p.getQuantidade() * p.getPreco();
            }
        }

        return valorTotalEstoque;
    }

    public Produto obterProcutoMaisCaro(){
        Produto produtoMaisCaro = null;

        double maiorPreco = Double.MIN_VALUE;

        for (Produto p: estoqueProdutosMap.values()){
            if (p.getPreco() > maiorPreco){
                produtoMaisCaro = p;
            }
        }
        return produtoMaisCaro;
    }

    public Produto obterProcutoMaisBarato(){
        Produto produtoMaisBarato = null;

        double menorPreco = Double.MIN_VALUE;

        for (Produto p: estoqueProdutosMap.values()){
            if (p.getPreco() > menorPreco){
                produtoMaisBarato = p;
            }
        }
        return produtoMaisBarato;
    }

    // Declaração de um método público chamado obterProdutoMaiorQuantidadeValorTotalNoEstoque
    public Produto obterProdutoMaiorQuantidadeValorTotalNoEstoque() {
        // Inicialização de variáveis
        // produtoMaiorQuantidadeValorNoEstoque vai armazenar o produto com maior valor total no estoque
        Produto produtoMaiorQuantidadeValorNoEstoque = null;
        // maiorValorTotalProdutoEstoque vai armazenar o maior valor total encontrado até agora
        double maiorValorTotalProdutoEstoque = 0d;

        // Verifica se o mapa de estoque de produtos (estoqueProdutosMap) não está vazio
        if (!estoqueProdutosMap.isEmpty()) {
            // Iteração sobre os pares chave-valor (entry) no mapa de estoque de produtos
            for (Map.Entry<Long, Produto> entry : estoqueProdutosMap.entrySet()) {
                // Calcula o valor total do produto em estoque multiplicando o preço pela quantidade
                double valorProdutoEmEstoque = entry.getValue().getPreco() * entry.getValue().getQuantidade();

                // Verifica se o valor total deste produto é maior do que o maior valor total encontrado até agora
                if (valorProdutoEmEstoque > maiorValorTotalProdutoEstoque) {
                    // Se for maior, atualiza o maior valor total e armazena o produto correspondente
                    maiorValorTotalProdutoEstoque = valorProdutoEmEstoque;
                    produtoMaiorQuantidadeValorNoEstoque = entry.getValue();
                }
            }
        }

        // Retorna o produto com a maior quantidade de valor total no estoque
        return produtoMaiorQuantidadeValorNoEstoque;
    }



    public static void main(String[] args) {
        EstoqueProdutos estoque = new EstoqueProdutos();

        // Exibe o estoque vazio
        estoque.exibirProdutos();

        // Adiciona produtos ao estoque
        estoque.adicionarProduto(1L, "Notebook", 1, 1500.0);
        estoque.adicionarProduto(2L, "Mouse", 5, 25.0);
        estoque.adicionarProduto(3L, "Monitor", 10, 400.0);
        estoque.adicionarProduto(4L, "Teclado", 2, 40.0);

        // Exibe os produtos no estoque
        estoque.exibirProdutos();

        // Calcula e exibe o valor total do estoque
        System.out.println("Valor total do estoque: R$" + estoque.calculaValorTotalEstoque());

        // Obtém e exibe o produto mais caro
        Produto produtoMaisCaro = estoque.obterProcutoMaisCaro();
        System.out.println("Produto mais caro: " + produtoMaisCaro);

        // Obtém e exibe o produto mais barato
        Produto produtoMaisBarato = estoque.obterProcutoMaisBarato();
        System.out.println("Produto mais barato: " + produtoMaisBarato);

        // Obtém e exibe o produto com a maior quantidade em valor no estoque
        Produto produtoMaiorQuantidadeValorTotal = estoque.obterProdutoMaiorQuantidadeValorTotalNoEstoque();
        System.out.println("Produto com maior quantidade em valor no estoque: " + produtoMaiorQuantidadeValorTotal);
    }


}
