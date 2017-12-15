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

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="roomdetails")

public class RoomDto{
	
	@Column(name="hotel_id")
	private int hotelId;

	
	@Id
	@Column(name="room_id")
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="seq")
	@SequenceGenerator(name="seq", sequenceName="room_seq")
	private int roomId;

	@NotEmpty
	@Pattern(regexp="[a-zA-Z][a-zA-Z0-9]{1,}",message="should be like ac,non-ac,deluxe,etc..")
	@Column(name="room_Type")
	private String roomType;
	@NotNull
	@Min(value=1,message="Minimum Amount value should be Rs.1")
	@Max(value=9999,message="Maximum Amount value should be less than 10000")
	@Column(name="per_Night_Rate")
	private float perNightRate;
	@NotEmpty
	@Pattern(regexp="true|false|False|True|t|T|f|F",message="should be true or false")
	@Column(name="availability")
	private String availability;

	public int getHotelId() {
		return hotelId;
	}
	public void setHotelId(int hotelId) {
		this.hotelId = hotelId;
	}
	public int getRoomId() {
		return roomId;
	}
	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}
	public String getRoomType() {
		return roomType;
	}
	@Override
	public String toString() {
		return "RoomDto [hotelId=" + hotelId + ", roomId=" + roomId + ", roomType=" + roomType + ", perNightRate="
				+ perNightRate + ", availability=" + availability + "]";
	}
	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}
	public float getPerNightRate() {
		return perNightRate;
	}
	public void setPerNightRate(float perNightRate) {
		this.perNightRate = perNightRate;
	}
	public String getAvailability() {
		return availability;
	}
	public void setAvailability(String availability) {
		this.availability = availability;
	}

}
