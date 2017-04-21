/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appweb.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
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
 * @author Adrián
 */
@Entity
@Table(name = "DATOSUSUARIO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Datosusuario.findAll", query = "SELECT d FROM Datosusuario d")
    , @NamedQuery(name = "Datosusuario.findById", query = "SELECT d FROM Datosusuario d WHERE d.id = :id")
    , @NamedQuery(name = "Datosusuario.findByEmail", query = "SELECT d FROM Datosusuario d WHERE d.email = :email")
    , @NamedQuery(name = "Datosusuario.findByPassword", query = "SELECT d FROM Datosusuario d WHERE d.password = :password")
    , @NamedQuery(name = "Datosusuario.findByNombre", query = "SELECT d FROM Datosusuario d WHERE d.nombre = :nombre")
    , @NamedQuery(name = "Datosusuario.findByApellidos", query = "SELECT d FROM Datosusuario d WHERE d.apellidos = :apellidos")
    , @NamedQuery(name = "Datosusuario.findByTwitter", query = "SELECT d FROM Datosusuario d WHERE d.twitter = :twitter")
    , @NamedQuery(name = "Datosusuario.findByInstagram", query = "SELECT d FROM Datosusuario d WHERE d.instagram = :instagram")
    , @NamedQuery(name = "Datosusuario.findByWeb", query = "SELECT d FROM Datosusuario d WHERE d.web = :web")})
public class Datosusuario implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 90)
    @Column(name = "EMAIL")
    private String email;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "PASSWORD")
    private String password;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "NOMBRE")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 80)
    @Column(name = "APELLIDOS")
    private String apellidos;
    @Size(max = 16)
    @Column(name = "TWITTER")
    private String twitter;
    @Size(max = 30)
    @Column(name = "INSTAGRAM")
    private String instagram;
    @Size(max = 120)
    @Column(name = "WEB")
    private String web;
    @Lob
    @Column(name = "FOTO")
    private Serializable foto;
    @JoinTable(name = "PETICIONES", joinColumns = {
        @JoinColumn(name = "DATOSUSUARIO_ID", referencedColumnName = "ID")}, inverseJoinColumns = {
        @JoinColumn(name = "DATOSUSUARIO_ID2", referencedColumnName = "ID")})
    @ManyToMany
    private Collection<Datosusuario> datosusuarioCollection;
    @ManyToMany(mappedBy = "datosusuarioCollection")
    private Collection<Datosusuario> datosusuarioCollection1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "datosusuario")
    private Collection<Amigos> amigosCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "datosusuario1")
    private Collection<Amigos> amigosCollection1;
    @OneToMany(mappedBy = "datosusuarioId")
    private Collection<Aficion> aficionCollection;
    @OneToMany(mappedBy = "datosusuarioId")
    private Collection<Experiencia> experienciaCollection;
    @OneToMany(mappedBy = "datosusuarioId")
    private Collection<Estudio> estudioCollection;

    public Datosusuario() {
    }

    public Datosusuario(BigDecimal id) {
        this.id = id;
    }

    public Datosusuario(BigDecimal id, String email, String password, String nombre, String apellidos) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.nombre = nombre;
        this.apellidos = apellidos;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getTwitter() {
        return twitter;
    }

    public void setTwitter(String twitter) {
        this.twitter = twitter;
    }

    public String getInstagram() {
        return instagram;
    }

    public void setInstagram(String instagram) {
        this.instagram = instagram;
    }

    public String getWeb() {
        return web;
    }

    public void setWeb(String web) {
        this.web = web;
    }

    public Serializable getFoto() {
        return foto;
    }

    public void setFoto(Serializable foto) {
        this.foto = foto;
    }

    @XmlTransient
    public Collection<Datosusuario> getDatosusuarioCollection() {
        return datosusuarioCollection;
    }

    public void setDatosusuarioCollection(Collection<Datosusuario> datosusuarioCollection) {
        this.datosusuarioCollection = datosusuarioCollection;
    }

    @XmlTransient
    public Collection<Datosusuario> getDatosusuarioCollection1() {
        return datosusuarioCollection1;
    }

    public void setDatosusuarioCollection1(Collection<Datosusuario> datosusuarioCollection1) {
        this.datosusuarioCollection1 = datosusuarioCollection1;
    }

    @XmlTransient
    public Collection<Amigos> getAmigosCollection() {
        return amigosCollection;
    }

    public void setAmigosCollection(Collection<Amigos> amigosCollection) {
        this.amigosCollection = amigosCollection;
    }

    @XmlTransient
    public Collection<Amigos> getAmigosCollection1() {
        return amigosCollection1;
    }

    public void setAmigosCollection1(Collection<Amigos> amigosCollection1) {
        this.amigosCollection1 = amigosCollection1;
    }

    @XmlTransient
    public Collection<Aficion> getAficionCollection() {
        return aficionCollection;
    }

    public void setAficionCollection(Collection<Aficion> aficionCollection) {
        this.aficionCollection = aficionCollection;
    }

    @XmlTransient
    public Collection<Experiencia> getExperienciaCollection() {
        return experienciaCollection;
    }

    public void setExperienciaCollection(Collection<Experiencia> experienciaCollection) {
        this.experienciaCollection = experienciaCollection;
    }

    @XmlTransient
    public Collection<Estudio> getEstudioCollection() {
        return estudioCollection;
    }

    public void setEstudioCollection(Collection<Estudio> estudioCollection) {
        this.estudioCollection = estudioCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Datosusuario)) {
            return false;
        }
        Datosusuario other = (Datosusuario) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "appweb.entity.Datosusuario[ id=" + id + " ]";
    }
    
}
