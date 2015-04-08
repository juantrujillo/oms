/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.oms.model.entity.oms;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * 
 * @author dianaduque
 */
@Embeddable
public class ProductosFabricantePK implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Basic(optional = false)
	@Column(name = "IdFabricante")
	private long idFabricante;
	@Basic(optional = false)
	@Column(name = "IdProducto")
	private BigInteger idProducto;

	public ProductosFabricantePK() {
	}

	public ProductosFabricantePK(long idFabricante, BigInteger idProducto) {
		this.idFabricante = idFabricante;
		this.idProducto = idProducto;
	}

	public long getIdFabricante() {
		return idFabricante;
	}

	public void setIdFabricante(long idFabricante) {
		this.idFabricante = idFabricante;
	}

	public BigInteger getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(BigInteger idProducto) {
		this.idProducto = idProducto;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (int) idFabricante;
		hash += (idProducto != null ? idProducto.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof ProductosFabricantePK)) {
			return false;
		}
		ProductosFabricantePK other = (ProductosFabricantePK) object;
		if (this.idFabricante != other.idFabricante) {
			return false;
		}
		if ((this.idProducto == null && other.idProducto != null)
				|| (this.idProducto != null && !this.idProducto
						.equals(other.idProducto))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "com.oms.model.entity.oms.ProductosFabricantePK[ idFabricante="
				+ idFabricante + ", idProducto=" + idProducto + " ]";
	}

}
