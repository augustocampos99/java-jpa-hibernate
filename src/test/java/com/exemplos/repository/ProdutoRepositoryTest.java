package com.exemplos.repository;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class ProdutoRepositoryTest {
	private ProdutoRepository repository = new ProdutoRepository();
	
	@Test
	public void ProdutoRepository() {
		assertTrue(this.repository.buscarTodos().size() > 0);
	}
}
