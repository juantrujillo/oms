/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.oms.model.entity.order;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Lob;

/**
 * 
 * @author dianaduque
 */
@Embeddable
public class DireccionesclientePK implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Basic(optional = false)
	@Lob
	@Column(name = "IDCLIENTE")
	private byte[] idcliente;
	@Basic(optional = false)
	@Column(name = "IDDIRECCION")
	private short iddireccion;

	public DireccionesclientePK() {
	}

	public DireccionesclientePK(byte[] idcliente, short iddireccion) {
		this.idcliente = idcliente;
		this.iddireccion = iddireccion;
	}

	public byte[] getIdcliente() {
		return idcliente;
	}

	public void setIdcliente(byte[] idcliente) {
		this.idcliente = idcliente;
	}

	public short getIddireccion() {
		return iddireccion;
	}

	public void setIddireccion(short iddireccion) {
		this.iddireccion = iddireccion;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (idcliente != null ? idcliente.hashCode() : 0);
		hash += (int) iddireccion;
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof DireccionesclientePK)) {
			return false;
		}
		DireccionesclientePK other = (DireccionesclientePK) object;
		if ((this.idcliente == null && other.idcliente != null)
				|| (this.idcliente != null && !this.idcliente
						.equals(other.idcliente))) {
			return false;
		}
		if (this.iddireccion != other.iddireccion) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "com.oms.model.entity.order.DireccionesclientePK[ idcliente="
				+ idcliente + ", iddireccion=" + iddireccion + " ]";
	}

}
