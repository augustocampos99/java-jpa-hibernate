package com.exemplos.app;

import java.util.List;

import com.exemplos.entity.Produto;
import com.exemplos.entity.Usuario;
import com.exemplos.repository.ProdutoRepository;
import com.exemplos.repository.UsuarioRepository;

public class Main {

	public static void main(String[] args) {

		UsuarioRepository usuarioRepository = new UsuarioRepository();
		ProdutoRepository produtoRepository = new ProdutoRepository();

		//produtoRepository.cadastrar();
		//usuarioRepository.cadastrar();
		List<Produto> produtosList = produtoRepository.buscarTodos();
		List<Produto> produtos = produtoRepository.buscarPorNomeCategoria("games");
		Usuario usuario = usuarioRepository.buscarPorEmail("admin");
		System.out.println(produtos.size());
		System.out.println(usuario.getId());
		System.out.println(produtoRepository.buscarApenasPrecoProduto(15));
		
	}

}
