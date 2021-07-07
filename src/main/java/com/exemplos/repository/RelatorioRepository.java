package com.exemplos.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class RelatorioRepository {

	private EntityManagerFactory factory;
	private EntityManager em;
	
	public RelatorioRepository() {
		this.factory = Persistence.createEntityManagerFactory("store-PU");
		this.em = factory.createEntityManager();
	}
	
	public List<Object[]> relatorioVendas() {
		String jpql = "SELECT produto.nome, "
				+ "MAX(pedido.dataPedido), "
				+ "SUM(produto.preco) "
				+ "FROM Produto produto "
				+ "JOIN produto.pedidos pedido "
				+ "GROUP BY produto.id "
				+ "ORDER BY produto.preco ASC";
		
		return this.em.createQuery(jpql, Object[].class).getResultList();
	}

}
