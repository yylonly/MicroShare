package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2016-05-05T20:17:57.884+0800")
@StaticMetamodel(Querylist.class)
public class Querylist_ {
	public static volatile SingularAttribute<Querylist, Integer> id;
	public static volatile SingularAttribute<Querylist, String> description;
	public static volatile SingularAttribute<Querylist, String> sqlquery;
	public static volatile SingularAttribute<Querylist, Urlforwebservice> urlforwebservice1;
	public static volatile ListAttribute<Querylist, Querytorole> querytoroles;
	public static volatile ListAttribute<Querylist, Role> roles;
	public static volatile SingularAttribute<Querylist, Urlforwebservice> urlforwebservice2;
}
