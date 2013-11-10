package model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the querytorole database table.
 * 
 */
@Embeddable
public class QuerytorolePK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(insertable=false, updatable=false)
	private int queryid;

	@Column(insertable=false, updatable=false)
	private int roleid;

	public QuerytorolePK() {
	}
	public int getQueryid() {
		return this.queryid;
	}
	public void setQueryid(int queryid)  {
		this.queryid = queryid;
	}
	public int getRoleid() {
		return this.roleid;
	}
	public void setRoleid(int roleid) {
		this.roleid = roleid;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof QuerytorolePK)) {
			return false;
		}
		QuerytorolePK castOther = (QuerytorolePK)other;
		return 
			(this.queryid == castOther.queryid)
			&& (this.roleid == castOther.roleid);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.queryid;
		hash = hash * prime + this.roleid;
		
		return hash;
	}
}