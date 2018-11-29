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
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "tipo_producto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoProducto.findAll", query = "SELECT t FROM TipoProducto t")
    , @NamedQuery(name = "TipoProducto.findByIdTp", query = "SELECT t FROM TipoProducto t WHERE t.idTp = :idTp")
    , @NamedQuery(name = "TipoProducto.findByDescripcionTp", query = "SELECT t FROM TipoProducto t WHERE t.descripcionTp = :descripcionTp")})
public class TipoProducto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_tp")
    private Short idTp;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "descripcion_tp")
    private String descripcionTp;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoProducto")
    private List<SubtipoProducto> subtipoProductoList;

    public TipoProducto() {
    }

    public TipoProducto(Short idTp) {
        this.idTp = idTp;
    }

    public TipoProducto(Short idTp, String descripcionTp) {
        this.idTp = idTp;
        this.descripcionTp = descripcionTp;
    }

    public Short getIdTp() {
        return idTp;
    }

    public void setIdTp(Short idTp) {
        this.idTp = idTp;
    }

    public String getDescripcionTp() {
        return descripcionTp;
    }

    public void setDescripcionTp(String descripcionTp) {
        this.descripcionTp = descripcionTp;
    }

    @XmlTransient
    public List<SubtipoProducto> getSubtipoProductoList() {
        return subtipoProductoList;
    }

    public void setSubtipoProductoList(List<SubtipoProducto> subtipoProductoList) {
        this.subtipoProductoList = subtipoProductoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTp != null ? idTp.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoProducto)) {
            return false;
        }
        TipoProducto other = (TipoProducto) object;
        if ((this.idTp == null && other.idTp != null) || (this.idTp != null && !this.idTp.equals(other.idTp))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dto.clases.TipoProducto[ idTp=" + idTp + " ]";
    }
    
}
