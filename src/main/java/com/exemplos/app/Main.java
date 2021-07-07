package com.exemplos.app;

import java.util.List;

import com.exemplos.entity.Produto;
import com.exemplos.entity.Usuario;
import com.exemplos.repository.*;

public class Main {

	public static void main(String[] args) {

		UsuarioRepository usuarioRepository = new UsuarioRepository();
		ProdutoRepository produtoRepository = new ProdutoRepository();
		PedidoRepository pedidoRepository = new PedidoRepository();
		RelatorioRepository relatorioRepository = new RelatorioRepository();

		//produtoRepository.cadastrar();
		//usuarioRepository.cadastrar();
		List<Produto> produtosList = produtoRepository.buscarTodos();
		List<Produto> produtos = produtoRepository.buscarPorNomeCategoria("games");
		Usuario usuario = usuarioRepository.buscarPorEmail("guto@gmail.com");
		System.out.println(produtos.size());
		System.out.println(usuario.getId());
		System.out.println(produtoRepository.buscarApenasPrecoProduto(15));
		System.out.println(pedidoRepository.buscarValorTotalPedidos());
		System.out.println(pedidoRepository.buscarMenorValorPedidos());
		System.out.println(pedidoRepository.buscarMaiorValorPedidos());
		System.out.println(pedidoRepository.buscarValorMedioPedidos());
		
		List<Object[]> relatorioVendas = relatorioRepository.relatorioVendas();
		
		for(Object[] item : relatorioVendas) {
			System.out.println(item[2]);
		}
	}

}
