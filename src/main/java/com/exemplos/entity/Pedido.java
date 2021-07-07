package com.exemplos.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "pedidos")
public class Pedido {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "valor_total")
	private BigDecimal valorTotal;

	@Column(name = "usuario_id")
	private int usuarioId;
	
	@Column(name = "data_pedido")
	private LocalDateTime dataPedido;

	@ManyToMany
	@JoinTable(name = "itens_pedido", joinColumns = { @JoinColumn(name = "pedido_id") }, inverseJoinColumns = { @JoinColumn(name = "produto_id") })
	private List<Produto> pedidos = new ArrayList<Produto>();
		
	public List<Produto> getPedidos() {
		return pedidos;
	}

	public void setPedidos(List<Produto> pedidos) {
		this.pedidos = pedidos;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public BigDecimal getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}

	public int getUsuarioId() {
		return usuarioId;
	}

	public void setUsuarioId(int usuarioId) {
		this.usuarioId = usuarioId;
	}

	public LocalDateTime getDataPedido() {
		return dataPedido;
	}

	public void setDataPedido(LocalDateTime dataPedido) {
		this.dataPedido = dataPedido;
	}
	
	

}
