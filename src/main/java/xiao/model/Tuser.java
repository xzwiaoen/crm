package xiao.model;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "tuser")
public class Tuser implements Serializable{
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String realName;
	private String userName;
	private String password;
	private String email;
	private String mobilePhone;
	private String sex;
	private String position;
	private Date birthDay;
	private Tdept dept;
	private Set<Trole> troles = new HashSet<Trole>();
	
	public Tuser() {
		super();
	}

	public Tuser(Integer id, String realName, String userName, String password,
			String email, String mobilePhone, String sex, String position,
			Date birthDay) {
		super();
		this.id = id;
		this.realName = realName;
		this.userName = userName;
		this.password = password;
		this.email = email;
		this.mobilePhone = mobilePhone;
		this.sex = sex;
		this.position = position;
		this.birthDay = birthDay;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "ID", unique = true, nullable = false)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "realName", length = 20)
	public String getRealName() {
		return realName;
	}
	public void setRealName(String realName) {
		this.realName = realName;
	}

	@Column(name = "userName", length = 20)
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Column(name = "password", length = 50)
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "email", length = 50)
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "mobilePhone", length = 20)
	public String getMobilePhone() {
		return mobilePhone;
	}
	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}

	@Column(name = "sex", length = 20)
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}

	@Column(name = "position", length = 20)
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "birthDay", length = 10)
	public Date getBirthDay() {
		return birthDay;
	}
	public void setBirthDay(Date birthDay) {
		this.birthDay = birthDay;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "deptId")
	public Tdept getDept() {
		return dept;
	}
	public void setDept(Tdept dept) {
		this.dept = dept;
	}

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "tuser_trole", 
	joinColumns = { @JoinColumn(name = "TUSERID", nullable = false, updatable = false) }, 
	inverseJoinColumns = { @JoinColumn(name = "TROLEID", nullable = false, updatable = false) })
	public Set<Trole> getTroles() {
		return troles;
	}

	public void setTroles(Set<Trole> troles) {
		this.troles = troles;
	}
	
	
}
