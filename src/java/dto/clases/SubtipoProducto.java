/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto.clases;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Patricio
 */
@Entity
@Table(name = "subtipo_producto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SubtipoProducto.findAll", query = "SELECT s FROM SubtipoProducto s")
    , @NamedQuery(name = "SubtipoProducto.findBySubtipoP", query = "SELECT s FROM SubtipoProducto s WHERE s.subtipoProductoPK.subtipoP = :subtipoP")
    , @NamedQuery(name = "SubtipoProducto.findByDescripcionStp", query = "SELECT s FROM SubtipoProducto s WHERE s.descripcionStp = :descripcionStp")
    , @NamedQuery(name = "SubtipoProducto.findByTipoProductoIdTp", query = "SELECT s FROM SubtipoProducto s WHERE s.subtipoProductoPK.tipoProductoIdTp = :tipoProductoIdTp")})
public class SubtipoProducto implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected SubtipoProductoPK subtipoProductoPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "descripcion_stp")
    private String descripcionStp;
    @JoinColumn(name = "tipo_producto_id_tp", referencedColumnName = "id_tp", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private TipoProducto tipoProducto;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "subtipoProducto")
    private List<Producto> productoList;

    public SubtipoProducto() {
    }

    public SubtipoProducto(SubtipoProductoPK subtipoProductoPK) {
        this.subtipoProductoPK = subtipoProductoPK;
    }

    public SubtipoProducto(SubtipoProductoPK subtipoProductoPK, String descripcionStp) {
        this.subtipoProductoPK = subtipoProductoPK;
        this.descripcionStp = descripcionStp;
    }

    public SubtipoProducto(short subtipoP, short tipoProductoIdTp) {
        this.subtipoProductoPK = new SubtipoProductoPK(subtipoP, tipoProductoIdTp);
    }

    public SubtipoProductoPK getSubtipoProductoPK() {
        return subtipoProductoPK;
    }

    public void setSubtipoProductoPK(SubtipoProductoPK subtipoProductoPK) {
        this.subtipoProductoPK = subtipoProductoPK;
    }

    public String getDescripcionStp() {
        return descripcionStp;
    }

    public void setDescripcionStp(String descripcionStp) {
        this.descripcionStp = descripcionStp;
    }

    public TipoProducto getTipoProducto() {
        return tipoProducto;
    }

    public void setTipoProducto(TipoProducto tipoProducto) {
        this.tipoProducto = tipoProducto;
    }

    @XmlTransient
    public List<Producto> getProductoList() {
        return productoList;
    }

    public void setProductoList(List<Producto> productoList) {
        this.productoList = productoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (subtipoProductoPK != null ? subtipoProductoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SubtipoProducto)) {
            return false;
        }
        SubtipoProducto other = (SubtipoProducto) object;
        if ((this.subtipoProductoPK == null && other.subtipoProductoPK != null) || (this.subtipoProductoPK != null && !this.subtipoProductoPK.equals(other.subtipoProductoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dto.clases.SubtipoProducto[ subtipoProductoPK=" + subtipoProductoPK + " ]";
    }
    
}
