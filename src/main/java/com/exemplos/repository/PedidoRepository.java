package com.exemplos.repository;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class PedidoRepository {

	private EntityManagerFactory factory;
	private EntityManager em;
	
	public PedidoRepository() {
		this.factory = Persistence.createEntityManagerFactory("store-PU");
		this.em = factory.createEntityManager();
	}
	
	public BigDecimal buscarValorTotalPedidos() {
		String jpql = "select SUM(p.valorTotal) from Pedido p";
		return this.em.createQuery(jpql, BigDecimal.class).getSingleResult();
	}
	
	public BigDecimal buscarMenorValorPedidos() {
		String jpql = "select MIN(p.valorTotal) from Pedido p";
		return this.em.createQuery(jpql, BigDecimal.class).getSingleResult();
	}
	
	public BigDecimal buscarMaiorValorPedidos() {
		String jpql = "select MAX(p.valorTotal) from Pedido p";
		return this.em.createQuery(jpql, BigDecimal.class).getSingleResult();
	}
	
	public Double buscarValorMedioPedidos() {
		String jpql = "select AVG(p.valorTotal) from Pedido p";
		return this.em.createQuery(jpql, Double.class).getSingleResult();
	}
	

}
