/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto.clases;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Patricio
 */
@Embeddable
public class SubtipoProductoPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "subtipo_p")
    private short subtipoP;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tipo_producto_id_tp")
    private short tipoProductoIdTp;

    public SubtipoProductoPK() {
    }

    public SubtipoProductoPK(short subtipoP, short tipoProductoIdTp) {
        this.subtipoP = subtipoP;
        this.tipoProductoIdTp = tipoProductoIdTp;
    }

    public short getSubtipoP() {
        return subtipoP;
    }

    public void setSubtipoP(short subtipoP) {
        this.subtipoP = subtipoP;
    }

    public short getTipoProductoIdTp() {
        return tipoProductoIdTp;
    }

    public void setTipoProductoIdTp(short tipoProductoIdTp) {
        this.tipoProductoIdTp = tipoProductoIdTp;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) subtipoP;
        hash += (int) tipoProductoIdTp;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SubtipoProductoPK)) {
            return false;
        }
        SubtipoProductoPK other = (SubtipoProductoPK) object;
        if (this.subtipoP != other.subtipoP) {
            return false;
        }
        if (this.tipoProductoIdTp != other.tipoProductoIdTp) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dto.clases.SubtipoProductoPK[ subtipoP=" + subtipoP + ", tipoProductoIdTp=" + tipoProductoIdTp + " ]";
    }
    
}
