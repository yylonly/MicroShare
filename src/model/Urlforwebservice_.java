package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2016-05-05T19:19:58.628+0800")
@StaticMetamodel(Urlforwebservice.class)
public class Urlforwebservice_ {
	public static volatile SingularAttribute<Urlforwebservice, Integer> id;
	public static volatile SingularAttribute<Urlforwebservice, String> url;
	public static volatile ListAttribute<Urlforwebservice, Querylist> querylists;
	public static volatile SingularAttribute<Urlforwebservice, Querylist> querylist;
}
