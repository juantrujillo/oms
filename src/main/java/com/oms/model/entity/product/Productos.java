/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.oms.model.entity.product;

import java.io.Serializable;
import java.math.BigInteger;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.NamedStoredProcedureQueries;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;
import javax.persistence.Table;

/**
 * 
 * @author dianaduque
 */
@Entity
@Table(name = "Productos")
@NamedQueries({
		@NamedQuery(name = "Productos.findAll", query = "SELECT p FROM Productos p"),
		@NamedQuery(name = "Productos.findByIdProducto", query = "SELECT p FROM Productos p WHERE p.idProducto = :idProducto"),
		@NamedQuery(name = "Productos.findByNombre", query = "SELECT p FROM Productos p WHERE p.nombre = :nombre"),
		@NamedQuery(name = "Productos.findByDescripcion", query = "SELECT p FROM Productos p WHERE p.descripcion = :descripcion"),
		@NamedQuery(name = "Productos.findByIdCategoria", query = "SELECT p FROM Productos p WHERE p.idCategoria = :idCategoria"),
		@NamedQuery(name = "Productos.findByPrecioLista", query = "SELECT p FROM Productos p WHERE p.precioLista = :precioLista"),
		@NamedQuery(name = "Productos.findByImagen", query = "SELECT p FROM Productos p WHERE p.imagen = :imagen"),
		@NamedQuery(name = "Productos.findByThumb", query = "SELECT p FROM Productos p WHERE p.thumb = :thumb") })
@NamedStoredProcedureQueries({ @NamedStoredProcedureQuery(name = "findProductsBy", procedureName = "spTraerProductos", resultClasses = Productos.class, parameters = {
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "Codigo", type = Integer.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "Nombre", type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "Descripcion", type = String.class) }) })
public class Productos implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "IdProducto")
	private Integer idProducto;
	@Column(name = "Nombre")
	private String nombre;
	@Column(name = "Descripcion")
	private String descripcion;
	@Basic(optional = false)
	@Column(name = "IdCategoria")
	private short idCategoria;
	@Column(name = "PrecioLista")
	private BigInteger precioLista;
	@Column(name = "Imagen")
	private String imagen;
	@Column(name = "Thumb")
	private String thumb;

	public Productos() {
	}

	public Productos(Integer idProducto) {
		this.idProducto = idProducto;
	}

	public Productos(Integer idProducto, short idCategoria) {
		this.idProducto = idProducto;
		this.idCategoria = idCategoria;
	}

	public Integer getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(Integer idProducto) {
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

	public short getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(short idCategoria) {
		this.idCategoria = idCategoria;
	}

	public BigInteger getPrecioLista() {
		return precioLista;
	}

	public void setPrecioLista(BigInteger precioLista) {
		this.precioLista = precioLista;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public String getThumb() {
		return thumb;
	}

	public void setThumb(String thumb) {
		this.thumb = thumb;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (idProducto != null ? idProducto.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof Productos)) {
			return false;
		}
		Productos other = (Productos) object;
		if ((this.idProducto == null && other.idProducto != null)
				|| (this.idProducto != null && !this.idProducto
						.equals(other.idProducto))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "com.oms.model.entity.product.Productos[ idProducto="
				+ idProducto + " ]";
	}

}
