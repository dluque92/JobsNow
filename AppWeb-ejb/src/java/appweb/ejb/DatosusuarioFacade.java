/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appweb.ejb;

import appweb.entity.Datosusuario;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Adrián
////// */
@Stateless
public class DatosusuarioFacade extends AbstractFacade<Datosusuario> {

    @PersistenceContext(unitName = "AppWeb-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DatosusuarioFacade() {
        super(Datosusuario.class);
    }
    
    public Datosusuario obtenerID(String email, String pass){
        Query q;
        q = this.em.createQuery("select d from Datosusuario d where d.email = :email and d.password = :pass ");
        q.setParameter("email", email);
        q.setParameter("pass", pass);
        List <Datosusuario> lista = (List)q.getResultList();
        return lista.get(0);
    }
    
    public Integer obtenerProximoValorIdUsuario (  ){
        Query q;
        List<Integer> lista;
        
        q = em.createQuery("select max(u.id) from Datosusuario u");
        lista = q.getResultList();
        if(lista==null || lista.isEmpty())
            return 0;
        else{
            Integer entero = lista.get(0);
            return entero+1;
        }
    }
    
    public Boolean emailUsado(String email){
        Query q;
        q = this.em.createQuery("select d from Datosusuario d where d.email = :email ");
        q.setParameter("email", email);
        List <Datosusuario> lista = (List)q.getResultList();
        return lista.get(0) != null;
    }
}
