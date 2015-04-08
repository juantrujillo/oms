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
@Table(name = "CARRIERS")
@NamedQueries({
		@NamedQuery(name = "Carriers.findAll", query = "SELECT c FROM Carriers c"),
		@NamedQuery(name = "Carriers.findByIdcarrier", query = "SELECT c FROM Carriers c WHERE c.idcarrier = :idcarrier"),
		@NamedQuery(name = "Carriers.findByNombre", query = "SELECT c FROM Carriers c WHERE c.nombre = :nombre"),
		@NamedQuery(name = "Carriers.findByConexion", query = "SELECT c FROM Carriers c WHERE c.conexion = :conexion"),
		@NamedQuery(name = "Carriers.findByTipoconexion", query = "SELECT c FROM Carriers c WHERE c.tipoconexion = :tipoconexion") })
public class Carriers implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Basic(optional = false)
	@Column(name = "IDCARRIER")
	private Short idcarrier;
	@Basic(optional = false)
	@Column(name = "NOMBRE")
	private String nombre;
	@Basic(optional = false)
	@Column(name = "CONEXION")
	private String conexion;
	@Basic(optional = false)
	@Column(name = "TIPOCONEXION")
	private Character tipoconexion;

	public Carriers() {
	}

	public Carriers(Short idcarrier) {
		this.idcarrier = idcarrier;
	}

	public Carriers(Short idcarrier, String nombre, String conexion,
			Character tipoconexion) {
		this.idcarrier = idcarrier;
		this.nombre = nombre;
		this.conexion = conexion;
		this.tipoconexion = tipoconexion;
	}

	public Short getIdcarrier() {
		return idcarrier;
	}

	public void setIdcarrier(Short idcarrier) {
		this.idcarrier = idcarrier;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getConexion() {
		return conexion;
	}

	public void setConexion(String conexion) {
		this.conexion = conexion;
	}

	public Character getTipoconexion() {
		return tipoconexion;
	}

	public void setTipoconexion(Character tipoconexion) {
		this.tipoconexion = tipoconexion;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (idcarrier != null ? idcarrier.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof Carriers)) {
			return false;
		}
		Carriers other = (Carriers) object;
		if ((this.idcarrier == null && other.idcarrier != null)
				|| (this.idcarrier != null && !this.idcarrier
						.equals(other.idcarrier))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "com.oms.model.entity.order.Carriers[ idcarrier=" + idcarrier
				+ " ]";
	}

}
