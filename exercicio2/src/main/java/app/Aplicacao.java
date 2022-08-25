package app;

import java.util.List;

import dao.DAO;
import dao.ProdutoDAO;
import model.Produto;

public class Aplicacao {
	
	public static void main(String[] args) throws Exception {
		
		ProdutoDAO produtoDAO = new ProdutoDAO();
		
		System.out.println("\n\n==== Inserir produto === ");
		Produto produto = new Produto(11, "carro", "transporte");
		if(produtoDAO.insert(produto) == true) {
			System.out.println("Inserção com sucesso -> " + produto.toString());
		}
		
		System.out.println("\n\n==== Testando autenticação ===");
		System.out.println("Produto (" + produto.getNome() + "): " + produtoDAO.autenticar("carro", "transporte"));
			
		System.out.println("\n\n==== Atualizar tipo (código (" + produto.getCodigo() + ") === ");
		produto.setTipo(DAO.toMD5("direcao"));
		produtoDAO.update(produto);
		
		System.out.println("\n\n==== Testando autenticação ===");
		System.out.println("Usuário (" + produto.getNome() + "): " + produtoDAO.autenticar("carro", DAO.toMD5("direcao")));		
		
		System.out.println("\n\n==== Mostrar produtos ordenados por código === ");
		List<Produto> produtos = produtoDAO.getOrderByCodigo();
		for (Produto u: produtos) {
			System.out.println(u.toString());
		}
		
		System.out.println("\n\n==== Excluir produto (código " + produto.getCodigo() + ") === ");
		produtoDAO.delete(produto.getCodigo());
		
		System.out.println("\n\n==== Mostrar usuários ordenados por nome === ");
		produtos = produtoDAO.getOrderByNome();
		for (Produto u: produtos) {
			System.out.println(u.toString());
		}
	}
}
