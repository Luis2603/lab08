package model.entity;
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;
@PersistenceCapable(identityType = IdentityType.APPLICATION)

public class Access {
	
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY) 
	private Long id;
	@Persistent
	private Long rolId;
	@Persistent
	private Long resourceId;
	@Persistent
	private boolean status;
	@Persistent
	private String date;
	
	public Access(Long rolid, Long resourceid, boolean status, String date) {
		super();
		this.rolId = rolid;
		this.resourceId = resourceid;
		this.status = status;
		this.date = date;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getRol() {
		return rolId;
	}
	public void setRol(Long rolid) {
		this.rolId = rolid;
	}
	public Long getResource() {
		return resourceId;
	}
	public void setResource(Long resourceid) {
		this.resourceId = resourceid;
	}
	public boolean getStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
	
}
