/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appweb.entity;


import java.io.Serializable;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
 * @author Adrián
 */
@Entity
@Table(name = "ESTUDIO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Estudio.findAll", query = "SELECT e FROM Estudio e")
    , @NamedQuery(name = "Estudio.findByIdEstudios", query = "SELECT e FROM Estudio e WHERE e.idEstudios = :idEstudios")
    , @NamedQuery(name = "Estudio.findByFechaComienzo", query = "SELECT e FROM Estudio e WHERE e.fechaComienzo = :fechaComienzo")
    , @NamedQuery(name = "Estudio.findByFechoFinalizacion", query = "SELECT e FROM Estudio e WHERE e.fechoFinalizacion = :fechoFinalizacion")
    , @NamedQuery(name = "Estudio.findByDescripcion", query = "SELECT e FROM Estudio e WHERE e.descripcion = :descripcion")
    , @NamedQuery(name = "Estudio.findByUbicacion", query = "SELECT e FROM Estudio e WHERE e.ubicacion = :ubicacion")})
public class Estudio implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_ESTUDIOS")
    private BigDecimal idEstudios;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA_COMIENZO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaComienzo;
    @Column(name = "FECHO_FINALIZACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechoFinalizacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @Size(max = 60)
    @Column(name = "UBICACION")
    private String ubicacion;
    @JoinColumn(name = "DATOSUSUARIO_ID", referencedColumnName = "ID")
    @ManyToOne
    private Datosusuario datosusuarioId;

    public Estudio() {
    }

    public Estudio(BigDecimal idEstudios) {
        this.idEstudios = idEstudios;
    }

    public Estudio(BigDecimal idEstudios, Date fechaComienzo, String descripcion) {
        this.idEstudios = idEstudios;
        this.fechaComienzo = fechaComienzo;
        this.descripcion = descripcion;
    }

    public BigDecimal getIdEstudios() {
        return idEstudios;
    }

    public void setIdEstudios(BigDecimal idEstudios) {
        this.idEstudios = idEstudios;
    }

    public String getFechaComienzoString() throws ParseException {
        //String stringFechaComienzo = fechaComienzo.toString();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(fechaComienzo);
        //return FechaComienzo.toString();
    }
    
    
    public Date getFechaComienzo() {
        return fechaComienzo;
    }
    

    public void setFechaComienzo(Date fechaComienzo) {
        this.fechaComienzo = fechaComienzo;
    }

    public Date getFechoFinalizacion() {
        return fechoFinalizacion;
    }
    public String getFechaFinString() throws ParseException {
        //String stringFechaComienzo = fechaComienzo.toString();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(fechoFinalizacion);
        //return FechaComienzo.toString();
    }

    public void setFechoFinalizacion(Date fechoFinalizacion) {
        this.fechoFinalizacion = fechoFinalizacion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
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
        hash += (idEstudios != null ? idEstudios.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Estudio)) {
            return false;
        }
        Estudio other = (Estudio) object;
        if ((this.idEstudios == null && other.idEstudios != null) || (this.idEstudios != null && !this.idEstudios.equals(other.idEstudios))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "appweb.entity.Estudio[ idEstudios=" + idEstudios + " ]";
    }
    
}
