package servlet.mvc.rest.model;// default package
// Generated Apr 17, 2016 3:22:53 PM by Hibernate Tools 4.3.1.Final

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * State generated by hbm2java
 */
@Entity
@Table(name = "State", catalog = "FreeNForSale")
public class State implements java.io.Serializable {

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "StateId", unique = true, nullable = false)
	private Integer stateId;

	@Column(name = "Name", nullable = false, length = 2)
	private String name;

	@Column(name = "FullName", nullable = false, length = 30)
	private String fullName;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "state")
	private Set<User> users = new HashSet<User>(0);

	public State() {
	}

	public State(String name, String fullName) {
		this.name = name;
		this.fullName = fullName;
	}

	public State(String name, String fullName, Set<User> users) {
		this.name = name;
		this.fullName = fullName;
		this.users = users;
	}

	public Integer getStateId() {
		return this.stateId;
	}

	public void setStateId(Integer stateId) {
		this.stateId = stateId;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFullName() {
		return this.fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public Set<User> getUsers() {
		return this.users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

}
