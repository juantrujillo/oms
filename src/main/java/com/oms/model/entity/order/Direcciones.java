/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.oms.model.entity.order;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * 
 * @author dianaduque
 */
@Entity
@Table(name = "DIRECCIONES")
@NamedQueries({
		@NamedQuery(name = "Direcciones.findAll", query = "SELECT d FROM Direcciones d"),
		@NamedQuery(name = "Direcciones.findByIddireccion", query = "SELECT d FROM Direcciones d WHERE d.iddireccion = :iddireccion"),
		@NamedQuery(name = "Direcciones.findByCalle", query = "SELECT d FROM Direcciones d WHERE d.calle = :calle"),
		@NamedQuery(name = "Direcciones.findByEstado", query = "SELECT d FROM Direcciones d WHERE d.estado = :estado"),
		@NamedQuery(name = "Direcciones.findByCodigopostal", query = "SELECT d FROM Direcciones d WHERE d.codigopostal = :codigopostal"),
		@NamedQuery(name = "Direcciones.findByPais", query = "SELECT d FROM Direcciones d WHERE d.pais = :pais"),
		@NamedQuery(name = "Direcciones.findByCiudad", query = "SELECT d FROM Direcciones d WHERE d.ciudad = :ciudad") })
public class Direcciones implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Basic(optional = false)
	@Column(name = "IDDIRECCION")
	private Short iddireccion;
	@Basic(optional = false)
	@Column(name = "CALLE")
	private String calle;
	@Basic(optional = false)
	@Column(name = "ESTADO")
	private String estado;
	@Basic(optional = false)
	@Column(name = "CODIGOPOSTAL")
	private String codigopostal;
	@Basic(optional = false)
	@Column(name = "PAIS")
	private String pais;
	@Basic(optional = false)
	@Column(name = "CIUDAD")
	private String ciudad;

	public Direcciones() {
	}

	public Direcciones(Short iddireccion) {
		this.iddireccion = iddireccion;
	}

	public Direcciones(Short iddireccion, String calle, String estado,
			String codigopostal, String pais, String ciudad) {
		this.iddireccion = iddireccion;
		this.calle = calle;
		this.estado = estado;
		this.codigopostal = codigopostal;
		this.pais = pais;
		this.ciudad = ciudad;
	}

	public Short getIddireccion() {
		return iddireccion;
	}

	public void setIddireccion(Short iddireccion) {
		this.iddireccion = iddireccion;
	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getCodigopostal() {
		return codigopostal;
	}

	public void setCodigopostal(String codigopostal) {
		this.codigopostal = codigopostal;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (iddireccion != null ? iddireccion.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof Direcciones)) {
			return false;
		}
		Direcciones other = (Direcciones) object;
		if ((this.iddireccion == null && other.iddireccion != null)
				|| (this.iddireccion != null && !this.iddireccion
						.equals(other.iddireccion))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "com.oms.model.entity.order.Direcciones[ iddireccion="
				+ iddireccion + " ]";
	}

}
