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
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * 
 * @author dianaduque
 */
@Entity
@Table(name = "CLIENTES")
@NamedQueries({
		@NamedQuery(name = "Clientes.findAll", query = "SELECT c FROM Clientes c"),
		@NamedQuery(name = "Clientes.findByNombre", query = "SELECT c FROM Clientes c WHERE c.nombre = :nombre"),
		@NamedQuery(name = "Clientes.findByApellido", query = "SELECT c FROM Clientes c WHERE c.apellido = :apellido"),
		@NamedQuery(name = "Clientes.findByTelefono", query = "SELECT c FROM Clientes c WHERE c.telefono = :telefono"),
		@NamedQuery(name = "Clientes.findByEmail", query = "SELECT c FROM Clientes c WHERE c.email = :email"),
		@NamedQuery(name = "Clientes.findByPassword", query = "SELECT c FROM Clientes c WHERE c.password = :password"),
		@NamedQuery(name = "Clientes.findByTipotarjetacredito", query = "SELECT c FROM Clientes c WHERE c.tipotarjetacredito = :tipotarjetacredito"),
		@NamedQuery(name = "Clientes.findByNumerotarjeta", query = "SELECT c FROM Clientes c WHERE c.numerotarjeta = :numerotarjeta") })
public class Clientes implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GenericGenerator(name = "generator", strategy = "guid", parameters = {})
	@GeneratedValue(generator = "generator")
	@Basic(optional = false)
	@Column(name = "IDCLIENTE")
	private String idcliente;
	@Basic(optional = false)
	@Column(name = "NOMBRE")
	private String nombre;
	@Basic(optional = false)
	@Column(name = "APELLIDO")
	private String apellido;
	@Basic(optional = false)
	@Column(name = "TELEFONO")
	private String telefono;
	// @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?",
	// message="Invalid email")//if the field contains email address consider
	// using this annotation to enforce field validation
	@Basic(optional = false)
	@Column(name = "EMAIL")
	private String email;
	@Basic(optional = false)
	@Column(name = "PASSWORD")
	private String password;
	@Column(name = "TIPOTARJETACREDITO")
	private String tipotarjetacredito;
	@Column(name = "NUMEROTARJETA")
	private String numerotarjeta;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "idcliente")
	private Collection<Pedidos> pedidosCollection;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "clientes")
	private Collection<Direccionescliente> direccionesclienteCollection;

	public Clientes() {
	}

	public Clientes(String idcliente) {
		this.idcliente = idcliente;
	}

	public Clientes(String idcliente, String nombre, String apellido,
			String telefono, String email, String password) {
		this.idcliente = idcliente;
		this.nombre = nombre;
		this.apellido = apellido;
		this.telefono = telefono;
		this.email = email;
		this.password = password;
	}

	public String getIdcliente() {
		return idcliente;
	}

	public void setIdcliente(String idcliente) {
		this.idcliente = idcliente;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getTipotarjetacredito() {
		return tipotarjetacredito;
	}

	public void setTipotarjetacredito(String tipotarjetacredito) {
		this.tipotarjetacredito = tipotarjetacredito;
	}

	public String getNumerotarjeta() {
		return numerotarjeta;
	}

	public void setNumerotarjeta(String numerotarjeta) {
		this.numerotarjeta = numerotarjeta;
	}

	public Collection<Pedidos> getPedidosCollection() {
		return pedidosCollection;
	}

	public void setPedidosCollection(Collection<Pedidos> pedidosCollection) {
		this.pedidosCollection = pedidosCollection;
	}

	public Collection<Direccionescliente> getDireccionesclienteCollection() {
		return direccionesclienteCollection;
	}

	public void setDireccionesclienteCollection(
			Collection<Direccionescliente> direccionesclienteCollection) {
		this.direccionesclienteCollection = direccionesclienteCollection;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (idcliente != null ? idcliente.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof Clientes)) {
			return false;
		}
		Clientes other = (Clientes) object;
		if ((this.idcliente == null && other.idcliente != null)
				|| (this.idcliente != null && !this.idcliente
						.equals(other.idcliente))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "com.oms.model.entity.order.Clientes[ idcliente=" + idcliente
				+ " ]";
	}

}
