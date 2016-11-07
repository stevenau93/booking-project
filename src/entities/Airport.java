package entities;
// Generated Nov 2, 2016 10:23:53 PM by Hibernate Tools 4.3.1.Final

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Airport generated by hbm2java
 */
@Entity
@Table(name = "airport", catalog = "booking_project")
public class Airport implements java.io.Serializable {

	private String airportId;
	private String airportName;
	private String city;
	private String countryCode;

	public Airport() {
	}

	public Airport(String airportId) {
		this.airportId = airportId;
	}

	public Airport(String airportId, String airportName, String city, String countryCode) {
		this.airportId = airportId;
		this.airportName = airportName;
		this.city = city;
		this.countryCode = countryCode;
	}

	@Id

	@Column(name = "airport_id", unique = true, nullable = false, length = 10)
	public String getAirportId() {
		return this.airportId;
	}

	public void setAirportId(String airportId) {
		this.airportId = airportId;
	}

	@Column(name = "airport_name", length = 45)
	public String getAirportName() {
		return this.airportName;
	}

	public void setAirportName(String airportName) {
		this.airportName = airportName;
	}

	@Column(name = "city", length = 45)
	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Column(name = "country_code", length = 45)
	public String getCountryCode() {
		return this.countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

}
