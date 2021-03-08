package com.ss.assignments.utopia.models;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="flight")
public class Flight {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name="route_id")
	private Route route;
	
	@ManyToOne
	@JoinColumn(name="airplane_id")
	private Airplane airplane;
	
	//@Temporal(TemporalType.TIMESTAMP)
	@Column(name="departure_time")
	private LocalDateTime departure;
	
	@Column(name="reserved_seats")
	private Integer reservedSeats = 0;
	
	@Column(name="seat_price")
	private Float seatPrice;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Route getRoute() {
		return route;
	}

	public void setRoute(Route route) {
		this.route = route;
	}

	public Airplane getAirplane() {
		return airplane;
	}

	public void setAirplane(Airplane airplane) {
		this.airplane = airplane;
	}

	public LocalDateTime getDeparture() {
		return departure;
	}

	public void setDeparture(LocalDateTime departure) {
		this.departure = departure;
	}

	public Integer getReservedSeats() {
		return reservedSeats;
	}

	public void setReservedSeats(Integer reservedSeats) {
		this.reservedSeats = reservedSeats;
	}

	public Float getSeatPrice() {
		return seatPrice;
	}

	public void setSeatPrice(Float seatPrice) {
		this.seatPrice = seatPrice;
	}
	
	public String toString() {
		return "Flight[" +
				"id=" + id + ";" +
				"route=" + route.toString() + ";" +
				"airplane=" + airplane.toString() + ";" +
				"departure=" + departure.toString() + ";" +
				"reservedSeats=" + reservedSeats + ";" +
				"seatPrice=" + seatPrice + "]";
	}
}
