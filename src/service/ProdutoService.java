package service;

import java.util.ArrayList;
import java.util.List;

import model.Produto;

public class ProdutoService {
	
	ArrayList<Produto> produtos = new ArrayList<>();
	private int proximoId;
	
	public ProdutoService() {
		produtos = new ArrayList<Produto>();
		proximoId = 1;
	}
	
	public void adicionarProduto(String nome, int quantidade, double preco) {
		for(Produto p : produtos) {
			if(p.getNome().equalsIgnoreCase(nome)) {
				return;
			}
		}
		
		produtos.add(new Produto(proximoId,nome, quantidade, preco));
		proximoId++;
	}
	
	public List<Produto> listarProdutos() {
		return produtos;
	}
	
	public boolean atualizarProduto(int id, String nome, int quantidade, double preco) {
		for(Produto p : produtos ) {
			if(p.getId() == id) {
				p.setNome(nome);
				p.setQuantidade(quantidade);
				p.setPreco(preco);
				return true;
			}
		}
		
		return false;
	}
	
	public boolean deletarProduto(int id) {
		for(int i = 0; i < produtos.size() ; i++) {
			if(produtos.get(i).getId() == id) {
				produtos.remove(i);
				return true;
			}
		
		}
		
		return false;
	}
	
	
}
