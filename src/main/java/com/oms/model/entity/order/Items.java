/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.oms.model.entity.order;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * 
 * @author dianaduque
 */
@Entity
@Table(name = "ITEMS")
@NamedQueries({
		@NamedQuery(name = "Items.findAll", query = "SELECT i FROM Items i"),
		@NamedQuery(name = "Items.findByIdproducto", query = "SELECT i FROM Items i WHERE i.idproducto = :idproducto"),
		@NamedQuery(name = "Items.findByIdfabricante", query = "SELECT i FROM Items i WHERE i.idfabricante = :idfabricante"),
		@NamedQuery(name = "Items.findByPrecio", query = "SELECT i FROM Items i WHERE i.precio = :precio"),
		@NamedQuery(name = "Items.findByCantidad", query = "SELECT i FROM Items i WHERE i.cantidad = :cantidad"),
		@NamedQuery(name = "Items.findByNomproducto", query = "SELECT i FROM Items i WHERE i.nomproducto = :nomproducto") })
public class Items implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Basic(optional = false)
	@Lob
	@Column(name = "IDITEM")
	private byte[] iditem;
	@Basic(optional = false)
	@Column(name = "IDPRODUCTO")
	private BigInteger idproducto;
	@Column(name = "IDFABRICANTE")
	private Short idfabricante;
	// @Max(value=?) @Min(value=?)//if you know range of your decimal fields
	// consider using these annotations to enforce field validation
	@Basic(optional = false)
	@Column(name = "PRECIO")
	private BigDecimal precio;
	@Basic(optional = false)
	@Column(name = "CANTIDAD")
	private short cantidad;
	@Column(name = "NOMPRODUCTO")
	private String nomproducto;
	@JoinColumn(name = "IDPEDIDO")
	@ManyToOne(optional = false)
	private Pedidos idpedido;

	public Items() {
	}

	public Items(byte[] iditem) {
		this.iditem = iditem;
	}

	public Items(byte[] iditem, BigInteger idproducto, BigDecimal precio,
			short cantidad) {
		this.iditem = iditem;
		this.idproducto = idproducto;
		this.precio = precio;
		this.cantidad = cantidad;
	}

	public byte[] getIditem() {
		return iditem;
	}

	public void setIditem(byte[] iditem) {
		this.iditem = iditem;
	}

	public BigInteger getIdproducto() {
		return idproducto;
	}

	public void setIdproducto(BigInteger idproducto) {
		this.idproducto = idproducto;
	}

	public Short getIdfabricante() {
		return idfabricante;
	}

	public void setIdfabricante(Short idfabricante) {
		this.idfabricante = idfabricante;
	}

	public BigDecimal getPrecio() {
		return precio;
	}

	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}

	public short getCantidad() {
		return cantidad;
	}

	public void setCantidad(short cantidad) {
		this.cantidad = cantidad;
	}

	public String getNomproducto() {
		return nomproducto;
	}

	public void setNomproducto(String nomproducto) {
		this.nomproducto = nomproducto;
	}

	public Pedidos getIdpedido() {
		return idpedido;
	}

	public void setIdpedido(Pedidos idpedido) {
		this.idpedido = idpedido;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (iditem != null ? iditem.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof Items)) {
			return false;
		}
		Items other = (Items) object;
		if ((this.iditem == null && other.iditem != null)
				|| (this.iditem != null && !this.iditem.equals(other.iditem))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "com.oms.model.entity.order.Items[ iditem=" + iditem + " ]";
	}

}
