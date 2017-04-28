/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appweb.ejb;

import appweb.entity.Mensaje;
import java.math.BigDecimal;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author adri_
 */
@Stateless
public class MensajeFacade extends AbstractFacade<Mensaje> {

    @PersistenceContext(unitName = "AppWeb-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MensajeFacade() {
        super(Mensaje.class);
    }
    
    public List<Mensaje> getMensajesAmigos( BigDecimal id, BigDecimal id2) {
        Query q;
        q = this.em.createQuery("select m from Mensaje m"
                + "where (:id = Mensaje.MensajePK.amigosDatousuarioId and  "
                + ":id2 = Mensaje.MensajePK.amigosDatousuarioId1)" +
                "or( :id = Mensaje.MensajePK.amigosDatousuarioId1 and"
                + ":id2 = Mensaje.MensajePK.amigosDatousuarioId)");
        
        q.setParameter("id", id);
        q.setParameter("id2", id2);
        List <Mensaje> lista = (List)q.getResultList();
        return lista;
    }
    
}
