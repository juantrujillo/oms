/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.oms.model.entity.oms;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * 
 * @author dianaduque
 */
@Entity
@Table(name = "Campanias")
@NamedQueries({
		@NamedQuery(name = "Campanias.findAll", query = "SELECT c FROM Campanias c"),
		@NamedQuery(name = "Campanias.findByIdCampania", query = "SELECT c FROM Campanias c WHERE c.idCampania = :idCampania"),
		@NamedQuery(name = "Campanias.findByIdProducto", query = "SELECT c FROM Campanias c WHERE c.idProducto = :idProducto"),
		@NamedQuery(name = "Campanias.findByNombre", query = "SELECT c FROM Campanias c WHERE c.nombre = :nombre"),
		@NamedQuery(name = "Campanias.findByDescripcion", query = "SELECT c FROM Campanias c WHERE c.descripcion = :descripcion"),
		@NamedQuery(name = "Campanias.findByImagen", query = "SELECT c FROM Campanias c WHERE c.imagen = :imagen"),
		@NamedQuery(name = "Campanias.findByFechaInicial", query = "SELECT c FROM Campanias c WHERE c.fechaInicial = :fechaInicial"),
		@NamedQuery(name = "Campanias.findByFechaFinal", query = "SELECT c FROM Campanias c WHERE c.fechaFinal = :fechaFinal") })
public class Campanias implements Serializable {
	private static final long serialVersionUID = 1L;
	// @Max(value=?) @Min(value=?)//if you know range of your decimal fields
	// consider using these annotations to enforce field validation
	@Id
	@Basic(optional = false)
	@Column(name = "IdCampania")
	private BigDecimal idCampania;
	@Basic(optional = false)
	@Column(name = "IdProducto")
	private BigInteger idProducto;
	@Basic(optional = false)
	@Column(name = "Nombre")
	private String nombre;
	@Basic(optional = false)
	@Column(name = "Descripcion")
	private String descripcion;
	@Basic(optional = false)
	@Column(name = "Imagen")
	private String imagen;
	@Basic(optional = false)
	@Column(name = "FechaInicial")
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaInicial;
	@Basic(optional = false)
	@Column(name = "FechaFinal")
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaFinal;

	public Campanias() {
	}

	public Campanias(BigDecimal idCampania) {
		this.idCampania = idCampania;
	}

	public Campanias(BigDecimal idCampania, BigInteger idProducto,
			String nombre, String descripcion, String imagen,
			Date fechaInicial, Date fechaFinal) {
		this.idCampania = idCampania;
		this.idProducto = idProducto;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.imagen = imagen;
		this.fechaInicial = fechaInicial;
		this.fechaFinal = fechaFinal;
	}

	public BigDecimal getIdCampania() {
		return idCampania;
	}

	public void setIdCampania(BigDecimal idCampania) {
		this.idCampania = idCampania;
	}

	public BigInteger getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(BigInteger idProducto) {
		this.idProducto = idProducto;
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

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public Date getFechaInicial() {
		return fechaInicial;
	}

	public void setFechaInicial(Date fechaInicial) {
		this.fechaInicial = fechaInicial;
	}

	public Date getFechaFinal() {
		return fechaFinal;
	}

	public void setFechaFinal(Date fechaFinal) {
		this.fechaFinal = fechaFinal;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (idCampania != null ? idCampania.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof Campanias)) {
			return false;
		}
		Campanias other = (Campanias) object;
		if ((this.idCampania == null && other.idCampania != null)
				|| (this.idCampania != null && !this.idCampania
						.equals(other.idCampania))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "com.oms.model.entity.oms.Campanias[ idCampania=" + idCampania
				+ " ]";
	}

}
