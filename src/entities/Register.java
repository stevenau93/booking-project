package entities;
// Generated Nov 2, 2016 10:23:53 PM by Hibernate Tools 4.3.1.Final

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Register generated by hbm2java
 */
@Entity
@Table(name = "register", catalog = "booking_project")
public class Register implements java.io.Serializable {

	private String username;
	private String password;
	private byte[] salt;
	private String permisstion;
	private Date createDate;

	public Register() {
	}

	public Register(String username) {
		this.username = username;
	}

	public Register(String username, String password, byte[] salt, String permisstion, Date createDate) {
		this.username = username;
		this.password = password;
		this.salt = salt;
		this.permisstion = permisstion;
		this.createDate = createDate;
	}

	@Id

	@Column(name = "username", unique = true, nullable = false, length = 50)
	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Column(name = "password", length = 500)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "salt", length = 500)
	public byte[] getSalt() {
		return this.salt;
	}

	public void setSalt(byte[] salt) {
		this.salt = salt;
	}

	@Column(name = "permisstion", length = 50)
	public String getPermisstion() {
		return this.permisstion;
	}

	public void setPermisstion(String permisstion) {
		this.permisstion = permisstion;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "create_date", length = 19)
	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

}
