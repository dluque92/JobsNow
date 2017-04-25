package appweb.entity;

import appweb.entity.Datosusuario;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-04-25T18:48:21")
@StaticMetamodel(Aficion.class)
public class Aficion_ { 

    public static volatile SingularAttribute<Aficion, BigDecimal> idAficiones;
    public static volatile SingularAttribute<Aficion, String> nombre;
    public static volatile SingularAttribute<Aficion, Datosusuario> datosusuarioId;

}