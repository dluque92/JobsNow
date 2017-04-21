/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appweb.entity;

import java.io.Serializable;
import java.math.BigDecimal;
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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Adrián
 */
@Entity
@Table(name = "AFICION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Aficion.findAll", query = "SELECT a FROM Aficion a")
    , @NamedQuery(name = "Aficion.findByIdAficiones", query = "SELECT a FROM Aficion a WHERE a.idAficiones = :idAficiones")
    , @NamedQuery(name = "Aficion.findByNombre", query = "SELECT a FROM Aficion a WHERE a.nombre = :nombre")})
public class Aficion implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_AFICIONES")
    private BigDecimal idAficiones;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "NOMBRE")
    private String nombre;
    @JoinColumn(name = "DATOSUSUARIO_ID", referencedColumnName = "ID")
    @ManyToOne
    private Datosusuario datosusuarioId;

    public Aficion() {
    }

    public Aficion(BigDecimal idAficiones) {
        this.idAficiones = idAficiones;
    }

    public Aficion(BigDecimal idAficiones, String nombre) {
        this.idAficiones = idAficiones;
        this.nombre = nombre;
    }

    public BigDecimal getIdAficiones() {
        return idAficiones;
    }

    public void setIdAficiones(BigDecimal idAficiones) {
        this.idAficiones = idAficiones;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Datosusuario getDatosusuarioId() {
        return datosusuarioId;
    }

    public void setDatosusuarioId(Datosusuario datosusuarioId) {
        this.datosusuarioId = datosusuarioId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAficiones != null ? idAficiones.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Aficion)) {
            return false;
        }
        Aficion other = (Aficion) object;
        if ((this.idAficiones == null && other.idAficiones != null) || (this.idAficiones != null && !this.idAficiones.equals(other.idAficiones))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "appweb.entity.Aficion[ idAficiones=" + idAficiones + " ]";
    }
    
}
