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
 * FlightSchedule generated by hbm2java
 */
@Entity
@Table(name = "flight_schedule", catalog = "booking_project")
public class FlightSchedule implements java.io.Serializable {

	private String flightScheduleId;
	private String from;
	private String to;
	private Date departureDate;
	private String departureTime;
	private Date arrivalDate;
	private String arrivalTime;

	public FlightSchedule() {
	}

	public FlightSchedule(String flightScheduleId) {
		this.flightScheduleId = flightScheduleId;
	}

	public FlightSchedule(String flightScheduleId, String from, String to, Date departureDate, String departureTime,
			Date arrivalDate, String arrivalTime) {
		this.flightScheduleId = flightScheduleId;
		this.from = from;
		this.to = to;
		this.departureDate = departureDate;
		this.departureTime = departureTime;
		this.arrivalDate = arrivalDate;
		this.arrivalTime = arrivalTime;
	}

	@Id

	@Column(name = "flight_schedule_id", unique = true, nullable = false, length = 50)
	public String getFlightScheduleId() {
		return this.flightScheduleId;
	}

	public void setFlightScheduleId(String flightScheduleId) {
		this.flightScheduleId = flightScheduleId;
	}

	@Column(name = "from", length = 10)
	public String getFrom() {
		return this.from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	@Column(name = "to", length = 10)
	public String getTo() {
		return this.to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "departure_date", length = 19)
	public Date getDepartureDate() {
		return this.departureDate;
	}

	public void setDepartureDate(Date departureDate) {
		this.departureDate = departureDate;
	}

	@Column(name = "departure_time", length = 10)
	public String getDepartureTime() {
		return this.departureTime;
	}

	public void setDepartureTime(String departureTime) {
		this.departureTime = departureTime;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "arrival_date", length = 19)
	public Date getArrivalDate() {
		return this.arrivalDate;
	}

	public void setArrivalDate(Date arrivalDate) {
		this.arrivalDate = arrivalDate;
	}

	@Column(name = "arrival_time", length = 10)
	public String getArrivalTime() {
		return this.arrivalTime;
	}

	public void setArrivalTime(String arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

}
