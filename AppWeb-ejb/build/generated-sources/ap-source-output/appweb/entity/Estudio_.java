package appweb.entity;

import appweb.entity.Datosusuario;
import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-04-24T18:07:47")
@StaticMetamodel(Estudio.class)
public class Estudio_ { 

    public static volatile SingularAttribute<Estudio, String> descripcion;
    public static volatile SingularAttribute<Estudio, String> ubicacion;
    public static volatile SingularAttribute<Estudio, Date> fechoFinalizacion;
    public static volatile SingularAttribute<Estudio, BigDecimal> idEstudios;
    public static volatile SingularAttribute<Estudio, Date> fechaComienzo;
    public static volatile SingularAttribute<Estudio, Datosusuario> datosusuarioId;

}