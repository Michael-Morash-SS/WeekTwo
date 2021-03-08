/**
 * 
 */
package com.ss.assignments.utopia.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * @author Michael
 *
 */
@Entity
@Table(name="airport")
public class Airport {
	@Id
	@Column(name="iata_id")
	private String iata;
	
	@Column(name="city")
	private String city;

	public String getIata() {
		return iata;
	}

	public void setIata(String iata) {
		this.iata = iata;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
	
	public String toString() {
		return "Airport[iata='"+iata+"';city='"+city+"']";
	}
}
