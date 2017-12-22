package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2016-05-05T19:19:58.627+0800")
@StaticMetamodel(Role.class)
public class Role_ {
	public static volatile SingularAttribute<Role, Integer> id;
	public static volatile SingularAttribute<Role, String> name;
	public static volatile ListAttribute<Role, Querytorole> querytoroles;
	public static volatile ListAttribute<Role, Querylist> querylists;
	public static volatile ListAttribute<Role, User> users;
}
