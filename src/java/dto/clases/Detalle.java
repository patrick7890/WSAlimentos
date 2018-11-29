/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto.clases;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Patricio
 */
@Entity
@Table(name = "detalle")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Detalle.findAll", query = "SELECT d FROM Detalle d")
    , @NamedQuery(name = "Detalle.findByIdDetalle", query = "SELECT d FROM Detalle d WHERE d.idDetalle = :idDetalle")})
public class Detalle implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_detalle")
    private Float idDetalle;
    @JoinColumn(name = "boleta_id_boleta", referencedColumnName = "id_boleta")
    @ManyToOne(optional = false)
    private Boleta boletaIdBoleta;
    @JoinColumn(name = "producto_id_producto", referencedColumnName = "id_producto")
    @ManyToOne(optional = false)
    private Producto productoIdProducto;

    public Detalle() {
    }

    public Detalle(Float idDetalle) {
        this.idDetalle = idDetalle;
    }

    public Float getIdDetalle() {
        return idDetalle;
    }

    public void setIdDetalle(Float idDetalle) {
        this.idDetalle = idDetalle;
    }

    public Boleta getBoletaIdBoleta() {
        return boletaIdBoleta;
    }

    public void setBoletaIdBoleta(Boleta boletaIdBoleta) {
        this.boletaIdBoleta = boletaIdBoleta;
    }

    public Producto getProductoIdProducto() {
        return productoIdProducto;
    }

    public void setProductoIdProducto(Producto productoIdProducto) {
        this.productoIdProducto = productoIdProducto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDetalle != null ? idDetalle.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Detalle)) {
            return false;
        }
        Detalle other = (Detalle) object;
        if ((this.idDetalle == null && other.idDetalle != null) || (this.idDetalle != null && !this.idDetalle.equals(other.idDetalle))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dto.clases.Detalle[ idDetalle=" + idDetalle + " ]";
    }
    
}
