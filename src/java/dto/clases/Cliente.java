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
@Table(name = "cliente")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cliente.findAll", query = "SELECT c FROM Cliente c")
    , @NamedQuery(name = "Cliente.findByIdCliente", query = "SELECT c FROM Cliente c WHERE c.idCliente = :idCliente")
    , @NamedQuery(name = "Cliente.findByRut", query = "SELECT c FROM Cliente c WHERE c.rut = :rut")
    , @NamedQuery(name = "Cliente.findByDv", query = "SELECT c FROM Cliente c WHERE  c.dv = :dv")
    , @NamedQuery(name = "Cliente.findByRutDv", query = "SELECT c FROM Cliente c WHERE c.rut = :rut and c.dv = :dv")
    , @NamedQuery(name = "Cliente.findByNombreCliente", query = "SELECT c FROM Cliente c WHERE c.nombreCliente = :nombreCliente")
    , @NamedQuery(name = "Cliente.findByApellidoCliente", query = "SELECT c FROM Cliente c WHERE c.apellidoCliente = :apellidoCliente")
    , @NamedQuery(name = "Cliente.findBySexo", query = "SELECT c FROM Cliente c WHERE c.sexo = :sexo")
    , @NamedQuery(name = "Cliente.findByActivoC", query = "SELECT c FROM Cliente c WHERE c.activoC = :activoC")
    , @NamedQuery(name = "Cliente.findByEdadCliente", query = "SELECT c FROM Cliente c WHERE c.edadCliente = :edadCliente")})
public class Cliente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_cliente")
    private Short idCliente;
    @Basic(optional = false)
    @NotNull
    @Column(name = "rut")
    private int rut;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "dv")
    private String dv;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "nombre_cliente")
    private String nombreCliente;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "apellido_cliente")
    private String apellidoCliente;
    @Basic(optional = false)
    @NotNull
    @Column(name = "sexo")
    private boolean sexo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "activo_c")
    private boolean activoC;
    @Basic(optional = false)
    @NotNull
    @Column(name = "edad_cliente")
    private short edadCliente;
    @JoinColumn(name = "estado_civil_id_estado_civil", referencedColumnName = "id_estado_civil")
    @ManyToOne(optional = false)
    private EstadoCivil estadoCivilIdEstadoCivil;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "clienteIdCliente")
    private List<Ventas> ventasList;

    public Cliente() {
    }

    public Cliente(Short idCliente) {
        this.idCliente = idCliente;
    }

    public Cliente(Short idCliente, int rut, String dv, String nombreCliente, String apellidoCliente, boolean sexo, boolean activoC, short edadCliente) {
        this.idCliente = idCliente;
        this.rut = rut;
        this.dv = dv;
        this.nombreCliente = nombreCliente;
        this.apellidoCliente = apellidoCliente;
        this.sexo = sexo;
        this.activoC = activoC;
        this.edadCliente = edadCliente;
    }

    public Short getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Short idCliente) {
        this.idCliente = idCliente;
    }

    public int getRut() {
        return rut;
    }

    public void setRut(int rut) {
        this.rut = rut;
    }

    public String getDv() {
        return dv;
    }

    public void setDv(String dv) {
        this.dv = dv;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getApellidoCliente() {
        return apellidoCliente;
    }

    public void setApellidoCliente(String apellidoCliente) {
        this.apellidoCliente = apellidoCliente;
    }

    public boolean getSexo() {
        return sexo;
    }

    public void setSexo(boolean sexo) {
        this.sexo = sexo;
    }

    public boolean getActivoC() {
        return activoC;
    }

    public void setActivoC(boolean activoC) {
        this.activoC = activoC;
    }

    public short getEdadCliente() {
        return edadCliente;
    }

    public void setEdadCliente(short edadCliente) {
        this.edadCliente = edadCliente;
    }

    public EstadoCivil getEstadoCivilIdEstadoCivil() {
        return estadoCivilIdEstadoCivil;
    }

    public void setEstadoCivilIdEstadoCivil(EstadoCivil estadoCivilIdEstadoCivil) {
        this.estadoCivilIdEstadoCivil = estadoCivilIdEstadoCivil;
    }

    @XmlTransient
    public List<Ventas> getVentasList() {
        return ventasList;
    }

    public void setVentasList(List<Ventas> ventasList) {
        this.ventasList = ventasList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCliente != null ? idCliente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cliente)) {
            return false;
        }
        Cliente other = (Cliente) object;
        if ((this.idCliente == null && other.idCliente != null) || (this.idCliente != null && !this.idCliente.equals(other.idCliente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dto.clases.Cliente[ idCliente=" + idCliente + " ]";
    }
    
}
