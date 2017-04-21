/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appweb.entity;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.CascadeType;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Adrián
 */
@Entity
@Table(name = "AMIGOS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Amigos.findAll", query = "SELECT a FROM Amigos a")
    , @NamedQuery(name = "Amigos.findByDatosusuarioId", query = "SELECT a FROM Amigos a WHERE a.amigosPK.datosusuarioId = :datosusuarioId")
    , @NamedQuery(name = "Amigos.findByDatosusuarioId2", query = "SELECT a FROM Amigos a WHERE a.amigosPK.datosusuarioId2 = :datosusuarioId2")})
public class Amigos implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected AmigosPK amigosPK;
    @JoinColumn(name = "DATOSUSUARIO_ID", referencedColumnName = "ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Datosusuario datosusuario;
    @JoinColumn(name = "DATOSUSUARIO_ID2", referencedColumnName = "ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Datosusuario datosusuario1;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "amigos")
    private Mensaje mensaje;

    public Amigos() {
    }

    public Amigos(AmigosPK amigosPK) {
        this.amigosPK = amigosPK;
    }

    public Amigos(BigInteger datosusuarioId, BigInteger datosusuarioId2) {
        this.amigosPK = new AmigosPK(datosusuarioId, datosusuarioId2);
    }

    public AmigosPK getAmigosPK() {
        return amigosPK;
    }

    public void setAmigosPK(AmigosPK amigosPK) {
        this.amigosPK = amigosPK;
    }

    public Datosusuario getDatosusuario() {
        return datosusuario;
    }

    public void setDatosusuario(Datosusuario datosusuario) {
        this.datosusuario = datosusuario;
    }

    public Datosusuario getDatosusuario1() {
        return datosusuario1;
    }

    public void setDatosusuario1(Datosusuario datosusuario1) {
        this.datosusuario1 = datosusuario1;
    }

    public Mensaje getMensaje() {
        return mensaje;
    }

    public void setMensaje(Mensaje mensaje) {
        this.mensaje = mensaje;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (amigosPK != null ? amigosPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Amigos)) {
            return false;
        }
        Amigos other = (Amigos) object;
        if ((this.amigosPK == null && other.amigosPK != null) || (this.amigosPK != null && !this.amigosPK.equals(other.amigosPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "appweb.entity.Amigos[ amigosPK=" + amigosPK + " ]";
    }
    
}
