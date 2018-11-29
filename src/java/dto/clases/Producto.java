/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto.clases;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Patricio
 */
@Entity
@Table(name = "producto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Producto.findAll", query = "SELECT p FROM Producto p")
    , @NamedQuery(name = "Producto.findByIdProducto", query = "SELECT p FROM Producto p WHERE p.idProducto = :idProducto")
    , @NamedQuery(name = "Producto.findByNombreProducto", query = "SELECT p FROM Producto p WHERE p.nombreProducto = :nombreProducto")
    , @NamedQuery(name = "Producto.findByPrecioProducto", query = "SELECT p FROM Producto p WHERE p.precioProducto = :precioProducto")
    , @NamedQuery(name = "Producto.findByAnioF", query = "SELECT p FROM Producto p WHERE p.anioF = :anioF")
    , @NamedQuery(name = "Producto.findByAnioV", query = "SELECT p FROM Producto p WHERE p.anioV = :anioV")
    , @NamedQuery(name = "Producto.findByDescripcionProducto", query = "SELECT p FROM Producto p WHERE p.descripcionProducto = :descripcionProducto")
    , @NamedQuery(name = "Producto.findByTarificacion", query = "SELECT p FROM Producto p WHERE p.tarificacion = :tarificacion")})
public class Producto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_producto")
    private Short idProducto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "nombre_producto")
    private String nombreProducto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "precio_producto")
    private int precioProducto;
    @Column(name = "anio_f")
    @Temporal(TemporalType.TIMESTAMP)
    private Date anioF;
    @Column(name = "anio_v")
    @Temporal(TemporalType.TIMESTAMP)
    private Date anioV;
    @Size(max = 45)
    @Column(name = "descripcion_producto")
    private String descripcionProducto;
    @Column(name = "tarificacion")
    private Integer tarificacion;
    @JoinColumns({
        @JoinColumn(name = "subtipo_producto_subtipo_p", referencedColumnName = "subtipo_p")
        , @JoinColumn(name = "subtipo_producto_tipo_producto_id_tp", referencedColumnName = "tipo_producto_id_tp")})
    @ManyToOne(optional = false)
    private SubtipoProducto subtipoProducto;

    public Producto() {
    }

    public Producto(Short idProducto) {
        this.idProducto = idProducto;
    }

    public Producto(Short idProducto, String nombreProducto, int precioProducto) {
        this.idProducto = idProducto;
        this.nombreProducto = nombreProducto;
        this.precioProducto = precioProducto;
    }

    public Short getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Short idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public int getPrecioProducto() {
        return precioProducto;
    }

    public void setPrecioProducto(int precioProducto) {
        this.precioProducto = precioProducto;
    }

    public Date getAnioF() {
        return anioF;
    }

    public void setAnioF(Date anioF) {
        this.anioF = anioF;
    }

    public Date getAnioV() {
        return anioV;
    }

    public void setAnioV(Date anioV) {
        this.anioV = anioV;
    }

    public String getDescripcionProducto() {
        return descripcionProducto;
    }

    public void setDescripcionProducto(String descripcionProducto) {
        this.descripcionProducto = descripcionProducto;
    }

    public Integer getTarificacion() {
        return tarificacion;
    }

    public void setTarificacion(Integer tarificacion) {
        this.tarificacion = tarificacion;
    }

    public SubtipoProducto getSubtipoProducto() {
        return subtipoProducto;
    }

    public void setSubtipoProducto(SubtipoProducto subtipoProducto) {
        this.subtipoProducto = subtipoProducto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProducto != null ? idProducto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Producto)) {
            return false;
        }
        Producto other = (Producto) object;
        if ((this.idProducto == null && other.idProducto != null) || (this.idProducto != null && !this.idProducto.equals(other.idProducto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dto.clases.Producto[ idProducto=" + idProducto + " ]";
    }
    
}
