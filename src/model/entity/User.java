package model.entity;
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;
@PersistenceCapable(identityType = IdentityType.APPLICATION)

public class User {
	
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY) 
	private Long id;
	@Persistent
	private String email;
	@Persistent
	private Long rolId;
	@Persistent
	private String birth;
	@Persistent
	private boolean gender;
	@Persistent
	private boolean status;
	@Persistent
	private String date;
	
	
	
	public User(String email, Long rol, String birth, boolean gender,
			boolean status, String date) {
		super();
		this.email = email;
		this.rolId = rol;
		this.birth = birth;
		this.gender = gender;
		this.status = status;
		this.date = date;
	}
	
	
	
	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Long getRolID() {
		return rolId;
	}
	public void setRolID(Long rol) {
		this.rolId = rol;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	public boolean getGender() {
		return gender;
	}
	public void setGender(boolean gender) {
		this.gender = gender;
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
