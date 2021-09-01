package com.exemplos.app;

import java.util.List;

import com.exemplos.entity.Categoria;
import com.exemplos.entity.Produto;
import com.exemplos.entity.Usuario;
import com.exemplos.repository.*;
import com.exemplos.vo.RelatorioVendasVo;

public class Main {

	public static void main(String[] args) {

		UsuarioRepository usuarioRepository = new UsuarioRepository();
		ProdutoRepository produtoRepository = new ProdutoRepository();
		PedidoRepository pedidoRepository = new PedidoRepository();
		CategoriaRepository categoriaRepository = new CategoriaRepository();
		RelatorioRepository relatorioRepository = new RelatorioRepository();

		//produtoRepository.cadastrar();
		//usuarioRepository.cadastrar();
		List<Produto> produtosList = produtoRepository.buscarTodosComNamedQuery();
		List<Produto> produtosListDinamico = produtoRepository.buscaDinamica("Sansung", "Smartphones");
		List<Produto> produtosPorCategoria = produtoRepository.buscarPorNomeCategoria("games");
		Usuario usuario = usuarioRepository.buscarPorEmail("guto@gmail.com");
		System.out.println(produtosList.size());
		System.out.println(produtosListDinamico.size());
		System.out.println(produtosPorCategoria.size());
		System.out.println(usuario.getId());
		System.out.println(produtoRepository.buscarApenasPrecoProduto(15));
		System.out.println(pedidoRepository.buscarValorTotalPedidos());
		System.out.println(pedidoRepository.buscarMenorValorPedidos());
		System.out.println(pedidoRepository.buscarMaiorValorPedidos());
		System.out.println(pedidoRepository.buscarValorMedioPedidos());
		
		List<RelatorioVendasVo> relatorioVendas = relatorioRepository.relatorioVendas();
		
		for(RelatorioVendasVo item : relatorioVendas) {
			System.out.println(item.toString());
		}
		
		List<Categoria> categorias = categoriaRepository.buscarTodosQueryNativa();
		for(Categoria item : categorias) {
			System.out.println(item.toString());
		}
	}

}
