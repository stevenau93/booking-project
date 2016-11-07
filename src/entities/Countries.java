package entities;
// Generated Nov 2, 2016 10:23:53 PM by Hibernate Tools 4.3.1.Final

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Countries generated by hbm2java
 */
@Entity
@Table(name = "countries", catalog = "booking_project")
public class Countries implements java.io.Serializable {

	private String countryId;
	private String countryName;

	public Countries() {
	}

	public Countries(String countryId) {
		this.countryId = countryId;
	}

	public Countries(String countryId, String countryName) {
		this.countryId = countryId;
		this.countryName = countryName;
	}

	@Id

	@Column(name = "country_id", unique = true, nullable = false, length = 3)
	public String getCountryId() {
		return this.countryId;
	}

	public void setCountryId(String countryId) {
		this.countryId = countryId;
	}

	@Column(name = "country_name", length = 45)
	public String getCountryName() {
		return this.countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

}