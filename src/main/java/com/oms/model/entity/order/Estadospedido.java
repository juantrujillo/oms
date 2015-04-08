/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.oms.model.entity.order;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * 
 * @author dianaduque
 */
@Entity
@Table(name = "ESTADOSPEDIDO")
@NamedQueries({
		@NamedQuery(name = "Estadospedido.findAll", query = "SELECT e FROM Estadospedido e"),
		@NamedQuery(name = "Estadospedido.findByIdestado", query = "SELECT e FROM Estadospedido e WHERE e.idestado = :idestado"),
		@NamedQuery(name = "Estadospedido.findByNombre", query = "SELECT e FROM Estadospedido e WHERE e.nombre = :nombre") })
public class Estadospedido implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Basic(optional = false)
	@Column(name = "IDESTADO")
	private Short idestado;
	@Basic(optional = false)
	@Column(name = "NOMBRE")
	private String nombre;
	@OneToMany(cascade = CascadeType.ALL)
	private Collection<Pedidos> pedidosCollection;

	public Estadospedido() {
	}

	public Estadospedido(Short idestado) {
		this.idestado = idestado;
	}

	public Estadospedido(Short idestado, String nombre) {
		this.idestado = idestado;
		this.nombre = nombre;
	}

	public Short getIdestado() {
		return idestado;
	}

	public void setIdestado(Short idestado) {
		this.idestado = idestado;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Collection<Pedidos> getPedidosCollection() {
		return pedidosCollection;
	}

	public void setPedidosCollection(Collection<Pedidos> pedidosCollection) {
		this.pedidosCollection = pedidosCollection;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (idestado != null ? idestado.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof Estadospedido)) {
			return false;
		}
		Estadospedido other = (Estadospedido) object;
		if ((this.idestado == null && other.idestado != null)
				|| (this.idestado != null && !this.idestado
						.equals(other.idestado))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "com.oms.model.entity.order.Estadospedido[ idestado=" + idestado
				+ " ]";
	}

}
