package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2016-05-05T19:19:58.625+0800")
@StaticMetamodel(Querytorole.class)
public class Querytorole_ {
	public static volatile SingularAttribute<Querytorole, QuerytorolePK> id;
	public static volatile SingularAttribute<Querytorole, String> description;
	public static volatile SingularAttribute<Querytorole, Querylist> querylist;
	public static volatile SingularAttribute<Querytorole, Role> role;
}
