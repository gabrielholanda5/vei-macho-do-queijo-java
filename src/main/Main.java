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
			
			try {
				opcao = Integer.parseInt(scanner.nextLine());
			} catch (NumberFormatException e) {
				System.out.println("Digite um numero");
				continue;
			}
			
			
			if(opcao == 1) {
				
				String nome;
				int quantidade;
				double preco;
				
				while(true) {
					System.out.println("Produto: ");
					nome = scanner.nextLine();
					
					if (nome.matches("[a-zA-Z]+")) {
						break;
					} else {
						System.out.println("Digite apenas letras!");
					}
					
				}
				
				
				while(true) {
					System.out.println("Quantidade: ");
					
					try {
						quantidade = Integer.parseInt(scanner.nextLine());
						
						
					} catch (NumberFormatException e) {
						System.out.println("Digite apenas numeros!");
						continue;
					}
					
					if (quantidade <= 0) {
						System.out.println("A quantidade tem que ser maior que 0");
						continue;
					}
					
					break;
				}
				
				 
				while(true) {
					System.out.println("Preço: ");
					
					try {
						preco = Double.parseDouble(scanner.nextLine());
						
					} catch (NumberFormatException e) {
						System.out.println("Digite apenas numeros!");
						continue;
					}
					
					if(preco <= 0) {
						System.out.println("O preco tem que ser maior do que 0");
						continue;
					}
					
					break;
				}
				
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
				
				int id;
				String nome;
				int quantidade;
				double preco;
				
				while(true) {
					
					System.out.println("Digite o ID do produto: ");
				
					try {
						id = Integer.parseInt(scanner.nextLine());
					} catch (NumberFormatException e) {
						System.out.println("Digite um numero!");
						continue;
					}
					
					while(true) {
						System.out.println("Produto: ");
						nome = scanner.nextLine();
					
						if(nome.matches("[a-zA-Z]+")) {
							break;
						} else {
							System.out.println("Digite apenas letras");
						}
					}
					
				
					while(true) {
						System.out.println("Quantidade: ");
						
					
						try {
							quantidade = Integer.parseInt(scanner.nextLine());
						} catch (NumberFormatException e) {
							System.out.println("Digite apenas numeros!");
							continue;
						}
					
						if(quantidade < 0) {
							System.out.println("Quantidade nao pode ser negativa!");
							continue;
						}
						
						break;
					}
					
					while(true) {
						System.out.println("Preço: ");
					
					
						try {
							preco = Double.parseDouble(scanner.nextLine());
							
							
						} catch (NumberFormatException e) {
							System.out.println("Digite apenas numeros!");
							continue;
						}
						
						if(preco <= 0 ) {
							System.out.println("O preco tem que ser maior que 0");
							continue;
						}
						break;
						
					}
					
				
					boolean atualizado = produtoService.atualizarProduto(id, nome, quantidade, preco);
				
					if(atualizado) {
						System.out.println("Produto atualizado");
						break;
					} else {
						System.out.println("Produto nao encontrado");
						break;
					}
				}
				
			}
			else if(opcao == 4) {
				
				int id;
				
				while(true) {
					System.out.println("Digite o ID do produto: ");
					
					try {
						id = Integer.parseInt(scanner.nextLine());
						break;
					} catch (NumberFormatException e) {
						System.out.println("Digite um numero!");
						continue;
					}
				}
				
				
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
