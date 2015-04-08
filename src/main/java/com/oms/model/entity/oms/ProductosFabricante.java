/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.oms.model.entity.oms;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
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
@Table(name = "ProductosFabricante")
@NamedQueries({
    @NamedQuery(name = "ProductosFabricante.findAll", query = "SELECT p FROM ProductosFabricante p"),
    @NamedQuery(name = "ProductosFabricante.findByIdFabricante", query = "SELECT p FROM ProductosFabricante p WHERE p.productosFabricantePK.idFabricante = :idFabricante"),
    @NamedQuery(name = "ProductosFabricante.findByIdProducto", query = "SELECT p FROM ProductosFabricante p WHERE p.productosFabricantePK.idProducto = :idProducto"),
    @NamedQuery(name = "ProductosFabricante.findByPrecio", query = "SELECT p FROM ProductosFabricante p WHERE p.precio = :precio")})
public class ProductosFabricante implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ProductosFabricantePK productosFabricantePK;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "Precio")
    private BigDecimal precio;
    @JoinColumn(name = "IdFabricante", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Fabricantes fabricantes;

    public ProductosFabricante() {
    }

    public ProductosFabricante(ProductosFabricantePK productosFabricantePK) {
        this.productosFabricantePK = productosFabricantePK;
    }

    public ProductosFabricante(ProductosFabricantePK productosFabricantePK, BigDecimal precio) {
        this.productosFabricantePK = productosFabricantePK;
        this.precio = precio;
    }

    public ProductosFabricante(long idFabricante, BigInteger idProducto) {
		this.productosFabricantePK = new ProductosFabricantePK(idFabricante,
				idProducto);
    }

    public ProductosFabricantePK getProductosFabricantePK() {
        return productosFabricantePK;
    }

    public void setProductosFabricantePK(ProductosFabricantePK productosFabricantePK) {
        this.productosFabricantePK = productosFabricantePK;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    public Fabricantes getFabricantes() {
        return fabricantes;
    }

    public void setFabricantes(Fabricantes fabricantes) {
        this.fabricantes = fabricantes;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (productosFabricantePK != null ? productosFabricantePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProductosFabricante)) {
            return false;
        }
        ProductosFabricante other = (ProductosFabricante) object;
        if ((this.productosFabricantePK == null && other.productosFabricantePK != null) || (this.productosFabricantePK != null && !this.productosFabricantePK.equals(other.productosFabricantePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.oms.model.entity.oms.ProductosFabricante[ productosFabricantePK=" + productosFabricantePK + " ]";
    }
    
}
