package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2016-05-05T19:19:58.630+0800")
@StaticMetamodel(User.class)
public class User_ {
	public static volatile SingularAttribute<User, Integer> id;
	public static volatile SingularAttribute<User, String> password;
	public static volatile SingularAttribute<User, String> username;
	public static volatile SingularAttribute<User, Role> roleBean;
}
