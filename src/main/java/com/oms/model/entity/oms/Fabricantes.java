/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.oms.model.entity.oms;

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
@Table(name = "Fabricantes")
@NamedQueries({
		@NamedQuery(name = "Fabricantes.findAll", query = "SELECT f FROM Fabricantes f"),
		@NamedQuery(name = "Fabricantes.findByIdFabricante", query = "SELECT f FROM Fabricantes f WHERE f.idFabricante = :idFabricante"),
		@NamedQuery(name = "Fabricantes.findByNombre", query = "SELECT f FROM Fabricantes f WHERE f.nombre = :nombre"),
		@NamedQuery(name = "Fabricantes.findByConexion", query = "SELECT f FROM Fabricantes f WHERE f.conexion = :conexion"),
		@NamedQuery(name = "Fabricantes.findByTipoConexion", query = "SELECT f FROM Fabricantes f WHERE f.tipoConexion = :tipoConexion") })
public class Fabricantes implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Basic(optional = false)
	@Column(name = "IdFabricante")
	private Long idFabricante;
	@Basic(optional = false)
	@Column(name = "Nombre")
	private String nombre;
	@Basic(optional = false)
	@Column(name = "Conexion")
	private String conexion;
	@Basic(optional = false)
	@Column(name = "TipoConexion")
	private Character tipoConexion;

	public Fabricantes() {
	}

	public Fabricantes(Long idFabricante) {
		this.idFabricante = idFabricante;
	}

	public Fabricantes(Long idFabricante, String nombre, String conexion,
			Character tipoConexion) {
		this.idFabricante = idFabricante;
		this.nombre = nombre;
		this.conexion = conexion;
		this.tipoConexion = tipoConexion;
	}

	public Long getIdFabricante() {
		return idFabricante;
	}

	public void setIdFabricante(Long idFabricante) {
		this.idFabricante = idFabricante;
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

	public Character getTipoConexion() {
		return tipoConexion;
	}

	public void setTipoConexion(Character tipoConexion) {
		this.tipoConexion = tipoConexion;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (idFabricante != null ? idFabricante.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof Fabricantes)) {
			return false;
		}
		Fabricantes other = (Fabricantes) object;
		if ((this.idFabricante == null && other.idFabricante != null)
				|| (this.idFabricante != null && !this.idFabricante
						.equals(other.idFabricante))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "com.oms.model.entity.oms.Fabricantes[ idFabricante="
				+ idFabricante + " ]";
	}

}
