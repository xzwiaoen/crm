package xiao.model;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "trole")
public class Trole {
	private Integer id;
	private String name;
	private String info;
	private Set<Tuser> tusers = new HashSet<Tuser>();
	private Set<Tmodule> tmodules = new HashSet<Tmodule>();
	
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
	
	@Column(name = "info", length = 50)
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "troles")
	public Set<Tuser> getTusers() {
		return tusers;
	}
	public void setTusers(Set<Tuser> tusers) {
		this.tusers = tusers;
	}
	
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinTable(name = "trole_tmodule",
	joinColumns = { @JoinColumn(name = "TROLEID", nullable = false, updatable = false) },
	inverseJoinColumns = { @JoinColumn(name = "TMODULEID", nullable = false, updatable = false) })
	public Set<Tmodule> getTmodules() {
		return tmodules;
	}
	public void setTmodules(Set<Tmodule> tmodules) {
		this.tmodules = tmodules;
	}
	
	
}
