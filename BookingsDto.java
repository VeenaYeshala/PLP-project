package com.cg.dto;

import java.util.Date;

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


@Entity
@Table(name="bookingdetails")
public class BookingsDto {
	@Id
	@Column(name="booking_id")
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="seq")
	@SequenceGenerator(name="seq", sequenceName="booking_seq")
	private int bookingId;
	@NotNull
	@Min(value=1000,message="Hotel Id Should be of 4 digits")
	@Max(value=9999,message="Hotel Id Should be of 4 digits")
	@Column(name="hotel_id")
	private int hotelId;
	@Column(name="room_id")
	private int roomId;
	@Column(name="user_id")
	private int userId;
	@Column(name="booked_from")
	private Date bookingFrom;
	@Column(name="booked_to")
	private Date bookingTo;
	@Column(name="no_of_adults")
	private int noOfAdults;
	@Column(name="no_of_children")
	private int noOfChildren;
	private float amount;
	public int getBookingId() {
		return bookingId;
	}
	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}
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
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public Date getBookingFrom() {
		return bookingFrom;
	}
	public void setBookingFrom(Date bookingFrom) {
		this.bookingFrom = bookingFrom;
	}
	public Date getBookingTo() {
		return bookingTo;
	}
	public void setBookingTo(Date bookingTo) {
		this.bookingTo = bookingTo;
	}
	public int getNoOfAdults() {
		return noOfAdults;
	}
	public void setNoOfAdults(int noOfAdults) {
		this.noOfAdults = noOfAdults;
	}
	public int getNoOfChildren() {
		return noOfChildren;
	}
	public void setNoOfChildren(int noOfChildren) {
		this.noOfChildren = noOfChildren;
	}
	public float getAmount() {
		return amount;
	}
	public void setAmount(float amount) {
		this.amount = amount;
	}
	@Override
	public String toString() {
		return "BookingsDto [bookingId=" + bookingId + ", hotelId=" + hotelId
				+ ", roomId=" + roomId + ", userId=" + userId
				+ ", bookingFrom=" + bookingFrom + ", bookingTo=" + bookingTo
				+ ", noOfAdults=" + noOfAdults + ", noOfChildren="
				+ noOfChildren + ", amount=" + amount + "]";
	}
	
	


}
