package xiao.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.apache.commons.lang3.StringUtils;

/**
 * Tmodule entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "tmodule")
public class Tmodule implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	
	private String id;
	private String name;
	private String pid;
	private String url;
	private String iconCls;
	private Integer seq;
	private Date createdatetime;
	private Date updatedatetime;
	private String description;
	private Tmodule module;
	private TmoduleType moduleType;
	private Set<Tmodule> modules=new HashSet<Tmodule>();
	private Set<Trole> troles = new HashSet<Trole>();

	/** default constructor */
	public Tmodule() {
	}

	/** minimal constructor */
	public Tmodule(String name, String pid) {
		this.name = name;
		this.pid = pid;
	}

	/** full constructor */
	public Tmodule(String name, String pid, Set<Trole> troles) {
		this.name = name;
		this.pid = pid;
		this.troles = troles;
	}

	@Id
	@Column(name = "ID", unique = true, nullable = false, length = 36)
	public String getId() {
		if (!StringUtils.isBlank(this.id)) {
			return this.id;
		}
		return UUID.randomUUID().toString();
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	@Column(name = "name", nullable = false, length = 20)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "url", nullable = false)
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Column(name = "iconCls", nullable = false)
	public String getIconCls() {
		return iconCls;
	}

	public void setIconCls(String iconCls) {
		this.iconCls = iconCls;
	}

	@Column(name = "seq", precision = 8, scale = 0)
	public Integer getSeq() {
		return seq;
	}

	public void setSeq(Integer seq) {
		this.seq = seq;
	}

	@Column(name = "description", length = 50)
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "createdatetime", length = 7)
	public Date getCreatedatetime() {
		return createdatetime;
	}

	public void setCreatedatetime(Date createdatetime) {
		this.createdatetime = createdatetime;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "updatedatetime", length = 7)
	public Date getUpdatedatetime() {
		return updatedatetime;
	}

	public void setUpdatedatetime(Date updatedatetime) {
		this.updatedatetime = updatedatetime;
	}

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "tmodules")
	public Set<Trole> getTroles() {
		return this.troles;
	}

	public void setTroles(Set<Trole> troles) {
		this.troles = troles;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "model_Id")
	public Tmodule getModule() {
		return module;
	}
	public void setModule(Tmodule module) {
		this.module = module;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "modelType_Id")
	public TmoduleType getModuleType() {
		return moduleType;
	}
	public void setModuleType(TmoduleType moduleType) {
		this.moduleType = moduleType;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "module", cascade = CascadeType.ALL)
	public Set<Tmodule> getModules() {
		return modules;
	}

	public void setModules(Set<Tmodule> modules) {
		this.modules = modules;
	}

	@Transient
	public String getPid() {
		if (module != null && !StringUtils.isBlank(module.getId())) {
			return module.getId();
		}
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

}