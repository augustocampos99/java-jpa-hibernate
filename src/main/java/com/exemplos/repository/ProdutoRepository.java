package com.exemplos.repository;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.exemplos.entity.Produto;

public class ProdutoRepository {
	private EntityManagerFactory factory;
	private EntityManager em;
	
	public ProdutoRepository() {
		this.factory = Persistence.createEntityManagerFactory("store-PU");
		this.em = factory.createEntityManager();
	}
	
	public List<Produto> buscarTodos() {
		String jpql = "select p from Produto p join fetch p.categoria c";
		List<Produto> produtoList = this.em.createQuery(jpql, Produto.class).getResultList();
		return produtoList;
	}
	
	public List<Produto> buscarTodosComNamedQuery() {
		List<Produto> produtoList = this.em.createNamedQuery("Produto.SelectAll", Produto.class).getResultList();
		return produtoList;
	}
	
	public Produto buscarPorId(int id) {
		Produto produtoResult = this.em.find(Produto.class, id);
		return produtoResult;
	}
	
	public List<Produto> buscarPorNome(String nome) {
		String 	jpql = "select p from Produto p join fetch p.categoria c where p.nome like :nome";

		return this.em.createQuery(jpql, Produto.class)
		.setParameter("nome", "%"+ nome +"%")		
		.getResultList();
	}
	
	public List<Produto> buscarPorNomeCategoria(String nome) {
		String 	jpql = "select p from Produto p join fetch p.categoria c where c.nome = :nome";

		return this.em.createQuery(jpql, Produto.class)
		.setParameter("nome", nome)		
		.getResultList();
	}
	
	public BigDecimal buscarApenasPrecoProduto(int id) {
		String jpql = "select p.preco from Produto p where p.id = :id";
		return this.em.createQuery(jpql, BigDecimal.class)
				.setParameter("id", id)
				.getSingleResult();
	}
	
	public Produto cadastrar(Produto produto) {
		this.em.getTransaction().begin();
		this.em.persist(produto);
		this.em.getTransaction().commit();
		this.em.close();
		
		return produto;
	}
	
	public Produto atualizar(Produto produto) {
		this.em.getTransaction().begin();
		this.em.merge(produto);
		this.em.getTransaction().commit();
		this.em.close();
		
		return produto;
	}
	
	public boolean excluir(int id) {
		Produto produto = this.em.find(Produto.class, id);
		if(produto == null)
			return false;
					
		this.em.getTransaction().begin();
		this.em.remove(produto);
		this.em.getTransaction().commit();
		this.em.close();

		return true;		
	}
	
	
}
