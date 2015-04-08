/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.oms.model.entity.order;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

;

/**
 * 
 * @author dianaduque
 */
@Entity
@Table(name = "PEDIDOS")
@NamedQueries({
		@NamedQuery(name = "Pedidos.findAll", query = "SELECT p FROM Pedidos p"),
		@NamedQuery(name = "Pedidos.findByIdcarrier", query = "SELECT p FROM Pedidos p WHERE p.idcarrier = :idcarrier"),
		@NamedQuery(name = "Pedidos.findByFecha", query = "SELECT p FROM Pedidos p WHERE p.fecha = :fecha"),
		@NamedQuery(name = "Pedidos.findByPrecio", query = "SELECT p FROM Pedidos p WHERE p.precio = :precio"),
		@NamedQuery(name = "Pedidos.findByComentarios", query = "SELECT p FROM Pedidos p WHERE p.comentarios = :comentarios") })
public class Pedidos implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Basic(optional = false)
	@Lob
	@Column(name = "IDPEDIDO")
	private byte[] idpedido;
	@Column(name = "IDCARRIER")
	private Short idcarrier;
	@Basic(optional = false)
	@Column(name = "FECHA")
	@Temporal(TemporalType.TIMESTAMP)
	private Date fecha;
	@Basic(optional = false)
	@Column(name = "PRECIO")
	private long precio;
	@Column(name = "COMENTARIOS")
	private String comentarios;
	@JoinColumn(name = "IDESTADO")
	@ManyToOne(optional = false)
	private Estadospedido idestado;
	@JoinColumn(name = "IDCLIENTE")
	@ManyToOne(optional = false)
	private Clientes idcliente;
	@OneToMany(cascade = CascadeType.ALL)
	private Collection<Items> itemsCollection;

	public Pedidos() {
	}

	public Pedidos(byte[] idpedido) {
		this.idpedido = idpedido;
	}

	public Pedidos(byte[] idpedido, Date fecha, long precio) {
		this.idpedido = idpedido;
		this.fecha = fecha;
		this.precio = precio;
	}

	public byte[] getIdpedido() {
		return idpedido;
	}

	public void setIdpedido(byte[] idpedido) {
		this.idpedido = idpedido;
	}

	public Short getIdcarrier() {
		return idcarrier;
	}

	public void setIdcarrier(Short idcarrier) {
		this.idcarrier = idcarrier;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public long getPrecio() {
		return precio;
	}

	public void setPrecio(long precio) {
		this.precio = precio;
	}

	public String getComentarios() {
		return comentarios;
	}

	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}

	public Estadospedido getIdestado() {
		return idestado;
	}

	public void setIdestado(Estadospedido idestado) {
		this.idestado = idestado;
	}

	public Clientes getIdcliente() {
		return idcliente;
	}

	public void setIdcliente(Clientes idcliente) {
		this.idcliente = idcliente;
	}

	public Collection<Items> getItemsCollection() {
		return itemsCollection;
	}

	public void setItemsCollection(Collection<Items> itemsCollection) {
		this.itemsCollection = itemsCollection;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (idpedido != null ? idpedido.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof Pedidos)) {
			return false;
		}
		Pedidos other = (Pedidos) object;
		if ((this.idpedido == null && other.idpedido != null)
				|| (this.idpedido != null && !this.idpedido
						.equals(other.idpedido))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "com.oms.model.entity.order.Pedidos[ idpedido=" + idpedido
				+ " ]";
	}

}
