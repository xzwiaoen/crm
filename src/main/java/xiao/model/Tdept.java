package xiao.model;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tdept")
public class Tdept implements Serializable{
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String name;
	private Tdept parentDept;
	//经理
	private Tuser manager;
	//总裁
	private Tuser president;
	private Set<Tuser> users=new HashSet<Tuser>();
	private Set<Tgroup> groups=new HashSet<Tgroup>(); 
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "ID", unique = true, nullable = false)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	@Column(name = "name", length = 20)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "parentDeptId")
	public Tdept getParentDept() {
		return parentDept;
	}
	public void setParentDept(Tdept parentDept) {
		this.parentDept = parentDept;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "managerId")
	public Tuser getManager() {
		return manager;
	}
	public void setManager(Tuser manager) {
		this.manager = manager;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "presidentId")
	public Tuser getPresident() {
		return president;
	}
	public void setPresident(Tuser president) {
		this.president = president;
	}
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "dept")
	public Set<Tuser> getUsers() {
		return users;
	}
	public void setUsers(Set<Tuser> users) {
		this.users = users;
	}
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "dept")
	public Set<Tgroup> getGroups() {
		return groups;
	}
	public void setGroups(Set<Tgroup> groups) {
		this.groups = groups;
	}
	
	
}
