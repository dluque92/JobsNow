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
public class AmigosPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "DATOSUSUARIO_ID")
    private BigInteger datosusuarioId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DATOSUSUARIO_ID2")
    private BigInteger datosusuarioId2;

    public AmigosPK() {
    }

    public AmigosPK(BigInteger datosusuarioId, BigInteger datosusuarioId2) {
        this.datosusuarioId = datosusuarioId;
        this.datosusuarioId2 = datosusuarioId2;
    }

    public BigInteger getDatosusuarioId() {
        return datosusuarioId;
    }

    public void setDatosusuarioId(BigInteger datosusuarioId) {
        this.datosusuarioId = datosusuarioId;
    }

    public BigInteger getDatosusuarioId2() {
        return datosusuarioId2;
    }

    public void setDatosusuarioId2(BigInteger datosusuarioId2) {
        this.datosusuarioId2 = datosusuarioId2;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (datosusuarioId != null ? datosusuarioId.hashCode() : 0);
        hash += (datosusuarioId2 != null ? datosusuarioId2.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AmigosPK)) {
            return false;
        }
        AmigosPK other = (AmigosPK) object;
        if ((this.datosusuarioId == null && other.datosusuarioId != null) || (this.datosusuarioId != null && !this.datosusuarioId.equals(other.datosusuarioId))) {
            return false;
        }
        if ((this.datosusuarioId2 == null && other.datosusuarioId2 != null) || (this.datosusuarioId2 != null && !this.datosusuarioId2.equals(other.datosusuarioId2))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "appweb.entity.AmigosPK[ datosusuarioId=" + datosusuarioId + ", datosusuarioId2=" + datosusuarioId2 + " ]";
    }
    
}
