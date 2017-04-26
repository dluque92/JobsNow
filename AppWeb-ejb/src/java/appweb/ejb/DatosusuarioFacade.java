/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appweb.ejb;

import appweb.entity.Amigos;
import appweb.entity.Datosusuario;
import java.math.BigDecimal;
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
    
    public Datosusuario obtenerUsuario(String email, String pass){
        Query q;
        q = this.em.createQuery("select d from Datosusuario d where UPPER(d.email) = UPPER(:email) and d.password = :pass ");
        q.setParameter("email", email);
        q.setParameter("pass", pass);
        List <Datosusuario> lista = (List)q.getResultList();
        if (!lista.isEmpty()){
            return lista.get(0);  
        }else{
            return null;
        }
    }
  
    public Boolean emailUsado(String email){
        Query q;
        q = this.em.createQuery("select d from Datosusuario d where UPPER(d.email) = UPPER(:email) ");
        q.setParameter("email", email);
        List <Datosusuario> lista = (List)q.getResultList();
        return !lista.isEmpty();
    }

    public Datosusuario crearUsuario(String email, String password, String nombre, String apellidos) {
        Query q;
        q = this.em.createNativeQuery("select SEQ_ID_DATOSUSUARIO.nextval from dual");
        BigDecimal num = (BigDecimal) q.getResultList().get(0);
        Datosusuario u = new Datosusuario(num,email,password, nombre, apellidos);
        return u;
    }
    
    public List<Datosusuario> findByName(String nombre, BigDecimal id) {
        Query q;
        q = this.em.createQuery("select d from Datosusuario d where UPPER(d.nombre) LIKE UPPER(:nombre) and d.id <> :id");
        q.setParameter("nombre", "%"+nombre+"%");
        q.setParameter("id", id);
        List <Datosusuario> lista = (List)q.getResultList();
        return lista;
    }

    public Boolean sonAmigos(BigDecimal id, BigDecimal id0) {
       Query q;
       q= this.em.createQuery("select a from Amigos a where (a.datosusuario.id = :amigo1 and a.datosusuario1.id = :amigo2) OR (a.datosusuario.id = :amigo2 and a.datosusuario1.id = :amigo1)");
       q.setParameter("amigo1", id);
       q.setParameter("amigo2", id0);
       List<Amigos> listaAmigos =  (List) q.getResultList();
       return listaAmigos.size()!=0;
    }
}
