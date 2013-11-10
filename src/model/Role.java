package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the role database table.
 * 
 */
@Entity
@NamedQuery(name="Role.findAll", query="SELECT r FROM Role r")
public class Role implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private String name;

	//bi-directional many-to-one association to Querytorole
	@OneToMany(mappedBy="role")
	private List<Querytorole> querytoroles;

	//bi-directional many-to-many association to Querylist
	@ManyToMany
	@JoinTable(
		name="querytorole"
		, joinColumns={
			@JoinColumn(name="roleid")
			}
		, inverseJoinColumns={
			@JoinColumn(name="queryid")
			}
		)
	private List<Querylist> querylists;

	//bi-directional many-to-one association to User
	@OneToMany(mappedBy="roleBean")
	private List<User> users;

	public Role() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Querytorole> getQuerytoroles() {
		return this.querytoroles;
	}

	public void setQuerytoroles(List<Querytorole> querytoroles) {
		this.querytoroles = querytoroles;
	}

	public Querytorole addQuerytorole(Querytorole querytorole) {
		getQuerytoroles().add(querytorole);
		querytorole.setRole(this);

		return querytorole;
	}

	public Querytorole removeQuerytorole(Querytorole querytorole) {
		getQuerytoroles().remove(querytorole);
		querytorole.setRole(null);

		return querytorole;
	}

	public List<Querylist> getQuerylists() {
		return this.querylists;
	}

	public void setQuerylists(List<Querylist> querylists) {
		this.querylists = querylists;
	}

	public List<User> getUsers() {
		return this.users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public User addUser(User user) {
		getUsers().add(user);
		user.setRoleBean(this);

		return user;
	}

	public User removeUser(User user) {
		getUsers().remove(user);
		user.setRoleBean(null);

		return user;
	}

}