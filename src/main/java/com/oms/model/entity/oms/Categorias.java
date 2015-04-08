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
@Table(name = "Categorias")
@NamedQueries({
		@NamedQuery(name = "Categorias.findAll", query = "SELECT c FROM Categorias c"),
		@NamedQuery(name = "Categorias.findByIdCategoria", query = "SELECT c FROM Categorias c WHERE c.idCategoria = :idCategoria"),
		@NamedQuery(name = "Categorias.findByNombre", query = "SELECT c FROM Categorias c WHERE c.nombre = :nombre"),
		@NamedQuery(name = "Categorias.findByDescripcion", query = "SELECT c FROM Categorias c WHERE c.descripcion = :descripcion") })
public class Categorias implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Basic(optional = false)
	@Column(name = "IdCategoria")
	private Integer idCategoria;
	@Basic(optional = false)
	@Column(name = "Nombre")
	private String nombre;
	@Basic(optional = false)
	@Column(name = "Descripcion")
	private String descripcion;

	public Categorias() {
	}

	public Categorias(Integer idCategoria) {
		this.idCategoria = idCategoria;
	}

	public Categorias(Integer idCategoria, String nombre, String descripcion) {
		this.idCategoria = idCategoria;
		this.nombre = nombre;
		this.descripcion = descripcion;
	}

	public Integer getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(Integer idCategoria) {
		this.idCategoria = idCategoria;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (idCategoria != null ? idCategoria.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof Categorias)) {
			return false;
		}
		Categorias other = (Categorias) object;
		if ((this.idCategoria == null && other.idCategoria != null)
				|| (this.idCategoria != null && !this.idCategoria
						.equals(other.idCategoria))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "com.oms.model.entity.oms.Categorias[ idCategoria="
				+ idCategoria + " ]";
	}

}
