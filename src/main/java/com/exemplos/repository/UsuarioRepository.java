package com.exemplos.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.exemplos.entity.Usuario;

public class UsuarioRepository {
	private EntityManagerFactory factory;
	private EntityManager em;
	
	public UsuarioRepository() {
		this.factory = Persistence.createEntityManagerFactory("store-PU");
		this.em = factory.createEntityManager();
	}
	
	
	public List<Usuario> buscarTodos() {
		String jpql = "select u from Usuario u";
		List<Usuario> usuarioList = this.em.createQuery(jpql, Usuario.class).getResultList();
		return usuarioList;
	}
	
	public Usuario buscarPorId(int id) {
		Usuario usuarioResult = this.em.find(Usuario.class, id);
		return usuarioResult;
	}
		
	public Usuario buscarPorEmail(String email) {
		String jpql = "select u from Usuario u where u.email = :email";
		List<Usuario> usuarioList = this.em.createQuery(jpql, Usuario.class)
									.setParameter("email", email)
									.getResultList();
		if(usuarioList == null || usuarioList.isEmpty()) {
			return null;
		}
		
		return usuarioList.get(0);
	}
		
	public Usuario cadastrar(Usuario usuario) {
		this.em.getTransaction().begin();
		this.em.persist(usuario);
		this.em.getTransaction().commit();
		this.em.close();
		
		return usuario;
	}
	
	public Usuario atualizar(Usuario usuario) {
		this.em.getTransaction().begin();
		this.em.merge(usuario);
		this.em.getTransaction().commit();
		this.em.close();
		
		return usuario;
	}
	
	public boolean excluir(int id) {
		Usuario usuario = this.em.find(Usuario.class, id);
		if(usuario == null)
			return false;
					
		this.em.getTransaction().begin();
		this.em.remove(usuario);
		this.em.getTransaction().commit();
		this.em.close();

		return true;		
	}
}
