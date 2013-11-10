package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the urlforwebservice database table.
 * 
 */
@Entity
@NamedQuery(name="Urlforwebservice.findAll", query="SELECT u FROM Urlforwebservice u")
public class Urlforwebservice implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private String url;

	//bi-directional many-to-one association to Querylist
	@OneToMany(mappedBy="urlforwebservice1")
	private List<Querylist> querylists;

	//bi-directional one-to-one association to Querylist
	@OneToOne
	@PrimaryKeyJoinColumn(name="id")
	private Querylist querylist;

	public Urlforwebservice() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public List<Querylist> getQuerylists() {
		return this.querylists;
	}

	public void setQuerylists(List<Querylist> querylists) {
		this.querylists = querylists;
	}

	public Querylist addQuerylist(Querylist querylist) {
		getQuerylists().add(querylist);
		querylist.setUrlforwebservice1(this);

		return querylist;
	}

	public Querylist removeQuerylist(Querylist querylist) {
		getQuerylists().remove(querylist);
		querylist.setUrlforwebservice1(null);

		return querylist;
	}

	public Querylist getQuerylist() {
		return this.querylist;
	}

	public void setQuerylist(Querylist querylist) {
		this.querylist = querylist;
	}

}