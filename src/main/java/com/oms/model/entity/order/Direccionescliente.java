/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.oms.model.entity.order;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * 
 * @author dianaduque
 */
@Entity
@Table(name = "DIRECCIONESCLIENTE")
@NamedQueries({
		@NamedQuery(name = "Direccionescliente.findAll", query = "SELECT d FROM Direccionescliente d"),
		@NamedQuery(name = "Direccionescliente.findByIddireccion", query = "SELECT d FROM Direccionescliente d WHERE d.direccionesclientePK.iddireccion = :iddireccion") })
public class Direccionescliente implements Serializable {
	private static final long serialVersionUID = 1L;
	@EmbeddedId
	protected DireccionesclientePK direccionesclientePK;
	@JoinColumn(name = "IDCLIENTE", insertable = false, updatable = false)
	@ManyToOne(optional = false)
	private Clientes clientes;

	public Direccionescliente() {
	}

	public Direccionescliente(DireccionesclientePK direccionesclientePK) {
		this.direccionesclientePK = direccionesclientePK;
	}

	public Direccionescliente(byte[] idcliente, short iddireccion) {
		this.direccionesclientePK = new DireccionesclientePK(idcliente,
				iddireccion);
	}

	public DireccionesclientePK getDireccionesclientePK() {
		return direccionesclientePK;
	}

	public void setDireccionesclientePK(
			DireccionesclientePK direccionesclientePK) {
		this.direccionesclientePK = direccionesclientePK;
	}

	public Clientes getClientes() {
		return clientes;
	}

	public void setClientes(Clientes clientes) {
		this.clientes = clientes;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (direccionesclientePK != null ? direccionesclientePK.hashCode()
				: 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof Direccionescliente)) {
			return false;
		}
		Direccionescliente other = (Direccionescliente) object;
		if ((this.direccionesclientePK == null && other.direccionesclientePK != null)
				|| (this.direccionesclientePK != null && !this.direccionesclientePK
						.equals(other.direccionesclientePK))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "com.oms.model.entity.order.Direccionescliente[ direccionesclientePK="
				+ direccionesclientePK + " ]";
	}

}
