package main;

import java.util.List;
import java.util.Scanner;

import model.Produto;
import service.ProdutoService;

public class Main {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		ProdutoService produtoService = new ProdutoService();
		
		int opcao;
		
		while(true) {
			
			System.out.println("""
					=== ESTOQUE VEI MACHO DO QUEIJO ===
					1 - Adicionar produto
					2 - Listar produtos
					3 - Atualizar produto
					4 - Excluir produto
					5 - Sair
					===================================
					Escolha uma opção: 
					""");
			
			opcao = scanner.nextInt();
			
			if(opcao == 1) {
				System.out.println("Produto: ");
				String nome = scanner.next();
				
				System.out.println("Quantidade: ");
				int quantidade = scanner.nextInt();
				
				System.out.println("Preço: ");
				double preco = scanner.nextDouble();
				
				boolean adicionado = produtoService.adicionarProduto(nome, quantidade, preco);
				
				if(adicionado) {
					System.out.println("Produto adicionado!");
				} else {
					System.out.println("Esse produto já existe!!!");
				}
			}
			else if(opcao == 2) {
				List<Produto> produtos = produtoService.listarProdutos();
				
				if(produtos.isEmpty()) {
					System.out.println("Nenhum produto cadastrado!!!");
				} else {
					for (Produto p : produtos) {
						System.out.println("ID: " + p.getId() + " | " +"Produto: " + p.getNome() + " | " + "Qtd: " + p.getQuantidade() + " | " + "Preço: " + p.getPreco());
						
					}
				}
				
			}
			else if(opcao == 3) {
				
				System.out.println("Digite o ID do produto: ");
				int id = scanner.nextInt();
				
				System.out.println("Produto: ");
				String nome = scanner.next();
				
				System.out.println("Quantidade: ");
				int quantidade = scanner.nextInt();
				
				System.out.println("Preço: ");
				double preco = scanner.nextDouble();
				
				boolean atualizado = produtoService.atualizarProduto(id, nome, quantidade, preco);
				
				if(atualizado) {
					System.out.println("Produto atualizado");
				} else {
					System.out.println("Produto nao encontrado");
				}
				
			}
			else if(opcao == 4) {
				
				System.out.println("Digite o ID do produto: ");
				int id = scanner.nextInt();
				
				boolean deletado = produtoService.deletarProduto(id);
				
				if(deletado) {
					System.out.println("Produto deletado");
				} else {
					System.out.println("Produto nao encontrado");
				}
			}
			else if(opcao == 5) {
				System.out.println("Programa finalizado");
				break;
			}
			else {
				System.out.println("Escolha umas das opcoes acima");
				continue;
			}
			
		}
		
		
	}
}
