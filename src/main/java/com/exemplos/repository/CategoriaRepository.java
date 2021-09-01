package com.exemplos.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.exemplos.entity.Categoria;

public class CategoriaRepository {
	private EntityManagerFactory factory;
	private EntityManager em;
	
	public CategoriaRepository() {
		this.factory = Persistence.createEntityManagerFactory("store-PU");
		this.em = factory.createEntityManager();
	}
	
	
	public List<Categoria> buscarTodos() {
		String jpql = "select c from Categoria c";
		List<Categoria> categoriaList = this.em.createQuery(jpql, Categoria.class).getResultList();
		return categoriaList;
	}
	
	@SuppressWarnings("unchecked")
	public List<Categoria> buscarTodosQueryNativa() {
		String jpql = "select c.id, c.nome from categorias c";
		Query query = this.em.createNativeQuery(jpql, Categoria.class);
		return query.getResultList();
	}
	
	public Categoria buscarPorId(int id) {
		Categoria categoriaResult = this.em.find(Categoria.class, id);
		return categoriaResult;
	}
		
	public Categoria cadastrar(Categoria categoria) {
		this.em.getTransaction().begin();
		this.em.persist(categoria);
		this.em.getTransaction().commit();
		this.em.close();
		
		return categoria;
	}
	
	public Categoria atualizar(Categoria categoria) {
		this.em.getTransaction().begin();
		this.em.merge(categoria);
		this.em.getTransaction().commit();
		this.em.close();
		
		return categoria;
	}
	
	public boolean excluir(int id) {
		Categoria categoria = this.em.find(Categoria.class, id);
		if(categoria == null)
			return false;
					
		this.em.getTransaction().begin();
		this.em.remove(categoria);
		this.em.getTransaction().commit();
		this.em.close();

		return true;		
	}

}
