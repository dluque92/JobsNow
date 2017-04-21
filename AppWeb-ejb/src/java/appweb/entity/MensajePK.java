/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appweb.entity;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Adrián
 */
@Embeddable
public class MensajePK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "AMIGOS_DATOSUSUARIO_ID")
    private BigInteger amigosDatosusuarioId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "AMIGOS_DATOSUSUARIO_ID1")
    private BigInteger amigosDatosusuarioId1;

    public MensajePK() {
    }

    public MensajePK(BigInteger amigosDatosusuarioId, BigInteger amigosDatosusuarioId1) {
        this.amigosDatosusuarioId = amigosDatosusuarioId;
        this.amigosDatosusuarioId1 = amigosDatosusuarioId1;
    }

    public BigInteger getAmigosDatosusuarioId() {
        return amigosDatosusuarioId;
    }

    public void setAmigosDatosusuarioId(BigInteger amigosDatosusuarioId) {
        this.amigosDatosusuarioId = amigosDatosusuarioId;
    }

    public BigInteger getAmigosDatosusuarioId1() {
        return amigosDatosusuarioId1;
    }

    public void setAmigosDatosusuarioId1(BigInteger amigosDatosusuarioId1) {
        this.amigosDatosusuarioId1 = amigosDatosusuarioId1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (amigosDatosusuarioId != null ? amigosDatosusuarioId.hashCode() : 0);
        hash += (amigosDatosusuarioId1 != null ? amigosDatosusuarioId1.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MensajePK)) {
            return false;
        }
        MensajePK other = (MensajePK) object;
        if ((this.amigosDatosusuarioId == null && other.amigosDatosusuarioId != null) || (this.amigosDatosusuarioId != null && !this.amigosDatosusuarioId.equals(other.amigosDatosusuarioId))) {
            return false;
        }
        if ((this.amigosDatosusuarioId1 == null && other.amigosDatosusuarioId1 != null) || (this.amigosDatosusuarioId1 != null && !this.amigosDatosusuarioId1.equals(other.amigosDatosusuarioId1))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "appweb.entity.MensajePK[ amigosDatosusuarioId=" + amigosDatosusuarioId + ", amigosDatosusuarioId1=" + amigosDatosusuarioId1 + " ]";
    }
    
}
