package appweb.entity;

import appweb.entity.Aficion;
import appweb.entity.Amigos;
import appweb.entity.Datosusuario;
import appweb.entity.Estudio;
import appweb.entity.Experiencia;
import java.io.Serializable;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-04-21T17:07:12")
@StaticMetamodel(Datosusuario.class)
public class Datosusuario_ { 

    public static volatile SingularAttribute<Datosusuario, String> apellidos;
    public static volatile CollectionAttribute<Datosusuario, Datosusuario> datosusuarioCollection;
    public static volatile CollectionAttribute<Datosusuario, Amigos> amigosCollection;
    public static volatile CollectionAttribute<Datosusuario, Aficion> aficionCollection;
    public static volatile CollectionAttribute<Datosusuario, Estudio> estudioCollection;
    public static volatile SingularAttribute<Datosusuario, String> instagram;
    public static volatile CollectionAttribute<Datosusuario, Datosusuario> datosusuarioCollection1;
    public static volatile SingularAttribute<Datosusuario, String> nombre;
    public static volatile CollectionAttribute<Datosusuario, Experiencia> experienciaCollection;
    public static volatile SingularAttribute<Datosusuario, String> password;
    public static volatile SingularAttribute<Datosusuario, String> twitter;
    public static volatile SingularAttribute<Datosusuario, Serializable> foto;
    public static volatile SingularAttribute<Datosusuario, String> web;
    public static volatile SingularAttribute<Datosusuario, BigDecimal> id;
    public static volatile SingularAttribute<Datosusuario, String> email;
    public static volatile CollectionAttribute<Datosusuario, Amigos> amigosCollection1;

}