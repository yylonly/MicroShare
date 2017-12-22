package model;

import java.io.Serializable;

import javax.persistence.*;


/**
 * The persistent class for the querytorole database table.
 * 
 */
@Entity 
@NamedQuery(name="Querytorole.findAll", query="SELECT q FROM Querytorole q")
public class Querytorole implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private QuerytorolePK id;

	private String description;

	//bi-directional many-to-one association to Querylist
	@ManyToOne
	@JoinColumn(name="queryid")
	private Querylist querylist;

	//bi-directional many-to-one association to Role
	@ManyToOne
	@JoinColumn(name="roleid")
	private Role role;

	public Querytorole() {
	}

	public QuerytorolePK getId() {
		return this.id;
	}

	public void setId(QuerytorolePK id) {
		this.id = id;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Querylist getQuerylist() {
		return this.querylist;
	}

	public void setQuerylist(Querylist querylist) {
		this.querylist = querylist;
	}

	public Role getRole() {
		return this.role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

}