package appweb.entity;

import appweb.entity.Amigos;
import appweb.entity.MensajePK;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-04-25T17:44:19")
@StaticMetamodel(Mensaje.class)
public class Mensaje_ { 

    public static volatile SingularAttribute<Mensaje, Date> fecha;
    public static volatile SingularAttribute<Mensaje, MensajePK> mensajePK;
    public static volatile SingularAttribute<Mensaje, Amigos> amigos;
    public static volatile SingularAttribute<Mensaje, Character> leido;
    public static volatile SingularAttribute<Mensaje, String> mensaje;

}