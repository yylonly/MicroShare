package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the querylist database table.
 * 
 */
@Entity
@NamedQuery(name="Querylist.findAll", query="SELECT q FROM Querylist q")
public class Querylist implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private String description;

	private String sqlquery;

	//bi-directional many-to-one association to Urlforwebservice
	@ManyToOne
	@JoinColumn(name="urlid")
	private Urlforwebservice urlforwebservice1;

	//bi-directional many-to-one association to Querytorole
	@OneToMany(mappedBy="querylist")
	private List<Querytorole> querytoroles;

	//bi-directional many-to-many association to Role
	@ManyToMany(mappedBy="querylists")
	private List<Role> roles;

	//bi-directional one-to-one association to Urlforwebservice
	@OneToOne(mappedBy="querylist")
	private Urlforwebservice urlforwebservice2;

	public Querylist() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getSqlquery() {
		return this.sqlquery;
	}

	public void setSqlquery(String sqlquery) {
		this.sqlquery = sqlquery;
	}

	public Urlforwebservice getUrlforwebservice1() {
		return this.urlforwebservice1;
	}

	public void setUrlforwebservice1(Urlforwebservice urlforwebservice1) {
		this.urlforwebservice1 = urlforwebservice1;
	}

	public List<Querytorole> getQuerytoroles() {
		return this.querytoroles;
	}

	public void setQuerytoroles(List<Querytorole> querytoroles) {
		this.querytoroles = querytoroles;
	}

	public Querytorole addQuerytorole(Querytorole querytorole) {
		getQuerytoroles().add(querytorole);
		querytorole.setQuerylist(this);

		return querytorole;
	}

	public Querytorole removeQuerytorole(Querytorole querytorole) {
		getQuerytoroles().remove(querytorole);
		querytorole.setQuerylist(null);

		return querytorole;
	}

	public List<Role> getRoles() {
		return this.roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public Urlforwebservice getUrlforwebservice2() {
		return this.urlforwebservice2;
	}

	public void setUrlforwebservice2(Urlforwebservice urlforwebservice2) {
		this.urlforwebservice2 = urlforwebservice2;
	}

}