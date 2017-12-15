package com.cg.dto;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
@Entity
@Table(name="hotel")
public class HotelDto {
	@Id
	@Column(name="hotel_id")
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="seq")
	@SequenceGenerator(name="seq", sequenceName="hotel_seq")
	private int hotelId;

	private String city;
	
	@Column(name="hotel_name")
	@Pattern(regexp="[a-zA-Z0-9 ]{3,20}",message="should be between 3-20 characters")
	private String hotelName;
	
	@Column(name="address")
	@Pattern(regexp="[a-zA-Z0-9 ]{3,40}",message="should be between 3-40 characters")
	private String hotelAddress;

	
	@Pattern(regexp="[a-zA-Z0-9 ]{3,150}",message="should be between 3-150 characters")
	private String description;

	@NotNull
	@Min(value=1,message="Minimum Amount value should be Rs.1")
	@Max(value=9999,message="Maximum Amount value should be less than 10000")
	@Column(name="avg_rate_per_night")
	private int avgRatePerNight;

	/*@Length(min=10,max=10,message="Phone number should be 10 digits only")*/
	@Pattern(regexp="[789]{1}[0-9]{9}",message="Phone Number should be 10 digits")
	@Column(name="phone_no1")
	private String phoneNo1;

	/*@Length(min=10,max=10,message="Phone number should be 10 digits only")*/
	@Pattern(regexp="[789]{1}[0-9]{9}",message="Phone Number should be 10 digits")
	@Column(name="phone_no2")
	private String phoneNo2;

	private String rating;


	public int getHotelId() {
		return hotelId;
	}

	public void setHotelId(int hotelId) {
		this.hotelId = hotelId;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getHotelName() {
		return hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	public String getHotelAddress() {
		return hotelAddress;
	}

	public void setHotelAddress(String hotelAddress) {
		this.hotelAddress = hotelAddress;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getAvgRatePerNight() {
		return avgRatePerNight;
	}

	public void setAvgRatePerNight(int avgRatePerNight) {
		this.avgRatePerNight = avgRatePerNight;
	}

	public String getPhoneNo1() {
		return phoneNo1;
	}

	public void setPhoneNo1(String phoneNo1) {
		this.phoneNo1 = phoneNo1;
	}

	public String getPhoneNo2() {
		return phoneNo2;
	}

	public void setPhoneNo2(String phoneNo2) {
		this.phoneNo2 = phoneNo2;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public String getHotelEmail() {
		return hotelEmail;
	}

	public void setHotelEmail(String hotelEmail) {
		this.hotelEmail = hotelEmail;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	@Column(name="email")
	@Email(message="Please enter valid email id(Ex: xyz@abc.pqr)")
	@NotEmpty(message="It cannot be empty")
	private String hotelEmail;

	@Length(min=10,max=10,message="Fax number should be 10 digits only")
	private String fax;




}
