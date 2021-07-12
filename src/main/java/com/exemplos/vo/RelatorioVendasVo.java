package com.exemplos.vo;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class RelatorioVendasVo {
	private String nomeProduto;
	private LocalDateTime dataUltimoPedido;
	private BigDecimal totalVendas;
	
		
	public RelatorioVendasVo(String nomeProduto, LocalDateTime dataUltimoPedido, BigDecimal totalVendas) {
		super();
		this.nomeProduto = nomeProduto;
		this.dataUltimoPedido = dataUltimoPedido;
		this.totalVendas = totalVendas;
	}

	public String getNomeProduto() {
		return nomeProduto;
	}
	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}
	public LocalDateTime getDataUltimoPedido() {
		return dataUltimoPedido;
	}
	public void setDataUltimoPedido(LocalDateTime dataUltimoPedido) {
		this.dataUltimoPedido = dataUltimoPedido;
	}
	public BigDecimal getTotalVendas() {
		return totalVendas;
	}
	public void setTotalVendas(BigDecimal totalVendas) {
		this.totalVendas = totalVendas;
	}
	
	
	@Override
	public String toString() {
		return "RelatorioPedidoVo [nomeProduto=" + nomeProduto + ", dataUltimoPedido=" + dataUltimoPedido
				+ ", totalVendas=" + totalVendas + "]";
	}
	
}
