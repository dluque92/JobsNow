package appweb.entity;

import appweb.entity.Datosusuario;
import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-04-23T11:31:40")
@StaticMetamodel(Experiencia.class)
public class Experiencia_ { 

    public static volatile SingularAttribute<Experiencia, String> webEmpresa;
    public static volatile SingularAttribute<Experiencia, String> puesto;
    public static volatile SingularAttribute<Experiencia, BigDecimal> idExperiencia;
    public static volatile SingularAttribute<Experiencia, Date> fechaComienzo;
    public static volatile SingularAttribute<Experiencia, String> empresa;
    public static volatile SingularAttribute<Experiencia, Datosusuario> datosusuarioId;
    public static volatile SingularAttribute<Experiencia, Date> fechaFinalizacion;

}