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
@Table(name = "estado_civil")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EstadoCivil.findAll", query = "SELECT e FROM EstadoCivil e")
    , @NamedQuery(name = "EstadoCivil.findByIdEstadoCivil", query = "SELECT e FROM EstadoCivil e WHERE e.idEstadoCivil = :idEstadoCivil")
    , @NamedQuery(name = "EstadoCivil.findByDescripcionEstadoCivil", query = "SELECT e FROM EstadoCivil e WHERE e.descripcionEstadoCivil = :descripcionEstadoCivil")})
public class EstadoCivil implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_estado_civil")
    private Short idEstadoCivil;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "descripcion_estado_civil")
    private String descripcionEstadoCivil;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "estadoCivilIdEstadoCivil")
    private List<Cliente> clienteList;

    public EstadoCivil() {
    }

    public EstadoCivil(Short idEstadoCivil) {
        this.idEstadoCivil = idEstadoCivil;
    }

    public EstadoCivil(Short idEstadoCivil, String descripcionEstadoCivil) {
        this.idEstadoCivil = idEstadoCivil;
        this.descripcionEstadoCivil = descripcionEstadoCivil;
    }

    public Short getIdEstadoCivil() {
        return idEstadoCivil;
    }

    public void setIdEstadoCivil(Short idEstadoCivil) {
        this.idEstadoCivil = idEstadoCivil;
    }

    public String getDescripcionEstadoCivil() {
        return descripcionEstadoCivil;
    }

    public void setDescripcionEstadoCivil(String descripcionEstadoCivil) {
        this.descripcionEstadoCivil = descripcionEstadoCivil;
    }

    @XmlTransient
    public List<Cliente> getClienteList() {
        return clienteList;
    }

    public void setClienteList(List<Cliente> clienteList) {
        this.clienteList = clienteList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEstadoCivil != null ? idEstadoCivil.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EstadoCivil)) {
            return false;
        }
        EstadoCivil other = (EstadoCivil) object;
        if ((this.idEstadoCivil == null && other.idEstadoCivil != null) || (this.idEstadoCivil != null && !this.idEstadoCivil.equals(other.idEstadoCivil))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dto.clases.EstadoCivil[ idEstadoCivil=" + idEstadoCivil + " ]";
    }
    
}
