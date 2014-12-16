package xiao.model;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tgroup")
public class Tgroup {
	private Integer id;
	private String name;
	private Tuser leader;
	private Tdept dept;
	
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
	@JoinColumn(name = "leaderId")
	public Tuser getLeader() {
		return leader;
	}
	public void setLeader(Tuser leader) {
		this.leader = leader;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "deptId")
	public Tdept getDept() {
		return dept;
	}
	public void setDept(Tdept dept) {
		this.dept = dept;
	}
	
}
